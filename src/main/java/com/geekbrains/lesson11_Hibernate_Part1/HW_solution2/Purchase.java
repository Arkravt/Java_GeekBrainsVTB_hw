package com.geekbrains.lesson11_Hibernate_Part1.HW_solution2;

import jakarta.persistence.*;

import java.io.Serializable;
import java.util.Objects;

@Entity
@Table(name = "purchase")
public class Purchase {

    @Embeddable
    public static class Id implements Serializable {

        private Long buyerId;

        private Long goodId;

        public Long getBuyerId() {
            return buyerId;
        }

        public void setBuyerId(Long buyerId) {
            this.buyerId = buyerId;
        }

        public Long getGoodId() {
            return goodId;
        }

        public void setGoodId(Long goodId) {
            this.goodId = goodId;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            Id id = (Id) o;
            return Objects.equals(buyerId, id.buyerId) && Objects.equals(goodId, id.goodId);
        }

        @Override
        public int hashCode() {
            return Objects.hash(buyerId, goodId);
        }
    }


    @EmbeddedId
    private Id id = new Id();

    @ManyToOne
    //@MapsId("buyerId")
    @JoinColumn(name = "buyer_id")
    private Buyer buyer;

    @ManyToOne
    //@MapsId("goodId")
    @JoinColumn(name = "good_id")
    private Good good;

    @Column(name = "price")
    private int price;


    public Purchase() {
    }


    public Id getId() {
        return id;
    }

    public void setId(Id id) {
        this.id = id;
    }

    public Buyer getBuyer() {
        return buyer;
    }

    public void setBuyer(Buyer buyer) {
        this.buyer = buyer;
    }

    public Good getGood() {
        return good;
    }

    public void setGood(Good good) {
        this.good = good;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }
}
