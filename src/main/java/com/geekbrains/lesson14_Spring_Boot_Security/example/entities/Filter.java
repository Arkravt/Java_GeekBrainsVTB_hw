package com.geekbrains.lesson14_Spring_Boot_Security.example.entities;

import java.security.PrivateKey;

public class Filter {

    private int minPrice;
    private int maxPrice;
    private String subStringTitle;

    public int getMinPrice() {
        return minPrice;
    }

    public void setMinPrice(int minPrice) {
        this.minPrice = minPrice;
    }

    public int getMaxPrice() {
        return maxPrice;
    }

    public void setMaxPrice(int maxPrice) {
        this.maxPrice = maxPrice;
    }

    public String getSubStringTitle() {
        return subStringTitle;
    }

    public void setSubStringTitle(String subStringTitle) {
        this.subStringTitle = subStringTitle;
    }
}
