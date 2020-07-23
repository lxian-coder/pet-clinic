package com.lxian.petclinic.bootstrap;

import com.lxian.petclinic.map.OwnerServiceMap;
import com.lxian.petclinic.map.VetServiceMap;
import com.lxian.petclinic.model.Owner;
import com.lxian.petclinic.model.Vet;
import com.lxian.petclinic.services.OwnerService;
import com.lxian.petclinic.services.VetService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

/**
 * pet-clinic
 * Author : Darcy Xian    Create : 2020-07-23  22:07
 */
@Component
public class DataLodar implements CommandLineRunner {
    private final OwnerService ownerService;
    private final VetService vetService;

    public DataLodar() {
        ownerService = new OwnerServiceMap();
        vetService = new VetServiceMap();
    }

    @Override
    public void run(String... args) throws Exception {

        Owner owner1 = new Owner();
        owner1.setId(1L);
        owner1.setFirstName("Micheal");
        owner1.setLastName("Weston");

        ownerService.save(owner1);

        Owner owner2 = new Owner();
        owner1.setId(2L);
        owner1.setFirstName("Fiona");
        owner1.setLastName("Glename");

        ownerService.save(owner2);

        System.out.println("Loaded Owners......");

        Vet vet1 = new Vet();
        vet1.setId(1L);
        vet1.setFirstName("Sam");
        vet1.setLastName("Axe");

        vetService.save(vet1);

        Vet vet2 = new Vet();
        vet2.setId(2L);
        vet2.setFirstName("Jessie");
        vet2.setLastName("Porter");

        vetService.save(vet2);

        System.out.println("Loaded Vets........");

    }
}
