package com.example.inyeccionDependenciasAutowired.controller;

import com.example.inyeccionDependenciasAutowired.model.Posteo;
import com.example.inyeccionDependenciasAutowired.repository.IPosteoRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class aplicacionController {

    @Autowired
    //hacemos referencia a la interfaz que vamos a llamar para hacer uso
    IPosteoRepository repo; //con esto ya estamos asociando nuestro controller con la interfaz, y la interfaz al mismo tiempo esta asociada a la clase PosteoRepository

    @GetMapping("/posteos")
    public List<Posteo> traerTodos() {
        return repo.traerTodos(); //este repo va a llamar a IPosteoRepository
    }
}
