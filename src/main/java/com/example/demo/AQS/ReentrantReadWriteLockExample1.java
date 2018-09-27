package com.example.demo.AQS;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;
import java.util.concurrent.locks.ReentrantReadWriteLock;

/**
 * 使用场景很少 了解
 */
public class ReentrantReadWriteLockExample1 {

    private final static Map<String,Object> map = new TreeMap<>();
    private final static ReentrantReadWriteLock lock = new ReentrantReadWriteLock();
    private final static ReentrantReadWriteLock.ReadLock readLock = lock.readLock();
    private final static ReentrantReadWriteLock.WriteLock writeLock = lock.writeLock();

    public  Object get(String key){
        readLock.lock();
        try {
            return map.get(key);
        }finally {
            readLock.unlock();
        }
    }

    public  Set<String> getAllKey(){
        readLock.lock();
        try {
            return map.keySet();
        }finally {
            readLock.unlock();
        }
    }

    public  void put(String key,Object value){
        writeLock.lock();
        try {
            map.put(key,value);
        }finally {
            writeLock.unlock();
        }
    }

    public static void main(String[] args) {
        ReentrantReadWriteLockExample1 reentrantReadWriteLockExample1 = new ReentrantReadWriteLockExample1();
        reentrantReadWriteLockExample1.put("key","value");
        reentrantReadWriteLockExample1.put("1","111");

        System.out.println(reentrantReadWriteLockExample1.getAllKey().size());
    }
}
