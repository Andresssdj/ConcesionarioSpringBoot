package com.crisprog.demoConcesionario.implementacion;

import com.crisprog.demoConcesionario.entity.Marca;
import com.crisprog.demoConcesionario.entity.Rol;
import com.crisprog.demoConcesionario.repositorio.RepositoryRol;
import com.crisprog.demoConcesionario.servicio.RolServicio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RolImpl implements RolServicio {

    @Autowired
    RepositoryRol repositoryRol;


    @Override
    public List<Rol> encontrarTodos() {
        return this.repositoryRol.findAll();
    }

    @Override
    public Rol encontrarPorId(int id) {
        return this.repositoryRol.encontrarPorId(id);
    }

    @Override
    public void actualizarRol(Rol rol) {
        this.repositoryRol.save(rol);
    }

    @Override
    public void crearRol(Rol rol) {
        this.repositoryRol.save(rol);
    }

    @Override
    public void eliminarRol(int id) {

        System.out.println("######" + id);
        Rol rol = this.repositoryRol.getById(id);
        System.out.println("@@@@@@ " + rol.toString());
        if (rol != null) {
            this.repositoryRol.delete(rol);
        }
    }
}