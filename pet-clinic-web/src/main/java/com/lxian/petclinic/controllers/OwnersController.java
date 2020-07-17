package com.lxian.petclinic.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * pet-clinic
 * Author : Darcy Xian    Create : 2020-07-17  11:29
 */
@RequestMapping({"/owners"})
@Controller
public class OwnersController {

    @RequestMapping({"/","/index","/index.html",""})
    public String listOwners(){

        return "owners/index";
    }
}
