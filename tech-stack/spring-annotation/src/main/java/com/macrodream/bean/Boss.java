package com.macrodream.bean;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * @author Macros.Zhang
 * @date 6/19/2022 21:54
 */
@Component
public class Boss {

    private Limo limo;

    /**
     * 构造器要用的组件，都是从容器中获取
     *
     */
    public Boss(Limo limo) {
        this.limo = limo;
        System.out.println("Boss...有参构造器");
    }

    public Limo getLimo() {
        return limo;
    }


    /**
     * 标注在方法，Spring容器创建当前对象，就会调用方法，完成赋值；
     * 方法使用的参数，自定义类型的值从ioc容器中获取
     */
    //@Autowired
    public void setLimo(Limo limo) {
        this.limo = limo;
    }

    @Override
    public String toString() {
        return "Boss{" +
                "limo=" + limo +
                '}';
    }
}
