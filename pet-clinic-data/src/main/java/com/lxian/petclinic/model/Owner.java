package com.lxian.petclinic.model;



import lombok.*;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;
@Setter
@Getter
@NoArgsConstructor
@Entity
@Table(name = "Owners")
public class Owner extends Person {

    @Builder
    public Owner(Long id, String firstName, String lastName,String address,String city,String telehpone) {

        super(id, firstName, lastName);
        this.address = address;
        this.city = city;
        this.telehpone = telehpone;
    }


    @Column(name = "address")
    private String address;

    @Column(name = "city")
    private String city;

    @Column(name = "telephone")
    private String telehpone;

    @OneToMany( cascade = CascadeType.ALL, mappedBy = "owner")
    private Set<Pet> pets = new HashSet<>();

}
