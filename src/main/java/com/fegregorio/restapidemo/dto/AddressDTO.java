package com.fegregorio.restapidemo.dto;

import com.fegregorio.restapidemo.entities.Address;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

public class AddressDTO {

    private @NotBlank String street;
    private @NotNull Integer number;
    private String addOn;
    private @NotBlank String district;
    private @NotBlank String city;
    private @NotBlank String state;
    private @NotBlank String zipCode;


    public Address toEntity() {
        return new Address(street, number, addOn, district, city, state, zipCode);
    }

    public String getStreet() { return street; }
    public Integer getNumber() { return number; }
    public String getAddOn() { return addOn; }
    public String getDistrict() { return district; }
    public String getCity() { return city; }
    public String getState() { return state; }
    public String getZipCode() { return zipCode; }

    public void setStreet(String street) { this.street = street; }
    public void setNumber(Integer number) { this.number = number; }
    public void setAddOn(String addOn) { this.addOn = addOn; }
    public void setDistrict(String district) { this.district = district; }
    public void setCity(String city) { this.city = city; }
    public void setState(String state) { this.state = state; }
    public void setZipCode(String zipCode) { this.zipCode = zipCode; }
}
