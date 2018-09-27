package com.example.demo.atomic;

import java.util.concurrent.atomic.AtomicReference;

public class AtomicExample4 {

    private static AtomicReference<Integer> count = new AtomicReference<>(0);

    private static AtomicReference<Integer> count1 = new AtomicReference<>(1);


    public static void main(String[] args) {
        test1();
        test2();
    }

    public static void test1(){
        count.compareAndSet(0,2);  //如果count是0 就更新为2; 否则就不变。
        count.compareAndSet(0,1);
        count.compareAndSet(1,3);
        count.compareAndSet(2,4);
        count.compareAndSet(3,5);
        System.out.println(count.get());  //4
    }

    public static void test2(){
        count1.compareAndSet(0,2);
        count1.compareAndSet(0,1);
        count1.compareAndSet(1,3);
        count1.compareAndSet(2,4);
        count1.compareAndSet(3,5);
        System.out.println(count1.get());  //5
    }
}
