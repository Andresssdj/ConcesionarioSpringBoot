package com.crisprog.demoConcesionario.dto;



import lombok.Data;
import org.springframework.stereotype.Component;

import java.util.Date;

@Data
public class UsuarioDto {

    private int id_Usuario;


    private String nombre;

    private  String apellido;

    private String correo;

    private  int telefono;

    private Date fechaNacimiento;

}
