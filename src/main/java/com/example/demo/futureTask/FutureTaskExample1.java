package com.example.demo.futureTask;

import java.util.concurrent.*;

public class FutureTaskExample1 {

    static class MyCallable implements Callable<String>{  //返回值类型为String

        @Override
        public String call() throws Exception {
            System.out.println("do something in callable");
            Thread.sleep(4000);  //模拟这个线程 执行任务 时间比较长
            return "Done";
        }
    }

    public static void main(String[] args) throws ExecutionException, InterruptedException {
        ExecutorService executorService = Executors.newCachedThreadPool();
        Future<String> future = executorService.submit(new MyCallable());

        System.out.println("do something in main");

        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        String result = future.get();

        System.out.println("看看线程执行返回的结果是什么 " + result);

        executorService.shutdown();
    }

}
