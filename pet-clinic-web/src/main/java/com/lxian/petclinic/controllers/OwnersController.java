package com.lxian.petclinic.controllers;

import com.lxian.petclinic.model.Owner;
import com.lxian.petclinic.services.OwnerService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.validation.Valid;
import java.util.List;


/**
 * pet-clinic
 * Author : Darcy Xian    Create : 2020-07-17  11:29
 */
@RequestMapping({"/owners"})
@AllArgsConstructor
@Controller
public class OwnersController {
    private static final String VIEWS_OWNERS_CREATE_OR_UPDATE_FORM = "owners/createOrUpdateOwnerForm";

    private final OwnerService ownerService;

    @InitBinder
    public void setAllowedFields(WebDataBinder dataBinder){
        //prevent the Model from getting the ID
        dataBinder.setDisallowedFields("id");
    }

    @RequestMapping("/find")
    public String findOwners(Model model){
        model.addAttribute("owner",Owner.builder().build());
        return "owners/findOwners";
    }
    @GetMapping()
    public String processFindForm(Owner owner, BindingResult result, Model model){
        // allow parameterless GET request for /owners  return all records
        if (owner.getLastName() == null){
            owner.setLastName(""); // empty string signifies broadest possible search
        }
    //find owners by last name
    List<Owner> results = ownerService.findAllByLastNameLike("%"+owner.getLastName()+"%");

        if(results.isEmpty()){
            //no owners found
            result.rejectValue("lastName","notFound","not found");
            return "owners/findOwners";
        }else if (results.size() == 1){
            // 1 owner found
            owner = results.get(0);
            return "redirect:/owners/" + owner.getId();
        }else {
            // multiple owners found
            model.addAttribute("selections", results);
            return "owners/ownersList";
        }
    }
    @GetMapping("/{ownerId}")
    public ModelAndView showOwner(@PathVariable Long ownerId){
        ModelAndView mav = new ModelAndView("owners/ownerDetails");
        Owner owner = ownerService.findByID(ownerId);
        mav.addObject(owner);
        return mav;
    }

    @GetMapping("/new")
    public String initCreationForm(Model model){
        model.addAttribute("owner",Owner.builder().build());
        return VIEWS_OWNERS_CREATE_OR_UPDATE_FORM;
    }

    @PostMapping("/new")
    public String processCreationForm(@Valid Owner owner, BindingResult result){
        if(result.hasErrors()){
            return VIEWS_OWNERS_CREATE_OR_UPDATE_FORM;
        }else {
            Owner savedOwner = ownerService.save(owner);
            return "redirect:/owners/" +savedOwner.getId();
        }
    }

    @GetMapping("/{ownerId}/edit")
    public String initUpdateOwnerForm(@PathVariable Long ownerId, Model model){
        model.addAttribute(ownerService.findByID(ownerId));
        return VIEWS_OWNERS_CREATE_OR_UPDATE_FORM;
    }

    @PostMapping("/{ownerId}/edit")
    public String processUpdateOwnerForm(@Valid Owner owner, BindingResult result, @PathVariable Long ownerId){
        if(result.hasErrors()){
            return  VIEWS_OWNERS_CREATE_OR_UPDATE_FORM;
        }else {
            // 因为WebDataBind 已经禁止了ID绑定，所以Owner是没有ID的，我们必须给它设置一个；
            owner.setId(ownerId);
            Owner savedOwner = ownerService.save(owner);
            return "redirect:/owners/" + savedOwner.getId();
        }



    }
}
































































