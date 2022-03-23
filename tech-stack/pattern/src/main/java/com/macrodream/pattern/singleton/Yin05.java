package com.macrodream.pattern.singleton;

/**
 * @author Macros.Zhang
 * @date 3/23/2022 18:30
 */
public class Yin05 {
    private static Yin05 INSTANCE;

    private Yin05() {
    }

    public static Yin05 getInstance() {
        if (INSTANCE == null) {
            /*妄图通过减小同步代码块的方式提高效率，然后不可行*/
            synchronized (Yin05.class) {
                try {
                    Thread.sleep(1);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            INSTANCE = new Yin05();
        }
        return INSTANCE;
    }

    public void m() {
        System.out.println("Yin05 m");
    }

    public static void main(String[] args) {
        for (int i = 0; i < 100; i++) {
            new Thread(() -> {
                System.out.println(Yin05.getInstance().hashCode());
            }).start();
        }
    }
}
