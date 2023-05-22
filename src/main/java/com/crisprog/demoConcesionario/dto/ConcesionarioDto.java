package com.crisprog.demoConcesionario.dto;


import lombok.Data;

@Data
public class ConcesionarioDto {

    private int id_Concesionario;
    private String nombre;

    private String direccion;
    private int telefono;

    private String ciudad;
}
