package com.geekbrains.lesson11_Hibernate_Part1;

import jakarta.persistence.*;

@Entity
@Table(name = "author_details")
public class AuthorDetails {

    @Id
    //@GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "age")
    private int age;

    @Column(name = "city")
    private String city;

    @MapsId
    @OneToOne
    @JoinColumn(name = "author_id")
    private Author author;


    public AuthorDetails() {
    }

    public AuthorDetails(Long id, int age, String city) {
        this.id = id;
        this.age = age;
        this.city = city;
    }


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public Author getAuthor() {
        return author;
    }

    public void setAuthor(Author author) {
        this.author = author;
    }

    @Override
    public String toString() {
        return "AuthorDetails{" +
                "id=" + id +
                ", age=" + age +
                ", city='" + city + '\'' +
                '}';
    }
}
