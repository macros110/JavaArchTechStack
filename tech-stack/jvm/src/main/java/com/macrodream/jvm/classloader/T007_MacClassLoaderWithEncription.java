package com.macrodream.jvm.classloader;

import com.macrodream.jvm.Hello;

import java.io.*;

public class T007_MacClassLoaderWithEncription extends ClassLoader{

    public static int seed = 0B101101110;

    @Override
    protected Class<?> findClass(String name) throws ClassNotFoundException {
        File f = new File("D:\\Develop\\java\\ideaProjs\\JavaArchTechStack\\tech-stack\\jvm\\target\\classes\\",
                name.replaceAll("\\.", "/").concat(".macclass"));
        FileInputStream fis = null;
        ByteArrayOutputStream baos = null;
        try {
           fis = new FileInputStream(f);
           baos = new ByteArrayOutputStream();
           int b = 0;
           while ((b=fis.read()) != 0) {
               baos.write(b ^ seed);
           }
           byte[] bytes = baos.toByteArray();

           return defineClass(name, bytes, 0, bytes.length);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (baos != null) {
                try {
                    baos.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if (fis != null) {
                try {
                    fis.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
        return super.findClass(name);
    }


    public static void main(String[] args) throws Exception {
        encFile("com.macrodream.jvm.Hello");
        ClassLoader l = new T007_MacClassLoaderWithEncription();
        Class clazz = l.loadClass("com.macrodream.jvm.Hello");
        Hello h = (Hello) clazz.newInstance();
        h.m();

        System.out.println(l.getClass().getClassLoader());
        System.out.println(l.getParent());
    }

    private static void encFile(String name) {
        File f = new File("D:\\Develop\\java\\ideaProjs\\JavaArchTechStack\\tech-stack\\jvm\\target\\classes\\",
                name.replaceAll("\\.", "/").concat(".class"));
        FileInputStream fis = null;
        FileOutputStream fos = null;
        try {
            fis = new FileInputStream(f);
            fos = new FileOutputStream(
                    new File("D:\\Develop\\java\\ideaProjs\\JavaArchTechStack\\tech-stack\\jvm\\target\\classes\\",
                    name.replaceAll("\\.", "/").concat(".macclass")));
            int b = 0;
            while ((b=fis.read()) != 0) {
                fos.write(b ^ seed);
            }

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (fos != null) {
                try {
                    fos.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if (fis != null) {
                try {
                    fis.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
