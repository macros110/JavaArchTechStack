package com.macrodream.juc.basic;

public class T05_Synchronized02Obj {

    private int count = 10;

    public void m() {
        /*任何线程要执行{}代码块，必须拿到this的锁*/
        synchronized (this) {
            count--;
            System.out.println(Thread.currentThread().getName() + "count = " + count);
        }
    }
}
