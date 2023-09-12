package com.example.java_study.mjia.concurrency;

import java.util.concurrent.*;

public class FutureExample {

    public FutureExample() {
        ExecutorService executorService = Executors.newCachedThreadPool();
        Future<Double> future = executorService.submit(new Callable<Double>() {
            @Override
            public Double call() throws Exception {
                return doSomeLongComputation();
            }
        });

        //do something else
        //...

        try {
            Double result = future.get(1, TimeUnit.SECONDS);
        } catch (InterruptedException | ExecutionException | TimeoutException e) {
            throw new RuntimeException(e);
        }

    }

    private double doSomeLongComputation() {
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        return 1.0;
    }
}
