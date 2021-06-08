package com.fegregorio.restapidemo.dto;

import com.fegregorio.restapidemo.entities.Address;
import com.fegregorio.restapidemo.entities.Person;
import com.fegregorio.restapidemo.repositories.PersonRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Optional;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;
import static org.mockito.Mockito.any;

public class AddressDTOTest {

    PersonRepository personRepository = mock(PersonRepository.class);

    @DisplayName("Should transform AdressDTO to an entity")
    @Test
    void shouldTransformAddressDTOToEntity() {

        AddressDTO addressDTO = mockAddressDTO();
        Person person = mock(Person.class);
        Optional<Person> optionalPerson = Optional.of(person);

        when(personRepository.findById(any())).thenReturn(optionalPerson);

        Assertions.assertDoesNotThrow(() -> {
            Address address = addressDTO.toEntity(personRepository);
            Assertions.assertNotNull(address);
        });
    }

    private AddressDTO mockAddressDTO() {

        AddressDTO addressDTO = new AddressDTO();

        addressDTO.setAddOn("addOn");
        addressDTO.setCity("city");
        addressDTO.setDistrict("district");
        addressDTO.setNumber("number");
        addressDTO.setState("state");
        addressDTO.setPersonId(1L);
        addressDTO.setStreet("street");
        addressDTO.setZipCode("zipCode");

        return addressDTO;
    }
}
