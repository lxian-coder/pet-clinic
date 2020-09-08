package com.lxian.petclinic.services.springdatajpa;

import com.lxian.petclinic.model.Owner;
import com.lxian.petclinic.repositories.OwnerRepository;
import com.lxian.petclinic.services.OwnerService;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Profile("springdatajpa")
public class OwnerJpaService implements OwnerService {
    private final OwnerRepository ownerRepository;


    public OwnerJpaService(OwnerRepository ownerRepository) {
        this.ownerRepository = ownerRepository;
    }

    @Override
    public Owner findByLastName(String lastName) {
        return ownerRepository.findByLastName(lastName).orElse(null);
    }

    @Override
    public Iterable<Owner> findAll() {
        return ownerRepository.findAll();
    }


    @Override
    public Owner findByID(Long aLong) {
        return ownerRepository.findById(aLong).orElse(null);
    }

    @Override
    public Owner save(Owner object) {

        return ownerRepository.save(object);
    }

    @Override
    public void delete(Owner object) { ownerRepository.delete(object);

    }

    @Override
    public void deleteByID(Long aLong) { ownerRepository.deleteById(aLong);

    }

    @Override
    public List<Owner> findAllByLastNameLike(String lastName) {
        return ownerRepository.findAllByLastNameLike(lastName);
    }
}
