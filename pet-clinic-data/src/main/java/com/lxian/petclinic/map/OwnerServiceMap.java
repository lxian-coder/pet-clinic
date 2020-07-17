package com.lxian.petclinic.map;

import com.lxian.petclinic.model.Owner;
import com.lxian.petclinic.services.CrudService;

import java.util.Set;

/**
 * Program : pet-clinic
 * Author : Darcy Xian
 * Create : 2020-07-16  18:42
 */
public class OwnerServiceMap extends AbstractService<Owner,Long> implements CrudService<Owner,Long> {

    @Override
    public Set<Owner> findAll() {
        return super.findAll();
    }

    @Override
    public Owner findByID(Long id) {
        return super.findByID(id);
    }

    @Override
    public Owner save (Owner object) {
        return super.save(object.getId(),object);
    }

    @Override
    public void delete(Owner object) {
        super.delete(object);
    }

    @Override
    public void deleteByID(Long id) {
        super.deleteByID(id);

    }

}
