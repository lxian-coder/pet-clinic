package com.lxian.petclinic.services.springdatajpa;

import com.lxian.petclinic.model.Pet;
import com.lxian.petclinic.repositories.PetRepository;
import com.lxian.petclinic.services.PetService;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

/**
 * Darcy Xian  11/8/20  8:34 pm      pet-clinic
 */
@Service
@Profile("springdatajpa")
public class PetJpaService implements PetService {

    private final PetRepository petRepository;

    public PetJpaService(PetRepository petRepository) {
        this.petRepository = petRepository;
    }

    @Override
    public Iterable<Pet> findAll() {
        return petRepository.findAll();
    }

    @Override
    public Pet findByID(Long aLong) {
        return petRepository.findById(aLong).orElse(null);
    }

    @Override
    public Pet save(Pet object) {
        return petRepository.save(object);
    }

    @Override
    public void delete(Pet object) {
         petRepository.delete(object);
    }

    @Override
    public void deleteByID(Long aLong) {
        petRepository.deleteById(aLong);
    }
}
