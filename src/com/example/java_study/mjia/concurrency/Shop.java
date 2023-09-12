package com.example.java_study.mjia.concurrency;

import java.util.Random;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.Future;

public class Shop {
    private String name;

    public Shop(String shopName) {
        this.name  = shopName;
    }
    public double getPrice(String product) {
        return calculatePrice(product);
    }

    private double calculatePrice(String product) {
        delay();
        return Math.random() * product.charAt(0) + product.charAt(1);
    }

    public static void delay() {
        try {
            Thread.sleep(1000L);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    public Future<Double> getPriceAsync(String product) {
        CompletableFuture<Double> futurePrice = new CompletableFuture<>();
        new Thread( () -> {
            try {
                double price = calculatePrice(product);
                futurePrice.complete(price);
            } catch (Exception ex) {
                futurePrice.completeExceptionally(ex);  //propagate exception to the caller
            }
        }).start();
        return futurePrice;
    }

    public Future<Double> getPriceAsync2(String product) {
        //line below is  equivalent to the method above
        return CompletableFuture.supplyAsync(() -> calculatePrice(product));
    }


    public String getName() {
        return name;
    }
}
