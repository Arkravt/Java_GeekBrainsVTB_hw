package com.geekbrains.lesson11_Hibernate_Part1.HW;

import jakarta.persistence.*;

@Entity
@Table(name = "goods")
public class Good {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "name")
    private String name;

    @Column(name = "price")
    private int price;

    @ManyToOne @JoinColumn(name = "buyer_id")
    private Buyer buyer;


    public Good() {
    }

    public Good(Long id, String name, int price, Buyer buyer) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.buyer = buyer;
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

    public Buyer getBuyer() {
        return buyer;
    }

    public void setBuyer(Buyer buyer) {
        this.buyer = buyer;
    }

    @Override
    public String toString() {
        return "Good{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", price=" + price +
                ", buyer=" + buyer +
                '}';
    }
}
