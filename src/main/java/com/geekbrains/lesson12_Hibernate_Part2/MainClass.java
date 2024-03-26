package com.geekbrains.lesson12_Hibernate_Part2;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.stream.Collectors;

public class MainClass {
    public static void main(String[] args) throws IOException {
        prepareData();
//        work();
//        optimisticVersioningThreadingTest();
    }

    public static void work() {
        SessionFactory factory = new Configuration()
                .configure("hibernate_lesson12.cfg.xml")
                .buildSessionFactory();
        Session session = null;
//        try {
//
//        } finally {
//            factory.close();
//            if (session != null)
//                session.close();
//        }
    }

    public static void prepareData() throws IOException {

        SessionFactory factory = new Configuration()
                .configure("hibernate_lesson12.cfg.xml")
                .buildSessionFactory();
        Session session = null;
        try {
            String sql = Files.lines(Paths.get("drop-and-create.sql")).collect(Collectors.joining(" "));
            session = factory.getCurrentSession();
            session.beginTransaction();
            session.createNativeQuery(sql).executeUpdate();
            session.getTransaction().commit();
        } finally {
            factory.close();
            if (session != null)
                session.close();
        }
    }
}
