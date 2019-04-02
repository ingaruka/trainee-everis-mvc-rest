package com.everis.trainee.demo.mvc.repo;

import com.everis.trainee.demo.mvc.model.Persona;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IPersonaRepo extends JpaRepository<Persona, Integer> {
}
