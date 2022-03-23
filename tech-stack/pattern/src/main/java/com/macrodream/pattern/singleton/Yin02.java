package com.macrodream.pattern.singleton;

/**
 * @author Macros.Zhang
 *      跟01一个意思
 */
public class Yin02 {
    private static final Yin02 INSTANCE;
    static {
        INSTANCE = new Yin02();
    }

    private Yin02() {}

    public static Yin02 getInstance() {
        return INSTANCE;
    }

    public void m() {
        System.out.println("Yin02 Hunger m");
    }

    public static void main(String[] args) {
        Yin02 y1 = Yin02.getInstance();
        Yin02 y2 = Yin02.getInstance();
        System.out.println(y1 = y2);
    }
}
