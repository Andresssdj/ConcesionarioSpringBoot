package com.crisprog.demoConcesionario.negocio;

import com.crisprog.demoConcesionario.dto.MarcaDto;
import com.crisprog.demoConcesionario.entity.Marca;
import com.crisprog.demoConcesionario.implementacion.MarcaImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class MarcaNegocio {

    @Autowired
    private MarcaImpl marcaImpl;

    public List<MarcaDto> listDtoMarcas;

    public List<MarcaDto> encontrarTodos() {
        listDtoMarcas = new ArrayList<>();

        this.marcaImpl.encontrarTodos().forEach(marca -> {
            MarcaDto marcaDto = new MarcaDto();
            marcaDto.setId_Marca(marca.getId_Marca());
            marcaDto.setMarca(marca.getMarca());
            this.listDtoMarcas.add(marcaDto);
        });
        return this.listDtoMarcas;
    }

    public String guardarMarca(MarcaDto marcaDto) {
        Marca marca = new Marca();
        try {
            if (marcaDto.getId_Marca() != 0) {
                marca.setId_Marca(marcaDto.getId_Marca());
                marca.setMarca(marcaDto.getMarca());
                this.marcaImpl.actualizarMarca(marca);
            } else {
                marca.setMarca(marcaDto.getMarca());
                this.marcaImpl.crearMarca(marca);
            }
            return "Se guardaron los datos correctamente";
        } catch (Exception e) {
            return "Fallo algo";
        }
    }

    public String eliminarMarca(int id) {
        Marca marca;
        try {
            this.marcaImpl.eliminarMarca(id);
            return "Eliminacion exitosa";
        } catch (Exception e) {
            e.printStackTrace();
            return "Eliminacion Fallida";
        }

    }
}