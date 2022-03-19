package com.macrodream.juc.basic;

import sun.misc.PostVMInitHook;

import java.util.concurrent.TimeUnit;

public class T05_Synchronized11Error {
    int count = 0;
    synchronized void m() {
        System.out.println(Thread.currentThread().getName() + " start");
        while (true) {
            count++;
            System.out.println(Thread.currentThread().getName() + " count = " + count);
            try {
                TimeUnit.SECONDS.sleep(1);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            if (count == 5) {
                /*此处抛出异常，锁将释放，要想不释放，可以在这里进行catch，然后让循环继续*/
                int i = 1 / 0;
                System.out.println(i);
            }
        }
    }

    public static void main(String[] args) {
        T05_Synchronized11Error t =  new T05_Synchronized11Error();
        new Thread(t::m,"t1").start();

        try {
            TimeUnit.SECONDS.sleep(3);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        new Thread(t::m, "t2").start();
    }
}
