package com.springframework.petclinic.model.services;

import com.springframework.petclinic.model.Owner;
import com.springframework.petclinic.model.Vet;

import java.util.Set;

public interface VetService {

    Vet findByLastName(String lastName);

    Vet findById(Long id);

    Vet save(Vet owner);

    Set<Vet> findAll();

}
