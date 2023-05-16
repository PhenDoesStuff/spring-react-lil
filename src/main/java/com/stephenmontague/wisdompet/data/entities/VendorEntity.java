package com.stephenmontague.wisdompet.data.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;
import lombok.ToString;

@Entity
@Table(name = "VENDORS")
@Data
@ToString
public class VendorEntity {
    @Id
    @Column(name = "VENDOR_ID")
    @GeneratedValue
    private long id;
    @Column(name = "NAME")
    private String name;
    @Column(name = "CONTACT")
    private String contact;
    @Column(name = "PHONE")
    private String phoneNumber;
    @Column(name = "EMAIL")
    private String emailAddress;
    @Column(name = "ADDRESS")
    private String address;
}
