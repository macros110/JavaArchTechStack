package com.macrodream.spring.guides.gs.routingfiltering;

import com.macrodream.spring.guides.gs.routingfiltering.filter.pre.SimpleFilter;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;
import org.springframework.context.annotation.Bean;

@EnableZuulProxy
@SpringBootApplication
public class RoutingFilterGatewayApp {

    public static void main(String[] args) {
        SpringApplication.run(RoutingFilterGatewayApp.class,args);
    }

    @Bean
    public SimpleFilter simpleFilter(){
        return new SimpleFilter();
    }
}
