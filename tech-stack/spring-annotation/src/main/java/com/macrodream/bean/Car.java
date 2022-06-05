package com.macrodream.bean;

/**
 * @author Macros.Zhang
 * @date 6/5/2022 11:00
 */
public class Car {
    public Car() {
        System.out.println("car constructor ...");
    }

    public void init() {
        System.out.println("car ... init ...");
    }

    public void destroy() {
        System.out.println("car ... destroy");
    }
}
