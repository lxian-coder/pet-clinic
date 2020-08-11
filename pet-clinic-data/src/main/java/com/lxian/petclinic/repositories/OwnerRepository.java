package com.lxian.petclinic.repositories;

import com.lxian.petclinic.model.Owner;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;


public interface OwnerRepository extends CrudRepository<Owner,Long> {

   Optional<Owner> findByLastName(String lastName);

}
