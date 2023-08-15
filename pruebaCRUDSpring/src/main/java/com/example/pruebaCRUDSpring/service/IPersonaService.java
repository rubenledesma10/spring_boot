package com.example.pruebaCRUDSpring.service;

import com.example.pruebaCRUDSpring.model.Persona;
import java.util.List;

public interface IPersonaService {
    
    //declaramos los metodos
    //traer todas las personas
    //lectura
    public List<Persona> getPersonas(); //por convencion se suele poner todos los verbos en ingles (las acciones)

    //alta
    public void savePersona(Persona perso); //va a recibir como parametro una persona y lo va a guardar

    //baja
    public void deletePersona(Long id); //recibe como parametro el id para saber que persona eliminar

    //lectura de un solo objeto
    public Persona findPersona(Long id); //recibe como parametro el id para saber que persona buscar
    
    //edicion, modificacion
    public void editPersona(Long idOriginal, Long idNueva, String nuevoNombre, String nuevoApellido, int nuevaEdad);

    public void editPersona(Persona per);
    
}
