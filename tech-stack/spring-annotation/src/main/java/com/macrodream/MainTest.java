package com.macrodream;

import com.macrodream.bean.Person;
import com.macrodream.config.MainConfig;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @author Macros.Zhang
 * @date 5/30/2022 23:23
 */
public class MainTest {
    public static void main(String[] args) {
        /*
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("beans.xml");
        Person bean = (Person) applicationContext.getBean("person");
        System.out.println(bean);
         */
        ApplicationContext context = new AnnotationConfigApplicationContext(MainConfig.class);
        Person bean = context.getBean(Person.class);
        System.out.println(bean);
        String[] namesForType = context.getBeanNamesForType(Person.class);
        for (String name : namesForType) {
            System.out.println(name);
        }
    }
}
