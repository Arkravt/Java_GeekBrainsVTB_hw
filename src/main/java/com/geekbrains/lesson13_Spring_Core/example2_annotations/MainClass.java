package com.geekbrains.lesson13_Spring_Core.example2_annotations;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.support.ClassPathXmlApplicationContext;

@ComponentScan
public class MainClass {
    public static void main(String[] args) {
        //ApplicationContext ctx = new ClassPathXmlApplicationContext("lesson13/Context_component_scan.xml");
        ApplicationContext ctx = new AnnotationConfigApplicationContext(MainClass.class);
        Car bmw = ctx.getBean(Car.class);
        bmw.go();
    }
}
