package com.crisprog.demoConcesionario.negocio;

import com.crisprog.demoConcesionario.dto.VentaDto;
import com.crisprog.demoConcesionario.entity.Marca;
import com.crisprog.demoConcesionario.entity.Venta;
import com.crisprog.demoConcesionario.implementacion.VentaImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class VentaNegocio {

    @Autowired
    private VentaImpl ventaImpl;

    public List<VentaDto> listVentas;

    public List<VentaDto> encontrarTodos(){
        listVentas= new ArrayList<>();

        this.ventaImpl.encontrarTodos().forEach(venta -> {
            VentaDto ventaDto=new VentaDto();
            ventaDto.setId_Venta(venta.getId_Venta());
            ventaDto.setMetodosDePago(venta.getMetodosDePago());
            ventaDto.setFechaVenta(venta.getFechaVenta());
            ventaDto.setMontoTotal(venta.getMontoTotal());
            this.listVentas.add(ventaDto);
        });
        return this.listVentas;
    }
   /* public String guardarVenta(VentaDto ventaDto){
        Venta venta = new Venta();
        try {
            if (ventaDto.getId_Venta()!=0){
                venta.setId_Venta(ventaDto.getId_Venta());
                venta.setMetodosDePago(ventaDto.getMetodosDePago());
                venta.setFechaVenta(ventaDto.getFechaVenta());
                venta.setMontoTotal(ventaDto.getMontoTotal());
                this.ventaImpl.actualizarVenta(venta);
            }else {
                venta.setMetodosDePago(venta.getMetodosDePago());
                venta.setFechaVenta(ventaDto.getFechaVenta());
                venta.setMontoTotal(ventaDto.getMontoTotal());
                this.ventaImpl.crearVenta(venta);
            }
            return "Se guardaron los datos correctamente";
        }catch (Exception e){
            return "Fallo algo";
        }
    }

    */

    public String guardarVenta(VentaDto ventaDto){
        Venta venta = new Venta();
        try {
            if (ventaDto.getId_Venta() != 0){
                venta.setId_Venta(ventaDto.getId_Venta());
                venta.setMetodosDePago(ventaDto.getMetodosDePago());
                venta.setFechaVenta(ventaDto.getFechaVenta());
                venta.setMontoTotal(ventaDto.getMontoTotal());
                this.ventaImpl.actualizarVenta(venta);
            } else {
                venta.setMetodosDePago(ventaDto.getMetodosDePago());
                venta.setFechaVenta(ventaDto.getFechaVenta());
                venta.setMontoTotal(ventaDto.getMontoTotal());
                this.ventaImpl.crearVenta(venta);
            }
            return "Se guardaron los datos correctamente";
        } catch (Exception e){
            return "Fallo algo";
        }
    }

    public String eliminarVenta(int id) {
        Marca marca;
        try {
            this.ventaImpl.eliminarVenta(id);
            return "Eliminacion exitosa";
        } catch (Exception e) {
            e.printStackTrace();
            return "Eliminacion Fallida";
        }

    }
}
