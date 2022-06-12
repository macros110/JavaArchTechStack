package com.macrodream.config;

import com.macrodream.dao.BookDao;
import org.springframework.context.annotation.*;

/**
 * @author Macros.Zhang
 * @date 6/12/2022 22:00
 *
 *  自动装配
 *      Spring利用依赖注入(DI),完成对IOC容器中各个组件的以依赖关系赋值；
 *
 *  1 @Autowired 自动注入
 *      1) 默认优先按照类型去容器中找对应的组件 applicationContext.getBean(BookDao.class);
 *      2) 如果找到多个相同类型组件，再将属性名称作为组件id去容器中查找
 *          applicationContext.getBean("bookDao")
 *      3) @Qualifier("bookDao")  使用@Qualifier指定需要装配的组件id,而不是使用属性名
 *      4) 自动装配默认一定将属性赋值好，没有就会报错；
 *          可以使用@Autowired(required = false);
 *      5) @Primary 让Spring进行自动装配时，默认使用首选bean;
 *          也可以继续使用@Qualifier指定需要装配的bean的名字
 *
 *      BookService { @Autowired BookDao bookDao;}
 *  2
 */
@Configuration
@ComponentScan({"com.macrodream.service", "com.macrodream.dao", "com.macrodream.controller"})
public class MainConfigOfAutowired {

    @Primary
    @Bean("bookDao2")
    public BookDao bookDao() {
        BookDao bookDao = new BookDao();
        bookDao.setLabel("2");
        return bookDao;
    }
}
