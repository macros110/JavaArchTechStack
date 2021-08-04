package com.macrodream.spring.guides.gs.multimodule.application;


import com.macrodream.spring.guides.gs.multimodule.service.MyService;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication(scanBasePackages = "com.macrodream.spring.guides.gs.multimodule")
@RestController
public class DemoApp {

    private final MyService myService;

    public DemoApp(MyService myService) {
        this.myService = myService;
    }

    @GetMapping("/")
    public String home() {
        return myService.message();
    }

    public static void main(String[] args) {
        SpringApplication.run(DemoApp.class, args);
    }
}
