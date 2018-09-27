package com.example.demo.AQS;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class CountDownLatchExample2 {

    private static int threadCount = 200;

    public static void main(String[] args) throws InterruptedException {
        ExecutorService executorService = Executors.newCachedThreadPool();

        final CountDownLatch countDownLatch = new CountDownLatch(threadCount);

        for (int i = 0 ; i < threadCount ; i ++){
            final int threadNum = i;
            executorService.execute(()->{
                try {
                    test(threadNum);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }finally {
                    countDownLatch.countDown();
                }
            });
        }
        /**
         * 在实际需求中 可能会存在一些方法的执行 我们需要控制时间  超过多长时间 我们就不等待了 直接过。
         * 我们可以看到 下面每个方法 都超过10毫秒 所以 finsh是最先打印出来的
         * 具体这个10毫秒  是指哪个时间  有待进一步的学习和研究的。
         */
        countDownLatch.await(10,TimeUnit.MILLISECONDS);  //等待10毫秒  这个时间是 test()方法的执行时间。
        System.out.println("finsh");
        executorService.shutdown();  //关闭资源
    }

    private static void test(int threadNum) throws InterruptedException {
        if (threadNum == 100){
            Thread.sleep(100);
        }
        System.out.println(threadNum);
    }
}
