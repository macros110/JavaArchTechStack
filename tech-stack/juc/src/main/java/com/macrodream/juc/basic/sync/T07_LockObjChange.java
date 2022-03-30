package com.macrodream.juc.basic.sync;

import java.util.concurrent.TimeUnit;

/**
 * @author Macros.Zhang
 * @date 3/23/2022 22:20
 * 锁定o，如果o是属性发生变化，不影响锁的使用
 * 但o变成另一个对象，则锁定对象发生改变
 * 应该避免将锁对象的引用变成另外对象
 */
public class T07_LockObjChange {
    /*final*/  Object o = new Object();

    void m() {
        synchronized (o) {
            while (true) {
                try {
                    TimeUnit.SECONDS.sleep(1);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println(Thread.currentThread().getName());
            }
        }
    }

    public static void main(String[] args) {
        T07_LockObjChange t = new T07_LockObjChange();

        new Thread(t::m, "t1").start();

        Thread t2 = new Thread(t::m, "t2");

        /*锁对象发生改变，所有t2线程得以执行，如果注释掉这句，线程2将永远得不到执行*/
        t.o = new Object();

        t2.start();
    }
}
