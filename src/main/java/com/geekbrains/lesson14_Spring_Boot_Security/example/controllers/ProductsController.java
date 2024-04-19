package com.geekbrains.lesson14_Spring_Boot_Security.example.controllers;

import com.geekbrains.lesson14_Spring_Boot_Security.example.entities.Product;
import com.geekbrains.lesson14_Spring_Boot_Security.example.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/products")
public class ProductsController {

    private ProductService productService;

    @Autowired
    public void setProductService(ProductService productService) {
        this.productService = productService;
    }

    @GetMapping
    public String showProductsList(Model model,
                                   @RequestParam(value = "word", required = false) String word,
                                   @RequestParam(value = "minPrice", required = false, defaultValue = "0") int minPrice,
                                   @RequestParam(value = "maxPrice", required = false, defaultValue = "0") int maxPrice) {
        model.addAttribute("products", productService.getAllProductsWithFilter(word, minPrice, maxPrice));
        model.addAttribute("word", word);
        model.addAttribute("minPrice", minPrice);
        model.addAttribute("maxPrice", maxPrice);
        return "products";
    }

    @GetMapping("/show/{id}")
    public String showProduct(Model model, @PathVariable Long id) {
        Product product = productService.getById(id);
        model.addAttribute(product);
        return "product-show";
    }

    @GetMapping("/add")
    public String addProduct(Model model) {
        model.addAttribute("product", new Product());
        return "product-edit";
    }

    @GetMapping("/edit/{id}")
    public String editProduct(Model model, @PathVariable Long id) {
        Product product = productService.getById(id);
        model.addAttribute(product);
        return "product-edit";
    }

    @PostMapping("/edit")
    public String editProduct(@ModelAttribute Product product) {
        if (product.getId() == null) {
            productService.add(product);
        } else {
            productService.update(product);
        }

        return "redirect:/products";
    }

    @GetMapping("/delete/{id}")
    public String deleteProduct(@PathVariable Long id) {
        productService.deleteProduct(id);
        return "redirect:/products";
    }
}
