package com.mx.SalaCine.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.mx.SalaCine.Entity.Sala;
import com.mx.SalaCine.Service.SalaServiceImpl;

@RestController
@RequestMapping("/Sala")
@CrossOrigin
public class SalaWS {

	@Autowired
	private SalaServiceImpl service;
	
	
	//listar
	//http://localhost:8003/Sala/listar
	@GetMapping("listar")
	public List<Sala> listar(){
		return service.listar();
		
	}
	
	//buscar
	//http://localhost:8003/Sala/buscar
	@PostMapping("buscar")
	public Sala buscar(@RequestBody Sala sala) {
		return service.buscar(sala);
	}
	
	//guardar
	//http://localhost:8003/Sala/guardar
	@PostMapping("guardar")
	public Sala guardar(@RequestBody Sala sala) {
		return service.gurdar(sala);
	}
	
	//editar
	//http://localhost:8003/Sala/editar
	@PutMapping("editar")
	public Sala editar(@RequestBody Sala sala) {
		return service.editar(sala);
		
	}
	
	//eliminar
	//http://localhost:8003/Sala/eliminar
	@DeleteMapping("eliminar")
	public Sala eliminar(@RequestBody Sala sala) {
		return service.eliminar(sala);
		
	}
	
	//metodos personalizados
	//BUSCAR POR CATEGORIA 1
	//http://localhost:8003/Sala/buscarPorCategoria1
	@PostMapping("buscarPorCategoria1")
	public List<Sala> buscarPorCategoria(@Param("categoria") String categoria){
		return service.buscarPorCategoria1(categoria);
	}
	
	//metodos personalizados
		//BUSCAR POR CATEGORIA 2
		//http://loxalhost:8003/Sala/buscarPorCategoria2
		@PostMapping("buscarPorCategoria2")
		public List<Sala> buscarPorCategoria2(@Param("categoria") String categoria){
			return service.buscarPorCategoria2(categoria);
		}
		
	
	
}
