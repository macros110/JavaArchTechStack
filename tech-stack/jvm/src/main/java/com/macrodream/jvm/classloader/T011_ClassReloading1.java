package com.macrodream.jvm.classloader;

public class T011_ClassReloading1 {
    public static void main(String[] args) throws Exception {
        T006_MacClassLoader macClassLoader = new T006_MacClassLoader();
        Class clazz = macClassLoader.loadClass("com.macrodream.jvm.Hello");

        macClassLoader = null;
        System.out.println(clazz.hashCode());

        macClassLoader = null;

        macClassLoader = new T006_MacClassLoader();
        Class clazz1 = macClassLoader.loadClass("com.macrodream.jvm.Hello");
        System.out.println(clazz1.hashCode());

        System.out.println(clazz == clazz1);
    }
}
