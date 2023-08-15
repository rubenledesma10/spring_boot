package com.example.inyeccionDependenciasAutowired.repository;

import com.example.inyeccionDependenciasAutowired.model.Posteo;
import java.util.ArrayList;
import java.util.List;
import org.springframework.stereotype.Repository;

@Repository
public class PosteoRepository implements IPosteoRepository {

    @Override
    public List<Posteo> traerTodos() {
        List<Posteo> listaPosteos = new ArrayList<Posteo>();
        listaPosteos.add(new Posteo(1L, "¿Por donde arrancar a programar?", "Ruben Ledesma"));
        listaPosteos.add(new Posteo(2L, "Logica de programacion", "Ruben Ledesma"));
        return listaPosteos;
    }

}
