package com.geekbrains.lesson11_Hibernate_Part1;

import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "readers")
public class Readers {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private int age;

    @ManyToMany
    @JoinTable(name = "readers_books",
            joinColumns = {@JoinColumn(name = "readers_id")},
            inverseJoinColumns = {@JoinColumn(name = "books_id")})
    private List<Book> books;


    public Readers() {
    }

    public Readers(Long id, String name, int age) {
        this.id = id;
        this.name = name;
        this.age = age;
    }


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public List<Book> getBooks() {
        return books;
    }

    public void setBooks(List<Book> books) {
        this.books = books;
    }

    @Override
    public String toString() {
        return "Readers{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", age=" + age +
                '}';
    }
}
