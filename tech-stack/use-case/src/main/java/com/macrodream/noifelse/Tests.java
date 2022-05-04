package com.macrodream.noifelse;

import org.junit.jupiter.api.Test;

/**
 * @author Macros.Zhang
 * @date 5/4/2022 11:48
 */
public class Tests {
    @Test
    void isFalse(){
        HandleUtils.isTrue(false).throwMessage("我要抛异常咯");
    }

    @Test
    void isTrue(){
        HandleUtils.isTrue(true).throwMessage("参数为true，我要抛异常咯");
    }

    @Test
    void isTrueOrFalse() {
        //HandleUtils.isTrueOrFalse(true)
        HandleUtils.isTrueOrFalse(false)
                .trueOrFalseHandle(() -> System.out.println("true 我要开始show了"),
                        () -> System.out.println("false show不动，快跑"));
    }

    @Test
    void isBlank() {
        HandleUtils.isBlankOrNoBlank("").presentOrElseHandle(System.out::println,
                () -> System.out.println("空字符串"));
    }

    @Test
    void isNoBlank() {
        HandleUtils.isBlankOrNoBlank("Hello").presentOrElseHandle(System.out::println,
                () -> System.out.println("空字符串"));
    }
}
