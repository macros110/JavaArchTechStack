package com.macrodream.registrar;

import com.macrodream.bean.RainBow;
import org.springframework.beans.factory.support.BeanDefinitionRegistry;
import org.springframework.beans.factory.support.RootBeanDefinition;
import org.springframework.context.annotation.ImportBeanDefinitionRegistrar;
import org.springframework.core.type.AnnotationMetadata;

/**
 * @author Macros.Zhang
 * @date 6/4/2022 22:08
 */
public class MyImportBeanDefintionRegistrar implements ImportBeanDefinitionRegistrar {
    /**
     *
     * @param importingClassMetadata annotation metadata of the importing class
     *                 当前类的注解信息
     * @param registry current bean definition registry
     *                 BeanDefinition注册类
     *                 把所有需要添加到容器中的bean；调用
     *                 BeanDefinitionRegistry.registerBeanDefinition手工注册进来
     */
    @Override
    public void registerBeanDefinitions(AnnotationMetadata importingClassMetadata, BeanDefinitionRegistry registry) {
        boolean definition =  registry.containsBeanDefinition("com.macrodream.bean.Red");
        boolean definition2 =  registry.containsBeanDefinition("com.macrodream.bean.Blue");
        if (definition && definition2) {
            //指定Bean定义信息；(Bean的类型，Bean的Scope...)
            RootBeanDefinition beanDefinition = new RootBeanDefinition(RainBow.class);
            //注册一个Bean，指定bean名
            registry.registerBeanDefinition("rainRow", beanDefinition);
        }
    }
}
