package com.macrodream.juc.basic.sync;

import com.macrodream.juc.basic.volare.T01_Volatile;
import com.macrodream.juc.basic.volare.T02_Volatile;

import java.util.concurrent.TimeUnit;

/**
 * @author Macros.Zhang
 * @date 3/23/2022 21:14
 */
public class T06_FineCoarseLock {
    int count = 0;

    synchronized void m1() {
        try {
            TimeUnit.SECONDS.sleep(2);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        for (int i = 0; i < Integer.MAX_VALUE; i++) {
            count++;
        }

        try {
            TimeUnit.SECONDS.sleep(2);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    void m2() {
        try {
            TimeUnit.SECONDS.sleep(2);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        synchronized (this) {
            for (int i = 0; i < Integer.MAX_VALUE; i++) {
                count++;
            }
        }

        try {
            TimeUnit.SECONDS.sleep(2);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        T06_FineCoarseLock t = new T06_FineCoarseLock();
        long start = System.currentTimeMillis();
        t.m1();
        long mid = System.currentTimeMillis();
        t.m2();
        long end = System.currentTimeMillis();
        System.out.println(mid-start);
        System.out.println(end-mid);
    }
}
