package com.example.pruebaCRUDSpring.service;

import com.example.pruebaCRUDSpring.model.Persona;
import com.example.pruebaCRUDSpring.repository.IPersonaRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PersonaService implements IPersonaService {
    
    @Autowired
    private IPersonaRepository persoRepo;

    @Override
    public List<Persona> getPersonas() {
        //tenemos que obtener una lista de nuestra BD con todas las personas y luego devolversela al controlador que nos va a hacer la consullta
        List<Persona> listaPersonas = persoRepo.findAll(); //persoRepo porqque es mi inyeccion al repositorio, finall es un metodo exclusivo que me va a traer todas las personas
        return listaPersonas;
    }

    @Override
    public void savePersona(Persona perso) {
        persoRepo.save(perso); //save metodo exclusivo para guardar/dar de alta, y entre parentesis la perso que recibimos
    }

    @Override
    public void deletePersona(Long id) {
        persoRepo.deleteById(id); //deleteById es una de las formas para eliminar, pero hay otras, y entre parentesis el id que recibimos
    }

    @Override
    public Persona findPersona(Long id) {
        //creamos un objeto persona porque tenemos que devolver algo
        Persona perso = persoRepo.findById(id).orElse(null); //finbyid es para traer un id, y orElse es por si no encuentra esta persona nos devuleva un null
        return perso; //devolvemos la persona que buscamos
    }

    @Override
    public void editPersona(Long idOriginal, Long idNueva, String nuevoNombre, String nuevoApellido, int nuevaEdad) {
        //busco el objeto original
        //uso this porque llamo al mismo metodo findPersona de esta clase
        Persona perso = this.findPersona(idOriginal); //perso va a venir con los valores originales guardados en la bd
        
        //proceso de modificacion a nivel logico
        //seteamos los posibles nuevos valores
        perso.setId(idNueva);
        perso.setNombre(nuevoNombre);
        perso.setApellido(nuevoApellido);
        perso.setEdad(nuevaEdad);
        
        //guardamos los cambios
        //uso this porque llamo al mismo metodo savePersona de esta clase
        this.savePersona(perso);
        
    }

    @Override
    public void editPersona(Persona per) {
        this.savePersona(per);
    }
    
}
