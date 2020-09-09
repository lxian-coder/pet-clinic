package com.lxian.petclinic.model;

import lombok.*;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "pet_type")
public class PetType extends BaseEntity {

    @Builder
    public PetType(Long id, String name){
        super(id);
        this.name = name;
    }

    @Column(name = "name")
    private String name;

}
