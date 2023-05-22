package com.crisprog.demoConcesionario.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.util.Date;

@Entity
@Data
@Table(name = "venta")
public class Venta {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id_Venta;
    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "fechaVenta")
    private Date fechaVenta;
    @Column(name = "metodosDePago")
    private String metodosDePago;
    @Column(name = "montoTotal")
    private int montoTotal;


    @ManyToOne
    @JoinColumn(name = "id_Usuario")
    Usuario  fk_idUsuario;


    @ManyToOne
    @JoinColumn(name = "id_Concesionario")
    Concesionario fk_idConcesionario;

    @ManyToOne
    @JoinColumn(name = "id_Vehiculo")
    Vehiculo fk_idVehiculo;
}
