package com.macrodream.condition;

import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;
import org.springframework.beans.factory.support.BeanDefinitionRegistry;
import org.springframework.context.annotation.Condition;
import org.springframework.context.annotation.ConditionContext;
import org.springframework.core.env.Environment;
import org.springframework.core.type.AnnotatedTypeMetadata;

/**
 * @author Macros.Zhang
 * @date 6/4/2022 18:32
 * 判断系统为Windows的条件类
 */
public class WindowsCondition implements Condition {
    @Override
    public boolean matches(ConditionContext context, AnnotatedTypeMetadata metadata) {
        //1 能获取到ioc使用BeanFactory
        ConfigurableListableBeanFactory beanFactory = context.getBeanFactory();
        //2 获取类加载器
        ClassLoader  classLoader = context.getClassLoader();
        //3 获取当前环境信息
        Environment environment = context.getEnvironment();
        //4 获取到bean定义的注册类
        BeanDefinitionRegistry registry = context.getRegistry();

        String property = environment.getProperty("os.name");
        if (property.contains("Windows")) {
            return true;
        }
        return false;
    }
}
