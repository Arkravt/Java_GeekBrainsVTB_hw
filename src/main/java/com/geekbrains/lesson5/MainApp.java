package com.geekbrains.lesson5;

import java.util.*;

public class MainApp {

    public static void main(String[] args) {
        //task1();

        PhoneBook pBook = new PhoneBook();
        pBook.add("Ivanov", 11111);
        pBook.add("Sidorov", 22222);
        pBook.add("Ahmed", 33333);
        pBook.add("Walker", 44444);
        pBook.add("Ivanov", 555555);
        pBook.add("Ivanov", 88888);

        System.out.println(pBook.get("Ivanov"));
    }

    public static void task1() {
        String[] array = {"A", "B", "C", "D", "E", "F", "A", "A", "B", "C", "Z", "H"};
        Map<String, Integer> map = new HashMap<>();


        for (String elem : array) {
            int count = map.get(elem) == null ? 0 : map.get(elem);
            map.put(elem, ++count);
        }

        for (Map.Entry<String, Integer> pair : map.entrySet()) {
            System.out.println(pair.getKey() + " " + pair.getValue());
        }

    }

}
