package com.springframework.petclinic.model;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "vet")
public class Vet extends Person {

    @ManyToMany(mappedBy = "specialty")
    private Set<Specialty> specialties = new HashSet<>();

    public Set<Specialty> getSpecialties() {
        return specialties;
    }

    public void setSpecialties(Set<Specialty> specialties) {
        this.specialties = specialties;
    }

}
