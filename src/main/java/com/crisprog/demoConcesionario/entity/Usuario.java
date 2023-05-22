package com.crisprog.demoConcesionario.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

@Entity
@Data
@Table(name = "usuario")
public class Usuario implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id_Usuario;

    @Column(name = "nombre")
    private String nombre;
    @Column(name = "apellido")
    private  String apellido;
    @Column(name = "correo")
    private String correo;
    @Column(name = "telefono")
    private  int telefono;
    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "fechaNacimiento")
    private Date fechaNacimiento;

    @ManyToOne
    @JoinColumn(name = "id_Concesionario")
    Concesionario fk_idConcesionario;

    @ManyToMany
    @JoinTable(name = "Usuarios_has_Roles",
            joinColumns = @JoinColumn(name = "fk_idRol", nullable = false),
            inverseJoinColumns=@JoinColumn(name = "fk_idUsuario",nullable = false)
    )
    private List<Rol> listRoles;


    @JsonIgnore
    @OneToMany(mappedBy = "fk_idUsuario")
    private List<Venta> listVenta;


}
