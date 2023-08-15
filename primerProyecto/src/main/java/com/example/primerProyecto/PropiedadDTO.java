package com.example.primerProyecto;

import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class PropiedadDTO {
    private Long id_propiedad;
    private String tipo_propiedad;
    private String direccion;
    private Double precio_alquiler;
    private String nombre;
    private String apellido;

    public PropiedadDTO() {
    }

    public PropiedadDTO(Long id_propiedad, String tipo_propiedad, String direccion, Double precio_alquiler, String nombre, String apellido) {
        this.id_propiedad = id_propiedad;
        this.tipo_propiedad = tipo_propiedad;
        this.direccion = direccion;
        this.precio_alquiler = precio_alquiler;
        this.nombre = nombre;
        this.apellido = apellido;
    }
    
}
