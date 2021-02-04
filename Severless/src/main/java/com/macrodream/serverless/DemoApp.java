package com.macrodream.serverless;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import reactor.core.publisher.Flux;

import java.util.function.Function;

@SpringBootApplication
public class DemoApp {

    @Bean
    public Function<Flux<String>, Flux<String>> uppercase() {
        return flux -> flux.map(value -> value.toUpperCase());
    }

    @Bean
    public Function<String,String> lowercase(){
        return value-> value.toLowerCase();
    }

    public static void main(String[] args) {
        SpringApplication.run(DemoApp.class, args);
    }
}
