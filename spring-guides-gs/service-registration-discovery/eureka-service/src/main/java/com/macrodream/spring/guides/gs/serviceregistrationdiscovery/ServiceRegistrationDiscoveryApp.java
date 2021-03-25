package com.macrodream.spring.guides.gs.serviceregistrationdiscovery;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@EnableEurekaServer
@SpringBootApplication
public class ServiceRegistrationDiscoveryApp {
    public static void main(String[] args) {
        SpringApplication.run(ServiceRegistrationDiscoveryApp.class,args);
    }
}
