package com.geekbrains.lesson13_Spring_Core.HW;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class MainClass {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext(AppConfig.class);

        ProductService productService = ctx.getBean(ProductService.class);
        OrderService orderService = ctx.getBean(OrderService.class);
        Cart cart = ctx.getBean(Cart.class);

        Product milk = productService.findByTitle("milk");
        Product bread = productService.findByTitle("bread");
        Product beer = productService.findByTitle("beer");

        cart.add(milk);
        cart.add(bread);
        cart.add(beer);

        orderService.makeOrder();

        ctx.close();
    }
}
