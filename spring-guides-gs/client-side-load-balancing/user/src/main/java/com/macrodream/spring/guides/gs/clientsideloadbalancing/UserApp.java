package com.macrodream.spring.guides.gs.clientsideloadbalancing;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.cloud.netflix.ribbon.RibbonClient;
import org.springframework.context.annotation.Bean;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication
@RestController
@RibbonClient(name = "say-hello", configuration = SayHelloConfig.class)
public class UserApp {
    @LoadBalanced
    @Bean
    RestTemplate restTemplate(){
        return new RestTemplate();
    }
    @Autowired
    RestTemplate restTemplate;

    @RequestMapping(value = "/hi")
    public String hi(@RequestParam(value = "name", defaultValue = "Macros") String name){
        String greeting = this.restTemplate.getForObject("http://say-hello/greeting",String.class);
        return String.format("%s %s", greeting, name);
    }

    public static void main(String[] args) {
        SpringApplication.run(UserApp.class,args);
    }
}
