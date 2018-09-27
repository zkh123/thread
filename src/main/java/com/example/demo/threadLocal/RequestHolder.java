package com.example.demo.threadLocal;

public class RequestHolder {
    private final static ThreadLocal<Long> requestHolder = new ThreadLocal<>();

    /**
     * 请求进入后台服务器 但是还没有进行实际业务处理  使用过滤器
     * @param id
     */
    public static void add(Long id){
        requestHolder.set(id);
    }

    public static Long getId(){
        return requestHolder.get();
    }

    /**
     * 执行完业务结束的时候 操作。 使用拦截器
     */
    public static void remove(){
        requestHolder.remove();
    }
}