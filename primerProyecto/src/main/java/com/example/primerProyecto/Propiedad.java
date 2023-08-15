package com.example.primerProyecto;

import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class Propiedad {
    
    private Long id_propiedad;
    private String tipo_propiedad;
    private String direccion;
    private Double metros_cuadrado;
    private Double precio_alquiler;

    public Propiedad() {
    }

    public Propiedad(Long id_propiedad, String tipo_propiedad, String direccion, Double metros_cuadrado, Double precio_alquiler) {
        this.id_propiedad = id_propiedad;
        this.tipo_propiedad = tipo_propiedad;
        this.direccion = direccion;
        this.metros_cuadrado = metros_cuadrado;
        this.precio_alquiler = precio_alquiler;
    }
    
}
