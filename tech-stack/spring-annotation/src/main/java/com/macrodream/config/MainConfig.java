package com.macrodream.config;

import com.macrodream.bean.Person;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author Macros.Zhang
 * @date 5/30/2022 23:26
 */
/*配置类=配置文件*/
@Configuration /*告诉Spring这是一个配置类*/
public class MainConfig {

    /**
     * 给容器中注册一个Bean;类型为返回值的类型，id默认是用方法名作为id
     */
    @Bean("person")
    public Person person01() {
        return new Person("lisi", 20);
    }
}
