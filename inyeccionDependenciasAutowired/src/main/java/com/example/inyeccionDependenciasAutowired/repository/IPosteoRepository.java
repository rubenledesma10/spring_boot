package com.example.inyeccionDependenciasAutowired.repository;

import com.example.inyeccionDependenciasAutowired.model.Posteo;
import java.util.List;

public interface IPosteoRepository {
    
    public List<Posteo> traerTodos();
    
}
