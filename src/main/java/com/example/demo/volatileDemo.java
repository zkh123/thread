package com.example.demo;

public class volatileDemo {


    /**
    1,volatile关键字 修饰一个状态标记量。前面干完了事情 后面紧接着干。

    volatile boolean inited = false;

    //线程1
    context = loadContext();  //线程1做的事情
    inited = true;

    //线程2
    while(!inited){
        sleep();
    }
    doSomethingWithConfig(context);

     */
}
