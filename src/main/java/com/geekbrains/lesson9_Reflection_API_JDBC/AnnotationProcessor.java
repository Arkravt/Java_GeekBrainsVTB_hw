package com.geekbrains.lesson9_Reflection_API_JDBC;

import java.lang.reflect.Field;
import java.sql.*;
import java.util.Arrays;
import java.util.stream.Collectors;

public class AnnotationProcessor {

    private static Connection connection;
    private static Statement statement;
    private static String DB_URL = "jdbc:sqlite:C:\\Курсы\\Java\\SQLite\\school.db";

    private static void connect() throws SQLException {
        try {
            Class.forName("org.sqlite.JDBC");
            connection = DriverManager.getConnection(DB_URL);
            statement = connection.createStatement();
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
                    .collect(Collectors.joining(",", "CREATE TABLE IF NOT EXISTS " + tableAnotation.title() + " (", ");"));
            statement.executeUpdate(sql);
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            disconnect();
        }
    }

    public static void addObjectToDataBase(Object objectToAdd) {

        Class<?> objectClass = objectToAdd.getClass();

        if (!objectClass.isAnnotationPresent(Table.class)) {
            return;
        }

        try {
            connect();

            Table tableAnotation = (Table) objectClass.getAnnotation(Table.class);

            Field[] fields = Arrays.stream(objectClass.getDeclaredFields())
                    .filter(f -> f.isAnnotationPresent(Column.class)).toArray(Field[]::new);

            String preparedSQL = Arrays.stream(fields)
                    .map(Field::getName)
                    .collect(Collectors.joining(", ", "INSERT INTO " + tableAnotation.title() + " (", ")"));

            preparedSQL = Arrays.stream(fields)
                    .map(f -> "?")
                    .collect(Collectors.joining(", ", preparedSQL + " VALUES (", ");"));

            PreparedStatement preparedStatement = connection.prepareStatement(preparedSQL);

            for (int i = 0; i < fields.length; i++) {
                fields[i].setAccessible(true);
                preparedStatement.setObject(i + 1, fields[i].get(objectToAdd));
            }

            preparedStatement.execute();

        } catch (IllegalAccessException | SQLException e) {
            e.printStackTrace();
        } finally {
            disconnect();
        }

    }

}
