package com.crisprog.demoConcesionario.repositorio;

import com.crisprog.demoConcesionario.entity.Rol;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface RepositoryRol  extends JpaRepository<Rol,Integer> {

    @Query(value = "SELECT r FROM Rol r WHERE r.id=id")
    public Rol encontrarPorId (int id);
}
