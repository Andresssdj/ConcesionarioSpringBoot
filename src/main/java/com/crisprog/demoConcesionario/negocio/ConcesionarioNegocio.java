package com.crisprog.demoConcesionario.negocio;

import com.crisprog.demoConcesionario.dto.ConcesionarioDto;
import com.crisprog.demoConcesionario.entity.Concesionario;
import com.crisprog.demoConcesionario.entity.Marca;
import com.crisprog.demoConcesionario.implementacion.ConcesionarioImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class ConcesionarioNegocio {

    @Autowired
    private ConcesionarioImpl concesionarioImpl;

    public List<ConcesionarioDto> listConcesionarios;

    public List<ConcesionarioDto> encontrarTodos(){
        listConcesionarios= new ArrayList<>();
        this.concesionarioImpl.encontrarTodos().forEach(concesionario -> {

            ConcesionarioDto concesionarioDto=new ConcesionarioDto();
            concesionarioDto.setId_Concesionario(concesionario.getId_Concesionario());
            concesionarioDto.setNombre(concesionario.getNombre());
            concesionarioDto.setTelefono(concesionario.getTelefono());
            concesionarioDto.setCiudad(concesionario.getCiudad());
            concesionarioDto.setDireccion(concesionario.getDireccion());
            this.listConcesionarios.add(concesionarioDto);
        });
        return this.listConcesionarios;
    }
    public String guardarConcesionario(ConcesionarioDto concesionarioDto){
        Concesionario concesionario=new Concesionario();
        try {
            if (concesionarioDto.getId_Concesionario()!=0){
                concesionario.setId_Concesionario(concesionarioDto.getId_Concesionario());
                concesionario.setNombre(concesionarioDto.getNombre());
                concesionario.setTelefono(concesionarioDto.getTelefono());
                concesionario.setCiudad(concesionarioDto.getCiudad());
                concesionario.setDireccion(concesionarioDto.getDireccion());
                this.concesionarioImpl.actualizarConcesionario(concesionario);
            }else {
                concesionario.setNombre(concesionarioDto.getNombre());
                concesionario.setTelefono(concesionarioDto.getTelefono());
                concesionario.setCiudad(concesionarioDto.getCiudad());
                concesionario.setDireccion(concesionarioDto.getDireccion());
                this.concesionarioImpl.crearConcesionario(concesionario);
            }
            return "Se guardaron los datos correctamente";
        }catch (Exception e){
            return "Fallo algo";
        }
    }

    public String eliminarConcesionario(int id) {
        Marca marca;
        try {
            this.concesionarioImpl.eliminarConcesionario(id);
            return "Eliminacion exitosa";
        } catch (Exception e) {
            e.printStackTrace();
            return "Eliminacion Fallida";
        }

    }
}
