package com.stephenmontague.wisdompet.data.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;
import lombok.ToString;

import java.math.BigDecimal;

@Entity
@Table(name = "PRODUCTS")
@Data
@ToString
public class ProductEntity {
    @Id
    @Column(name = "PRODUCT_ID")
    @GeneratedValue
    private long id;
    @Column(name = "NAME")
    private String name;
    @Column(name = "PRICE")
    private BigDecimal price;
    @Column(name = "VENDOR_ID")
    private String vendorId;
}