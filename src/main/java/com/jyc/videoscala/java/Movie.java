package com.jyc.videoscala.java;

public class Movie {
    public static final int REGULAR = 1;
    public static final int NEW_RELEASE = 2;
    public static final int CHILDRENS = 3;

    private String title;
    private Integer priceCode;

    public Movie(String title, Integer priceCode) {
        this.title = title;
        this.priceCode = priceCode;
    }

    public String getTitle() {
        return title;
    }

    public Integer getPriceCode() {
        return priceCode;
    }
}
