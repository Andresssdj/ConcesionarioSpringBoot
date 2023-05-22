package com.crisprog.demoConcesionario.negocio;

import com.crisprog.demoConcesionario.dto.RolDto;
import com.crisprog.demoConcesionario.entity.Marca;
import com.crisprog.demoConcesionario.entity.Rol;
import com.crisprog.demoConcesionario.implementacion.RolImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class RolNegocio {

    @Autowired
    private RolImpl rolImpl;

    public List<RolDto> listDtoRoles;

    public List<RolDto> encontrarTodos() {
        listDtoRoles = new ArrayList<>();

        this.rolImpl.encontrarTodos().forEach(rol -> {

            RolDto rolDto = new RolDto();
            rolDto.setId(rol.getId());
            rolDto.setNombre(rol.getNombre());
            this.listDtoRoles.add(rolDto);
        });
        return this.listDtoRoles;
    }

    public String guardarRol(RolDto rolDto) {
        Rol rol = new Rol();
        try {
            if (rolDto.getId() != 0) {
                rol.setId(rolDto.getId());
                rol.setNombre(rolDto.getNombre());
                this.rolImpl.actualizarRol(rol);
            } else {
                rol.setNombre(rolDto.getNombre());
                this.rolImpl.crearRol(rol);
            }
            return "Se guardaron los datos correctamente";
        } catch (Exception e) {
            return "Fallo algo";
        }
    }
        public String eliminarRol ( int id){
            Rol rol;
            try {
                this.rolImpl.eliminarRol(id);
                return "Eliminacion exitosa";
            } catch (Exception e) {
                e.printStackTrace();
                return "Eliminacion Fallida";
            }
    }
}

