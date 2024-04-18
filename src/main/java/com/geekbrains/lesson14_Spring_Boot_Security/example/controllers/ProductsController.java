package com.geekbrains.lesson14_Spring_Boot_Security.example.controllers;

import com.geekbrains.lesson14_Spring_Boot_Security.example.entities.Filter;
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
    public String showProductsList(Model model) {
        model.addAttribute("products", productService.getAllProducts());
        model.addAttribute("product", new Product());
        model.addAttribute("filter", new Filter());
        return "products";
    }

    @PostMapping()
    public String filter(Model model, @ModelAttribute Filter filter) {
        model.addAttribute("products", productService.getAllProducts(filter));
        model.addAttribute("product", new Product());
        model.addAttribute("filter", filter);
        return "products";
    }

    @PostMapping("/add")
    public String addProduct(@ModelAttribute Product product) {
        productService.add(product);
        return "redirect:/products";
    }

    @GetMapping("/show/{id}")
    public String showProduct(Model model, @PathVariable Long id) {
        Product product = productService.getById(id);
        model.addAttribute(product);
        return "product-show";
    }

    @GetMapping("/edit/{id}")
    public String editProduct(Model model, @PathVariable Long id) {
        Product product = productService.getById(id);
        model.addAttribute(product);
        return "product-edit";
    }

    @PostMapping("/edit")
    public String editProduct(@ModelAttribute Product product) {
        productService.updateProduct(product);
        return "redirect:/products";
    }

    @GetMapping("/delete/{id}")
    public String deleteProduct(@PathVariable Long id) {
        productService.deleteProduct(id);
        return "redirect:/products";
    }
}
