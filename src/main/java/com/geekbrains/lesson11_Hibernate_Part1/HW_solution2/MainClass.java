package com.geekbrains.lesson11_Hibernate_Part1.HW_solution2;

import jakarta.persistence.NoResultException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import java.util.Scanner;
import java.util.stream.Collectors;

public class  MainClass {

    private static SessionFactory factory;
    private static Session session;

    public static void main(String[] args) {

        factory = new Configuration()
                .configure("hibernate.cfg.xml")
                .addAnnotatedClass(Buyer.class)
                .addAnnotatedClass(Good.class)
                .addAnnotatedClass(Purchase.class)
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
                findPersonsByProductTitle(value);
            } else if (command.equals("/removePerson")) {
                removePerson(value);
            } else if (command.equals("/removeProduct")) {
                removeProduct(value);
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

            Purchase purchase = new Purchase();
            purchase.setBuyer(buyer);
            purchase.setGood(good);
            purchase.setPrice(good.getPrice());

            session.persist(purchase);
            //buyer.getPurchases().add(purchase);


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

//            String result = buyer.getGoods().stream()
//                    .map(good -> good.getGood().getName())
//                    .collect(Collectors.joining(", ", buyerName + " купил: ", ""));

            session.getTransaction().commit();
//            System.out.println(result);

        } catch (NoResultException e) {
            System.err.println("Покупатель не найден в базе данных");
        }
    }

    private static void findPersonsByProductTitle(String goodName) {
        try {
            session = factory.getCurrentSession();
            session.beginTransaction();

            Good good = session.createQuery("from Good where name =:name", Good.class)
                    .setParameter("name", goodName)
                    .getSingleResult();

//            String result = good.getBuyers().stream()
//                    .map(buyers -> buyers.getBuyer().getName())
//                    .collect(Collectors.joining(", ", "Товар " + goodName + " купили: ", ""));

            session.getTransaction().commit();
//            System.out.println(result);

        } catch (NoResultException e) {
            System.err.println("Товар не найден");
        }
    }

    private static void removePerson(String buyerName) {
        try {
            session = factory.getCurrentSession();
            session.beginTransaction();

            Buyer buyer = session.createQuery("from Buyer where name =:name", Buyer.class)
                    .setParameter("name", buyerName)
                    .getSingleResult();

            session.remove(buyer);
            session.getTransaction().commit();
            System.out.println(buyerName + " удален из базы данных");
        } catch (NoResultException e) {
            System.err.println("Покупатель не найден");
        }
    }

    private static void removeProduct(String goodName) {
        try {
            session = factory.getCurrentSession();
            session.beginTransaction();

            Good good = session.createQuery("from Good where name =:name", Good.class)
                    .setParameter("name", goodName)
                    .getSingleResult();

            session.remove(good);
            session.getTransaction().commit();
            System.out.println(goodName + " удален из базы данных");
        } catch (NoResultException e) {
            System.err.println("Товар не найден");
        }
    }
    //////////// API ////////////
}

