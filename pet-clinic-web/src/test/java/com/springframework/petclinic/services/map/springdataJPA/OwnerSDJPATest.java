package com.springframework.petclinic.services.map.springdataJPA;

import com.springframework.petclinic.model.Owner;
import com.springframework.petclinic.repositories.OwnerRepository;
import com.springframework.petclinic.repositories.PetRepository;
import com.springframework.petclinic.repositories.PetTypeRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class OwnerSDJPATest {

    @Mock
    OwnerRepository ownerRepository;

    @Mock
    PetRepository petRepository;

    @Mock
    PetTypeRepository petTypeRepository;

    @InjectMocks
    OwnerSDJPA service;

    @BeforeEach
    void setUp() {
    }

    @Test
    void should_FindAll_When_FindAllInvoked() {
        Set<Owner> owners = new HashSet<>();
        owners.add(Owner.builder().id(1L).build());
        owners.add(Owner.builder().id(2L).build());

        when(ownerRepository.findAll()).thenReturn(owners);

        Set<Owner> actual = service.findAll();

        assertEquals(2, actual.size());
    }

    @Test
    void should_FindById_When_OwnerExisting() {
        Long id = 1L;
        Owner expected = Owner.builder().id(id).build();
        when(ownerRepository.findById(id)).thenReturn(Optional.ofNullable(expected));

        Owner actual = service.findById(id);

        assertEquals(expected, actual);
    }

    @Test
    void should_ReturnNull_When_OwnerNotExisting() {
        when(ownerRepository.findById(anyLong())).thenReturn(Optional.empty());

        Owner actual = service.findById(anyLong());

        assertNull(actual);
    }

    @Test
    void should_SaveOwner_When_SaveInvoked() {
        Owner owner = Owner.builder().id(1L).build();
        when(ownerRepository.save(any())).thenReturn(owner);

        Owner actual = service.save(owner);

        assertEquals(owner, actual);
    }

    @Test
    void delete() {
        Owner owner = Owner.builder().id(1L).build();

        service.delete(owner);

        verify(ownerRepository).delete(any());
    }

    @Test
    void deleteById() {
        service.deleteById(1L);

        verify(ownerRepository).deleteById(anyLong());
    }

    @Test
    void findByLastName() {
        Owner owner = Owner.builder().id(1L).lastName("lastname").build();

        when(ownerRepository.findByLastName(any())).thenReturn(owner);

        Owner actual = service.findByLastName("lastname");

        assertEquals(owner, actual);
    }
}