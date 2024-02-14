package com.geekbrains.lesson5;

import java.util.*;

public class PhoneBook {

    private final Map<String, HashSet<Integer>> phoneBook = new HashMap<>();

    public void add(String lastName, int phoneNumber) {
        if (phoneBook.containsKey(lastName)) {
            phoneBook.get(lastName).add(phoneNumber);
        } else {
            HashSet<Integer> phoneSet = new HashSet<>();
            phoneSet.add(phoneNumber);
            phoneBook.put(lastName, phoneSet);
        }
    }

    public HashSet<Integer> get(String lastName) {
        return phoneBook.get(lastName);
    }
}
