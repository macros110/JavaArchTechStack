package com.macrodream.pattern.singleton;

/**
 * @author Macros.Zhang
 * @date 3/23/2022 18:41
 *  DCL
 */
public class Yin06 {
    /**
     * JIT
     *  volatile防止指令重排序的问题
     */
    private static volatile Yin06 INSTANCE;
    private Yin06() {}

    public static Yin06 getInstance() {
        /*业务代码省略*/
        if (null == INSTANCE) {
            /*双重检查*/
            synchronized (Yin06.class) {
                if (null == INSTANCE) {
                    try {
                        Thread.sleep(10);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    INSTANCE = new Yin06();
                }
            }
        }
        return INSTANCE;
    }

    public void m() {
        System.out.println("Yin06 DCL m");
    }

    public static void main(String[] args) {
        for (int i = 0; i < 100; i++) {
            new Thread(() -> {
                System.out.println(Yin06.getInstance().hashCode());
            }).start();
        }
    }
}
