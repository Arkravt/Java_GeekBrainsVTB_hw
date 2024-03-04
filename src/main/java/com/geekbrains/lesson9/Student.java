package com.geekbrains.lesson9;

@Table(title = "students")
public class Student {

    @Column(type = "INTEGER")
    private int id;

    @Column(type = "TEXT")
    private String name;

    @Column(type = "INTEGER")
    private int age;

    @Column(type = "INTEGER")
    private int grade;

    public Student(int id, String name, int age, int grade) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.grade = grade;
    }

}
