package com.crisprog.demoConcesionario.implementacion;

import com.crisprog.demoConcesionario.entity.Marca;
import com.crisprog.demoConcesionario.repositorio.RepositoryMarca;

import com.crisprog.demoConcesionario.servicio.MarcaServicio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MarcaImpl implements MarcaServicio {

    @Autowired
    RepositoryMarca repositoryMarca;

    @Override
    public List<Marca> encontrarTodos() {
        return this.repositoryMarca.findAll();
    }

    @Override
    public Marca encontrarPorId(int id) {
        return this.repositoryMarca.encontrarPorId(id);
    }

    @Override
    public void actualizarMarca(Marca marca) {
        this.repositoryMarca.save(marca);
    }

    @Override
    public void crearMarca(Marca marca) {
        this.repositoryMarca.save(marca);
    }

    @Override
    public void eliminarMarca(int id) {
        System.out.println("######" + id);
        Marca marca = this.repositoryMarca.getById(id);
        System.out.println("@@@@@@ " + marca.toString());
        if (marca != null) {
            this.repositoryMarca.delete(marca);
        }
    }
}
