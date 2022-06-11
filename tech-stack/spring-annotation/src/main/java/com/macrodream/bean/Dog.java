package com.macrodream.bean;

import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

/**
 * @author Macros.Zhang
 * @date 6/5/2022 11:41
 */
@Component
public class Dog implements ApplicationContextAware {

    private ApplicationContext applicationContext;
    public Dog() {
        System.out.println("Dog...constructor...");
    }

    /**
     * 对象创建并赋值之后调用
     */
    @PostConstruct
    public void init() {
        System.out.println("Dog...@PostConstruct...");
    }

    /**
     * 容器移除对象之前
     */
    @PreDestroy
    public void destroy() {
        System.out.println("Dog...@PreDestroy...");
    }

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        this.applicationContext = applicationContext;
    }
}