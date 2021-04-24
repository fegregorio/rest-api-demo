package com.fegregorio.restapidemo.repositories;

import com.fegregorio.restapidemo.entities.Person;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PersonRepository extends JpaRepository<Person, Long> {

    public List<Person> findByCpf(String cpf);
    public List<Person> findByEmail(String email);
}
