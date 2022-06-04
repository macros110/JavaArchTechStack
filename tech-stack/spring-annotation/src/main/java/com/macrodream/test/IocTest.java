package com.macrodream.test;

import com.macrodream.bean.Person;
import com.macrodream.config.MainConfig;
import com.macrodream.config.MainConfig2;
import org.junit.jupiter.api.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.core.env.ConfigurableEnvironment;

import java.util.Arrays;
import java.util.Map;

/**
 * @author Macros.Zhang
 * @date 6/4/2022 12:34
 */
public class IocTest {
    AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext(MainConfig2.class);
    @Test
    void test03() {
        String[] namesForType = ctx.getBeanNamesForType(Person.class);
        Arrays.asList(namesForType).stream().forEach(System.out::println);
        ConfigurableEnvironment environment = ctx.getEnvironment();
        //动态获取操作系统 Windows 10
        String property = environment.getProperty("os.name");
        System.out.println(property);
        Map<String, Person> persons = ctx.getBeansOfType(Person.class);
        System.out.println(persons);
    }

    @Test
    void test02() {
        AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext(MainConfig2.class);
//        String[] names = ctx.getBeanDefinitionNames();
//        Arrays.asList(names).stream().forEach(System.out::println);
        System.out.println("ioc容器创建对象....");
        Object bean = ctx.getBean("person");
        Object bean2 = ctx.getBean("person");
        System.out.println(bean == bean2);

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
