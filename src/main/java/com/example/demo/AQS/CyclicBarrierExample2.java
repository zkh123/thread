package com.example.demo.AQS;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class CyclicBarrierExample2 {
    private static CyclicBarrier cyclicBarrier = new CyclicBarrier(5,()->{
        System.out.println("callback is running 我是额外操作 最后执行。");
    });

    public static void main(String[] args) throws InterruptedException {
        ExecutorService executors = Executors.newCachedThreadPool();

        for (int i = 0 ; i < 10 ; i++){
            final int threadNum = i;
            Thread.sleep(1000);
            executors.execute(()->{
                try {
                    race(threadNum);
                } catch (BrokenBarrierException e) {
                    e.printStackTrace();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            });
        }

        executors.shutdown();
    }

    private static void race(int threadNum) throws BrokenBarrierException, InterruptedException {
        System.out.println("ready " +threadNum);
        cyclicBarrier.await();  //核心方法
        System.out.println("continue " + threadNum);
    }

    /**
     ready 0
     ready 1
     ready 2
     ready 3
     ready 4
     callback is running 我是额外操作 最后执行。
     continue 4
     continue 0
     continue 3
     continue 2
     continue 1
     ready 5
     ready 6
     ready 7
     ready 8
     ready 9
     callback is running 我是额外操作 最后执行。
     continue 9
     continue 5
     continue 6
     continue 8
     continue 7
     */

}
