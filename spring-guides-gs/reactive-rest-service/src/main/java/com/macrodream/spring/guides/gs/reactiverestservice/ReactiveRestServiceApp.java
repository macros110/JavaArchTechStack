package com.macrodream.spring.guides.gs.reactiverestservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class ReactiveRestServiceApp {
    public static void main(String[] args) {
        SpringApplication.run(ReactiveRestServiceApp.class,args);
        GreetingWebClient gwc = new GreetingWebClient();
        System.out.println(gwc.getResult());
    }
}
