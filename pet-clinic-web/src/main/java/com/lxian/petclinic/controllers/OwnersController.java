package com.lxian.petclinic.controllers;

import com.lxian.petclinic.model.Owner;
import com.lxian.petclinic.services.OwnerService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

/**
 * pet-clinic
 * Author : Darcy Xian    Create : 2020-07-17  11:29
 */
@RequestMapping({"/owners"})
@Controller
public class OwnersController {

    private final OwnerService ownerService;

    public OwnersController(OwnerService ownerService) {
        this.ownerService = ownerService;
    }

    @RequestMapping({"/", "/index", "/index.html", ""})
    public String listOwners(Model model) {
        model.addAttribute("owners", ownerService.findAll());
        return "owners/index";
    }

    @RequestMapping("/find")
    public String findOwners(){
        return "notImplement";
    }

    @GetMapping("/{ownerId}")
    public ModelAndView showOwner(@PathVariable("ownerId") Long ownerId){
        ModelAndView mav = new ModelAndView("owners/ownerDetails");
        Owner owner = ownerService.findByID(ownerId);
        mav.addObject(owner);
        return mav;

    }

}
