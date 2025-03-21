package com.mx.Cajero.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.mx.Cajero.Entity.Denominaciones;
import com.mx.Cajero.Service.DenominacionServiceImpl;

@RestController
@RequestMapping("/Denominaciones")
public class DenominacionesWs {
	
	
	
	@Autowired
    private DenominacionServiceImpl denominacionesService; // Inyecta la implementación
	
	// http://localhost:8006/Denominaciones
	
	 @GetMapping
	    public List<Denominaciones> listar() {
	        return denominacionesService.listar();
	    }
	 
	    @PostMapping("/{id}")
	    public Denominaciones buscar(@PathVariable int id) {
	        return denominacionesService.buscar(id);
	    }

	    @PostMapping
	    public void guardar(@RequestBody Denominaciones denominacion) {
	        denominacionesService.guardar(denominacion);
	    }

	    @PutMapping
	    public void editar(@RequestBody Denominaciones denominacion) {
	        denominacionesService.editar(denominacion);
	    }
	    
	    @DeleteMapping("/{id}")
	    public void eliminar(@PathVariable int id) {
	        denominacionesService.eliminar(id);
	    }
	    
	    // Método personalizado para actualizar la cantidad
	    @PutMapping("/{id}/cantidad/{cantidad}")
	    public void actualizarCantidadDenominacion(@PathVariable long id, @PathVariable int cantidad) {
	        denominacionesService.actualizarCantidadDenominacion(id, cantidad);
	    }
	    
	    
}
