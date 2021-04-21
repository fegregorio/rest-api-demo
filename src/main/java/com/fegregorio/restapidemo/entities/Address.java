package com.fegregorio.restapidemo.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Address {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String street;
    private Integer number;
    private String addOn;
    private String district;
    private String city;
    private String state;
    private String zipCode;


    @Deprecated
    public Address() {}


    public Address(String street, int number, String addOn, String district,
                   String city, String state, String zipCode) {
        this.street = street;
        this.number = number;
        this.addOn = addOn;
        this.district = district;
        this.city = city;
        this.state = state;
        this.zipCode = zipCode;
    }

    public Long getId() { return id; }
}
