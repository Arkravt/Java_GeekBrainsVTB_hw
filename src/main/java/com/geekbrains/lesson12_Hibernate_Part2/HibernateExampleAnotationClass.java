package com.geekbrains.lesson12_Hibernate_Part2;

import jakarta.persistence.*;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Entity
@Table(name = "example_annotated", indexes = {
        @Index(name = "name_idx", columnList = "name"),
        @Index(name = "id_name_idx", columnList = "id, name"),
        @Index(name = "unique_name_idx", columnList = "name", unique = true),
})
public class HibernateExampleAnotationClass {

    @Id
    @GeneratedValue
    @Column(name = "id")
    private Long id;

    @Column(name = "name")
    private String name;

    @Column(name = "shortstr", nullable = false, length = 10)
    private String shortString;

    @Column(name = " weight")
    @org.hibernate.annotations.ColumnTransformer(
            read = "weight / 2.0",
            write = "? * 2.0")
    private float divideWieght;

    @org.hibernate.annotations.Formula("Select avg(p.cost) FROM Product p WHERE p.manufacturer_id = id")
    private BigDecimal avgManufacturerProductCost;

    @Temporal(TemporalType.TIME)
    @Column(name = "created_at", updatable = false)
    @org.hibernate.annotations.CreationTimestamp
    private LocalDateTime updateAt;


    @Column(name ="manual_def_str", columnDefinition = "VARCHAR(50) NOT NULL UNIQUE;")
    private String manualDefinedString;

}
