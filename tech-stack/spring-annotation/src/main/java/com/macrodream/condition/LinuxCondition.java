package com.macrodream.condition;

import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;
import org.springframework.beans.factory.support.BeanDefinitionRegistry;
import org.springframework.context.annotation.Condition;
import org.springframework.context.annotation.ConditionContext;
import org.springframework.core.env.Environment;
import org.springframework.core.type.AnnotatedTypeMetadata;

/**
 * @author Macros.Zhang
 * @date 6/4/2022 18:31
 * 判断Linux系统的条件类
 */
public class LinuxCondition implements Condition {
    /**
     *
     * @param context the condition context 判断条件能使用的上下文（环境）
     * @param metadata the metadata of the {@link org.springframework.core.type.AnnotationMetadata class}
     * or {@link org.springframework.core.type.MethodMetadata method} being checked
     *                 注释信息
     * @return
     */
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

        //可以判断容器中的bean注册情况，也可以给容器中注册bean
        boolean definiaton = registry.containsBeanDefinition("person");

        if (property.contains("linux")) {
            return true;
        }

        return false;
    }
}
