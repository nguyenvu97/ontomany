package com.example.demo.Thread;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class CachedThreadPool {

    public void run(){
        ExecutorService executor = Executors.newCachedThreadPool();
        for (int i = 0; i < 1000; i++) {
            executor.submit(() -> {
                System.out.println("Task running on thread: " + Thread.currentThread().getName() + " ---- "+ Thread.activeCount());
            });
        }

        executor.shutdown();
    }
}
