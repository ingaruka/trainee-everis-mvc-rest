package com.everis.trainee.demo.mvc.controller;

import com.everis.trainee.demo.mvc.model.Persona;
import com.everis.trainee.demo.mvc.repo.IPersonaRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class DemoController {

    @Autowired
    private IPersonaRepo repo;

    @GetMapping("/index")
    public String index(Model model) {

        // logica
        Persona p = new Persona();
        p.setIdPersona(2);
        p.setNombre("Rick");
        repo.save(p);

        model.addAttribute("titulo", "Spring MVC");
        return "index";
    }

    @GetMapping("/listar")
    public String listar(Model model) {
        model.addAttribute("personas", repo.findAll());
        return "index";
    }

}
