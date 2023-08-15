package com.example.pruebaCRUDSpring.service;

import com.example.pruebaCRUDSpring.model.Mascota;
import com.example.pruebaCRUDSpring.repository.IMascotaRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MascotaService implements IMascotaService {

    @Autowired
    private IMascotaRepository mascoRepo;

    @Override
    public List<Mascota> getMascota() {
        List<Mascota> listaMascotas = mascoRepo.findAll(); //persoRepo porqque es mi inyeccion al repositorio, finall es un metodo exclusivo que me va a traer todas las personas
        return listaMascotas;
    }

    @Override
    public void saveMascota(Mascota masco) {
        mascoRepo.save(masco); //save metodo exclusivo para guardar/dar de alta, y entre parentesis la perso que recibimos
    }

    @Override
    public void deleteMascota(Long id) {
        mascoRepo.deleteById(id); //deleteById es una de las formas para eliminar, pero hay otras, y entre parentesis el id que recibimos
    }

    @Override
    public Mascota findMascota(Long id) {
        Mascota masco = mascoRepo.findById(id).orElse(null); //finbyid es para traer un id, y orElse es por si no encuentra esta persona nos devuleva un null
        return masco; //devolvemos la persona que buscamos
    }

    @Override
    public void editMascota(Long idOriginalMasco, Long idNuevaMasco, String nuevoNombre, String nuevaEspecie, String nuevaRaza, String nuevoColor) {
 
        Mascota masco = this.findMascota(idOriginalMasco);
        
        masco.setId(idNuevaMasco);
        masco.setNombre(nuevoNombre);
        masco.setEspecie(nuevaEspecie);
        masco.setRaza(nuevaRaza);
        masco.setColor(nuevoColor);
        this.saveMascota(masco);
    }

}
