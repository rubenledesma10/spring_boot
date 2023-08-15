package com.example.primerProyecto.controller;

import com.example.primerProyecto.Cliente;
import com.example.primerProyecto.Inquilino;
import com.example.primerProyecto.Propiedad;
import com.example.primerProyecto.PropiedadDTO;
import java.util.ArrayList;
import java.util.List;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
//con esta annotation spring booy ya sabe que esta va a ser la controladora y que va a ser una api, todos los endpoints van a estar aca

@RestController
public class HelloController {

    //REQUEST
    /*
    @GetMapping("/hello/{nombre}") //va a recibir una solicitud a traves del metodo get, de esta forma le decimos de que forma recibir las peticiones
    public String sayHello(@PathVariable String nombre){ //pathvariable es para pasar parametros
        return "Hola " +nombre;
    }
    
    @GetMapping("/bye/{nombre}/{edad}/{profesion}") //entre {} los parametros que vamos a recibir
    public String sayBye(@PathVariable String nombre, @PathVariable int edad, @PathVariable String profesion){ 
        return "Chau. Tu nombre es " +nombre+ ". Tienes " +edad+ " años. Y tu profesion es " +profesion;
    }

    @GetMapping("/hello")
    public String sayHello(@RequestParam String nombre){ //pathvariable es para pasar parametros
        return "Hola " +nombre;
    }
    
    @GetMapping("/bye") 
    public String sayBye(@RequestParam String nombre, @RequestParam int edad, @RequestParam String profesion){ 
        return "Chau. Tu nombre es " +nombre+ ". Tienes " +edad+ " años. Y tu profesion es " +profesion;
    }
    
    
    @PostMapping("/cliente") //el usuario accede aca para que pueda acceder a la creacion de un nuevo cliente
    public void crearCliente(@RequestBody Cliente cli){ 
        //Requestbody le digo que los datos del cliente los estoy recibiendo de la solicitud postmapping. Rcibo un cliente y lo creo (para recibir id, nya)
        /*cuando la persona haga una solicitud mediante el metodo post a la url (/cliente) me va a poder mandar determinados datos
        en el cuerpo del paquete para que yo pueda recibir un cliente y lo pueda mostrar
        
        System.out.println("Cliente creado");
        System.out.println("Nombre: " +cli.getNombre());
        System.out.println("Apellido: " +cli.getApellido());
    }
     
    //RESPONSE
    //devolver datos al cliente
    @GetMapping("/cliente/traer")
    @ResponseBody //con esta annotation le decimos que lo que nos devuelva no los devuelva dentro del cuerpo    
    public List<Cliente> traerClientes() {
        List<Cliente> listaClientes = new ArrayList<Cliente>();
        listaClientes.add(new Cliente(1L, "Ruben", "Ledesma"));
        listaClientes.add(new Cliente(2L, "Lucas", "Ledesma"));
        listaClientes.add(new Cliente(3L, "Pablo", "Ledesma"));

        return listaClientes;
    }

    @GetMapping("/pruebaresponse")
    ResponseEntity<String> traerRespuesta() { //response entity nos permite es manipular como nosotros queramos cada uno de las partes del paquete que respondemos en una comunicacion HTTP en uan response (tocar status code, cabecera, etc.)
        return new ResponseEntity<>("Esta es una prueba de response entity", HttpStatus.NOT_FOUND);
    }
     */
    @GetMapping("/propiedad/{id}")
    @ResponseBody //la respuesta la vamos a mandar por el cuerpo del mensaje
    public PropiedadDTO devolverProp(@PathVariable Long id) {
        //a traves del id buscamos la propiedad en cuestion
        //trajimos al inquilino asociado a esa propiedad

        Propiedad prod = new Propiedad(1456456L, "Casa", "308 Negro Arroyo", 200.0, 40.000);
        Inquilino inqui = new Inquilino(1L, "123456789", "Walter", "White", "Profesor quimica");

        PropiedadDTO prodDTO = new PropiedadDTO();
        //asignamos los datos que necesitamos de propiedad
        prodDTO.setId_propiedad(prod.getId_propiedad());
        prodDTO.setPrecio_alquiler(prod.getPrecio_alquiler());
        prodDTO.setTipo_propiedad(prod.getTipo_propiedad());
        prodDTO.setDireccion(prod.getDireccion());
        //asignamos los datos que necesitamos de inquilino
        prodDTO.setNombre(inqui.getNombre());
        prodDTO.setApellido(inqui.getApellido());
        
        //retornamos el dto
        return prodDTO;

    }

}
