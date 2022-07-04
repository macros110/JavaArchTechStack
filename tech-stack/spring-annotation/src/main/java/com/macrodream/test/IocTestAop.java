package com.macrodream.test;

import com.macrodream.aop.MathCalculator;
import com.macrodream.bean.Boss;
import com.macrodream.bean.Ceo;
import com.macrodream.bean.Limo;
import com.macrodream.config.MainConfigOfAop;
import com.macrodream.config.MainConfigOfAutowired;
import com.macrodream.service.BookService;
import org.junit.jupiter.api.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * @author Macros.Zhang
 * @date 7/4/2022 20:46
 */
public class IocTestAop {
    @Test
    void test01() {
        AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext(MainConfigOfAop.class);
        //1 不要自己创建对象
        //MathCalculator mathCalculator = new MathCalculator();
        //mathCalculator.div(1,1);
        MathCalculator mathCalculator = ctx.getBean(MathCalculator.class);
        mathCalculator.div(1, 1);
        mathCalculator.div(1, 0);
        ctx.close();
    }
}
