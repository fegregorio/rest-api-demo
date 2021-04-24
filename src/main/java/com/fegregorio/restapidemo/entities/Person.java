package com.fegregorio.restapidemo.entities;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fegregorio.restapidemo.dto.PersonResponseDTO;

import javax.persistence.*;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

@Entity
public class Person {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String email;
    private String cpf;
    private @JsonFormat(pattern = "dd/MM/yyyy") LocalDate birthdate;
    private LocalDateTime createdAt = LocalDateTime.now();
    private @OneToMany(mappedBy = "person") List<Address> addresses;


    @Deprecated
    public Person() {}

    public Person(String name, String email, String cpf, LocalDate birthdate) {
        this.name = name;
        this.email = email;
        this.cpf = cpf;
        this.birthdate = birthdate;
    }


    public PersonResponseDTO toResponse() {
        return new PersonResponseDTO(name, email, cpf, birthdate);
    }

    public Long getId() { return id; }
}
