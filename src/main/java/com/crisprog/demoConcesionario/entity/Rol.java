package com.crisprog.demoConcesionario.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.util.List;

@Entity
@Data
@Table(name = "roles")
public class Rol {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "nombre")
    private String nombre;
    @ManyToMany(mappedBy = "listRoles")
    private List<Usuario> listUsuarios;
}