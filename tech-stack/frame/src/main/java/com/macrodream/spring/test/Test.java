package com.macrodream.spring.test;

import com.macrodream.spring.ApplicationContext;
import com.macrodream.spring.test.service.UserService;

public class Test {
    public static void main(String[] args) {
        ApplicationContext applicationContext = new ApplicationContext(AppConfig.class);
        UserService userService = (UserService) applicationContext.getBean("userService");
        userService.test();
    }
}
