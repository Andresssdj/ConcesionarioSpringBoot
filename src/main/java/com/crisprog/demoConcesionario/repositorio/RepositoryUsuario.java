package com.crisprog.demoConcesionario.repositorio;

import com.crisprog.demoConcesionario.entity.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface RepositoryUsuario extends JpaRepository<Usuario,Integer> {

    @Query(value = "SELECT u FROM Usuario u WHERE u.id=id")
    public Usuario encontrarPorId (int id);
}
