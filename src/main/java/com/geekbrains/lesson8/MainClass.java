package com.geekbrains.lesson8;

import java.util.*;
import java.util.stream.Collectors;

public class MainClass {
    public static void main(String[] args) {
        task1();
        task2();
        task3(3);
    }

    private static void task1() {
        String[] array = {"winter", "summer", "spring", "autumn", "summer", "spring", "summer"};
        String result1 = Arrays.stream(array)
                .collect(Collectors.groupingBy(String::valueOf, Collectors.counting()))
                .entrySet()
                .stream()
                .max(Map.Entry.comparingByValue())
                .get()
                .getKey();

        System.out.println("TASK 1: " + result1);
    }

    private static void task2() {
        Employee[] employees = getEmployees();

        double result2 = Arrays.stream(employees)
                .mapToDouble(Employee::getSalary).sum() / employees.length;

        double result3 = Arrays.stream(employees)
                .mapToDouble(Employee::getSalary)
                .reduce(Double::sum).getAsDouble() / employees.length;

        double result4 = Arrays.stream(employees)
                .collect(Collectors.summingDouble(Employee::getSalary)) / employees.length;

        double result5 = Arrays.stream(employees)
                .collect(Collectors.averagingDouble(Employee::getSalary));

        System.out.println("TASK 2(solution 1): " + result2);
        System.out.println("TASK 2(solution 2): " + result3);
        System.out.println("TASK 2(solution 3): " + result4);
        System.out.println("TASK 2(solution 4): " + result5);
    }

    private static void task3(int topOlderEmployees) {
        Employee[] employees = getEmployees();

        String result = Arrays.stream(employees)
                .sorted((o1, o2) -> o2.getAge() - o1.getAge())
                .limit(topOlderEmployees)
                .map(Employee::getName)
                .collect(Collectors.joining(", ", topOlderEmployees + " самых старших сотрудников зовут: ", ""));

        System.out.println(result);

        String result1 = Arrays.stream(employees)
                .sorted(Comparator.comparingInt(Employee::getAge).reversed())
                .limit(topOlderEmployees)
                .map(Employee::getName)
                .collect(Collectors.joining(", ", topOlderEmployees + " самых старших сотрудников зовут: ", ""));

        System.out.println(result1);


    }

    private static Employee[] getEmployees() {
        Employee[] employees = {
                new Employee("John", 30, 2000),
                new Employee("Pol", 25, 3500),
                new Employee("Smith", 35, 5000),
                new Employee("David", 33, 3700),
                new Employee("Ron", 38, 4200),
                new Employee("Frank", 29, 3400)
        };

        return employees;
    }

}
