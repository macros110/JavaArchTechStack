package com.macrodream.spring.framework.core.ioc;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
/**
@Configuration注解
 1.@Configuration注解的类表示此类主要作用是作为一个bean定义的来源
 2.@Configuration注解的类通过调用此类其他@Bean注释的方法，使得跨bean间依赖被定义出来
 */
@Configuration
public class AppConfig {
    /**
    @Bean注解
    1.常用于表示一个方法实例化、配置、初始化一个新对象，此对象被Spring IoC容器管理
    2.@Bean扮演的角色与配置文件中<beans/>下面的<bean/> 一样
    3.@Bean注解方法可用于任何 @Component注释类中，更常用于@Configuration注释的类中
     */
    @Bean
    public MyServie myServie(){
        return new MyServiceImp();
    }
}
