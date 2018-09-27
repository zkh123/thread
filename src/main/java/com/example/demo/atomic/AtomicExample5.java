package com.example.demo.atomic;

import java.util.concurrent.atomic.AtomicIntegerFieldUpdater;

public class AtomicExample5 {

    private static AtomicIntegerFieldUpdater<AtomicExample5> updater =
            AtomicIntegerFieldUpdater.newUpdater(AtomicExample5.class,"count");

    private volatile int count = 100;
    public int getCount() {
        return count;
    }
    public void setCount(int count) {
        this.count = count;
    }

    /**
     * 变量原子性修改 （指定类 中的属性 非静态变量同事被volatile关键字修饰的）
     * @param args
     */
    public static void main(String[] args) {
        AtomicExample5 atomicExample5 = new AtomicExample5();

        if (updater.compareAndSet(atomicExample5,100,120)){
            System.out.println("update success 1 ," + atomicExample5.getCount());
        }

        if (updater.compareAndSet(atomicExample5,100,140)){
            System.out.println("update success 2," + atomicExample5.getCount());
        }else {
            System.out.println("update fail," + atomicExample5.getCount());
        }

    }
}
