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

import com.mx.Cajero.Entity.Transacciones;
import com.mx.Cajero.Service.TransaccionesServiceImpl;

@RestController
@RequestMapping("/Transacciones")
public class TransaccionesWs {

	@Autowired
	private TransaccionesServiceImpl service;

	
	// http://localhost:8006/Transacciones
	@GetMapping
	public List<Transacciones> listar() {
		return service.listar();

	}

	@PostMapping("/{id}")
	public Transacciones buscar(@PathVariable int id) {
		return service.buscar(id);
	}

	@PostMapping
	public void guardar(@RequestBody Transacciones transaccion) {
		service.guardar(transaccion);
	}

	@PutMapping
	public void editar(@RequestBody Transacciones transaccion) {
		service.editar(transaccion);
	}

	@DeleteMapping("/{id}")
	public void eliminar(@PathVariable int id) {
		service.eliminar(id);
	}

	// Método personalizado para buscar por monto
	@GetMapping("/monto/{monto}")
	public List<Transacciones> buscarMonto(@PathVariable Double monto) {
		return service.buscarPorMonto(monto);
	}

	// Método personalizado para buscar por fecha
	@GetMapping("/fecha/{fecha}")
	public List<Transacciones> buscarFecha(@PathVariable String fecha) {
		return service.buscarPorFechaHora(fecha);
	}
}
