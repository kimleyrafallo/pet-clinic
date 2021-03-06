package com.springframework.petclinic.repositories;

import com.springframework.petclinic.model.Owner;
import com.springframework.petclinic.model.Vet;
import org.springframework.data.repository.CrudRepository;

public interface VetRepository extends CrudRepository<Vet, Long> {
    Vet findByLastName(String lastName);
}
