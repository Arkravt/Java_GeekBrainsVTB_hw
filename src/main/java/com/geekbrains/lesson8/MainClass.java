package com.geekbrains.lesson8;

import java.util.*;
import java.util.stream.Collectors;

public class MainClass {
    public static void main(String[] args) {

        // Task 1
        String[] array = {"winter", "summer", "spring", "autumn", "summer", "spring", "summer"};
        String result = Arrays.stream(array)
                .collect(Collectors.groupingBy(String::valueOf, Collectors.counting()))
                .entrySet()
                .stream()
                .max(Map.Entry.comparingByValue())
                .get()
                .getKey();

        System.out.println(result);

    }
}
