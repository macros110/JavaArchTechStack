package com.macrodream.juc.non_thread_safe;

import com.google.common.util.concurrent.ThreadFactoryBuilder;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Vector;
import java.util.concurrent.*;
import java.util.function.BiConsumer;
import java.util.function.Consumer;

/**
 * @author Macros.Zhang
 * @date 4/2/2022 11:50
 * 为什么ArrayList线程不安全
 *
 *  add(E) >>  elementData[size++] = e 非原子操作
 *
 */
public class T01_ArrayList {
    public static void main(String[] args) throws InterruptedException {
        //nonThreadSafe();
        nonThreadSafeWithPool();
    }

    private static void nonThreadSafeWithPool() throws InterruptedException {

        //List<Integer> list = new ArrayList<>();
        /**
         * 解决方案1 Vector  使用同步方法 锁粒度比较高
         * public synchronized boolean add(E e)
         */
        //Vector<Integer> list = new Vector<>();

        /**
         * 解决方案2 Collections.synchronizedList(new ArrayList<>())
         *      public static <T> List<T> synchronizedList(List<T> list) {
         *         return (list instanceof RandomAccess ?
         *                 new SynchronizedRandomAccessList<>(list) :
         *                 new SynchronizedList<>(list));
         *     }
         *
         *     //对象锁
         *     public boolean add(E e) {
         *         synchronized (mutex) {return c.add(e);}
         *     }
         *
         */
        //List<Integer> list = Collections.synchronizedList(new ArrayList<>());

        /**
         * 解决方案3 CopyOnWriteArrayList
         *
         *      public boolean add(E e) {
         *         final ReentrantLock lock = this.lock;
         *         lock.lock();
         *         try {
         *             Object[] elements = getArray();
         *             int len = elements.length;
         *             Object[] newElements = Arrays.copyOf(elements, len + 1);
         *             newElements[len] = e;
         *             setArray(newElements);
         *             return true;
         *         } finally {
         *             lock.unlock();
         *         }
         *     }
         *
         *     适合读多写少的场景
         */
        //List<Integer> list = new CopyOnWriteArrayList<>();

        /**
         * 解决方案4  ThreadLocal
         * 使用ThreadLocal变量确保线程封闭性(封闭线程往往是比较安全的， 但由于使用ThreadLocal封装变量，
         * 相当于把变量丢进执行线程中去，每new一个新的线程，变量也会new一次，一定程度上会造成性能[内存]损耗，
         * 但其执行完毕就销毁的机制使得ThreadLocal变成比较优化的并发解决方案)。
         *
         */
        ThreadLocal<List<Integer>> threadLocal = new ThreadLocal<List<Integer>>() {

            @Override
            protected List<Integer> initialValue() {
                return new ArrayList<>();
            }
        };
        List<Integer> list = threadLocal.get();

        int thread_count = 100;
        ThreadFactory namedThreadFactory = new ThreadFactoryBuilder()
                .setNameFormat("demo-pool-%d").build();
        ExecutorService pool = new ThreadPoolExecutor(100, 100,
                0L, TimeUnit.MILLISECONDS,
                new LinkedBlockingQueue<Runnable>(1024), namedThreadFactory, new ThreadPoolExecutor.AbortPolicy());
        for (int i = 0; i < thread_count; i++) {
            int finalI = i;
            pool.execute(()-> {
                try {
                    Thread.sleep(100);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                list.add(finalI);
            });
        }
        pool.shutdown();

        Thread.sleep(2000);

        list.forEach(consumerWithIndex((item,index) -> {
            System.out.println("list[" + index + "] = " + item);
        }));
    }

    public static <T>Consumer<T> consumerWithIndex(BiConsumer<T, Integer> consumer) {
        class Obj {
            int i;
        }
        Obj obj = new Obj();
        return t -> {
            int index = obj.i++;
            consumer.accept(t, index);
        };
    }

    private static void nonThreadSafe() throws InterruptedException {
        int loop_count1 = 1000;
        int loop_count2 = 2000;
        final List<Integer> list =  new ArrayList<>();
        new Thread(() -> {
            for (int i = 0; i < loop_count1; i++) {
                list.add(i);
                try {
                    Thread.sleep(1);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }).start();
        new Thread(() -> {
            for (int i = loop_count1; i < loop_count2; i++) {
                list.add(i);
                try {
                    Thread.sleep(1);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }).start();

        Thread.sleep(loop_count1);

        for (int i = 0; i < list.size(); i++) {
            System.out.println("第" + (i + 1) + "个元素为：" + list.get(i));
        }
    }
}
