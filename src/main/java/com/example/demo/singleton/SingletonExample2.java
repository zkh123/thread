package com.example.demo.singleton;

/**
 * 恶汉模式。
 * 缺点： 一开始就创建对象了，会导致不被立即使用的资源一开始就会被加载。
 */
public class SingletonExample2 {

    //私有构造函数
    private SingletonExample2(){
        //TODO
    }

    //单例对象
    private static SingletonExample2 instance = new SingletonExample2();

    /**
     * 静态工厂方法
     * @return
     */
    public  static SingletonExample2 getInstance(){
        return instance;
    }

    /**
     * 安全发布对象
     */
    public static void main(){
        SingletonExample2.getInstance();
    }
}
