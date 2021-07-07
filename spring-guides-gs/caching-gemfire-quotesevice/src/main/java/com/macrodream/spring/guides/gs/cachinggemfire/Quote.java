package com.macrodream.spring.guides.gs.cachinggemfire;

public class Quote {

    private Long id;

    private String quote;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getQuote() {
        return quote;
    }

    public void setQuote(String quote) {
        this.quote = quote;
    }

    public Quote(Long id, String quote) {
        this.id = id;
        this.quote = quote;
    }

    @Override
    public String toString() {
        return "Quote{" +
                "id=" + id +
                ", quote='" + quote + '\'' +
                '}';
    }
}
