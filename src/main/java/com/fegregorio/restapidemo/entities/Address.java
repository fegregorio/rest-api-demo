package com.fegregorio.restapidemo.entities;

import com.fegregorio.restapidemo.dto.AddressResponseDTO;

import javax.persistence.*;

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
    private @ManyToOne Person person;


    @Deprecated
    public Address() {}

    public Address(String street, int number, String addOn, String district,
                   String city, String state, String zipCode, Person person) {
        this.street = street;
        this.number = number;
        this.addOn = addOn;
        this.district = district;
        this.city = city;
        this.state = state;
        this.zipCode = zipCode;
        this.person = person;
    }


    public AddressResponseDTO toResponse() {
        return new AddressResponseDTO(street, number, addOn, district, city, state, zipCode);
    }

    public Long getId() { return id; }
}
