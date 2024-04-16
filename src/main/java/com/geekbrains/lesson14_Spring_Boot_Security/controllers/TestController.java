package com.geekbrains.lesson14_Spring_Boot_Security.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class TestController {

    @GetMapping(value = "/test")
    public String getHome() {
        return "test";
    }

}
