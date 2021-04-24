package com.fegregorio.restapidemo.controllers;

import com.fegregorio.restapidemo.dto.AddressDTO;
import com.fegregorio.restapidemo.dto.AddressResponseDTO;
import com.fegregorio.restapidemo.entities.Address;
import com.fegregorio.restapidemo.exceptions.ErrorMessages;
import com.fegregorio.restapidemo.repositories.AddressRepository;
import com.fegregorio.restapidemo.repositories.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/address")
public class AddressController {

    @Autowired
    private AddressRepository addressRepository;
    @Autowired
    private PersonRepository personRepository;


    @PostMapping("/new-address")
    public ResponseEntity<?> newAddress(@Valid @RequestBody AddressDTO dto) {

        Address address = dto.toEntity(personRepository);
        addressRepository.save(address);

        return ResponseEntity.status(HttpStatus.CREATED).body(dto);
    }

    @GetMapping("/person/{id}")
    public ResponseEntity<?> listAddresses(@PathVariable Long id) {

        List<AddressResponseDTO> responseList = addressRepository
                .findByPersonId(id)
                .stream()
                .map(Address::toResponse)
                .collect(Collectors.toList());

        if (responseList.isEmpty()) {
            return ResponseEntity.ok().body(ErrorMessages.EMPTY_RESPONSE_LIST.getMessage());
        }

        return ResponseEntity.ok().body(responseList);
    }
}
