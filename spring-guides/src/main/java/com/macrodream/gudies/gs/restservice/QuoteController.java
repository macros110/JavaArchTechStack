package com.macrodream.gudies.gs.restservice;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.atomic.AtomicLong;

@RestController
public class QuoteController {
    private final AtomicLong counter = new AtomicLong();
    @GetMapping("/quote")
    public Quote quote(@RequestParam(value = "quote",
            defaultValue = "Really loving Spring Boot, makes stand alone Spring apps easy.")
                                   String quote){
        return new Quote("success",new Value(counter.incrementAndGet(),quote));
    }
}
