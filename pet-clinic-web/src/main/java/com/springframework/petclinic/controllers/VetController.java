package com.springframework.petclinic.controllers;

import org.springframework.stereotype.Controller;
        import org.springframework.web.bind.annotation.RequestMapping;

@RequestMapping("/vets")
@Controller
public class VetController {

    @RequestMapping({"", "/index", "/index.html"})
    public String listOfVets(){
        return "vets/index";
    }
}
