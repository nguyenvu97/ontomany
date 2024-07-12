package com.example.demo.Thread;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class SingleThreadExecutor {

    public void run(){
        ExecutorService executor = Executors.newSingleThreadExecutor();
        for (int i = 0; i < 1000; i++) {
            executor.submit(() -> {
                System.out.println("Task running on thread: " + Thread.currentThread().getName() + " ---- "+ Thread.activeCount());
            });
        }

        executor.shutdown();
    }
}
