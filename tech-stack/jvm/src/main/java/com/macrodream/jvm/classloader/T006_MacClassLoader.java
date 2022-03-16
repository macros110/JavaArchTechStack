package com.macrodream.jvm.classloader;

import com.macrodream.jvm.Hello;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

public class T006_MacClassLoader extends ClassLoader{
    @Override
    protected Class<?> findClass(String name) throws ClassNotFoundException {
        File f = new File("D:\\Develop\\java\\ideaProjs\\JavaArchTechStack\\tech-stack\\jvm\\target\\classes",
                name.replaceAll(".", "/").concat(".class"));
        FileInputStream fis = null;
        ByteArrayOutputStream baos = null;
        try {
           fis = new FileInputStream(f);
           baos = new ByteArrayOutputStream();
           int b = 0;
           while ((b=fis.read()) != 0) {
               baos.write(b);
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
        ClassLoader l = new T006_MacClassLoader();
        Class clazz = l.loadClass("com.macrodream.jvm.Hello");
        Hello h = (Hello) clazz.newInstance();
        h.m();
    }
}
