package com.geekbrains.lesson14_Spring_Boot_Security.example.service;

import com.geekbrains.lesson14_Spring_Boot_Security.example.entities.Product;
import com.geekbrains.lesson14_Spring_Boot_Security.example.repositories.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductService {

    private ProductRepository productRepository;

    @Autowired
    public void setProductRepository(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    public List<Product> getAllProducts() {
        return productRepository.findAll();
    }

    public List<Product> getAllProductsWithFilter(String word, int minPrice, int maxPrice) {
        List<Product> productList = productRepository.findAll();

        if (word != null) {
            productList = productList.stream().filter(p -> p.getTitle().contains(word)).toList();
        }

        if (minPrice > 0) {
            productList = productList.stream()
                    .filter(p -> p.getPrice() >= minPrice).toList();
        }

        if (maxPrice > 0) {
            productList = productList.stream().filter(p -> p.getPrice() <= maxPrice).toList();
        }

        return productList;
    }

    public Product getById(Long id) {
        return productRepository.findById(id);
    }

    public void add(Product product) {
        productRepository.add(product);
    }

    public void update(Product product) {
        productRepository.update(product);
    }

    public void deleteProduct(Long id) {
        productRepository.delete(id);
    }

}
