package com.crisprog.demoConcesionario.implementacion;


import com.crisprog.demoConcesionario.entity.Marca;
import com.crisprog.demoConcesionario.entity.Venta;
import com.crisprog.demoConcesionario.repositorio.RepositoryVenta;
import com.crisprog.demoConcesionario.servicio.VentaServicio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class VentaImpl implements VentaServicio {
    @Autowired
    RepositoryVenta repositoryVenta;


    @Override
    public List<Venta> encontrarTodos() {
        return this.repositoryVenta.findAll();
    }

    @Override
    public Venta encontrarPorId(int id) {
        return this.repositoryVenta.encontrarPorId(id);
    }

    @Override
    public void actualizarVenta(Venta venta) {
    this.repositoryVenta.save(venta);
    }

    @Override
    public void crearVenta(Venta venta) {
        this.repositoryVenta.save(venta);
    }

    @Override
    public void eliminarVenta(int id) {
        System.out.println("######" + id);
        Venta venta = this.repositoryVenta.getById(id);
        System.out.println("@@@@@@ " + venta.toString());
        if (venta != null) {
            this.repositoryVenta.delete(venta);
        }
    }
}
