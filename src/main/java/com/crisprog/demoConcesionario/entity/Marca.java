package com.crisprog.demoConcesionario.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Data;

import java.util.List;

@Entity
@Data
@Table(name = "marca")
public class Marca {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id_Marca;
    @Column(name = "marca")
    private String marca;

    //Una marca solo un vehiculo
    @JsonIgnore
    @OneToMany(mappedBy = "fk_idMarca") //entre las "" va donde se va a ir reflejada la lista
    private List<Vehiculo> listVehiculos;
}
