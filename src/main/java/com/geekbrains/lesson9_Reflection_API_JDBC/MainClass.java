package com.geekbrains.lesson9_Reflection_API_JDBC;

public class MainClass {
    public static void main(String[] args) {
        AnnotationProcessor.createTable(Student.class);

        AnnotationProcessor.addObjectToDataBase(
                new Student(1, "Petr", 16, 10)
        );

        AnnotationProcessor.addObjectToDataBase(
                new Student(2, "Ivan", 10, 4)
        );

    }
}
