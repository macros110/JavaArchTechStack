package com.macrodream.spring.framework.core.ioc;


import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;


public class ConfigrationTestMain {
    public static void main(String[] args) {
        ApplicationContext ctx = new AnnotationConfigApplicationContext(AppConfig.class);
        MyServie myServie = (MyServie) ctx.getBean(MyServie.class);
        myServie.doStuff();
    }
}
