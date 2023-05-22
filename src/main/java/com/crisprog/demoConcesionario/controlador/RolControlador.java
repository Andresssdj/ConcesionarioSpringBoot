package com.crisprog.demoConcesionario.controlador;

import com.crisprog.demoConcesionario.dto.RolDto;
import com.crisprog.demoConcesionario.entity.Rol;
import com.crisprog.demoConcesionario.implementacion.RolImpl;
import com.crisprog.demoConcesionario.negocio.RolNegocio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping(path = "/rol")
@CrossOrigin(origins = "*", methods = {RequestMethod.GET,RequestMethod.POST,RequestMethod.PUT})
public class RolControlador {

    @Autowired
    private RolNegocio rolNegocio;

    @GetMapping("/all")
    @ResponseBody
    public ResponseEntity<Map<String, Object>> all() {


        Map<String, Object> res = new HashMap<>();
        List<RolDto> listDtoo = this.rolNegocio.encontrarTodos();
        res.put("status", "ok");
        res.put("data", listDtoo);

        return new ResponseEntity<>(res, HttpStatus.OK);
    }

    @PostMapping("/crear")
    @ResponseBody
    public ResponseEntity<Map<String, Object>> crearRol(@RequestBody Map<String, Object> request) {
        Map<String, Object> res = new HashMap<>();
        RolDto rolDto = new RolDto();

        rolDto.setId(0);
        rolDto.setNombre(request.get("nombre").toString());
        String respuesta = this.rolNegocio.guardarRol(rolDto);
        res.put("status", "ok");
        res.put("data", respuesta);
        return new ResponseEntity<>(res, HttpStatus.OK);
    }

    @PostMapping("/actualizar")
    @ResponseBody
    public ResponseEntity<Map<String, Object>> actualizarRol(@RequestBody Map<String, Object> request) {
        Map<String, Object> res = new HashMap<>();
        RolDto rolDto = new RolDto();

        rolDto.setId(Integer.parseInt(request.get("id").toString()));
        rolDto.setNombre(request.get("nombre").toString());
        String respuesta = this.rolNegocio.guardarRol(rolDto);
        res.put("status", "ok");
        res.put("data", respuesta);
        return new ResponseEntity<>(res, HttpStatus.OK);
    }
    @GetMapping("/eliminar/{id}")
    public ResponseEntity<Map<String, Object>> eliminarRol(@PathVariable int id) {
        Map<String, Object> res = new HashMap<>();
        String resp = this.rolNegocio.eliminarRol(id);
        res.put("status", "ok");
        res.put("data", resp);
        return new ResponseEntity<>(res, HttpStatus.OK);
    }
}