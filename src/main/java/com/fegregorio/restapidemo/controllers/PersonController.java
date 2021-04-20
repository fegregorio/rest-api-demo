package com.fegregorio.restapidemo.controllers;

import com.fegregorio.restapidemo.dto.PersonDTO;
import com.fegregorio.restapidemo.entities.Person;
import com.fegregorio.restapidemo.repositories.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/person")
public class PersonController {

    @Autowired
    private PersonRepository repository;


    @PostMapping("/create")
    public String createUser(@RequestBody PersonDTO dto) {
        Person user = dto.toEntity();
        repository.save(user);
        return "User profile created.";
    }
}
