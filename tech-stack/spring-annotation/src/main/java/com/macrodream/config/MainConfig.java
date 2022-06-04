package com.macrodream.config;

import com.macrodream.bean.Person;
import com.macrodream.service.BookService;
import org.springframework.context.annotation.*;
import org.springframework.stereotype.Controller;

/**
 * @author Macros.Zhang
 * @date 5/30/2022 23:26
 */
/*配置类=配置文件*/
@Configuration /*告诉Spring这是一个配置类*/
/**
 * @ComponentScan  包扫描代替bean context:component-scan
 *      value:指定要扫描的包
 *      excludeFilters = Filter[]: 指定扫描的时候按照什么规则排除那些组件
 *      includeFilters = Filter[]: 指定扫描的时候只需要包含哪些组件
 *      FilterType.ANNOTATION: 按照注解
 *      FilterType.ASSIGNABLE_TYPE: 按照给定的类型
 *      FilterType.ASPECTJ: 使用ASPECTJ表达式
 *      FilterType.REGEX: 使用正则指定
 *      FilterType.CUSTOM: 实现TypeFilter接口自定义规则
 * @ComponentScans
 *      value = ComponentScan[]
 */
/*
@ComponentScan(
        value = "com.macrodream",
        //excludeFilters = {
        //    @ComponentScan.Filter(type = FilterType.ANNOTATION, classes = {Controller.class})
        //},
        includeFilters = {
                @ComponentScan.Filter(type = FilterType.ANNOTATION, classes = {Controller.class})
        },
        useDefaultFilters = false
)*/
@ComponentScans(value = {
        @ComponentScan(
                value = "com.macrodream",
                //excludeFilters = {
                //    @ComponentScan.Filter(type = FilterType.ANNOTATION, classes = {Controller.class})
                //},
                includeFilters = {
                        //@ComponentScan.Filter(type = FilterType.ANNOTATION, classes = {Controller.class}),
                        //@ComponentScan.Filter(type = FilterType.ASSIGNABLE_TYPE, classes = {BookService.class}),
                        @ComponentScan.Filter(type = FilterType.CUSTOM, classes = {MyTypeFilter.class})
                },
                useDefaultFilters = false
        )
})
public class MainConfig {

    /**
     * 给容器中注册一个Bean;类型为返回值的类型，id默认是用方法名作为id
     */
    @Bean("person")
    public Person person01() {
        return new Person("lisi", 20);
    }
}
