package com.geekbrains.lesson14_Spring_Boot_Security.example.entities;

public class Product {

    private Long id;
    private String title;
    private int price;

    public Product() {
//        this.id = 0L;
//        this.title = "";
    }

    public Product(Long id, String title, int price) {
        this.id = id;
        this.title = title;
        this.price = price;
    }


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }
}
