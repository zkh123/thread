package com.example.demo.commonUnsafe;

import java.text.SimpleDateFormat;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Semaphore;
import java.util.logging.SimpleFormatter;

public class DateFormatExaple3 {

    /**
     * 执行报错 SimpleDateFormat 不是一个线程安全的对象
     */
    private static SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyyMMdd");

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
                    test();
                    semaphore.release();
                }catch (Exception e){
                    System.out.println("exception " + e.toString());
                }
                countDownLatch.countDown();
            });
        }
        countDownLatch.await();
        executorService.shutdown();
//        System.out.println("stringBuilder size : " + stringBuilder.length());
    }

    private static void test(){
        try {
            simpleDateFormat.parse("20180921");
        }catch (Exception e){
            System.out.println("pares fail " + e.toString());
        }
    }

}
