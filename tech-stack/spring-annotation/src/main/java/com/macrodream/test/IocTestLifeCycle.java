package com.macrodream.test;

import com.macrodream.bean.Car;
import com.macrodream.config.MainConfigOfLifeCycle;
import org.junit.jupiter.api.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * @author Macros.Zhang
 * @date 6/5/2022 11:04
 */
public class IocTestLifeCycle {
    @Test
    void test01() {
        //1 创建ioc容器
        AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext(MainConfigOfLifeCycle.class);
        System.out.println("容器创建完成...");
        Car car = (Car) ctx.getBean("car");
        // 关闭容器
        ctx.close();
    }
}
