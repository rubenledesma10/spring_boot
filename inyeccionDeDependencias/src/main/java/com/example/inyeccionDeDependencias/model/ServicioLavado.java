package com.example.inyeccionDeDependencias.model;

public class ServicioLavado {
    
    //al declarar estos objetos aca, digo que servicio normal y premium depende de servicio de lavado
    private ServicioNormal serviNorm;
    private ServicioPremium serviPrem;
    
    //generar inyeccion de dependencias mediante un constructor
    public ServicioLavado(ServicioNormal serviNorm, ServicioPremium serviPrem) {
        this.serviNorm = serviNorm;
        this.serviPrem = serviPrem;
    }
    
    //generar inyeccion de dependencias mediante setter

    public void setServiNorm(ServicioNormal serviNorm) {
        this.serviNorm = serviNorm;
    }

    public void setServiPrem(ServicioPremium serviPrem) {
        this.serviPrem = serviPrem;
    }
    
    
    
    
}
