package com.lxian.petclinic.services.springdatajpa;

import com.lxian.petclinic.model.Owner;
import com.lxian.petclinic.services.OwnerService;

public class OwnerSDJpaService implements OwnerService {

    private final OwnerRepository ownerRepository;
    private final PetRepository petRepository;

    public OwnerSDJpaService(OwnerRepository ownerRepository, PetRepository petRepository) {
        this.ownerRepository = ownerRepository;
        this.petRepository = petRepository;
    }

    @Override
    public Owner findByLastName(String lastName) {
        return null;
    }

    @Override
    public Iterable<Owner> findAll() {
        return null;
    }

    @Override
    public Owner findByID(Long aLong) {
        return null;
    }

    @Override
    public Owner save(Owner object) {
        return null;
    }

    @Override
    public void delete(Owner object) {

    }

    @Override
    public void deleteByID(Long aLong) {

    }
}
