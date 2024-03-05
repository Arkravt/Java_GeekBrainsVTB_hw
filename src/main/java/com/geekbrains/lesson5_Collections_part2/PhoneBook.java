package com.geekbrains.lesson5_Collections_part2;

import java.util.*;

public class PhoneBook {

    private final Map<String, HashSet<Integer>> phoneBook = new HashMap<>();

    public void add(String lastName, int phoneNumber) {
        if (!phoneBook.containsKey(lastName)) {
            phoneBook.put(lastName, new HashSet<>());
        }
        phoneBook.get(lastName).add(phoneNumber);
    }

    public HashSet<Integer> get(String lastName) {
        return phoneBook.get(lastName);
    }
}
