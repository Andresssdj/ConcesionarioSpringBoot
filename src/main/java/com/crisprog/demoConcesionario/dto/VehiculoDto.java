package com.crisprog.demoConcesionario.dto;


import lombok.Data;

@Data
public class VehiculoDto {

    private int id_Vehiculo;
    private int modelo;
    private int centimetrosCubicos;
    private  String placa;
    private int precio;
    private  String color;
}
