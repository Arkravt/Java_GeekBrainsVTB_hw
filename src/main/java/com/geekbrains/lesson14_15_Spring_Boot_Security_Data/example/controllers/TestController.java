package com.geekbrains.lesson14_15_Spring_Boot_Security_Data.example.controllers;

import com.geekbrains.lesson14_15_Spring_Boot_Security_Data.example.entities.Cat;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class TestController {

    // Пример перехода на страницу test.html
    @GetMapping(value = "/test")
    public String getHome() {
        return "test";
    }


    // Пример передачи параметров из url через @RequestParam(?) и через @PathVariable
    // Пример передачи параметров через Model на страницу html
    @GetMapping(value = "{id}/hello")
    public String getHello(Model model, @RequestParam("name") String name, @PathVariable("id") int id) {
        model.addAttribute("name", name);
        model.addAttribute("id", id);
        return "hello";
    }


    // Пример обработки формы на html странице и передача параметров с этой страницы.
    @GetMapping("/form")
    public String getForm() {
        return "form-ex";
    }

    @PostMapping("/form")
    public String postForm(@RequestParam String name, @RequestParam String email) {
        System.out.println(name);
        System.out.println(email);
        return "redirect:/test";
    }
    // Пример обработки формы на html странице и передача параметров с этой страницы.

    // Пример передачи объекта Cat на страницу html. На странице его заполняем и передаем назад заполненный объект.
    @GetMapping("/addcat")
    public String showAddCatForm(Model model) {
        Cat cat = new Cat();
        model.addAttribute("cat", cat);
        return "cat-form";
    }

    @PostMapping("/addcat")
    public String postCat(@ModelAttribute Cat cat) {
        System.out.println(cat);
        return "redirect:/test";
    }

}
