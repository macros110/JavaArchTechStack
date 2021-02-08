package com.macrodream.spring.framework.core.resource;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.core.io.Resource;

public class ResourceTestMain {
    public static void main(String[] args) {
        ApplicationContext ctx = new ClassPathXmlApplicationContext();
        Resource resource = ctx.getResource("com/macrodream/spring/framework/core/resource/mytpl.txt");
        System.out.println(resource);
    }
}
