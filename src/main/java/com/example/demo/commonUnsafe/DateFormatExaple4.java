package com.example.demo.commonUnsafe;

import java.text.SimpleDateFormat;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Semaphore;

public class DateFormatExaple4 {

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

    /**
     * 这么写 就不会有问题的。
     * 使用堆栈封闭的思想
     * 讲对象放到方法里面去 每次都是创建一个新的对象
     */
    private static void test(){
        try {
            SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyyMMdd");
            simpleDateFormat.parse("20180921");
        }catch (Exception e){
            System.out.println("pares fail " + e.toString());
        }
    }

}
