package com.crisprog.demoConcesionario;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class DemoConcesionarioApplication {

	public static void main(String[] args) {
		SpringApplication.run(DemoConcesionarioApplication.class, args);
	}

}



//Para que funcione mirar que esten todas las librerias importadas
//tener postman http://localhost:8088/usuario/all
//tener base de datos, solo crearla y que springboot la cree sola con la propiedad update