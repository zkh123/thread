package com.example.demo.atomic;


import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Semaphore;
import java.util.concurrent.atomic.AtomicBoolean;

public class AtomicExample6 {

    private static AtomicBoolean isHappened = new AtomicBoolean(false);

    private static int clientTotal = 5000; //5000个请求
    private static int threadTotal = 200;  //200个线程的线程池
    /**
     * 某段代码 只执行一次的场景
     * @param args
     */
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
        System.out.println("isHappened ," + isHappened.get());
    }

    /**
     * 要求该段代码 只能被执行一次。（无论是高并发下 还是单线程下）
     */
    private static void test(){
        if (isHappened.compareAndSet(false,true)){
            System.out.println("execute");  //说的就是这段代码啊
        }

//        System.out.println("-------------");
    }
}
