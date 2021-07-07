package com.macrodream.spring.guides.gs.cachinggemfire;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

@Service
public class QuoteServiceImpl implements QuoteService{
    @Override
    public List<Quote> findAll() {
        List<Quote> list = getAll();
        return list;
    }

    @Override
    public Quote findRandam() {
        List<Quote> list = getAll();
        Long id = Long.valueOf((long)(10 * Math.random()));
        return list.stream().filter(item -> item.getId() == id).findFirst().get();
    }

    @Override
    public Quote findById(Long id) {
        List<Quote> list = getAll();
        return list.stream().filter(item -> item.getId() == id).findFirst().get();
    }

    private List<Quote> getAll(){
        List list = new ArrayList();
        InputStream config = getClass().getResourceAsStream("/quotes.json");
        if (config == null) {
            throw new RuntimeException("读取文件失败");
        } else {
            try {
                JSONArray jsons = JSON.parseObject(config, JSONArray.class);
                for (int i = 0; i < jsons.size(); i++) {
                    JSONObject o = jsons.getJSONObject(i);
                    Quote quote = new Quote(o.getLong("id"), o.getString("quote"));
                    list.add(quote);
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return list;
    }
}
