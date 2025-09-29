package com.example;

import java.util.Random;

public class Race implements Runnable {

    private final int threadId;
    private long finishTime;

    public Race(int threadId) {
        this.threadId = threadId;
    }

    @Override
    public void run() {
        long startTime = System.currentTimeMillis();
        
        for (int i = 1; i <= 100; i++) {
            try {
                Thread.sleep(new Random().nextInt(200)); 
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        
        finishTime = System.currentTimeMillis() - startTime;
    }

    public long getFinishTime() {
        return finishTime;
    }

    public int getThreadId() {
        return threadId;
    }
}