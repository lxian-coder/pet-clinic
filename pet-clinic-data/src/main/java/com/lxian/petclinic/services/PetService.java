package com.lxian.petclinic.services;

import com.lxian.petclinic.model.Pet;

import java.util.Set;

/**
 * @author : Darcy Xian
 * @program : pet-clinic
 * @create : 2020-07-15  16:51
 */
public interface PetService {

    Pet findByID(Long id);
    Pet save(Pet pet);
    Set<Pet> findAll();

}

