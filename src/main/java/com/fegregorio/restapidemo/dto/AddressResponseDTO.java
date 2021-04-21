package com.fegregorio.restapidemo.dto;

public class AddressResponseDTO {

    private String street;
    private String number;
    private String addOn;
    private String district;
    private String city;
    private String state;
    private String zipCode;


    public AddressResponseDTO(String street, String number, String addOn, String district,
                              String city, String state, String zipCode) {
        this.street = street;
        this.number = number;
        this.addOn = addOn;
        this.district = district;
        this.city = city;
        this.state = state;
        this.zipCode = zipCode;
    }

    public String getStreet() {
        return street;
    }
    public String getNumber() {
        return number;
    }
    public String getAddOn() {
        return addOn;
    }
    public String getDistrict() {
        return district;
    }
    public String getCity() {
        return city;
    }
    public String getState() {
        return state;
    }
    public String getZipCode() {
        return zipCode;
    }
}
