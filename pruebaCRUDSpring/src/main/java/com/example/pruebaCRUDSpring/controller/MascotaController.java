package com.example.pruebaCRUDSpring.controller;

import com.example.pruebaCRUDSpring.model.Mascota;
import com.example.pruebaCRUDSpring.service.IMascotaService;
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
public class MascotaController {
    
    @Autowired  
    private IMascotaService mascoServ;
    
    @GetMapping("/mascotas/traer")
    public List<Mascota> getMascota() {
        return mascoServ.getMascota();
    }

    @PostMapping("/mascotas/crear")
    public String saveMascota(@RequestBody Mascota masco) {
        mascoServ.saveMascota(masco);
        return "Mascota creada";
    }

    @DeleteMapping("/mascotas/borrar/{id}") 
    public String deleteMascota(@PathVariable Long id) {
        mascoServ.deleteMascota(id);
        return "Mascota eliminada";
    }

    @PutMapping("/mascotas/editar/{idOriginalMasco}")
    public Mascota editMascota(@PathVariable Long idOriginalMasco,
            @RequestParam(required = false, name = "id") Long idNuevaMasco,
            @RequestParam(required = false, name = "nombre") String nuevoNombre,
            @RequestParam(required = false, name = "especie") String nuevaEspecie,
            @RequestParam(required = false, name = "raza") String nuevaRaza,
            @RequestParam(required = false, name="color") String nuevoColor){
    
        mascoServ.editMascota(idOriginalMasco, idNuevaMasco, nuevoNombre, nuevaEspecie, nuevaRaza, nuevoColor);
        
        Mascota masco = mascoServ.findMascota(idNuevaMasco);
        
        return masco;
    }
    
}
