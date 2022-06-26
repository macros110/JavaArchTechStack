package com.macrodream.test;

import com.macrodream.bean.Boss;
import com.macrodream.bean.Ceo;
import com.macrodream.bean.Limo;
import com.macrodream.config.MainConfigOfAutowired;
import com.macrodream.config.MainConfigOfProfile;
import com.macrodream.service.BookService;
import org.junit.jupiter.api.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import javax.sql.DataSource;
import java.util.Arrays;

/**
 * @author Macros.Zhang
 * @date 6/5/2022 11:04
 */
public class IocTestProfile {

    /**
     * 1 使用命令行动态参数： 在虚拟机参数位置加载-Dspring.profiles.active=test
     * 2 代码的方式激活某种环境；
     */
    @Test
    void test01() {
        //AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext(MainConfigOfProfile.class);
        //1 创建一个ApplicationContext
        AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext();
        //2 设置需要的激活环境
        //ctx.getEnvironment().setActiveProfiles("test","dev");
        //ctx.getEnvironment().setActiveProfiles("dev");
        ctx.getEnvironment().setActiveProfiles("test");
        //3 注册主配置类
        ctx.register(MainConfigOfProfile.class);
        //4 启动刷新容器
        ctx.refresh();

        String[] names = ctx.getBeanNamesForType(DataSource.class);
        Arrays.asList(names).stream().forEach(System.out::println);

        String[] names1 = ctx.getBeanDefinitionNames();
        Arrays.asList(names1).stream().forEach(System.out::println);
        ctx.close();
    }
}
