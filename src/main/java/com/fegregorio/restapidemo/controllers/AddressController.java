package com.fegregorio.restapidemo.controllers;

import com.fegregorio.restapidemo.dto.AddressDTO;
import com.fegregorio.restapidemo.entities.Address;
import com.fegregorio.restapidemo.repositories.AddressRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import javax.validation.Valid;
import java.net.URI;

@RestController
@RequestMapping("/address")
public class AddressController {

    @Autowired
    private AddressRepository repository;


    @PostMapping("/new-address")
    public ResponseEntity<?> newAddress(@Valid @RequestBody AddressDTO dto,
                                        UriComponentsBuilder builder) {
        Address address = dto.toEntity();
        repository.save(address);
        URI uri = builder.path("/address/{id}").buildAndExpand(address.getId()).toUri();
        return ResponseEntity.created(uri).build();
    }
}
