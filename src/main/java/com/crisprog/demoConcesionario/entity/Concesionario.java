package com.crisprog.demoConcesionario.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Data;

import java.io.Serializable;
import java.util.List;

@Entity
@Table(name = "concesionario")
@Data
public class Concesionario implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id_Concesionario;

    @Column(name = "nombre")
    private String nombre;
    @Column(name = "direccion")
    private String direccion;
    @Column(name = "telefono")
    private int telefono;
    @Column(name = "ciudad")
    private String ciudad;


    @OneToMany
    @JoinColumn(name = "fk_idConcesionario")
    private  List<Usuario> listUsuario;
    @JsonIgnore
    @OneToMany(mappedBy = "fk_idConcesionario")
    private List<Vehiculo> listVehiculo;

    @JsonIgnore
    @OneToMany(mappedBy = "fk_idConcesionario")
    private List<Venta> listVenta;

}