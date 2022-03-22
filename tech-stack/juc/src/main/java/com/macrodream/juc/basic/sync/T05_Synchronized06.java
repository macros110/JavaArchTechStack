package com.macrodream.juc.basic.sync;

public class T05_Synchronized06 implements Runnable {

    private /*volatile*/ int count = 100;

    @Override
    public /*synchronized*/ void run() {
        count--;
        System.out.println(Thread.currentThread().getName() + " count = " + count);
    }

    public static void main(String[] args) {
        T05_Synchronized06 t = new T05_Synchronized06();
        for (int i = 0; i < 100; i++) {
            //T05_Synchronized06 t = new T05_Synchronized06();
            new Thread(t, "THREAD" + i).start();
        }
    }
}
