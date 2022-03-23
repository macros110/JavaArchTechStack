package com.macrodream.pattern.singleton;

/**
 * @author Macros.Zhang
 * @date 3/23/2022 18:02
 *  lazy loading
 *  也称懒汉式
 *  虽然达到了按需初始化的目的，但却带来线程不安全的问题
 */
public class Yin03 {
    private static Yin03 INSTANCE;

    private Yin03() {
    }

    public static Yin03 getInstance() {
        if (INSTANCE == null) {
            try {
                Thread.sleep(1);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            INSTANCE = new Yin03();
        }
        return INSTANCE;
    }

    public void m() {
        System.out.println("Yin03 Lazy m");
    }

    public static void main(String[] args) {
        for (int i = 0; i < 100; i++) {
            new Thread(() -> {
                System.out.println(Yin03.getInstance().hashCode());
            }).start();
        }
    }
}
