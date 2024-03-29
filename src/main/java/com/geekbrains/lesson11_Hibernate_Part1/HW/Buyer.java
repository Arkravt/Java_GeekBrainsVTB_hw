package com.geekbrains.lesson11_Hibernate_Part1.HW;

import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "buyers")
public class Buyer {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "name")
    private String name;

    @OneToMany(mappedBy = "buyer", cascade = CascadeType.ALL)
    private List<Purchase> goods;


    public Buyer() {
    }

    public Buyer(Long id, String name) {
        this.id = id;
        this.name = name;
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

    public List<Purchase> getGoods() {
        return goods;
    }

    public void setGoods(List<Purchase> goods) {
        this.goods = goods;
    }
}
