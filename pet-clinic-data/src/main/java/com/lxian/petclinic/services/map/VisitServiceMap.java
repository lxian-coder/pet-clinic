package com.lxian.petclinic.services.map;

import com.lxian.petclinic.model.Visit;
import com.lxian.petclinic.services.VisitService;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

import java.util.Set;

/**
 * Darcy Xian  11/8/20  10:15 pm      pet-clinic
 */
@Service
@Profile({"default","map"})
public class VisitServiceMap extends AbstractService<Visit,Long> implements VisitService {


    @Override
    public Set<Visit> findAll() {
        return super.findAll();
    }

    @Override
    public Visit findByID(Long id) {
        return super.findByID(id);
    }

    @Override
    public Visit save(Visit object) {
        if(object.getPet() == null ||  object.getPet().getId() == null ||
                object.getPet().getOwner() == null || object.getPet().getOwner().getId() == null)
        throw new RuntimeException("Invalid Vist!!");


        return super.save(object);
    }

    @Override
    public void delete(Visit object) {
          super.delete(object);
    }

    @Override
    public void deleteByID(Long id) {
          super.deleteByID(id);
    }
}
