package com.example.demo.futureTask;

import java.util.concurrent.*;

public class FutureTaskExample2 {

    public static void main(String[] args) throws ExecutionException, InterruptedException {

        /**
         * 定义好 任务 直接执行就好
         * 后面等待拿到返回值 然后继续进行其他的操作
         */
        FutureTask<String> futureTask = new FutureTask<String>(new Callable<String>() {
            @Override
            public String call() throws Exception {
                System.out.println("do something in callable");
                Thread.sleep(4000);  //模拟这个线程 执行任务 时间比较长
                return "Done";
            }
        });

        new Thread(futureTask).start();

        System.out.println("do something in main");

        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }


        String result = futureTask.get();

        System.out.println("看看线程执行返回的结果是什么 " + result);
    }
}
