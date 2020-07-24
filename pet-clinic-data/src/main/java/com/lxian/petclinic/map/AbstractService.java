package com.lxian.petclinic.map;

import com.lxian.petclinic.model.BaseEntity;

import java.util.*;

/**
 * Program : pet-clinic
 * Author : Darcy Xian
 * Create : 2020-07-16  13:03
 */

public abstract class AbstractService<T extends BaseEntity,ID extends Long> {
    protected Map<Long,T> map = new HashMap<>();

    Set<T> findAll(){
        return new HashSet<>(map.values());   // map.values return collection of values
    }

    T findByID(ID id){
        return map.get(id);
    }

    T save( T object){
        if(object != null)
            if(object.getId() == null) {
                object.setId(getNextId());
                map.put(getNextId(), object);
            }
        return object;
    }

    void deleteByID(ID id){
        map.remove(id);
    }

    void delete(T object){
        map.entrySet().removeIf(entry -> entry.getValue().equals(object) );
    }

    public Long getNextId(){
        Long nextId = null;
        try{
            nextId = Collections.max(map.keySet()) + 1L; }
        catch(NoSuchElementException e){
            nextId = 1L;
        }

        return nextId ;
    }


}
