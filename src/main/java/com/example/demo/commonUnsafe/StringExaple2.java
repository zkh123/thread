package com.example.demo.commonUnsafe;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Semaphore;

public class StringExaple2 {

    private static StringBuffer stringBuffer = new StringBuffer();

    private static int clientTotal = 5000; //5000个请求
    private static int threadTotal = 200;  //200个线程的线程池


    public static void main(String[] args) throws InterruptedException {
        ExecutorService executorService = Executors.newCachedThreadPool();
        final Semaphore semaphore = new Semaphore(threadTotal);
        final CountDownLatch countDownLatch = new CountDownLatch(clientTotal);
        for (int i = 0 ; i < clientTotal ; i++){
            executorService.execute(() -> {
                try {
                    semaphore.acquire();
                    update();
                    semaphore.release();
                }catch (Exception e){
                    System.out.println("exception " + e.toString());
                }
                countDownLatch.countDown();
            });
        }
        countDownLatch.await();
        executorService.shutdown();
        /**
         * 正常是5000 但是实际上每次都是5000  所以stringBuffer是一个线程不安全的类
         */
        System.out.println("stringBuffer size : " + stringBuffer.length());
    }

    private static void update(){
        stringBuffer.append(1);
    }

}
