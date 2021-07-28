package com.macrodream.spring.guides.gs.testingweb;

import org.springframework.stereotype.Service;

@Service
public class GreetingService {
    public String greet() {
        return "Hello, World! Greeting!";
    }
}
