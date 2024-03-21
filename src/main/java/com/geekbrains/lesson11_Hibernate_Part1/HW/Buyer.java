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

    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(name = "buyers_goods",
            joinColumns = {@JoinColumn(name = "buyer_id")},
            inverseJoinColumns = {@JoinColumn(name = "good_id")})
    private List<Good> goods;

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

    public List<Good> getGoods() {
        return goods;
    }

    public void setGoods(List<Good> goods) {
        this.goods = goods;
    }
}
