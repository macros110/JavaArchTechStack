package com.macrodream.bean;

import org.springframework.stereotype.Component;

/**
 * @author Macros.Zhang
 * @date 6/5/2022 11:00
 */
@Component
public class Limo {
    public Limo() {
        System.out.println("Limo constructor ...");
    }

    public void init() {
        System.out.println("Limo ... init ...");
    }

    public void destroy() {
        System.out.println("Limo ... destroy");
    }
}
