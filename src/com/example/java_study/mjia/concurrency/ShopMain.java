package com.example.java_study.mjia.concurrency;

import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.stream.Collectors;

import static java.util.stream.Collectors.toList;

public class ShopMain {
    List<Shop> shops = List.of(new Shop("BestPrice"),
            new Shop("LetsSaveBig"),
            new Shop("MyFavoriteShop"),
            new Shop("BuyItAll"));

    String product =  "myPhone27S";

    public static void main(String[] args) {

    }

    public void getPriceFromShop() {
        Shop shop = new Shop("BestShop");
        long start = System.nanoTime();
        Future<Double> futurePrice = shop.getPriceAsync("my favorite product");
        long invocationTime = ((System.nanoTime() - start) / 1_000_000);
        System.out.println("Invocation returned after " + invocationTime
                + " msecs");
        // Do some more tasks, like querying other shops while the price of the product is being calculated
        // doSomethingElse();

        try {
            // Read the price from the Future or block until it becomes available.
            // If the process in thread in getPriceAsync throws error, the get() call blocks forever
            // In order to prevent this, use overloaded version of get() with timeout
            double price = futurePrice.get();
            System.out.printf("Price is %.2f%n", price);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }

        long retrievalTime = ((System.nanoTime() - start) / 1_000_000);
        System.out.println("Price returned after " + retrievalTime + " msecs");
    }

    public List<String> getPricesFromMultipleShops()  {
        List<Shop> shops = List.of(new Shop("BestPrice"),
                new Shop("LetsSaveBig"),
                new Shop("MyFavoriteShop"),
                new Shop("BuyItAll"));

        String product =  "myPhone27S";

        return shops.stream().map(shop -> String.format("%s price is %.2f",
            shop.getName(), shop.getPrice(product)))
            .collect(toList());

    }

    public List<String> findPricesSequential() {
        //this method takes to run is a few milliseconds longer than 4 seconds,
        // because the four shops are queried sequentially
        return shops.stream().map(shop -> String.format("%s price is %.2f",
                        shop.getName(), shop.getPrice(product)))
                .collect(toList());
    }

    public List<String> findPricesParallelStream(String product) {
        //Use a parallel Stream to retrieve the prices from the different shops in parallel.
        // four shops are queried in parallel, so the code takes a bit more than a second to complete
        //The parallel stream version performs so well only because it can run four tasks in parallel,
        // so it’s able to allocate exactly one thread for each shop
        return shops.parallelStream().map(shop -> String.format("%s price is %.2f",
                        shop.getName(), shop.getPrice(product)))
                .collect(toList());

    }

    public List<String> findPricesCompletableFuture(String product) {
        //Calculate each price asynchronously with a CompletableFuture.

        //both pazrallelstream and completablefuture internally use the same common pool
        // that by default has a fixed number of threads equal to the one
        // returned by Runtime.getRuntime().availableProcessors()
        List<CompletableFuture<String>> priceFutures = shops.stream()
                .map(shop -> CompletableFuture.supplyAsync(
                        () -> shop.getName() + " price is " +
                                shop.getPrice(product)))
                .collect(Collectors.toList());


        return priceFutures.stream()
                .map(CompletableFuture::join)
                .collect(toList());

        //If we run this with five shops, this method takes nearly 2 seconds
        //If we run this with nine shops, this method takes nearly 3 seconds

    }

    public List<String> findPricesCompletableFutureCustomExecutor(String product) {
         final Executor executor =
                Executors.newFixedThreadPool(Math.min(shops.size(), 100), (Runnable r) -> {
                    Thread t = new Thread(r);
                    t.setDaemon(true);
                    return t;
                });

        List<CompletableFuture<String>> priceFutures = shops.stream()
                .map(shop -> CompletableFuture.supplyAsync(() -> shop.getName() + " price is " +
                        shop.getPrice(product), executor))
                .collect(Collectors.toList());

        //After this improvement(custom executor), the CompletableFutures solution takes
        // 1021 milliseconds to process five shops and
        // 1022 milliseconds to process nine shops.


        return priceFutures.stream()
                .map(CompletableFuture::join)
                .collect(toList());
    }




}
