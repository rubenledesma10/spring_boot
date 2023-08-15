
package com.example.pruebaCRUDSpring.repository;

import com.example.pruebaCRUDSpring.model.Persona;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IPersonaRepository extends JpaRepository <Persona, Long> {
    
}
