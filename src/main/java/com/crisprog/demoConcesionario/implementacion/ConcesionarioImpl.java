package com.crisprog.demoConcesionario.implementacion;

import com.crisprog.demoConcesionario.entity.Concesionario;
import com.crisprog.demoConcesionario.repositorio.RepositoryConcesionario;
import com.crisprog.demoConcesionario.servicio.ConcesionarioServicio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ConcesionarioImpl implements ConcesionarioServicio {

    @Autowired
    RepositoryConcesionario repositoryConcesionario;

    @Override
    public List<Concesionario> encontrarTodos() {
        return this.repositoryConcesionario.findAll();
    }

    @Override
    public Concesionario encontrarPorId(int id) {
        return this.repositoryConcesionario.encontrarPorId(id);
    }

    @Override
    public void actualizarConcesionario(Concesionario concesionario) {
    this.repositoryConcesionario.save(concesionario);
    }

    @Override
    public void crearConcesionario(Concesionario concesionario) {
        this.repositoryConcesionario.save(concesionario);
    }

    @Override
    public void eliminarConcesionario(int id) {
        System.out.println("######" + id);
        Concesionario concesionario = this.repositoryConcesionario.getById(id);
        System.out.println("@@@@@@ " + concesionario.toString());
        if (concesionario != null) {
            this.repositoryConcesionario.delete(concesionario);
        }
    }
}
