package com.lxian.petclinic.controllers;

import com.lxian.petclinic.model.Owner;
import com.lxian.petclinic.services.OwnerService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;
import java.util.Map;

/**
 * pet-clinic
 * Author : Darcy Xian    Create : 2020-07-17  11:29
 */
@RequestMapping({"/owners"})
@AllArgsConstructor
@Controller
public class OwnersController {

    private final OwnerService ownerService;

    @InitBinder
    public void setAllowedFields(WebDataBinder dataBinder){
        dataBinder.setDisallowedFields("id");
    }



//    @RequestMapping({"/", "/index", "/index.html", ""})
//    public String listOwners(Model model) {
//        model.addAttribute("owners", ownerService.findAll());
//        return "owners/index";
//    }

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
    List<Owner> results = ownerService.findAllByLastNameLike(owner.getLastName());

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
    public ModelAndView showOwner(@PathVariable("ownerId") Long ownerId){
        ModelAndView mav = new ModelAndView("owners/ownerDetails");
        Owner owner = ownerService.findByID(ownerId);
        mav.addObject(owner);
        return mav;
    }


}
































































