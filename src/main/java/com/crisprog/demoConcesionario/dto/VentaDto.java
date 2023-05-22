package com.crisprog.demoConcesionario.dto;


import lombok.Data;

import java.util.Date;
@Data
public class VentaDto {

    private int id_Venta;
    private Date fechaVenta;
    private String metodosDePago;
    private int montoTotal;
}
