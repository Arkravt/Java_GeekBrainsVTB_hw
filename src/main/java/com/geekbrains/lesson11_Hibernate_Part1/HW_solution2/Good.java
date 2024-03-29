package com.geekbrains.lesson11_Hibernate_Part1.HW_solution2;

import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "goods")
public class Good {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "name")
    private String name;

    @Column(name = "price")
    private int price;

    @OneToMany(mappedBy = "good", cascade = CascadeType.ALL)
    private List<Purchase> purchases;

    public Good() {
    }

    public Good(Long id, String name, int price) {
        this.id = id;
        this.name = name;
        this.price = price;
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

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public List<Purchase> getPurchases() {
        return purchases;
    }

    public void setPurchases(List<Purchase> purchases) {
        this.purchases = purchases;
    }

    @Override
    public String toString() {
        return "Товар: " + this.name + ". Цена: " + this.price;
    }
}
