package com.example.demo.AQS;

import java.util.concurrent.Semaphore;

public class SemaphoreExample1 {
    /**
     * Semaphore 是信号量。允许同时能并发线程的数据。
     * 控制并发量的。
     */
    public static void main(String[] args) {
        Semaphore semaphore = new Semaphore(10);
    }
}
