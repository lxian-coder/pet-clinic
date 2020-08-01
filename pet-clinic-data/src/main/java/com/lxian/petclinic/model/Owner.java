package com.lxian.petclinic.model;

import java.util.Set;

public class Owner extends Person {

    private String Address;
    private String city;
    private String telehpone;
    private Set<Pet> pets;

    public String getAddress() {
        return Address;
    }

    public void setAddress(String address) {
        Address = address;
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

    public void setPets(Set<Pet> pets) {
        this.pets = pets;
    }
}
