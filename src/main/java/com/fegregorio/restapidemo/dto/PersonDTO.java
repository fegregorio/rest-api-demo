package com.fegregorio.restapidemo.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fegregorio.restapidemo.entities.Person;
import org.hibernate.validator.constraints.br.CPF;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.time.LocalDate;

public class PersonDTO {

    @NotBlank
    private String name;

    @NotBlank
    @Email
    private String email;

    @NotBlank
    @CPF
    private String cpf;

    @NotNull
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
