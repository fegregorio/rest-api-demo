package com.fegregorio.restapidemo.controllers;

import com.fegregorio.restapidemo.dto.PersonDTO;
import com.fegregorio.restapidemo.dto.PersonResponseDTO;
import com.fegregorio.restapidemo.entities.Person;
import com.fegregorio.restapidemo.exceptions.ErrorMessages;
import com.fegregorio.restapidemo.repositories.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.http.HttpStatus;
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
    public ResponseEntity<?> createUser(@Valid @RequestBody PersonDTO dto) {
        Person person = dto.toEntity();

        if (!repository.findByCpf(dto.getCpf()).isEmpty()) {

            return ResponseEntity
                    .status(HttpStatus.BAD_REQUEST)
                    .body(ErrorMessages.DUPLICATE_CPF.getMessage());
        }

        if (!repository.findByEmail(dto.getEmail()).isEmpty()) {

            return ResponseEntity
                    .status(HttpStatus.BAD_REQUEST)
                    .body(ErrorMessages.DUPLICATE_EMAIL.getMessage());
        }

        repository.save(person);
        return ResponseEntity.status(HttpStatus.CREATED).body(person.toResponse());
    }
}
