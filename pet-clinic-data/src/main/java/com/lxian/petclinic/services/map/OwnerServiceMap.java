package com.lxian.petclinic.services.map;

import com.lxian.petclinic.model.Owner;
import com.lxian.petclinic.model.Pet;
import com.lxian.petclinic.services.OwnerService;
import com.lxian.petclinic.services.PetService;
import com.lxian.petclinic.services.PetTypeService;
import org.springframework.stereotype.Service;

import java.util.Set;

/**
 * Program : pet-clinic
 * Author : Darcy Xian
 * Create : 2020-07-16  18:42
 */
@Service
//@Profile("asa")
public class OwnerServiceMap extends AbstractService<Owner,Long> implements OwnerService {

    private PetService petService;
    private PetTypeService petTypeService;

    public OwnerServiceMap(PetService petService, PetTypeService petTypeService) {
        this.petService = petService;
        this.petTypeService = petTypeService;
    }

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
        if (object != null) {
            if (object.getPets() != null) {
                for (Pet pet : object.getPets()) {
                    if (pet.getPetType() != null) {
                        if (pet.getPetType().getId() == null) {
                            // this petType object has been added to set<petType>
                            petTypeService.save(pet.getPetType());
                        }
                    } else {
                        throw new RuntimeException("PetType is required");
                    }
                    // 因为ID是pojo 在储存到set里面的时候自动分配,所以如果这个宠物没有ID,它就没有被存入set.
                    if(pet.getId() == null){
                        petService.save(pet);
                    }
                }
            }
        }
        return super.save(object);
    }


    @Override
    public void delete(Owner object) {
        super.delete(object);
    }

    @Override
    public void deleteByID(Long id) {
        super.deleteByID(id);

    }

    @Override
    public Owner findByLastName(String lastName) {
        return null;
    }


}
