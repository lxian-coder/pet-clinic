package com.lxian.petclinic.services.map;

import com.lxian.petclinic.model.Pet;
import com.lxian.petclinic.services.PetService;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

import java.util.Set;

/**
 * Program : pet-clinic
 * Author : Darcy Xian
 * Create : 2020-07-17  00:17
 */
@Service
@Profile({"default","map"})
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
        return super.save(object);
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
