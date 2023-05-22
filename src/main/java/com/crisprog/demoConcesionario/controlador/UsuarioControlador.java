package com.crisprog.demoConcesionario.controlador;

import com.crisprog.demoConcesionario.dto.UsuarioDto;
import com.crisprog.demoConcesionario.negocio.UsuarioNegocio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping(path = "/usuario")
@CrossOrigin(origins = "*", methods = {RequestMethod.GET,RequestMethod.POST,RequestMethod.PUT})
public class UsuarioControlador {

    @Autowired
    private UsuarioNegocio usuarioNegocio;

    @GetMapping("/all")
    @ResponseBody
    public ResponseEntity<Map<String, Object>> all() {


        Map<String, Object> res = new HashMap<>();
        List<UsuarioDto> listDto = this.usuarioNegocio.encontrarTodos();
        res.put("status", "ok");
        res.put("data", listDto);

        return new ResponseEntity<>(res, HttpStatus.OK);
    }

    @PostMapping("/crear")
    @ResponseBody
    public ResponseEntity<Map<String, Object>> crearUsuario(@RequestBody Map<String, Object> request) {

        Map<String, Object> res = new HashMap<>();
        UsuarioDto usuarioDto = new UsuarioDto();

        usuarioDto.setId_Usuario(0);
        usuarioDto.setNombre(request.get("nombre").toString());
        usuarioDto.setApellido(request.get("apellido").toString());
        usuarioDto.setTelefono(Integer.parseInt(request.get("telefono").toString()));
        usuarioDto.setCorreo(request.get("correo").toString());
        usuarioDto.setFechaNacimiento(new Date());
        String respuesta = this.usuarioNegocio.guardarUsuario(usuarioDto);
        res.put("status", "ok");
        res.put("data", respuesta);
        return  new ResponseEntity<>(res,HttpStatus.OK);
    }

    @PostMapping("/actualizar")
    @ResponseBody
    public ResponseEntity<Map<String, Object>> actualizarUsuario(@RequestBody Map<String, Object> request) {
        Map<String, Object> res = new HashMap<>();
        UsuarioDto usuarioDto = new UsuarioDto();

        usuarioDto.setId_Usuario(Integer.parseInt(request.get("id_Usuario").toString()));
        usuarioDto.setNombre(request.get("nombre").toString());
        usuarioDto.setApellido(request.get("apellido").toString());
        usuarioDto.setTelefono(Integer.parseInt(request.get("telefono").toString()));
        usuarioDto.setCorreo(request.get("correo").toString());
        usuarioDto.setFechaNacimiento(new Date());
        String respuesta = this.usuarioNegocio.guardarUsuario(usuarioDto);
        res.put("status", "ok");
        res.put("data", respuesta);
        return  new ResponseEntity<>(res,HttpStatus.OK);
    }
    @GetMapping("/eliminar/{id}")
    public ResponseEntity<Map<String, Object>> eliminarUsuario(@PathVariable int id) {
        Map<String, Object> res = new HashMap<>();
        String resp = this.usuarioNegocio.eliminarUsuario(id);
        res.put("status", "ok");
        res.put("data", resp);
        return new ResponseEntity<>(res, HttpStatus.OK);
    }
}