package com.geekbrains.lesson13_Spring_Core.HW;

import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.List;

@Component
public class Cart {

    private List<Product> cart;

    public void add(Product product) {
        cart.add(product);
    }

    public List<Product> getCart() {
        return cart;
    }

    @PostConstruct
    public void init() {
        cart = new ArrayList<>();
    }
}
