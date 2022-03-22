package com.macrodream.juc.basic.sync;

public class T05_Synchronized05MethodClass {

    private static int count = 10;

    /**等同于在方法代码执行时要synchronized (T05_Synchronized05MethodClass.class)*/
    public synchronized static void m() {
        count--;
        System.out.println(Thread.currentThread().getName() + "count = " + count);
    }

    public static void mm() {
        /*考虑一下这里写synchronized(this)是否可以*/
        synchronized (T05_Synchronized05MethodClass.class) {
            count--;
        }
    }
}
