package com.geekbrains.lesson11_Hibernate_Part1.HW;

import jakarta.persistence.*;

import java.io.Serializable;
import java.util.Objects;

@Entity
@Table(name = "buyers_goods")
public class Price {

    @Embeddable
    private static class Id implements Serializable {

        @Column(name = "buyer_id", insertable = false, updatable = false)
        int buyerId;

        @Column(name = "good_id", insertable = false, updatable = false)
        int goodId;

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            Id id = (Id) o;
            return buyerId == id.buyerId && goodId == id.goodId;
        }

        @Override
        public int hashCode() {
            return Objects.hash(buyerId, goodId);
        }
    }


    @EmbeddedId
    Id id;

    @ManyToOne
    @JoinColumn(name = "good_id")
    Good good;

    @ManyToOne
    @JoinColumn(name = "buyer_id")
    Buyer buyer;

    @Column(name = "price")
    int price;


    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }


    public Price() {
    }

}
