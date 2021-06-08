package com.fegregorio.restapidemo.repositories;

import com.fegregorio.restapidemo.entities.Person;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PersonRepository extends JpaRepository<Person, Long> {

    List<Person> findByCpf(String cpf);
    List<Person> findByEmail(String email);
}
