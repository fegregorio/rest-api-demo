package com.fegregorio.restapidemo.dto;

import com.fegregorio.restapidemo.entities.Address;
import com.fegregorio.restapidemo.entities.Person;
import com.fegregorio.restapidemo.exceptions.ErrorMessages;
import com.fegregorio.restapidemo.repositories.PersonRepository;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.util.NoSuchElementException;
import java.util.Optional;

public class AddressDTO {

    private @NotBlank String street;
    private @NotBlank String number;
    private String addOn;
    private @NotBlank String district;
    private @NotBlank String city;
    private @NotBlank String state;
    private @NotBlank String zipCode;
    private @NotNull Long personId;


    public Address toEntity(PersonRepository repository) {

        Optional<Person> possiblePerson = repository.findById(personId);

        if (possiblePerson.isEmpty()) {
            throw new NoSuchElementException(ErrorMessages.ID_NOT_FOUND.getMessage());
        }

        Person person = possiblePerson.get();
        return new Address(street, number, addOn, district, city, state, zipCode, person);
    }

    public String getStreet() { return street; }
    public String getNumber() { return number; }
    public String getAddOn() { return addOn; }
    public String getDistrict() { return district; }
    public String getCity() { return city; }
    public String getState() { return state; }
    public String getZipCode() { return zipCode; }
    public Long getPersonId() { return personId; }

    public void setStreet(String street) { this.street = street; }
    public void setNumber(String number) { this.number = number; }
    public void setAddOn(String addOn) { this.addOn = addOn; }
    public void setDistrict(String district) { this.district = district; }
    public void setCity(String city) { this.city = city; }
    public void setState(String state) { this.state = state; }
    public void setZipCode(String zipCode) { this.zipCode = zipCode; }
    public void setPersonId(Long personId) { this.personId = personId; }
}
