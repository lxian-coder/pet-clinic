package com.lxian.petclinic.model.repositories;

import com.lxian.petclinic.model.PetType;
import org.springframework.data.repository.CrudRepository;

public interface PetTypeRepository extends CrudRepository<PetType,Long> {
}
