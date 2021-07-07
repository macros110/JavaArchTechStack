package com.macrodream.spring.guides.gs.cachinggemfire;

import java.util.List;

public interface QuoteService {
    List<Quote> findAll();
    Quote findRandam();
    Quote findById(Long id);
}
