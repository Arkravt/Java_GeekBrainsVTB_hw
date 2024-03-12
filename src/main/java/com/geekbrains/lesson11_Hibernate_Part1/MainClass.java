package com.geekbrains.lesson11_Hibernate_Part1;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;


public class MainClass {
    public static void main(String[] args) {

        SessionFactory factory = new Configuration()
                .addAnnotatedClass(Catalog.class)
                .buildSessionFactory();

        //Session session = null;

        System.out.println("ss");
    }
}
