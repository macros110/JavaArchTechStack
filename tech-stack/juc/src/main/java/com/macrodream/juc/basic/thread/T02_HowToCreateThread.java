package com.macrodream.juc.basic.thread;

import java.util.concurrent.*;

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

    static class MyCallable implements Callable<String> {

        @Override
        public String call() throws Exception {
            System.out.println("Hi MyCallable");
            return "ok";
        }
    }

    public static void main(String[] args) {
        /*1.继承Thread*/
        new MyThread().start();

        /*2.实现Runnable(lambda形式),传给new Thread构造*/
        new Thread(new MyRun()).start();
        new Thread(() -> {
            System.out.println("Hi Lambda!");
        }).start();

        /*3. 实现Callable，Futuretask构造传参*/
        FutureTask task = new FutureTask<>(new MyCallable());
        new Thread(task).start();
        new Thread(new FutureTask<String>(() -> {
            System.out.println("Hi Callable Lambda!");
            return "ok";
        })).start();

        /*4. ExecutorService*/
        ExecutorService service = new ThreadPoolExecutor(2, 3, 10L,
                TimeUnit.SECONDS, new ArrayBlockingQueue<Runnable>(3));
        service.submit(() -> {
            System.out.println("Hi ThreadPool Run 1");
        });
        service.submit(() -> {
            System.out.println("Hi ThreadPool Run 2");
        });
        service.submit(new FutureTask<String>(()->{
            System.out.println("Hi ThreadPool Call 1");
            return "ok";
        }));
        service.shutdown();
    }
}
//启动线程的三种方式：1 Thread, 2 Runnable , 3 Executors.newCachedThread
