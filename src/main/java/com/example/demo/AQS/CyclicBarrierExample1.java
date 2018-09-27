package com.example.demo.AQS;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class CyclicBarrierExample1 {
    /**
     * CyclicBarrier 跟 countDownLatch 相似的
     * 1,但CyclicBarrier的计数器 可以使用resumed()方法重置  循环使用
     *     countDownLatch计数器只能使用一次。
     * 2,CyclicBarrier场景：
     * countDownLatch：一个线程或者多个线程执行完某个操作之后才能继续往下进行
     *                 一个或者n个线程 等待其他线程的关系
     * CyclicBarrier：多个线程之间的等待，直到所有线程都满足条件之后才能继续进行
     *                各个线程之间内部等待的关系。
     *  例如：五个线程都执行了await()方法之后 再继续往下执行。
     *  CyclicBarrier能处理更复杂的业务场景。
     */
    private static CyclicBarrier cyclicBarrier = new CyclicBarrier(5);  //等待五个执行完  再执行后面的内容  5个线程 同步等待

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
     * ready 0
     * ready 1
     * ready 2
     * ready 3
     * ready 4
     * continue 4
     * continue 0
     * continue 1
     * continue 2
     * continue 3
     * ready 5
     * ready 6
     * ready 7
     * ready 8
     * ready 9
     * continue 9
     * continue 5
     * continue 7
     * continue 8
     * continue 6
     */

}
