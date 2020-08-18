package com.lxian.petclinic.bootstrap;

import com.lxian.petclinic.model.*;
import com.lxian.petclinic.services.OwnerService;
import com.lxian.petclinic.services.PetTypeService;
import com.lxian.petclinic.services.SpecialityService;
import com.lxian.petclinic.services.VetService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.time.LocalDate;

/**
 * pet-clinic
 * Author : Darcy Xian    Create : 2020-07-23  22:07
 */
@Slf4j
@Component
public class DataLodar implements CommandLineRunner {

    private final OwnerService ownerService;
    private final VetService vetService;
    private final PetTypeService petTypeService;
    private final SpecialityService specialityService;

    public DataLodar(OwnerService ownerService, VetService vetService, PetTypeService petTypeService, SpecialityService specialityService) {
        this.ownerService = ownerService;
        this.vetService = vetService;
        this.petTypeService = petTypeService;
        this.specialityService = specialityService;
    }

    @Override
    public void run(String... args) throws Exception {
        log.debug("I am in datalodar" );
           loadData();

    }

    private void loadData() {
        Speciality speciality = new Speciality();
        speciality.setDescription("radiology");
        specialityService.save(speciality);

        Speciality speciality1 = new Speciality();
        speciality.setDescription("surgery");
        specialityService.save(speciality1);

        Speciality speciality2 = new Speciality();
        speciality2.setDescription("dentenist");
        specialityService.save(speciality2);

        PetType dog = new PetType();
        dog.setName("dog");
        PetType saveDogPetType = petTypeService.save(dog);

        PetType cat = new PetType();
        cat.setName("cat");
        PetType saveCatPetType = petTypeService.save(cat);
        
        System.out.println("Loaded PetType  dog cat........");
        

        Owner owner1 = new Owner();
        owner1.setFirstName("Micheal");
        owner1.setLastName("Weston");
        owner1.setAddress("2323 seaFarer Way");
        owner1.setCity("Melbourne");
        owner1.setTelehpone("044444444");

        Pet micPet = new Pet();
        micPet.setOwner(owner1);
        micPet.setPetType(saveCatPetType);
        micPet.setBirthDate(LocalDate.now());
        micPet.setName("Rusco");
        owner1.getPets().add(micPet);

        ownerService.save(owner1);


        Owner owner2 = new Owner();
        owner2.setFirstName("Fiona");
        owner2.setLastName("Glename");
        owner2.setAddress("2323 seaFarer Way");
        owner2.setCity("Melbourne");
        owner2.setTelehpone("044444444");

        Pet fionaCat = new Pet();
        fionaCat.setName("Babecue");
        fionaCat.setPetType(saveCatPetType);
        fionaCat.setBirthDate(LocalDate.now());
        fionaCat.setOwner(owner2);
        owner2.getPets().add(fionaCat);

        ownerService.save(owner2);

        System.out.println("Loaded Owners......");

        Vet vet1 = new Vet();
        vet1.setFirstName("Sam");
        vet1.setLastName("Axe");
        vet1.getSpecialities().add(speciality);

        vetService.save(vet1);

        Vet vet2 = new Vet();
        vet2.setFirstName("Jessie");
        vet2.setLastName("Porter");
        vet2.getSpecialities().add(speciality2);
        vet2.getSpecialities().add(speciality1);
        vetService.save(vet2);

        System.out.println("Loaded Vets........");
    }
}
