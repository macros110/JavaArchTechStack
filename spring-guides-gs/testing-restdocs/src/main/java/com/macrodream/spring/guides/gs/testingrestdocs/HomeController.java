package com.macrodream.spring.guides.gs.testingrestdocs;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collections;
import java.util.Map;

@RestController
public class HomeController {
    @GetMapping(value = "/")
    public Map<String, Object> greeting(){
        return Collections.singletonMap("message","Hello World!");
    }
}
