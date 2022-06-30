package com.springframework.petclinic.services.map.springdataJPA;

import com.springframework.petclinic.model.PetType;
import com.springframework.petclinic.repositories.PetTypeRepository;
import com.springframework.petclinic.services.PetTypeService;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

import java.util.Set;

@Service
@Profile("springdatajpa")
public class PetTypeSDJPA implements PetTypeService {

    private final PetTypeRepository petTypeRepository;

    public PetTypeSDJPA(PetTypeRepository petTypeRepository) {
        this.petTypeRepository = petTypeRepository;
    }

    @Override
    public Set<PetType> findAll() {
        return (Set<PetType>) petTypeRepository.findAll();
    }

    @Override
    public PetType findById(Long id) {
        return petTypeRepository.findById(id).orElse(null);
    }

    @Override
    public PetType save(PetType type) {
        return petTypeRepository.save(type);
    }

    @Override
    public void delete(PetType type) {
        petTypeRepository.delete(type);
    }

    @Override
    public void deleteById(Long type) {
        petTypeRepository.deleteById(type);
    }
}
