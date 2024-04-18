package com.geekbrains.lesson14_Spring_Boot_Security.example.repositories;

import com.geekbrains.lesson14_Spring_Boot_Security.example.entities.Filter;
import com.geekbrains.lesson14_Spring_Boot_Security.example.entities.Product;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

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

    public List<Product> findAll(Filter filter) {

        List<Product> res = products.stream()
                .filter(p -> p.getPrice() >= filter.getMinPrice()).toList();

        if (filter.getMaxPrice() > 0) {
            res = res.stream().filter(p -> p.getPrice() <= filter.getMaxPrice()).toList();
        }

        if(!filter.getSubStringTitle().isEmpty()) {
            res = res.stream().filter(p -> p.getTitle().contains(filter.getSubStringTitle())).toList();
        }

        return res;

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

    public void update(Product product) {
        Product productToUpdate = findById(product.getId());
        productToUpdate.setTitle(product.getTitle());
        productToUpdate.setPrice(product.getPrice());
    }

    public void delete(Long id) {
        Product productToUpdate = findById(id);
        products.remove(productToUpdate);
    }

}
