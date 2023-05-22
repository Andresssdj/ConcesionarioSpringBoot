package com.crisprog.demoConcesionario.servicio;


import com.crisprog.demoConcesionario.entity.Marca;
import com.crisprog.demoConcesionario.entity.Usuario;

import java.util.List;

public interface MarcaServicio {

    public List<Marca> encontrarTodos();
    public Marca encontrarPorId(int id);
    public  void actualizarMarca(Marca marca);

    public void crearMarca(Marca marca);

    public void eliminarMarca(int id);
}
