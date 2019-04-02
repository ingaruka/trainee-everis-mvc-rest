package com.everis.trainee.demo.mvc.rest;

import com.everis.trainee.demo.mvc.model.Persona;
import com.everis.trainee.demo.mvc.repo.IPersonaRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class RestDemoController {

    @Autowired
    private IPersonaRepo repo;

    @GetMapping("/personas")
    public List<Persona> listar() {
        return repo.findAll();
    }

    @GetMapping("/personas/{id}")
    public Persona buscarPersona(@PathVariable("id") Integer id) {
        return repo.findById(id).get();
    }

    @PostMapping("/personas")
    @ResponseStatus(HttpStatus.CREATED)
    public Persona registrar(@RequestBody Persona obj) {
        return repo.save(obj);
    }

    @PutMapping("/personas")
    public Persona editar(@RequestBody Persona obj) {
        return repo.save(obj);
    }

    @DeleteMapping("/personas/{id}")
    public void eliminar(@PathVariable("id") Integer id) {
        Persona persona = repo.findById(id).get();
        repo.delete(persona);
    }

}
