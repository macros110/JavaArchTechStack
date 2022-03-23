package com.macrodream.juc.basic.volare;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Macros.Zhang
 * @date 3/23/2022 21:04
 */
public class T02_Volatile {
    volatile int count = 0;
    void m() {
        for (int i = 0; i < 10000; i++) {
            count++;
        }
    }

    public static void main(String[] args) {
        T02_Volatile t = new T02_Volatile();
        List<Thread> threads = new ArrayList<>();
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
