package com.lxian.petclinic.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * pet-clinic
 * Author : Darcy Xian    Create : 2020-07-17  11:18
 */
@Controller
public class VetController {

    @RequestMapping({"/vets","/vets/index","/vets/index.html"})
    public String listVets(){

        return "vets/index";
    }

}
