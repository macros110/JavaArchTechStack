package com.macrodream.hello;

import org.springframework.beans.factory.annotation.Autowired;
import reactor.core.publisher.Mono;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.reactive.function.client.WebClient;

@RestController
@SpringBootApplication
public class ReadingApp {

    @Autowired
    private BookService bookService;

    @RequestMapping("/to-read")
    public Mono<String> toRead() {
        return bookService.readingList();
    }

    public static void main(String[] args) {
        SpringApplication.run(ReadingApp.class, args);
    }
}
