package com.lxian.petclinic.model;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "Owners")
public class Owner extends Person {

    @Column(name = "address")
    private String address;

    @Column(name = "city")
    private String city;

    @Column(name = "telephone")
    private String telehpone;

    @OneToMany( cascade = CascadeType.ALL, mappedBy = "owner")
    private Set<Pet> pets = new HashSet<>();

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getTelehpone() {
        return telehpone;
    }

    public void setTelehpone(String telehpone) {
        this.telehpone = telehpone;
    }

    public Set<Pet> getPets() {
        return pets;
    }

    public void setPets(Pet pet) {
        this.pets.add(pet);
    }
}
