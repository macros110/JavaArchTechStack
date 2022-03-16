package com.macrodream.jvm.classloader;

public class T008_LazyLoading {
    public static void main(String[] args) throws ClassNotFoundException {
        P p;
        X x = new X();
        System.out.println(P.i);
        System.out.println(P.j);
        Class.forName("com.macrodream.jvm.classloader.T008_LazyLoading$P");
    }

    public static class P {
        final static int i = 8;
        static int j = 9;
        static {
            System.out.println("P");
        }
    }

    public static class X extends P {
        static {
            System.out.println("X");
        }
    }
}
