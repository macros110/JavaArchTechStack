package com.macrodream.test;

import com.macrodream.bean.Car;
import com.macrodream.config.MainConfigOfAutowired;
import com.macrodream.config.MainConfigOfLifeCycle;
import com.macrodream.dao.BookDao;
import com.macrodream.service.BookService;
import org.junit.jupiter.api.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * @author Macros.Zhang
 * @date 6/5/2022 11:04
 */
public class IocTestAutowired {
    @Test
    void test01() {
        AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext(MainConfigOfAutowired.class);
        BookService bookService = ctx.getBean(BookService.class);
        System.out.println(bookService);

        //BookDao bean = ctx.getBean(BookDao.class);
        //System.out.println(bean);

        ctx.close();
    }
}
