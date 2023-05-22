package com.crisprog.demoConcesionario.repositorio;

import com.crisprog.demoConcesionario.entity.Venta;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface RepositoryVenta extends JpaRepository<Venta,Integer> {

    @Query(value = "SELECT v FROM Venta v WHERE v.id=id")
    public Venta encontrarPorId (int id);
}
