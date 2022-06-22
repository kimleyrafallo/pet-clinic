package com.springframework.petclinic.bootstrap;

import com.springframework.petclinic.model.Owner;
import com.springframework.petclinic.model.Pet;
import com.springframework.petclinic.model.PetType;
import com.springframework.petclinic.model.Vet;
import com.springframework.petclinic.services.OwnerService;
import com.springframework.petclinic.services.PetTypeService;
import com.springframework.petclinic.services.VetService;

import java.time.LocalDate;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class DataLoader implements CommandLineRunner {

    private final OwnerService ownerService;
    private final VetService vetService;
    private final PetTypeService petTypeService;

    public DataLoader(OwnerService ownerService, VetService vetService, PetTypeService petTypeService) {
        this.ownerService = ownerService;
        this.vetService = vetService;
        this.petTypeService = petTypeService;
    }

    @Override
    public void run(String... args) throws Exception {

        PetType dog = new PetType();
        dog.setName("Dog");
        PetType savedDogPetType = petTypeService.save(dog);

        PetType cat = new PetType();
        dog.setName("Cat");
        PetType savedCatPetType = petTypeService.save(cat);

        System.out.println("Loaded pet types.");

        Owner owner1 = new Owner();
        owner1.setFirstName("Michael");
        owner1.setLastName("Weston");
        owner1.setAddress("123 Brickel");
        owner1.setCity("Miami");
        owner1.setTelephone("091231231232");

        Pet mikesPet = new Pet();
        mikesPet.setPetType(savedDogPetType);
        mikesPet.setOwner(owner1);
        mikesPet.setBirthDate(LocalDate.now());
        mikesPet.setName("Bella");

        owner1.getPets().add(mikesPet);

        ownerService.save(owner1);

        Owner owner2 = new Owner();
        owner2.setFirstName("Fiona");
        owner2.setLastName("Glenanne");
        owner2.setAddress("123 Brickel");
        owner2.setCity("Miami");
        owner2.setTelephone("092133412634");

        Pet fionasPet = new Pet();
        fionasPet.setPetType(savedCatPetType);
        fionasPet.setOwner(owner2);
        fionasPet.setBirthDate(LocalDate.now());
        fionasPet.setName("Bingo");

        owner2.getPets().add(fionasPet);

        ownerService.save(owner2);

        System.out.println("Loaded owners with their pets.");

        Vet vet1 = new Vet();
        vet1.setFirstName("Alyanna");
        vet1.setLastName("Rafallo");

        vetService.save(vet1);

        Vet vet2 = new Vet();
        vet2.setFirstName("Magnamo");
        vet2.setLastName("Pukkan");

        vetService.save(vet2);

        System.out.println("Loaded vets.");

    }
}
