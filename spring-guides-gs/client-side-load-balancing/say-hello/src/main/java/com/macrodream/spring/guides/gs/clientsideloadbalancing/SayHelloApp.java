package com.macrodream.spring.guides.gs.clientsideloadbalancing;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;
import java.util.List;
import java.util.Random;

@RestController
@SpringBootApplication
public class SayHelloApp {

    private static Logger log = LoggerFactory.getLogger(SayHelloApp.class);

    @RequestMapping(value = "/greeting")
    public String greet(){
        log.info("Access /greeting");
        List<String> greetings = Arrays.asList("Hi there","Greeting","Salutations");
        Random rand = new Random();
        int randomNum = rand.nextInt(greetings.size());
        return greetings.get(randomNum);
    }

    @RequestMapping(value = "/")
    public String home(){
        log.info("Access /");
        return "Hi!";
    }
    public static void main(String[] args) {
        SpringApplication.run(SayHelloApp.class,args);
    }
}
