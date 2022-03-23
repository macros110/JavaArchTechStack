package com.macrodream.pattern.singleton;

/**
 * @author Macros.Zhang
 * @date 3/23/2022 18:19
 *  lazy loading
 *  也称懒汉式
 *  虽然达到了按需初始化的目的，但却带来线程不安全的问题
 *  可以通过synchronized解决，但也带来效率下降
 */
public class Yin04 {
    private static Yin04 INSTANCE;

    private Yin04() {
    }

    public static synchronized Yin04 getInstance() {
        if (INSTANCE == null) {
            try {
                Thread.sleep(1);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            INSTANCE = new Yin04();
        }
        return INSTANCE;
    }

    public void m() {
        System.out.println("Yin03 Lazy m");
    }

    public static void main(String[] args) {
        for (int i = 0; i < 100; i++) {
            new Thread(() -> {
                System.out.println(Yin04.getInstance().hashCode());
            }).start();
        }
    }
}
