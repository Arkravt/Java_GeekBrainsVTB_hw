package com.geekbrains.lesson12_Hibernate_Part2.solutionHW;

import jakarta.persistence.LockModeType;
import org.hibernate.LockMode;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.engine.spi.SessionDelegatorBaseImpl;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.concurrent.CountDownLatch;
import java.util.stream.Collectors;

public class MainClass {

    public static void main(String[] args) throws IOException, InterruptedException {
        initData();
        fillValues();
        doWork();
    }

    public static void initData() throws IOException {
        SessionFactory factory = new Configuration()
                .configure("hibernate_lesson12.cfg.xml")
                .buildSessionFactory();
        Session session = null;
        try {
            String sql = Files.lines(Paths.get("drop-and-create.sql")).collect(Collectors.joining(""));
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

    public static void fillValues() {
        SessionFactory factory = new Configuration()
                .configure("hibernate_lesson12.cfg.xml")
                .buildSessionFactory();
        Session session = null;
        try {
            session = factory.getCurrentSession();
            session.beginTransaction();
            for (int i = 0; i < 40; i++) {
                session.persist(new Item(0));
            }
            session.getTransaction().commit();
        } finally {
            ;
            if (session != null)
                session.close();
        }
    }

    public static void doWork() throws InterruptedException {

        CountDownLatch cd = new CountDownLatch(2);
        SessionFactory factory = new Configuration()
                .configure("hibernate_lesson12.cfg.xml")
                .buildSessionFactory();
        Long start = System.currentTimeMillis();
        try {
            for (int i = 0; i < 2; i++) {
                new Thread(() -> {
                    for (int j = 0; j < 20000; j++) {
                        int lineNumber = (int) Math.ceil(Math.random() * 40);
                        Session session = factory.getCurrentSession();
                        session.beginTransaction();
                        Item item = session.get(Item.class, lineNumber, LockMode.PESSIMISTIC_WRITE);
                        item.setVal(item.getVal() + 1);
                        session.persist(item);
                        session.getTransaction().commit();
                    }
                    cd.countDown();
                }).start();
            }
        } finally {
            cd.await();
            factory.close();
        }
        System.out.println(System.currentTimeMillis() - start);
    }
}
