package com.macrodream.config;

import com.macrodream.bean.Blue;
import com.macrodream.bean.Color;
import com.macrodream.bean.Person;
import com.macrodream.condition.LinuxCondition;
import com.macrodream.condition.WindowsCondition;
import com.macrodream.registrar.MyImportBeanDefintionRegistrar;
import com.macrodream.selector.MyImportSelector;
import org.springframework.context.annotation.*;

/**
 * @author Macros.Zhang
 * @date 6/4/2022 17:19
 */

/**
 * 当满足当前条件，这个类中配置所有bean注册才能生效
 */
@Conditional(WindowsCondition.class)
@Configuration
/**
 * @Import 导入组件，id默认是组件的全类名
 *      可以导入Class数组{}
 */
//@Import(Color.class)
//@Import({Color.class, Blue.class})
//@Import({Color.class, Blue.class, MyImportSelector.class})
@Import({Color.class, Blue.class, MyImportSelector.class, MyImportBeanDefintionRegistrar.class})
public class MainConfig2 {
    /**
     * 默认是单实例的
     * @since 4.2
     * @see ConfigurableBeanFactory#SCOPE_PROTOTYPE  prototype
     * @see ConfigurableBeanFactory#SCOPE_SINGLETON  singleton
     * @see org.springframework.web.context.WebApplicationContext#SCOPE_REQUEST
     * @see org.springframework.web.context.WebApplicationContext#SCOPE_SESSION
     *
     * @Scope 调整作用域
     * prototype 多实例的
     *      ioc容器启动并不会去调用方法创建对象放在容器中。
     *      每次获取的时候才会调用方法创建对象
     * singleton 单实例的(默认值)
     *      ioc容器启动会调用方法创建对象放到ioc容器中。
     *      以后每次获取就是直接从容器(map.get())去拿
     * request  同一次请求创建的一个实例
     * session  同一个session创建一个实例
     *
     * @Lazy 懒加载：
     *      单实例bean 默认在容器启动时候创建对象
     *      懒加载 容器启动不创建对象，第一次使用(获取)bean创建对象，并初始化
     */
    //@Scope
    //@Scope("prototype")
    @Lazy
    @Bean("person")
    public Person person() {
        System.out.println("给容器中添加Person....");
        return new Person("张三", 25);
    }

    /**
     * @Conditional({Condition})   按照一定的条件进行判断，满足条件给容器中注册bean
     *      可以放类上，也可以放方法上
     *      如果系统是windows，给容器注册("bill")
     *      如果是linux系统，给容器注册("linus")
     */
    //@Conditional(WindowsCondition.class)
    @Bean("bill")
    public Person person01() {
        return new Person("Bill Gates", 62);
    }
    @Conditional(LinuxCondition.class)
    @Bean("linus")
    public Person person02() {
        return new Person("linus", 48);
    }

    /**
     * 给容器中注册组件
     *      1 包扫描+组件标注注解(@Controller/@Service/@Repository/@Component)
     *      2 @Bean[导入的第三方包里面的组件]
     *      3 @Import[快速给容器导入一个组件]
     *          1) @Import(要导入到容器的组件) ，容器中会主动注册这个组件，id默认全类名
     *          2) ImportSelector：返回需要导入的组件的全类名数组
     *          3) ImportBeanDefinitionRegistrar:手工注册Bean
     */
}
