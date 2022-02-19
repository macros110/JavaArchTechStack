package com.macrodream.spring;

/**
 * @author Macros.Zhang
 */
public interface InitializingBean {

    /**
     * @throws Exception
     */
    void afterPropertiesSet() throws Exception;
}
