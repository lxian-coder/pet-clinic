package com.lxian.petclinic.map;

import com.lxian.petclinic.model.Pet;
import com.lxian.petclinic.services.PetService;

import java.util.Set;

/**
 * Program : pet-clinic
 * Author : Darcy Xian
 * Create : 2020-07-17  00:17
 */

public class PetServicesMap extends AbstractService<Pet,Long> implements PetService {

    @Override
    public Set<Pet> findAll() {
        return super.findAll();
    }

    @Override
    public Pet findByID(Long id) {
        return super.findByID(id);
    }

    @Override
    public Pet save(Pet object) {
        return super.save(object.getId(),object);
    }

    @Override
    public void delete(Pet object) {
          super.delete(object);

    }

    @Override
    public void deleteByID(Long id) {
        super.deleteByID(id);

    }
}
