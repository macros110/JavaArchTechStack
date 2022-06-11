package com.macrodream.test;

import com.macrodream.bean.Person;
import com.macrodream.config.MainConfigOfPropertyValues;
import org.junit.jupiter.api.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.core.env.ConfigurableEnvironment;

import java.util.Arrays;

/**
 * @author Macros.Zhang
 * @date 6/11/2022 21:10
 */
public class IocTestPropertyValue {
    AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext(MainConfigOfPropertyValues.class);
    @Test
    void test01() {
        printBeans(ctx);
        System.out.println("================");

        Person person = (Person)ctx.getBean("person");
        System.out.println(person);

        ConfigurableEnvironment environment = ctx.getEnvironment();
        String property = environment.getProperty("person.nickName");
        System.out.println(property);
        ctx.close();
    }

    private void printBeans( AnnotationConfigApplicationContext ctx) {
        String[] names = ctx.getBeanDefinitionNames();
        Arrays.asList(names).stream().forEach(System.out::println);
    }
}
