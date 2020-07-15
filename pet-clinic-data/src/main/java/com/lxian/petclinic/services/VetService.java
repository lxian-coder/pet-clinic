package com.lxian.petclinic.services;

import com.lxian.petclinic.model.Owner;
import com.lxian.petclinic.model.Vet;

import java.util.Set;

/**
 * @author : Darcy Xian
 * @program : pet-clinic
 * @create : 2020-07-15  16:52
 */
public interface VetService {
    Vet findByID(Long id);
    Vet save(Owner vet);
    Set<Vet> findAll();
}
