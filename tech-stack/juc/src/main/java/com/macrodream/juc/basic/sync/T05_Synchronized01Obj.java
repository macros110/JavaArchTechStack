package com.macrodream.juc.basic.sync;

public class T05_Synchronized01Obj {

    private int count = 10;
    private Object o = new Object();

    public void m() {
        /*任何线程要执行{}代码块，必须拿到o的锁*/
        synchronized (o) {
            count--;
            System.out.println(Thread.currentThread().getName() + "count = " + count);
        }
    }
}
