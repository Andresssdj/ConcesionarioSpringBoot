package com.crisprog.demoConcesionario.repositorio;

import com.crisprog.demoConcesionario.entity.Marca;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface RepositoryMarca  extends JpaRepository<Marca,Integer> {

    @Query(value = "SELECT m FROM Marca m WHERE m.id=id")
    public Marca encontrarPorId (int id);

}
