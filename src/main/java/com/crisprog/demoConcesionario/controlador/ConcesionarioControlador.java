package com.crisprog.demoConcesionario.controlador;


import com.crisprog.demoConcesionario.dto.ConcesionarioDto;
import com.crisprog.demoConcesionario.entity.Concesionario;
import com.crisprog.demoConcesionario.implementacion.ConcesionarioImpl;
import com.crisprog.demoConcesionario.negocio.ConcesionarioNegocio;
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
@RequestMapping(path = "/concesionario")
@CrossOrigin(origins = "*", methods = {RequestMethod.GET,RequestMethod.POST,RequestMethod.PUT})
public class ConcesionarioControlador {

    @Autowired
    private ConcesionarioNegocio concesionarioNegocio;

    @GetMapping("/all")
    @ResponseBody
    public ResponseEntity<Map<String, Object>> all() {

        Map<String, Object> res = new HashMap<>();
        List<ConcesionarioDto> listDto = this.concesionarioNegocio.encontrarTodos();
        res.put("status", "ok");
        res.put("data", listDto);

        return new ResponseEntity<>(res, HttpStatus.OK);
    }

    @PostMapping("/crear")
    @ResponseBody
    public ResponseEntity<Map<String, Object>> crearConcesionario(@RequestBody Map<String, Object> request) {

        Map<String, Object> res = new HashMap<>();
        ConcesionarioDto concesionarioDto = new ConcesionarioDto();

        concesionarioDto.setId_Concesionario(0);
        concesionarioDto.setNombre(request.get("nombre").toString());
        concesionarioDto.setCiudad(request.get("ciudad").toString());
        concesionarioDto.setTelefono(Integer.parseInt(request.get("telefono").toString()));
        concesionarioDto.setDireccion(request.get("direccion").toString());
        String respuesta = this.concesionarioNegocio.guardarConcesionario(concesionarioDto);
        res.put("status", "ok");
        res.put("data", respuesta);
        return new ResponseEntity<>(res, HttpStatus.OK);
    }

    @PostMapping("/actualizar")
    @ResponseBody
    public ResponseEntity<Map<String, Object>> actualizarConcesionario(@RequestBody Map<String, Object> request) {
        Map<String, Object> res = new HashMap<>();
        ConcesionarioDto concesionarioDto = new ConcesionarioDto();

        concesionarioDto.setId_Concesionario(Integer.parseInt(request.get("id_Concesionario").toString()));
        concesionarioDto.setNombre(request.get("nombre").toString());
        concesionarioDto.setCiudad(request.get("ciudad").toString());
        concesionarioDto.setTelefono(Integer.parseInt(request.get("telefono").toString()));
        concesionarioDto.setDireccion(request.get("direccion").toString());
        String respuesta = this.concesionarioNegocio.guardarConcesionario(concesionarioDto);
        res.put("status", "ok");
        res.put("data", respuesta);
        return new ResponseEntity<>(res, HttpStatus.OK);
    }
    @GetMapping("/eliminar/{id}")
    public ResponseEntity<Map<String, Object>> eliminarConcesionario(@PathVariable int id) {
        Map<String, Object> res = new HashMap<>();
        String resp = this.concesionarioNegocio.eliminarConcesionario(id);
        res.put("status", "ok");
        res.put("data", resp);
        return new ResponseEntity<>(res, HttpStatus.OK);
    }
}
