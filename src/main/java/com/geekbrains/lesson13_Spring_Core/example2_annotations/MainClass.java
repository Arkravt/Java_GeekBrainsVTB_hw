package com.geekbrains.lesson13_Spring_Core.example2_annotations;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class MainClass {
    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext("lesson13/Context_component_scan.xml");
        Car bmw = context.getBean(Car.class);
        bmw.go();
    }
}
