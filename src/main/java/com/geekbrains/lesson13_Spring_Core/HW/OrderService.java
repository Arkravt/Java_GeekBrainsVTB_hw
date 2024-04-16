package com.geekbrains.lesson13_Spring_Core.HW;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class OrderService {
    @Autowired
    Cart cart;

    public void makeOrder() {
        cart.getCart().stream().forEach(p -> System.out.println(p.toString()));

        System.out.println(cart.getCart().stream()
                .map(Product::getCost)
                .reduce(0.0, Double::sum));
    }
}
