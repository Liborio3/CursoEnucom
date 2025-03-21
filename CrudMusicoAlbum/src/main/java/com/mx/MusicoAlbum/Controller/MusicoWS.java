package com.mx.MusicoAlbum.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.mx.MusicoAlbum.Entity.Musico;
import com.mx.MusicoAlbum.Service.MusicoServiceImpl;

@RestController
@RequestMapping("/Musico")
@CrossOrigin("*")
public class MusicoWS {
	
	@Autowired
	private MusicoServiceImpl service;
	
	//Metodo Get listar
	// http://localhost:8004/Musico
	@GetMapping
	public List<Musico> listar(){
		return service.listar();
	}
	
	//Metodo Post Buscar
	//http://localhost:8004/Musico
	@PostMapping("/{idMusico}")
	public Musico buscar(@PathVariable Long idMusico) {
		return service.buscar(idMusico);
	}
	
	//Metodo Post Guardar
	//http://localhost:8004/Musico
	@PostMapping
	public Musico guardar(@RequestBody Musico musico) {
		return service.guardar(musico);
		}
	
	//Metodo Put Editar
	//http://localhost:8004/Musico
	@PutMapping
	public Musico editar(@RequestBody Musico musico) {
		return service.editar(musico);
		
	}
	
	//Metodo Delete Eliminar
	//http://localhost:8004/Musico
	@DeleteMapping
	public Musico eliminar(@RequestBody Musico musico) {
		return service.eliminar(musico);
	}
	
	//Metodos Personalizados
	@PostMapping("buscarPorGenero1{genero}")
	public List<Musico> buscarPorGenero1(@PathVariable String genero){
		return service.buscarPorGenero1(genero);
	}
	
	@PostMapping("buscarPorGenero2{genero}")
	public List<Musico> buscarPorGenero2(@Param("genero")  String genero){
		return service.buscarPorGenero2(genero);
	}
	
	
	
}
