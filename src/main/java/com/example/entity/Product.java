package com.example.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Entity
@Data
//@NoArgsConstructor
//@AllArgsConstructor
@Table(name = "product")
public class Product {
    @Id
    @Column(name = "pid")
    private Integer prodId;
    @Column(name = "pname")
    private String prodName;
    @Column(name = "pcost")
    private Double prodCost;

    public Product() {
        super();
    }

    public Product(Double prodCost, String prodName, Integer prodId) {
        this.prodCost = prodCost;
        this.prodName = prodName;
        this.prodId = prodId;
    }

    @Override
    public String toString() {
        return "Product{" +
                "prodCost=" + prodCost +
                ", prodId=" + prodId +
                ", prodName='" + prodName + '\'' +
                '}';
    }
}
