package com.crisprog.demoConcesionario.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Data;

import java.io.Serializable;
import java.util.List;

@Entity
@Table(name = "vehiculo")
@Data
public class Vehiculo implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id_Vehiculo;

    @Column(name= "modelo")
    private int modelo;
    @Column(name = "centimetrosCubicos")
    private int centimetrosCubicos;
    @Column(name = "placa")
    private  String placa;
    @Column(name = "precio")
    private int precio;
    @Column(name = "color")
    private  String color;



    //En muchos vehiculos hay una sola marca
    //una columna va a entrar a una coleccion de datos
    @ManyToOne
    @JoinColumn(name = "id_Marca") // nombre de columna
            Marca fk_idMarca; // mostrara la lista

    @ManyToOne
    @JoinColumn(name = "id_Concesionario")
    Concesionario fk_idConcesionario;

    @JsonIgnore
    //En un venta hay muchos vehiculos
    @OneToMany(mappedBy = "fk_idVehiculo")
    private List<Venta> listVenta;
}
