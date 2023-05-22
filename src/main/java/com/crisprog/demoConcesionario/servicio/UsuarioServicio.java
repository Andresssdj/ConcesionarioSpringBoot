package com.crisprog.demoConcesionario.servicio;

import com.crisprog.demoConcesionario.entity.Usuario;

import java.util.List;

public interface UsuarioServicio {
    public List<Usuario> encontrarTodos();
    public Usuario encontrarPorId(int id);
    public  void actualizarUsuario(Usuario usuario);

    public void crearUsario(Usuario usuario);

    public void eliminarUsuario(int id);

}

