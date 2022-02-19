package com.macrodream.spring.test.service;

import com.macrodream.spring.Autowired;
import com.macrodream.spring.BeanNameAware;
import com.macrodream.spring.Component;
import com.macrodream.spring.InitializingBean;

/**
 * @author Macros.Zhang
 */
@Component("userService")
public class UserServiceImpl implements BeanNameAware, InitializingBean, UserService {

    @Autowired
    private OrderService orderService;

    private String beanName;

    private String name;

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public void test() {
        System.out.println(orderService);
        System.out.println(beanName);
        System.out.println(name);
    }

    @Override
    public void setBeanName(String name) {
        this.beanName = name;
    }

    @Override
    public void afterPropertiesSet() throws Exception {
        System.out.println("初始化");
    }
}
