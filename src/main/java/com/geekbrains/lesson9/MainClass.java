package com.geekbrains.lesson9;

import java.sql.*;

public class MainClass {
    public static void main(String[] args) {
        //AnnotationProcessor.createTable(Student.class);

        AnnotationProcessor.addObjectToDataBase(
                new Student(1, "Petr", 16, 10)
        );

    }
}
