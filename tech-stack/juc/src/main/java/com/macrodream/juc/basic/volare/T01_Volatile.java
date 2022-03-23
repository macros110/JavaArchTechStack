package com.macrodream.juc.basic.volare;

import java.util.concurrent.TimeUnit;

/**
 *  volatile两个作用
 *      1. 保证线程的可见性
 *          MESI
 *          缓存一致性协议
 *      2. 禁止指令的重排序(CPU)
 *          每次写CPU都看得到
 *          DCL(Double Check Lock)单例
 */
public class T01_Volatile {
    /*对比一下有无volatile的情况下，整个程序运行的区别*/
    /*volatile*/ boolean running = true;

    void m() {
        System.out.println("m start");
        while (running) {
            /*
            try {
                TimeUnit.MILLISECONDS.sleep(10);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }*/
        }
        System.out.println("m end");
    }

    public static void main(String[] args) {
        T01_Volatile t = new T01_Volatile();

        new Thread(t::m, "t1").start();

        //lambda表达式 new Thread(new Runnable(run(){m()}))

        try {
            TimeUnit.SECONDS.sleep(1);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        t.running = false;
    }
}
