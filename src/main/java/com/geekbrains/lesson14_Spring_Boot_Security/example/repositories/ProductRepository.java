package com.geekbrains.lesson14_Spring_Boot_Security.example.repositories;

import com.geekbrains.lesson14_Spring_Boot_Security.example.entities.Product;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.List;

@Component
public class ProductRepository {
    private List<Product> products;

    @PostConstruct
    public void init() {
        products = new ArrayList<>();
        products.add(new Product(1L, "Bread", 34));
        products.add(new Product(2L, "milk", 99));
        products.add(new Product(3L, "eggs", 110));
        products.add(new Product(4L, "choco", 132));
    }

    public List<Product> findAll() {
        return products;
    }

    public Product findByTitle(String title) {
        return products.stream()
                .filter(p -> p.getTitle().equals(title))
                .findFirst()
                .get();
    }

    public Product findById(Long id) {
        return products.stream()
                .filter(p -> p.getId().equals(id))
                .findFirst()
                .get();
    }

    public void save(Product product) {
        products.add(product);
    }
}
