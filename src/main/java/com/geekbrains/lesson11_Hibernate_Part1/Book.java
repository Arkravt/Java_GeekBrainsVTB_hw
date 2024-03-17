package com.geekbrains.lesson11_Hibernate_Part1;

import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "books")
public class Book {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "title")
    private String title;

    @Column(name = "releaseYear")
    private int releaseYear;

    @ManyToOne
    @JoinColumn(name = "author_id")
    private Author author;

    @ManyToMany
    @JoinTable(name = "readers_books",
            joinColumns = {@JoinColumn(name = "books_id")},
            inverseJoinColumns = {@JoinColumn(name = "readers_id")})
    private List<Readers> readers;


    public Book() {
    }

    public Book(Long id, String title, int releaseYear) {
        this.id = id;
        this.title = title;
        this.releaseYear = releaseYear;
    }


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getReleaseYear() {
        return releaseYear;
    }

    public void setReleaseYear(int releaseYear) {
        this.releaseYear = releaseYear;
    }

    public Author getAuthor() {
        return author;
    }

    public void setAuthor(Author author) {
        this.author = author;
    }


    @Override
    public String toString() {
        return "Book{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", releaseYear=" + releaseYear +
                ", author=" + "2" +
                '}';
    }
}
