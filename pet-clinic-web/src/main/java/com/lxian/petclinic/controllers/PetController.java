package com.lxian.petclinic.controllers;

import com.lxian.petclinic.model.Owner;
import com.lxian.petclinic.model.PetType;
import com.lxian.petclinic.services.OwnerService;
import com.lxian.petclinic.services.PetService;
import com.lxian.petclinic.services.PetTypeService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Collection;

/**
 * Darcy Xian  9/9/20  11:47 am      pet-clinic
 */
@RequestMapping("/owners/{ownerId}")
@AllArgsConstructor
@Controller
public class PetController {

    private static final String VIEWS_PETS_CREAT_OR_UPDATE_FROM = "pets/createOrUpdatePetForm";

    private final PetTypeService petTypeService;
    private final OwnerService ownerService;
    private final PetService petService;

    @ModelAttribute("types")
    public Collection<PetType> populatePetypes(){
        return (Collection<PetType>) petTypeService.findAll();
    }

    @ModelAttribute("owner")
    public Owner findOwner(@PathVariable("ownerId") Long ownerId){
        return ownerService.findByID(ownerId);
    }

    @InitBinder("owner")
    public void initOwnerBinder(WebDataBinder dataBinder){
        dataBinder.setDisallowedFields("id");
    }


}
