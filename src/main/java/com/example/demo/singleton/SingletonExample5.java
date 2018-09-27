package com.example.demo.singleton;

/**
 * 恶汉模式。
 * 缺点： 一开始就创建对象了，会导致不被立即使用的资源一开始就会被加载。
 */
public class SingletonExample5 {

    //私有构造函数
    private SingletonExample5(){
        //TODO
    }

    /**
     * 千万注意静态代码块的位置
     */
    static {
        instance = new SingletonExample5();
    }

    //单例对象
    private static SingletonExample5 instance = null;

    /**
     * 静态工厂方法
     * @return
     */
    public  static SingletonExample5 getInstance(){
        return instance;
    }

    /**
     * 安全发布对象
     * 会报空指针异常
     */
    public static void main(String[] args){
        System.out.println(getInstance().hashCode());
        System.out.println(getInstance().hashCode());
    }
}
