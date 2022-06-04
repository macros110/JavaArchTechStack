package com.macrodream.config;

import com.macrodream.bean.Person;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;

/**
 * @author Macros.Zhang
 * @date 6/4/2022 17:19
 */
@Configuration
public class MainConfig2 {
    /**
     * 默认是单实例的
     * @since 4.2
     * @see ConfigurableBeanFactory#SCOPE_PROTOTYPE  prototype
     * @see ConfigurableBeanFactory#SCOPE_SINGLETON  singleton
     * @see org.springframework.web.context.WebApplicationContext#SCOPE_REQUEST
     * @see org.springframework.web.context.WebApplicationContext#SCOPE_SESSION
     *
     * @Scope 调整作用域
     * prototype 多实例的
     *      ioc容器启动并不会去调用方法创建对象放在容器中。
     *      每次获取的时候才会调用方法创建对象
     * singleton 单实例的(默认值)
     *      ioc容器启动会调用方法创建对象放到ioc容器中。
     *      以后每次获取就是直接从容器(map.get())去拿
     * request  同一次请求创建的一个实例
     * session  同一个session创建一个实例
     */
    //@Scope
    @Scope("prototype")
    @Bean("person")
    public Person person() {
        System.out.println("给容器中添加Person....");
        return new Person("张三", 25);
    }
}
