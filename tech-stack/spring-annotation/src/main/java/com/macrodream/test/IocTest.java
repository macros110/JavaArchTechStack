package com.macrodream.test;

import com.macrodream.config.MainConfig;
import com.macrodream.config.MainConfig2;
import org.junit.jupiter.api.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.Arrays;

/**
 * @author Macros.Zhang
 * @date 6/4/2022 12:34
 */
public class IocTest {
    @Test
    void test02() {
        AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext(MainConfig2.class);
//        String[] names = ctx.getBeanDefinitionNames();
//        Arrays.asList(names).stream().forEach(System.out::println);
        System.out.println("ioc容器创建对象....");
        Object bean = ctx.getBean("person");
        Object bean2 = ctx.getBean("person");
//        System.out.println(bean == bean2);

    }
    @Test
    void test01(){
        AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext(MainConfig.class);
        String[] definitionNames = ctx.getBeanDefinitionNames();
        for (String name : definitionNames) {
            System.out.println(name);
        }
    }
}
