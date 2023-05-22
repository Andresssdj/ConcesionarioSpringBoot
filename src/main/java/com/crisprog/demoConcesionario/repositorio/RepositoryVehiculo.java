package com.crisprog.demoConcesionario.repositorio;

import com.crisprog.demoConcesionario.entity.Vehiculo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface RepositoryVehiculo extends JpaRepository<Vehiculo, Integer> {

    @Query(value = "SELECT v FROM Vehiculo v WHERE v.id=id")
    public Vehiculo encontrarPorId (int id);
}
