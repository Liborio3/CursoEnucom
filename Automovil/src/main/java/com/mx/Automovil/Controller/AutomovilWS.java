package com.mx.Automovil.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.mx.Automovil.Entity.Automovil;
import com.mx.Automovil.Service.AutomovilServiceImpl;

@RestController
@RequestMapping("/Automovil")
@CrossOrigin("*")
public class AutomovilWS {
	
	@Autowired
	private AutomovilServiceImpl service;
	
	//Metodo Get LISTAR
	// http://localhost:8005/Automovil
	@GetMapping
	public List<Automovil> listar(){
		return service.listar();	
	}
	
	//Metodo Buscar
	// http://localhost:8005/Automovil
	@PostMapping("/{idAuto}")
	public Automovil buscar(@PathVariable Long idAuto) {
		return service.buscar(idAuto);
		
	}
	//Metodo Guardar
		// http://localhost:8005/Automovil
	@PostMapping
	public Automovil guardar(@RequestBody Automovil auto) {
		return service.guardar(auto);
	}
	
	//Metodo Editar
	// http://localhost:8005/Automovil
	@PutMapping
	public Automovil editar(@RequestBody Automovil auto) {
		return service.editar(auto);
	}
	
	//Metodo Eliminar
	// http://localhost:8005/Automovil
	@DeleteMapping
	public Automovil eliminar(@RequestBody Automovil auto) {
		return service.eliminar(auto);
	}
	
	@PostMapping("buscarPorMarca/{marca}")
	public List <Automovil> buscarPorMarca(@PathVariable String marca){
		return service.buscarPorMarca(marca);
	}
	
	
}
