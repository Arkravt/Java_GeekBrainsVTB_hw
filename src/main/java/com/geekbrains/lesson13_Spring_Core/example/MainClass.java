package com.geekbrains.lesson13_Spring_Core.example;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class MainClass {
    public static void main(String[] args) {
        //ApplicationContext context = new ClassPathXmlApplicationContext("lesson13/Context_example_constructor.xml");
        //ApplicationContext context = new ClassPathXmlApplicationContext("lesson13/Context_example_setters.xml");
        ApplicationContext context = new ClassPathXmlApplicationContext("lesson13/Context_example_setters_chemaP.xml");
        Car bmw = (Car) context.getBean("car");
        bmw.go();
    }
}
