package com.geekbrains.lesson12_Hibernate_Part2.solutionHW;

import jakarta.persistence.OptimisticLockException;
import org.hibernate.LockMode;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.concurrent.CountDownLatch;
import java.util.stream.Collectors;

public class MainClass {

    public static void main(String[] args) throws IOException, InterruptedException {
        initData();
        fillValues();
        //doWorkSingle();
        doWorkPessimistic();
        doWorkOptimistic();
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
            if (session != null)
                session.close();
        }
    }

    public static void sleep(int ms) {
        try {
            Thread.sleep(ms);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }


    public static void doWorkPessimistic() throws InterruptedException {

        CountDownLatch cd = new CountDownLatch(8);

        SessionFactory factory = new Configuration()
                .configure("hibernate_lesson12.cfg.xml")
                .buildSessionFactory();

        Long start = System.currentTimeMillis();

        try {
            for (int i = 0; i < 8; i++) {
                new Thread(() -> {
                    updateValue(factory);
                    cd.countDown();
                }).start();
            }
        } finally {
            cd.await();
            factory.close();
        }
        System.out.println(System.currentTimeMillis() - start);
    }

    public static void updateValue(SessionFactory factory) {
        for (int j = 0; j < 20000; j++) {
            int lineNumber = (int) Math.ceil(Math.random() * 40);
            Session session = factory.getCurrentSession();
            try {
                session.beginTransaction();
                Item item = session.get(Item.class, lineNumber, LockMode.PESSIMISTIC_WRITE);
                item.setVal(item.getVal() + 1);
                session.save(item);
                //sleep(5);
                session.getTransaction().commit();
            } finally {
                if (session != null)
                    session.close();
            }
        }
    }


    public static void doWorkSingle() {
        SessionFactory factory = new Configuration()
                .configure("hibernate_lesson12.cfg.xml")
                .buildSessionFactory();

        Long start = System.currentTimeMillis();
        updateValueSingle(factory);
        updateValueSingle(factory);
        updateValueSingle(factory);
        updateValueSingle(factory);
        updateValueSingle(factory);
        updateValueSingle(factory);
        updateValueSingle(factory);
        updateValueSingle(factory);
        System.out.println(System.currentTimeMillis() - start);
    }

    public static void updateValueSingle(SessionFactory factory) {
        Session session = factory.getCurrentSession();
        session.beginTransaction();

        for (int j = 0; j < 2000; j++) {
            int lineNumber = (int) Math.ceil(Math.random() * 40);
            Item item = session.get(Item.class, lineNumber);
            item.setVal(item.getVal() + 1);
            session.save(item);
            sleep(5);
        }

        session.getTransaction().commit();
    }


    public static void doWorkOptimistic() throws InterruptedException {

        CountDownLatch cd = new CountDownLatch(8);

        SessionFactory factory = new Configuration()
                .configure("hibernate_lesson12.cfg.xml")
                .buildSessionFactory();

        Long start = System.currentTimeMillis();

        try {
            for (int i = 0; i < 8; i++) {
                new Thread(() -> {
                    updateValueOptimistic(factory);
                    cd.countDown();
                }).start();
            }
        } finally {
            cd.await();
            factory.close();
        }

        System.out.println(System.currentTimeMillis() - start);
    }

    public static void updateValueOptimistic(SessionFactory factory) {
        for (int j = 0; j < 20000; j++) {
            boolean updated = false;
            int lineNumber = (int) Math.ceil(Math.random() * 40);
            while (!updated) {
                Session session = factory.getCurrentSession();
                session.beginTransaction();
                Item item = session.get(Item.class, lineNumber);
                item.setVal(item.getVal() + 1);
                try {
                    session.save(item);
                    session.getTransaction().commit();
                    updated = true;
                } catch (OptimisticLockException e) {
                    session.getTransaction().rollback();
                }
                session.close();
            }
        }
    }

}
