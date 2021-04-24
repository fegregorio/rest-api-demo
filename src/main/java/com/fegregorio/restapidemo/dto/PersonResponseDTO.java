package com.fegregorio.restapidemo.dto;

import java.time.LocalDate;

public class PersonResponseDTO {

    private String name;
    private String email;
    private String cpf;
    private LocalDate birthdate;


    public PersonResponseDTO(String name, String email, String cpf, LocalDate birthdate) {
        this.name = name;
        this.email = email;
        this.cpf = cpf;
        this.birthdate = birthdate;
    }


    public String getName() { return name; }
    public String getEmail() { return email; }
    public String getCpf() { return cpf; }
    public LocalDate getBirthdate() { return birthdate; }
}
