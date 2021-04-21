package com.fegregorio.restapidemo.controllers;

import com.fegregorio.restapidemo.dto.PersonDTO;
import com.fegregorio.restapidemo.entities.Person;
import com.fegregorio.restapidemo.repositories.PersonRepository;
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
@RequestMapping("/person")
public class PersonController {

    @Autowired
    private PersonRepository repository;


    @PostMapping("/create")
    public ResponseEntity<?> createUser(@Valid @RequestBody PersonDTO dto, UriComponentsBuilder builder) {
        Person person = dto.toEntity();
        repository.save(person);
        URI uri = builder.path("/person/{id}").buildAndExpand(person.getId()).toUri();
        return ResponseEntity.created(uri).build();
    }
}
