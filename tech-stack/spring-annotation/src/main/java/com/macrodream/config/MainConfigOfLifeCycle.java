package com.macrodream.config;

import com.macrodream.bean.Car;
import com.macrodream.bean.Cat;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;

/**
 * @author Macros.Zhang
 * @date 6/5/2022 10:56
 *      bean生命周期
 *          bean创建 -- 初始化 -- 销毁的过程
 *      容器管理bean的生命周期
 *      可自定义初始化好销毁方法；容器在bean进行到当前生命周期的时候来调用自定义初始化和销毁方法
 *      构造(对象创建)
 *          单实例 在容器启动的时候创建对象（懒加载@Lazy获取时创建）
 *          多实例 在每次获取时候创建对象
 *      初始化
 *          对象创建完成，并赋值好，调用初始化方法...
 *      销毁
 *          单实例 容器关闭的时候
 *          多实例 容器不会管理这个bean，容器不会调用销毁方法
 *
 *      1 指定初始化和销毁方法
 *          通过@Bean 指定init-method和destroy-method
 *      2 通过让Bean实现InitializingBean(定义初始化逻辑)、
 *                      DisposableBean(定义销毁逻辑)
 *      3 可以使用JSR250:
 *          @PostConstruct 在bean创建完成并且属性赋值完成，来执行初始化方法
 *          @PreDestroy 在容器销毁bean之前通知进行清理工作
 *      4
 */
@ComponentScan("com.macrodream.bean")
@Configuration
public class MainConfigOfLifeCycle {
    @Scope("prototype")
    @Bean(initMethod = "init",destroyMethod = "destroy")
    public Car car() {
        return new Car();
    }
}
