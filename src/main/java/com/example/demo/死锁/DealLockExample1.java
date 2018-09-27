package com.example.demo.死锁;

public class DealLockExample1 implements Runnable {
    private int flag = 1;
    private static Object o1 = new Object(),o2 = new Object();

    @Override
    public void run() {
        if (flag == 1){
            System.out.println("11111111111111111111111");
            synchronized (o1){
                try {
                    Thread.sleep(500);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                synchronized (o2){
                    System.out.println("1");
                }
            }
        }

        if (flag == 0){
            System.out.println("000000000000000000000");
            synchronized (o2){
                try {
                    Thread.sleep(500);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                synchronized (o1){
                    System.out.println(0);
                }
            }
        }
    }


    public static void main(String[] args) {
        DealLockExample1 dealLock1 = new DealLockExample1();
        DealLockExample1 dealLock2 = new DealLockExample1();
        dealLock1.flag = 1;
        dealLock1.flag = 0;

        new Thread(dealLock1).start();
        new Thread(dealLock2).start();
    }
}
