package com.fegregorio.restapidemo.entities;

import com.fegregorio.restapidemo.dto.AddressResponseDTO;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class AddressTest {

    @DisplayName("Should transform Address to Response DTO")
    @Test
    void shouldTransformAddressToResponseDTO() {

        Address address = mockAddress();
        AddressResponseDTO response = address.toResponse();

        Assertions.assertEquals("street", response.getStreet());
        Assertions.assertEquals("number", response.getNumber());
        Assertions.assertEquals("addOn", response.getAddOn());
        Assertions.assertEquals("district", response.getDistrict());
        Assertions.assertEquals("city", response.getCity());
        Assertions.assertEquals("state", response.getState());
        Assertions.assertEquals("zipCode", response.getZipCode());
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
}
