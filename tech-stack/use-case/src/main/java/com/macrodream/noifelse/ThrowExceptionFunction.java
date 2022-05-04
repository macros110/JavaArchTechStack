package com.macrodream.noifelse;

/**
 * @author Macros.Zhang
 * @date 5/4/2022 11:24
 * 抛异常接口
 */
@FunctionalInterface
public interface ThrowExceptionFunction {
    /**
     * 抛出异常信息
     * @param message
     */
    void throwMessage(String message);
}
