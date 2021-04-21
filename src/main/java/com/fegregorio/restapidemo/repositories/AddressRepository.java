package com.fegregorio.restapidemo.repositories;

import com.fegregorio.restapidemo.entities.Address;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AddressRepository extends JpaRepository<Address, Long> {

    public List<Address> findByPersonId(Long personId);
}
