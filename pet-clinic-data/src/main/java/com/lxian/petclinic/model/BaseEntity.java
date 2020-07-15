package com.lxian.petclinic.model;

import java.io.Serializable;

/**
 * @author : Darcy Xian
 * @program : pet-clinic
 * @create : 2020-07-15  17:13
 */

public class BaseEntity implements Serializable {

    private Long id;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}
