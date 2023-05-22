package com.crisprog.demoConcesionario.repositorio;

import com.crisprog.demoConcesionario.entity.Concesionario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface RepositoryConcesionario  extends JpaRepository<Concesionario,Integer> {

    @Query(value = "SELECT c FROM Concesionario c WHERE c.id=id")
    public Concesionario encontrarPorId (int id);
}
