package com.crisprog.demoConcesionario.negocio;

import com.crisprog.demoConcesionario.dto.UsuarioDto;
import com.crisprog.demoConcesionario.entity.Marca;
import com.crisprog.demoConcesionario.entity.Usuario;
import com.crisprog.demoConcesionario.implementacion.UsuarioImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;


@Component
public class UsuarioNegocio {

    @Autowired
    private UsuarioImpl usuarioImpl;

    public List<UsuarioDto> listDtoUsuarios;

    public List<UsuarioDto> encontrarTodos(){
        listDtoUsuarios=new ArrayList<>();
        this.usuarioImpl.encontrarTodos().forEach(usuario -> { //recorrame cada usuario y creeme:

            UsuarioDto usuarioDto=new UsuarioDto();
            usuarioDto.setId_Usuario(usuario.getId_Usuario());
            usuarioDto.setNombre(usuario.getNombre());
            usuarioDto.setApellido(usuario.getApellido());
            usuarioDto.setCorreo(usuario.getCorreo());
            usuarioDto.setTelefono(usuario.getTelefono());
            usuarioDto.setFechaNacimiento(usuario.getFechaNacimiento());
            this.listDtoUsuarios.add(usuarioDto);
        });
        return this.listDtoUsuarios;
    }
    public String guardarUsuario(UsuarioDto usuarioDto){
        Usuario usuario =new Usuario();
        try {
           if (usuarioDto.getId_Usuario()!=0){
             usuario.setId_Usuario(usuarioDto.getId_Usuario());
             usuario.setNombre(usuarioDto.getNombre());
             usuario.setApellido(usuarioDto.getApellido());
             usuario.setCorreo(usuarioDto.getCorreo());
             usuario.setTelefono(usuarioDto.getTelefono());
             usuario.setFechaNacimiento(usuarioDto.getFechaNacimiento());
             this.usuarioImpl.actualizarUsuario(usuario);
           }else {
             //usuario.setId_Usuario(usuarioDto.getId_Usuario());
             usuario.setNombre(usuarioDto.getNombre());
             usuario.setApellido(usuarioDto.getApellido());
             usuario.setCorreo(usuarioDto.getCorreo());
             usuario.setTelefono(usuarioDto.getTelefono());
             usuario.setFechaNacimiento(usuarioDto.getFechaNacimiento());
             this.usuarioImpl.crearUsario(usuario);
           }
              return "Se guardaron los datos correctamente";
        }catch (Exception e){
                return "Fallo algo";
        }
    }

    public String eliminarUsuario(int id) {
        Usuario usuario;
        try {
            this.usuarioImpl.eliminarUsuario(id);
            return "Eliminacion exitosa";
        } catch (Exception e) {
            e.printStackTrace();
            return "Eliminacion Fallida";
        }

    }
}
