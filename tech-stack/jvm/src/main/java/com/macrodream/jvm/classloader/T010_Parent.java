package com.macrodream.jvm.classloader;

public class T010_Parent {
    private static T006_MacClassLoader parent = new T006_MacClassLoader();

    private static class MyLoader extends ClassLoader {
        public MyLoader() {
            super(parent);
            this.getParent();
            System.out.println(getSystemClassLoader());
        }
    }
}
