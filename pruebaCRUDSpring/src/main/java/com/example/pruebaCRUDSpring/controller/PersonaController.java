package com.example.pruebaCRUDSpring.controller;

import com.example.pruebaCRUDSpring.model.Persona;
import com.example.pruebaCRUDSpring.service.IPersonaService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PersonaController {

    //inyectamos dependencia
    @Autowired
    private IPersonaService persoSer;

    //EndPoint para traer a todas las personas
    @GetMapping("/personas/traer")
    public List<Persona> getPersonas() {
        return persoSer.getPersonas();
    }

    //EndPoint para crear una persona
    @PostMapping("/personas/crear")
    public String savePersona(@RequestBody Persona perso) {
        persoSer.savePersona(perso);
        return "Persona creada";
    }

    //EndPoint para eliminar una persona
    @DeleteMapping("/personas/borrar/{id}") //ponemos como parametro el id de la persona que queremos borrar
    public String deletePersona(@PathVariable Long id) {
        persoSer.deletePersona(id);
        return "Persona eliminada";
    }

    //EndPoint para editar una persona (si el ID se puede cambiar)
    @PutMapping("/personas/editar/{idOriginal}")
    public Persona editPersona(@PathVariable Long idOriginal,
            @RequestParam(required = false, name = "id") Long nuevaId,
            @RequestParam(required = false, name = "nombre") String nuevoNombre,
            @RequestParam(required = false, name = "apellido") String nuevoApellido,
            @RequestParam(required = false, name = "edad") int nuevaEdad){
    
        persoSer.editPersona(idOriginal, nuevaId, nuevoNombre, nuevoApellido, nuevaEdad);
        
        /*
        una vez que termino de editar, llamo a objeto persona y le decimos que va a ser igual findPersona
        le pasamos la nueva id y la buscamos
        */
        Persona perso = persoSer.findPersona(nuevaId);
        
        //devolvemos la persona modificada
        return perso;
    }
    
    //EndPoint para editar una persona (si el ID no se puede cambiar)
    @PutMapping("/personas/editar")
    public Persona editPersona(@RequestBody Persona per){
        //en este metodo vamos a mandar el objeto completo
        persoSer.editPersona(per); //a partir de eso va a tener el id y todo para buscar, lo hace automaticamente jpa a traves de este metodo que va a recibir otro a traves de request body
        //realizo las modificaciones 
        return persoSer.findPersona(per.getId()); //aca nos devuelve el objeto completo
    }
}
