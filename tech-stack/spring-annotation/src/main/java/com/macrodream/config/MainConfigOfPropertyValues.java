package com.macrodream.config;

import com.macrodream.bean.Person;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

/**
 * @author Macros.Zhang
 * @date 6/11/2022 21:03
 */

/**
 * 使用@PropertySource读取外部配置文件中的k/v保存到运行的环境变量中;
 * 加载完外部的配置文件以后使用${} 取出配置文件的值
 *
 */
@PropertySource(value = {"classpath:/person.properties"})
@Configuration
public class MainConfigOfPropertyValues {

    @Bean
    public Person person() {
        return new Person();
    }
}
