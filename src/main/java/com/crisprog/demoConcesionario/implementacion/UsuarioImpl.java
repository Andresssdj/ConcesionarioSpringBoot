package com.crisprog.demoConcesionario.implementacion;

import com.crisprog.demoConcesionario.entity.Marca;
import com.crisprog.demoConcesionario.entity.Usuario;
import com.crisprog.demoConcesionario.repositorio.RepositoryUsuario;
import com.crisprog.demoConcesionario.servicio.UsuarioServicio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UsuarioImpl implements UsuarioServicio
{

    @Autowired
    RepositoryUsuario repositoryUsuario;

    @Override
    public List<Usuario> encontrarTodos() {

        return this.repositoryUsuario.findAll();
    }

    @Override
    public Usuario encontrarPorId(int id) {
        return this.repositoryUsuario.encontrarPorId(id);
    }

    @Override
    public void actualizarUsuario(Usuario usuario) {
        this.repositoryUsuario.save(usuario);
    }

    @Override
    public void crearUsario(Usuario usuario) {
        this.repositoryUsuario.save(usuario);
    }

    @Override
    public void eliminarUsuario(int id) {
        System.out.println("######" + id);
        Usuario usuario = this.repositoryUsuario.getById(id);
        System.out.println("@@@@@@ " + usuario.toString());
        if (usuario != null) {
            this.repositoryUsuario.delete(usuario);
        }
    }
}
