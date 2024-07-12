package com.example.demo.Thread;


import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class FixedThreadPool  {
    int number;

    public FixedThreadPool(int number) {
        this.number = number;
    }

    public void run (){
        ExecutorService executorService = Executors.newFixedThreadPool(this.number);
        for (int i = 0; i < 10; i++) {
            executorService.submit(() -> {
                System.out.println("Task running on thread: " + Thread.currentThread().getName());
            });
        }
        executorService.shutdown();;
    }
}
