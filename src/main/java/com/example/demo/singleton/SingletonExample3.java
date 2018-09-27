package com.example.demo.singleton;

/**
 * 懒汉模型
 * 缺点：下面加了synchronized关键字 保证了线程安全，但是多线程来调研这个类的时候 会导致性能的降低
 */
public class SingletonExample3 {

    //私有构造函数
    private SingletonExample3(){
        //TODO
    }

    //单例对象 (valatile 双层检测机制 防止指令重排)
    private volatile static SingletonExample3 instance = null;

    /**
     * 静态工厂方法
     * @return
     */
    public static SingletonExample3 getInstance(){
        if (instance == null){
            synchronized (SingletonExample3.class){
                instance = new SingletonExample3();
            }
        }
        return instance;
    }

    /**
     * 安全发布对象
     */
    public static void main(){
        SingletonExample3.getInstance();
    }
}
