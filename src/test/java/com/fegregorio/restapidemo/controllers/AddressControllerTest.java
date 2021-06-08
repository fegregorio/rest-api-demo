package com.fegregorio.restapidemo.controllers;

import com.fegregorio.restapidemo.dto.AddressDTO;
import com.fegregorio.restapidemo.dto.AddressResponseDTO;
import com.fegregorio.restapidemo.entities.Address;
import com.fegregorio.restapidemo.repositories.AddressRepository;
import com.fegregorio.restapidemo.repositories.PersonRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.List;
import java.util.stream.Collectors;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;
import static org.mockito.Mockito.any;

public class AddressControllerTest {

    AddressRepository addressRepository = mock(AddressRepository.class);
    PersonRepository personRepository = mock(PersonRepository.class);
    AddressController addressController = new AddressController(addressRepository, personRepository);


    @DisplayName("Should create a new address")
    @Test
    void shouldCreateANewAddress() {

        AddressDTO addressDTO = mock(AddressDTO.class);

        Assertions.assertDoesNotThrow(() -> {
            ResponseEntity<?> responseEntity = addressController.newAddress(addressDTO);

            Assertions.assertEquals(
                    ResponseEntity.status(HttpStatus.CREATED).body(addressDTO),
                    responseEntity);
        });
    }

    @Test
    void test() { // is bugged

        Address address = mock(Address.class);
        AddressResponseDTO responseDTO = mock(AddressResponseDTO.class);

        List<Address> addressList = List.of(address);
        List<AddressResponseDTO> responseList = List.of(responseDTO);

        when(addressRepository
                .findByPersonId(any())
                .stream()
                .map(Address::toResponse)
                .collect(Collectors.toList()))
                .thenReturn(responseList);

        ResponseEntity<?> responseEntity = addressController.listAddresses(1L);

        Assertions.assertEquals(
                ResponseEntity.ok().body(responseList), responseEntity
        );
    }

    private Address mockAddress() {

        return new Address(
                "street",
                "number",
                "addOn",
                "district",
                "city",
                "state",
                "zipCode",
                null
        );
    }

    private AddressResponseDTO mockAddressResponse() {

        return new AddressResponseDTO(
                "street",
                "number",
                "addOn",
                "district",
                "city",
                "state",
                "zipCode"
        );
    }
}
