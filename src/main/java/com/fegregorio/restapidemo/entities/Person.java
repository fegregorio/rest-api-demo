package com.fegregorio.restapidemo.entities;

import com.fasterxml.jackson.annotation.JsonFormat;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.time.LocalDate;
import java.time.LocalDateTime;

@Entity
public class Person {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String email;
    private String cpf;
    @JsonFormat(pattern = "dd/MM/yyyy")
    private LocalDate birthdate;
    private LocalDateTime createdAt = LocalDateTime.now();


    @Deprecated
    public Person() {}

    public Person(String name, String email, String cpf, LocalDate birthdate) {
        this.name = name;
        this.email = email;
        this.cpf = cpf;
        this.birthdate = birthdate;
    }
}
