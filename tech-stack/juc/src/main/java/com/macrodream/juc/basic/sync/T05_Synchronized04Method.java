package com.macrodream.juc.basic.sync;

public class T05_Synchronized04Method {

    private int count = 10;

    /**等同于在方法代码执行时要synchronized (this)*/
    public synchronized void m() {
        count--;
        System.out.println(Thread.currentThread().getName() + "count = " + count);
    }

    public void n() {
        count++;
    }
}
