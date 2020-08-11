package com.lxian.petclinic.services.springdatajpa;

import com.lxian.petclinic.model.Speciality;
import com.lxian.petclinic.repositories.SpecialityRepository;
import com.lxian.petclinic.services.SpecialityService;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

/**
 * Darcy Xian  11/8/20  8:45 pm      pet-clinic
 */
@Service
@Profile("springdatajpa")
public class SpecialtyJpaService implements SpecialityService {

   private final SpecialityRepository specialityRepository;

    public SpecialtyJpaService(SpecialityRepository specialityRepository) {
        this.specialityRepository = specialityRepository;
    }

    @Override
    public Iterable<Speciality> findAll() {
        return specialityRepository.findAll();
    }

    @Override
    public Speciality findByID(Long aLong) {
        return specialityRepository.findById(aLong).orElse(null);
    }

    @Override
    public Speciality save(Speciality object) {
        return specialityRepository.save(object);
    }

    @Override
    public void delete(Speciality object) {
        specialityRepository.delete(object);
    }

    @Override
    public void deleteByID(Long aLong) {
       specialityRepository.deleteById(aLong);
    }
}
