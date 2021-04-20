package com.fegregorio.restapidemo.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fegregorio.restapidemo.entities.Person;

import java.time.LocalDate;

public class PersonDTO {

    private String name;
    private String email;
    private String cpf;
    @JsonFormat(pattern = "dd/MM/yyyy")
    private LocalDate birthdate;


    public Person toEntity() {
        return new Person(name, email, cpf, birthdate);
    }

    public String getName() { return name; }
    public String getEmail() { return email; }
    public String getCpf() { return cpf; }
    public LocalDate getBirthdate() { return birthdate; }

    public void setName(String name) { this.name = name; }
    public void setEmail(String email) { this.email = email; }
    public void setCpf(String cpf) { this.cpf = cpf; }
    public void setBirthdate(LocalDate birthdate) { this.birthdate = birthdate; }
}
