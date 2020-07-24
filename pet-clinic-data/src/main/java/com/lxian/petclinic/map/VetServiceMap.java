package com.lxian.petclinic.map;

import com.lxian.petclinic.model.Vet;
import com.lxian.petclinic.services.VetService;
import org.springframework.stereotype.Service;

import java.util.Set;

/**
 * Program : pet-clinic
 * Author : Darcy Xian
 * Create : 2020-07-16  23:53
 */
@Service
public class VetServiceMap extends AbstractService<Vet, Long> implements VetService {

    @Override
    public Set<Vet> findAll() {
        return super.findAll();
    }

    @Override
    public Vet findByID(Long id) {
        return super.findByID(id);
    }

    @Override
    public Vet save(Vet object) {
       return   super.save( object);
    }

    @Override
    public void delete(Vet object) {
        super.delete(object);

    }

    @Override
    public void deleteByID(Long id) {
        super.deleteByID(id);

    }
}
