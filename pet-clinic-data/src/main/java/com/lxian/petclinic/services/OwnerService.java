package com.lxian.petclinic.services;

import com.lxian.petclinic.model.Owner;

import java.util.List;

/**
 * Author : Darcy Xian
 * Program : pet-clinic
 * Create : 2020-07-15  16:42
 */
public interface OwnerService extends CrudService<Owner, Long> {

  Owner findByLastName(String lastName);
  List<Owner> findAllByLastNameLike(String lastName);

}
