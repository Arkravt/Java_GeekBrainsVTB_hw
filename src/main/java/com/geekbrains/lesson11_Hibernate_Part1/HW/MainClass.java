package com.geekbrains.lesson11_Hibernate_Part1.HW;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import java.util.Arrays;
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

        startApp();

    }

    public static void startApp() {
        Scanner sc = new Scanner(System.in);
        String input = "";
        String command;
        String value;
        while (!input.equals("exit")) {
            input = sc.nextLine();
            String[] arrInput = input.split(" ", 2);
            command = arrInput[0].toLowerCase();
            value = arrInput[1].toLowerCase();

            if (command.equals("/showproductsbyperson")) {
                System.out.println("j");
            } else if (command.equals("/findpersonsbyproducttitle")) {
                System.out.println("j");
            } else if (command.equals("/removeperson")) {
                System.out.println("j");
            } else if (command.equals("/removeproduct")) {
                System.out.println("j");
            } else if (command.equals("/buy")) {
                System.out.println("j");
            } else {
                System.out.println("Не верная команда");
            }

        }
    }
}


//CREATE TABLE BUYERS (ID serial PRIMARY KEY, NAME Varchar(255));

//CREATE TABLE GOODS (
//        id serial PRIMARY KEY,
//        name Varchar(255),
//price int,
//buyer_id int,
//FOREIGN KEY (buyer_id) REFERENCES buyers (id) on DELETE CASCADE);