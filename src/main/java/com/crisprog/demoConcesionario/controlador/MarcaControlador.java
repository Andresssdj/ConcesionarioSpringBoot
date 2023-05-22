package com.crisprog.demoConcesionario.controlador;

import com.crisprog.demoConcesionario.dto.MarcaDto;
import com.crisprog.demoConcesionario.entity.Marca;
import com.crisprog.demoConcesionario.implementacion.MarcaImpl;
import com.crisprog.demoConcesionario.negocio.MarcaNegocio;
import com.crisprog.demoConcesionario.servicio.MarcaServicio;
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
@RequestMapping(path = "/marca")
@CrossOrigin(origins = "*", methods = {RequestMethod.GET,RequestMethod.POST,RequestMethod.PUT,})
public class MarcaControlador {


    @Autowired
    private MarcaNegocio marcaNegocio;

    @GetMapping("/all")
    @ResponseBody
    public ResponseEntity<Map<String, Object>> all() {

        Map<String, Object> res = new HashMap<>();
        List<MarcaDto> listDto = this.marcaNegocio.encontrarTodos();
        res.put("status", "ok");
        res.put("data", listDto);

        return new ResponseEntity<>(res, HttpStatus.OK);
    }

    @PostMapping("/crear")
    @ResponseBody
    public ResponseEntity<Map<String, Object>> crearMarca(@RequestBody Map<String, Object> request) {
        Map<String, Object> res = new HashMap<>();
        MarcaDto marcaDto = new MarcaDto();

        marcaDto.setId_Marca(0);
        marcaDto.setMarca(request.get("marca").toString());
        String respuesta = this.marcaNegocio.guardarMarca(marcaDto);
        res.put("status", "ok");
        res.put("data", respuesta);
        return new ResponseEntity<>(res, HttpStatus.OK);
    }

    @PostMapping("/actualizar")
    @ResponseBody
    public ResponseEntity<Map<String, Object>> actualizarMarca(@RequestBody Map<String, Object> request) {

        Map<String, Object> res = new HashMap<>();
        MarcaDto marcaDto = new MarcaDto();

        marcaDto.setId_Marca(Integer.parseInt(request.get("id_Marca").toString()));
        marcaDto.setMarca(request.get("marca").toString());
        String respuesta = this.marcaNegocio.guardarMarca(marcaDto);
        res.put("status", "ok");
        res.put("data", respuesta);
        return new ResponseEntity<>(res, HttpStatus.OK);
    }

    @GetMapping("/eliminar/{id}")
    public ResponseEntity<Map<String, Object>> eliminarMarca(@PathVariable int id) {
        Map<String, Object> res = new HashMap<>();
        String resp = this.marcaNegocio.eliminarMarca(id);
        res.put("status", "ok");
        res.put("data", resp);
        return new ResponseEntity<>(res, HttpStatus.OK);
    }
}


