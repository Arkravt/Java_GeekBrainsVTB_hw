package com.geekbrains.lesson13_Spring_Core.HW;

import org.springframework.stereotype.Component;
import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.List;

@Component
public class ProductService {

    private List<Product> productList;

    public void printAll() {
        productList.forEach(e -> System.out.println(e.toString()));
    }

    public Product findByTitle(String title) {
        return productList.stream()
                .filter(p -> p.getTitle().equals(title))
                .findFirst()
                .get();
    }

    @PostConstruct
    public void init() {
        productList = new ArrayList<>();
        productList.add(new Product(1, "milk", 50));
        productList.add(new Product(2, "bread", 30));
        productList.add(new Product(3, "coca", 100));
        productList.add(new Product(4, "apple", 24));
        productList.add(new Product(5, "beer", 120));
        productList.add(new Product(6, "eggs", 110));
        productList.add(new Product(7, "pasta", 76));
        productList.add(new Product(8, "water", 23));
        productList.add(new Product(9, "batter", 87));
        productList.add(new Product(10, "choco", 123));
    }

}
