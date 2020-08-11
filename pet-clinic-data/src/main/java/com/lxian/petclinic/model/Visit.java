package com.lxian.petclinic.model;

import javax.persistence.*;
import java.time.LocalDate;

/**
 * pet-clinic
 * Author : Darcy Xian    Create : 2020-07-30  13:38
 */
@Entity
@Table(name = "visits")
public class Visit extends BaseEntity{

    @Column(name = "date")
    private LocalDate localDate;

    @Column(name = "description")
    private String description;

    @ManyToOne
    @JoinColumn(name = "pet_id")
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
