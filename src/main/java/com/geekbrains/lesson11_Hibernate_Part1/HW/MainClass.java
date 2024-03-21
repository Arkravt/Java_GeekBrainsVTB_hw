package com.geekbrains.lesson11_Hibernate_Part1.HW;

import jakarta.persistence.NoResultException;
import jakarta.persistence.criteria.CollectionJoin;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import javax.management.Query;
import java.io.IOException;
import java.sql.SQLOutput;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

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
            session.close();
            factory.close();
        }

    }

    public static void startApp() {
        Scanner sc = new Scanner(System.in);
        String input = "";
        String command = "";
        String value = "";
        while (!input.equals("exit")) {
            input = sc.nextLine();
            String[] arrInput = input.split(" ", 2);

            if (arrInput.length > 0)
                command = arrInput[0];

            if (arrInput.length > 1)
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
            } else if (command.equals("exit")) {
                break;
            } else {
                System.out.println("Не верная команда");
            }

        }
    }


    //////////// API ////////////
    private static void buy(String buyerName, String goodName) {
        try {
            session = factory.getCurrentSession();
            session.beginTransaction();

            Buyer buyer = session.createQuery("from Buyer where name = :name", Buyer.class)
                    .setParameter("name", buyerName)
                    .getSingleResult();

            Good good = session.createQuery("from Good where name = :name", Good.class)
                    .setParameter("name", goodName)
                    .getSingleResult();

            buyer.getGoods().add(good);

            session.getTransaction().commit();
            System.out.println(buyerName + " успешно купил " + goodName);

        } catch (NoResultException e) {
            System.err.println("Покупатель или товар не найден в базе данных");
        }
    }

    private static void showProductsByPerson(String buyerName) {
        try {
            session = factory.getCurrentSession();
            session.beginTransaction();
            Buyer buyer = session.createQuery("from Buyer where name =:name", Buyer.class)
                    .setParameter("name", buyerName)
                    .getSingleResult();

            String result = buyer.getGoods().stream()
                    .map(Good::getName)
                    .collect(Collectors.joining(", ", buyerName + " купил: ", ""));

            session.getTransaction().commit();
            System.out.println(result);

        } catch (NoResultException e) {
            System.err.println("Покупатель не найден в базе данных");
        }
    }
    //////////// API ////////////
}

