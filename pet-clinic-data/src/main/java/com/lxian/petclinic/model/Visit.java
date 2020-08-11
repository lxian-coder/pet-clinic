package com.lxian.petclinic.model;

import java.time.LocalDate;

/**
 * pet-clinic
 * Author : Darcy Xian    Create : 2020-07-30  13:38
 */

public class Visit extends BaseEntity{
    private LocalDate localDate;
    private String description;
    private Pet pet;

    public LocalDate getLocalDate() {
        return localDate;
    }

    public void setLocalDate(LocalDate localDate) {
        this.localDate = localDate;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Pet getPet() {
        return pet;
    }

    public void setPet(Pet pet) {
        this.pet = pet;
    }
}
