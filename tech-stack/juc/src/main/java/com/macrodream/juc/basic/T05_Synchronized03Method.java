package com.macrodream.juc.basic;

public class T05_Synchronized03Method {

    private int count = 10;

    /**等同于在方法代码执行时要synchronized (this)*/
    public synchronized void m() {
        count--;
        System.out.println(Thread.currentThread().getName() + "count = " + count);
    }
}
