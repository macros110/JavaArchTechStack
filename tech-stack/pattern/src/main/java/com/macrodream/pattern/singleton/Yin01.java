package com.macrodream.pattern.singleton;

/**
 *  饿汉式
 *      类加载到内存后，就实例化一个单例，JVM保证线程安全
 *      简单实用，推荐使用！Runtime
 *      唯一缺点：不管用到与否，类装载是就完成实例化
 *      Class.forName("")
 *      话说你不用的，你装载它干啥？
 * @author Macros.Zhang
 */
public class Yin01 {
    private static final Yin01 INSTANCE = new Yin01();

    private Yin01() {}

    public static Yin01 getInstance() {
        return INSTANCE;
    }

    public void m() {
        System.out.println("Yin01 Hunger m");
    }

    public static void main(String[] args) {
        Yin01 y1 = Yin01.getInstance();
        Yin01 y2 = Yin01.getInstance();
        System.out.println(y1 == y2);
        y1.m();
        y2.m();
    }
}
