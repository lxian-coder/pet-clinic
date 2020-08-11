package com.lxian.petclinic.services.springdatajpa;

import com.lxian.petclinic.model.Visit;
import com.lxian.petclinic.repositories.VisitRepository;
import com.lxian.petclinic.services.VisitService;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

/**
 * Darcy Xian  11/8/20  11:07 pm      pet-clinic
 */

@Service
@Profile("springdatajpa")
public class VisitJpaService implements VisitService {
    private final VisitRepository visitRepository;

    public VisitJpaService(VisitRepository visitRepository) {
        this.visitRepository = visitRepository;
    }

    @Override
    public Iterable<Visit> findAll() {
        return visitRepository.findAll();
    }

    @Override
    public Visit findByID(Long aLong) {
        return visitRepository.findById(aLong).orElse(null);
    }

    @Override
    public Visit save(Visit object) {
        if(object.getPet() == null || object.getPet().getId() == null || object.getPet().getOwner() == null
        || object.getPet().getOwner().getId() == null)
            throw new RuntimeException("Invalid Visit");


        return visitRepository.save(object);
    }

    @Override
    public void delete(Visit object) {
        visitRepository.delete(object);
    }

    @Override
    public void deleteByID(Long aLong) {
          visitRepository.findById(aLong);
    }
}
