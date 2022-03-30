package com.macrodream.juc.atomic;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * @author Macros.Zhang
 * @date 3/25/2022 12:11
 * volitale不保证原子性，使用AtomicXXX类
 * AtomicXXX类本身方法都是原子性的(CAS)，但不能保证多个方法连续调用时原子性的
 */
public class T01_AtomicInteger {

    /*volatile*/  //int count = 0;

    AtomicInteger count = new AtomicInteger(0);

    /*synchronized*/ void m() {
        for (int i = 0; i < 10000; i++) {
            count.incrementAndGet();
        }
    }

    public static void main(String[] args) {
        T01_AtomicInteger t = new T01_AtomicInteger();
        List<Thread> threads =  new ArrayList<Thread>();
        for (int i = 0; i < 10; i++) {
            threads.add(new Thread(t::m, "thread-"+i));
        }

        threads.forEach((o) -> o.start());

        threads.forEach((o) -> {
            try {
                o.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });
        System.out.println(t.count);
    }
}
