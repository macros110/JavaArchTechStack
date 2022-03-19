package com.macrodream.juc.basic;

public class T02_HowToCreateThread {
    static class MyThread extends Thread {
        @Override
        public void run() {
            System.out.println("Hi MyThread!");
        }
    }

    static class MyRun implements Runnable {

        @Override
        public void run() {
            System.out.println("Hi MyRun!");
        }
    }

    public static void main(String[] args) {
        new MyThread().start();
        new Thread(new MyRun()).start();
        new Thread(() -> {
            System.out.println("Hi Lambda!");
        }).start();
    }
}
//启动线程的三种方式：1 Thread, 2 Runnable , 3 Executors.newCachedThread
