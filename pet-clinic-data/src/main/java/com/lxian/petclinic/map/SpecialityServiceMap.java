package com.lxian.petclinic.map;

import com.lxian.petclinic.model.Speciality;
import com.lxian.petclinic.services.SpecialityService;
import org.springframework.stereotype.Service;

import java.util.Set;

/**
 * pet-clinic
 * Author : Darcy Xian    Create : 2020-08-03  14:41
 */
@Service
public class SpecialityServiceMap extends AbstractService<Speciality,Long> implements SpecialityService {
    @Override
    public Set<Speciality> findAll() {
        return super.findAll();
    }

    @Override
    public Speciality findByID(Long id) {
        return super.findByID(id);
    }

    @Override
    public Speciality save(Speciality object) {
        return super.save(object);
    }

    @Override
    public void delete(Speciality object) {
        super.delete(object);
    }

    @Override
    public void deleteByID(Long id) {
       super.deleteByID(id);
    }
}
