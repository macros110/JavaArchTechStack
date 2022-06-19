package com.macrodream.bean;

import org.springframework.stereotype.Component;

/**
 * @author Macros.Zhang
 * @date 6/19/2022 22:13
 */

@Component
public class Ceo {

    private Limo limo;

    public Limo getLimo() {
        return limo;
    }

    public void setLimo(Limo limo) {
        this.limo = limo;
    }

    @Override
    public String toString() {
        return "Ceo{" +
                "limo=" + limo +
                '}';
    }
}
