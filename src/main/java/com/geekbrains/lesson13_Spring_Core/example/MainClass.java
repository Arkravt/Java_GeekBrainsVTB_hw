package com.geekbrains.lesson13_Spring_Core.example;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class MainClass {
    public static void main(String[] args) {

        ApplicationContext context = new ClassPathXmlApplicationContext("lesson13_example_Context.xml");
        Car bmw = (Car) context.getBean("car");
        bmw.go();
    }
}
