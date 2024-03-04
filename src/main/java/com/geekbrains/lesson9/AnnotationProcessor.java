package com.geekbrains.lesson9;

import java.awt.*;
import java.io.FilterOutputStream;
import java.lang.annotation.Annotation;
import java.lang.reflect.Field;
import java.sql.*;
import java.util.Arrays;
import java.util.stream.Collectors;

public class AnnotationProcessor {

    private static Connection connection;
    private static Statement statement;
    private static PreparedStatement preparedStatement;
    private static String DB_URL = "jdbc:sqlite:D:\\Study\\Java\\SQLite\\school.db";

    private static void connect() throws SQLException {
        try {
            Class.forName("org.sqlite.JDBC");
            connection = DriverManager.getConnection(DB_URL);
            statement = connection.createStatement();
            preparedStatement = connection.prepareStatement("INSERT INTO ? (?) VALUES (?)");
        } catch (ClassNotFoundException | SQLException e) {
            throw new SQLException("Enable to connect !");
        }
    }

    private static void disconnect() {
        try {
            statement.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        try {
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }


    public static void createTable(Class inputClass) {
        if (!inputClass.isAnnotationPresent(Table.class)) {
            return;
        }
        try {
            connect();
            Table tableAnotation = (Table) inputClass.getAnnotation(Table.class);
            String sql = Arrays.stream(inputClass.getDeclaredFields())
                    .filter(f -> f.isAnnotationPresent(Column.class))
                    .map(f -> f.getName() + " " + f.getAnnotation(Column.class).type())
                    .collect(Collectors.joining(",", "CREATE TABLE " + tableAnotation.title() + " (", ");"));
            statement.executeUpdate(sql);
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            disconnect();
        }
    }

    public static void addObjectToDataBase(Object objectToAdd) {

        Class objectClass = objectToAdd.getClass();

        if (!objectClass.isAnnotationPresent(Table.class)) {
            return;
        }

        Table tableAnotation = (Table) objectClass.getAnnotation(Table.class);
        //String prepareSQL = "INSERT INTO " + tableAnotation.title() + " (";


        Field[] fields = Arrays.stream(objectClass.getDeclaredFields())
                .filter(f -> f.isAnnotationPresent(Column.class)).toArray(Field[]::new);

        String prepareSQL = Arrays.stream(fields)
                .map(f -> f.getName())
                .collect(Collectors.joining(", ", "INSERT INTO " + tableAnotation.title() + "(", ")"));




//        try {
//            connect();
//
//
//
//        } catch (SQLException e) {
//            e.printStackTrace();
//        } finally {
//            disconnect();
//        }

    }

}
