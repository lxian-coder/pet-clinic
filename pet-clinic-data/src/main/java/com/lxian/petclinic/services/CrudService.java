package com.lxian.petclinic.services;

/**
 * Program : pet-clinic
 * Author : Darcy Xian
 * Create : 2020-07-16  12:25
 */

public interface CrudService <T,ID> {

    Iterable<T> findAll();
    T findByID(ID id);
    T save(T object);
    void delete(T object);
    void deleteByID(ID id);

}








