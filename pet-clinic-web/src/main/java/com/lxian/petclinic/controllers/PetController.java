package com.lxian.petclinic.controllers;

import com.lxian.petclinic.model.Owner;
import com.lxian.petclinic.model.Pet;
import com.lxian.petclinic.model.PetType;
import com.lxian.petclinic.services.OwnerService;
import com.lxian.petclinic.services.PetService;
import com.lxian.petclinic.services.PetTypeService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.util.StringUtils;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;

import javax.naming.Binding;
import javax.validation.Valid;
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
    public Owner findOwner(@PathVariable Long ownerId){
        return ownerService.findByID(ownerId);
    }

    @InitBinder("owner")
    public void initOwnerBinder(WebDataBinder dataBinder){
        dataBinder.setDisallowedFields("id");
    }

    @GetMapping("/pets/new")
    public String initCreationForm(Owner owner,Model model){
        Pet pet = new Pet();
        //???
        owner.getPets().add(pet);
        model.addAttribute("pet",pet);
        return VIEWS_PETS_CREAT_OR_UPDATE_FROM;
    }
    @PostMapping("/pets/new")
    public String processCreationForm(Owner owner, @Valid Pet pet, BindingResult result, Model model){
        if(StringUtils.hasLength(pet.getName()) && pet.isNew() && owner.getPet(pet.getName(), true)!=null){
           result.rejectValue("name","duplicate","already exists");
        }
        owner.getPets().add(pet);
       if (result.hasErrors()){
           model.addAttribute("pet",pet);
           return VIEWS_PETS_CREAT_OR_UPDATE_FROM;
       }else {
           petService.save(pet);

           return "redirect:/owners/"+owner.getId();
       }
    }
    @GetMapping("/pets/{petId}/edit")
    public String initUpdateForm(@PathVariable Long petId, Model model){
        model.addAttribute("pet",petService.findByID(petId));
        return VIEWS_PETS_CREAT_OR_UPDATE_FROM;
    }
    @PostMapping("/pets/{petId}/edit")
    public String processUpdateForm(@Valid Pet pet, BindingResult result,Owner owner,Model model){
        if(result.hasErrors()){
            //?????
            pet.setOwner(owner);
            model.addAttribute("pet",pet);
            return VIEWS_PETS_CREAT_OR_UPDATE_FROM;
        }else {
            owner.getPets().add(pet);
            petService.save(pet);
            return "redirect:/owners/" + owner.getId();
        }
    }




}




































