package com.lxian.petclinic.services;

import com.lxian.petclinic.model.Owner;

import java.util.Set;

/**
 * @author : Darcy Xian
 * @program : pet-clinic
 * @create : 2020-07-15  16:42
 */
public interface OwnerService {

    Owner findByLastName( String lastName);
    Owner findByID(Long id);
    Owner save(Owner owner);
    Set<Owner> findAll();


}
