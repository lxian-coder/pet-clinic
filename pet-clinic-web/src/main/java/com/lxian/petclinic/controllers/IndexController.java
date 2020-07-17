package com.lxian.petclinic.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Program : pet-clinic
 * Author : Darcy Xian
 * Create : 2020-07-17  09:42
 */
@Controller
public class IndexController {

    @RequestMapping({"","/","index.html","index"})
    public String index(){
        return "index";
    }
}
