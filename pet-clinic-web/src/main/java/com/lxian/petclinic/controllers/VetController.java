package com.lxian.petclinic.controllers;

import com.lxian.petclinic.services.VetService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * pet-clinic
 * Author : Darcy Xian    Create : 2020-07-17  11:18
 */
@Controller
public class VetController {

    private VetService vetService;

    public VetController(VetService vetService) {
        this.vetService = vetService;
    }

    @RequestMapping({"/vets","/vets/index","/vets/index.html"})
    public String listVets(Model model){
        model.addAttribute("vets",vetService.findAll());

        return "vets/index";
    }

}
