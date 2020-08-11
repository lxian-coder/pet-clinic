package com.lxian.petclinic.services.springdatajpa;

import com.lxian.petclinic.model.PetType;
import com.lxian.petclinic.repositories.PetTypeRepository;
import com.lxian.petclinic.services.PetTypeService;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

@Service
@Profile("springdatajpa")
public class PetTypeJpaService implements PetTypeService {

    private final PetTypeRepository petTypeRepository;

    public PetTypeJpaService(PetTypeRepository petTypeRepository) {
        this.petTypeRepository = petTypeRepository;
    }

    @Override
    public Iterable<PetType> findAll() {
        return petTypeRepository.findAll();
    }

    @Override
    public PetType findByID(Long aLong) {
        return petTypeRepository.findById(aLong).orElse(null);
    }

    @Override
    public PetType save(PetType object) {
        return petTypeRepository.save(object);
    }

    @Override
    public void delete(PetType object) {
        petTypeRepository.delete(object);
    }

    @Override
    public void deleteByID(Long aLong) {
       petTypeRepository.deleteById(aLong);
    }
}
