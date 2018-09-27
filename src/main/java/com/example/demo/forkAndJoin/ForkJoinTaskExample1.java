package com.example.demo.forkAndJoin;

import java.util.concurrent.RecursiveTask;

/**
 * 通过递归将大任务不断的切分成不同的任务
 * 然后生成阻塞队列
 * 一个阻塞队列中任务执行完了 它会跑去帮忙执行别的队列中的任务，一个从上往下 一个从下往上 直到汇聚
 *
 * 实际场景中 很难实现 看看就行。
 */
public class ForkJoinTaskExample1 extends RecursiveTask<Integer> {
    @Override
    protected Integer compute() {
        return null;
    }
}
