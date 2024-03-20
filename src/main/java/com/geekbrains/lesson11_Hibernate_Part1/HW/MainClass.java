package com.geekbrains.lesson11_Hibernate_Part1.HW;

import jakarta.persistence.NoResultException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import javax.management.Query;
import java.io.IOException;
import java.util.List;
import java.util.Scanner;

public class MainClass {

    private static SessionFactory factory;
    private static Session session;

    public static void main(String[] args) {

        factory = new Configuration()
                .configure("hibernate.cfg.xml")
                .addAnnotatedClass(Buyer.class)
                .addAnnotatedClass(Good.class)
                .buildSessionFactory();

        try {
            startApp();
        } finally {
            factory.close();
            session.close();
        }

    }

    public static void startApp() {
        Scanner sc = new Scanner(System.in);
        String input = "";
        String command;
        String value;
        while (!input.equals("exit")) {
            input = sc.nextLine();
            String[] arrInput = input.split(" ", 2);
            command = arrInput[0];
            value = arrInput[1];

            if (command.equals("/showProductsByPerson")) {
                showProductsByPerson(value);
            } else if (command.equals("/findPersonsByProductTitle")) {
                System.out.println("j");
            } else if (command.equals("/removePerson")) {
                System.out.println("j");
            } else if (command.equals("/removeProduct")) {
                System.out.println("j");
            } else if (command.equals("/buy")) {
                String[] valueArr = value.split(" ");
                if (valueArr.length != 2) {
                    System.out.println("Не верная команда");
                    continue;
                }
                buy(valueArr[0], valueArr[1]);
            } else {
                System.out.println("Не верная команда");
            }

        }
    }

    private static void buy(String buyerName, String goodName) throws NoResultException {
        session = factory.getCurrentSession();
        session.beginTransaction();

        try {
            Buyer buyer = session.createQuery("from Buyer where name = :name", Buyer.class)
                    .setParameter("name", buyerName)
                    .getSingleResult();

            Good good = session.createQuery("from Good where name = :name", Good.class)
                    .setParameter("name", goodName)
                    .getSingleResult();

            //buyer.getGoods().add(good);
            buyer.setGoods(good);
            //good.setBuyer(buyer);
            System.out.println(buyer.getGoods());
        } catch (NoResultException e) {
            System.err.println("Покупатель или товар не найден в базе данных");
        }

        session.getTransaction().commit();
        System.out.println(buyerName + " успешно купил " + goodName);
    }

    private static void showProductsByPerson(String value) {

        session = factory.getCurrentSession();
        session.beginTransaction();

        try {
            Buyer buyer = session.createQuery("from Buyer where name =:name", Buyer.class)
                    .setParameter("name", value)
                    .getSingleResult();

            System.out.println(buyer.getGoods());

        } catch (NoResultException e) {
            System.err.println("Покупатель не найден в базе данных");
        }

        session.getTransaction().commit();

    }

}


//CREATE TABLE BUYERS (ID serial PRIMARY KEY, NAME Varchar(255));

//CREATE TABLE GOODS (
//        id serial PRIMARY KEY,
//        name Varchar(255),
//price int,
//buyer_id int,
//FOREIGN KEY (buyer_id) REFERENCES buyers (id) on DELETE CASCADE);

//INSERT INTO buyers(name)
//VALUES ('Artem'), ('Tanya'), ('Petr'), ('Ivan'), ('Katya'), ('Sveta');
//
//INSERT INTO goods (name, price)
//VALUES
//        ('milk', 50),
//('bread', 30),
//        ('eggs', 100),
//        ('water', 35),
//        ('choco', 120);