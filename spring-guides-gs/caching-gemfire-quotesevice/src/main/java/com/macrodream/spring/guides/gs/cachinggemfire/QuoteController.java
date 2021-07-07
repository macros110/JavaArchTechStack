package com.macrodream.spring.guides.gs.cachinggemfire;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api")
public class QuoteController {
    @Autowired
    QuoteService quoteService;

    @GetMapping
    public Result<List<Quote>> quotes(){
        List<Quote> list = quoteService.findAll();
        return new Result<List<Quote>>("success",list);
    }

    @GetMapping("/random")
    public Result<Quote> randam(){
        Quote quote = quoteService.findRandam();
        return new Result<Quote>("success",quote);
    }

    @GetMapping("/{id}")
    public Result<Quote> findById(@PathVariable("id") Long id){
        Quote quote = quoteService.findById(id);
        return new Result<Quote>("success",quote);
    }
}
