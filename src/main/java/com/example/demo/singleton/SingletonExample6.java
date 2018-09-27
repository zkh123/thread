package com.example.demo.singleton;

/**
 * 枚举模式
 * 绝对的推荐 安全性更好，也是在实际调用时才被创建对象
 */
public class SingletonExample6 {

    //私有构造函数
    private SingletonExample6(){
        //TODO
    }

    /**
     * 静态工厂方法
     * @return
     */
    public  static SingletonExample6 getInstance(){
        return Singleton.INSTANCE.getInstance();
    }

    private enum Singleton{
        INSTANCE;

        private SingletonExample6 singleton;

        //jvm保证这个方法绝对只调用一次
        Singleton(){
            singleton = new SingletonExample6();
        }

        public SingletonExample6 getInstance(){
            return singleton;
        }
    }

    public static void main(String[] args) {
        System.out.println(getInstance().hashCode());
        System.out.println(getInstance().hashCode());
    }
}
