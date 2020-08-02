package com.lxian.petclinic.map;

import com.lxian.petclinic.model.PetType;
import com.lxian.petclinic.services.PetTypeService;

import java.util.Set;

/**
 * pet-clinic
 * Author : Darcy Xian    Create : 2020-08-02  19:04
 */

public class PetTypeServiceMap extends AbstractService<PetType,Long> implements PetTypeService{

    @Override
    public Set<PetType> findAll() {
        return super.findAll();
    }

    @Override
    public void deleteByID(Long id) {
         super.deleteByID(id);

    }

    @Override
    public void delete(PetType object) {
        delete(object);

    }

    @Override
    public PetType save(PetType object) {
        return super.save(object);
    }

    @Override
    public PetType findByID(Long id) {
        return super.findByID(id);
    }
}
