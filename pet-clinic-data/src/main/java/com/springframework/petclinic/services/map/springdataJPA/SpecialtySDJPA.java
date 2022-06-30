package com.springframework.petclinic.services.map.springdataJPA;

import com.springframework.petclinic.model.Specialty;
import com.springframework.petclinic.repositories.SpecialtyRepository;
import com.springframework.petclinic.services.SpecialtyService;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

import java.util.Set;

@Service
@Profile("springdatajpa")
public class SpecialtySDJPA implements SpecialtyService {

    private final SpecialtyRepository specialtyRepository;

    public SpecialtySDJPA(SpecialtyRepository specialtyRepository) {
        this.specialtyRepository = specialtyRepository;
    }

    @Override
    public Set<Specialty> findAll() {
        return (Set<Specialty>) specialtyRepository.findAll();
    }

    @Override
    public Specialty findById(Long id) {
        return specialtyRepository.findById(id).orElse(null);
    }

    @Override
    public Specialty save(Specialty specialty) {
        return specialtyRepository.save(specialty);
    }

    @Override
    public void delete(Specialty specialty) {
        specialtyRepository.delete(specialty);
    }

    @Override
    public void deleteById(Long id) {
        specialtyRepository.deleteById(id);
    }
}
