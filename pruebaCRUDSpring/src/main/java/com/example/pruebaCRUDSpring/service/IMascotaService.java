package com.example.pruebaCRUDSpring.service;

import com.example.pruebaCRUDSpring.model.Mascota;
import java.util.List;

public interface IMascotaService {
     //declaramos los metodos
    //traer todas las mascota
    //lectura
    public List<Mascota> getMascota(); //por convencion se suele poner todos los verbos en ingles (las acciones)

    //alta
    public void saveMascota(Mascota masco); //va a recibir como parametro una mascota y lo va a guardar

    //baja
    public void deleteMascota(Long id); //recibe como parametro el id para saber que mascota eliminar

    //lectura de un solo objeto
    public Mascota findMascota(Long id); //recibe como parametro el id para saber que mascota buscar
    
    //edicion, modificacion
    public void editMascota(Long idOriginalMasco, Long idNuevaMasco, String nuevoNombre, String nuevaEspecie, String nuevaRaza, String nuevoColor);
}
