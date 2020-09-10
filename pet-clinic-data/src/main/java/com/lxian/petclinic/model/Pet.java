package com.lxian.petclinic.model;

import lombok.*;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor

@Entity
@Table(name = "pet")
public class Pet extends BaseEntity {
    @Builder
    public Pet(Long id, PetType petType, String name, Owner owner, LocalDate birthDate, Set<Visit> visits) {
        super(id);
        this.petType = petType;
        this.name = name;
        this.owner = owner;
        this.birthDate = birthDate;
        if(visits != null) {
            this.visits = visits;
        }
    }

    @ManyToOne
    @JoinColumn(name = "type_id")
    private PetType petType;

    @Column(name = "name")
    private String name;

    @ManyToOne
    @JoinColumn(name = "owner_id")
    private Owner owner;

    @Column(name = "birth_date")
    private LocalDate birthDate;

    @OneToMany(cascade = CascadeType.ALL,mappedBy = "pet")
    private Set<Visit> visits = new HashSet<>();

}
