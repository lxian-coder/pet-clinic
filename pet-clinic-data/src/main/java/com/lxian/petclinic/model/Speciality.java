package com.lxian.petclinic.model;

/**
 * pet-clinic
 * Author : Darcy Xian    Create : 2020-07-30  13:50
 */

public class Speciality extends BaseEntity {
    private String description;

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
