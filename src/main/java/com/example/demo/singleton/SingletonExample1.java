package com.example.demo.singleton;

/**
 * 懒汉模型
 * 缺点：下面加了synchronized关键字 保证了线程安全，但是多线程来调研这个类的时候 会导致性能的降低
 */
public class SingletonExample1 {

    //私有构造函数
    private SingletonExample1(){
        //TODO
    }

    //单例对象
    private static SingletonExample1 instance = null;

    /**
     * 静态工厂方法
     * @return
     */
    public synchronized static SingletonExample1 getInstance(){
        if (instance == null){
            instance = new SingletonExample1();
        }
        return instance;
    }

    /**
     * 安全发布对象
     */
    public static void main(){
        SingletonExample1.getInstance();
    }
}
