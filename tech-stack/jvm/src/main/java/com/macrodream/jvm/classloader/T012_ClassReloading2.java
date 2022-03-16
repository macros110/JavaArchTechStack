package com.macrodream.jvm.classloader;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;

public class T012_ClassReloading2 {
    private static class MyLoader extends ClassLoader {
        @Override
        public Class<?> loadClass(String name) throws ClassNotFoundException {
            File f = new File(
                    "D:\\Develop\\java\\ideaProjs\\JavaArchTechStack\\tech-stack\\jvm\\target\\classes\\"
                    + name.replace(".","/").concat(".class"));
            if (!f.exists()) {
                return super.loadClass(name);
            }
            InputStream is = null;
            try {
                is = new FileInputStream(f);
                byte[] b = new byte[is.available()];
                is.read(b);
                return defineClass(name, b, 0, b.length);
            } catch (Exception e) {
                e.printStackTrace();
            } finally {
                if (is != null) {
                    try {
                        is.close();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
            }
            return super.loadClass(name);
        }
    }

    public static void main(String[] args) throws Exception {
        MyLoader myLoader = new MyLoader();
        Class clazz = myLoader.loadClass("com.macrodream.jvm.Hello");
        System.out.println(clazz.hashCode());

        myLoader = new MyLoader();
        Class clazzNew = myLoader.loadClass("com.macrodream.jvm.Hello");
        System.out.println(clazzNew.hashCode());
        System.out.println(clazzNew == clazz);

    }
}
