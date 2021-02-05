package com.macrodream.serverless;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.function.context.PollableBean;
import org.springframework.context.annotation.Bean;
import reactor.core.publisher.Flux;

import java.util.function.Function;
import java.util.function.Supplier;

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
    //Java 8 function support
    @PollableBean(splittable = true)
    public Supplier<Flux<String>> someSupplier() {
        return () -> {
            String v1 = String.valueOf(System.nanoTime());
            String v2 = String.valueOf(System.nanoTime());
            String v3 = String.valueOf(System.nanoTime());
            return Flux.just(v1, v2, v3);
        };
    }


    public static void main(String[] args) {
        SpringApplication.run(DemoApp.class, args);
    }
}
