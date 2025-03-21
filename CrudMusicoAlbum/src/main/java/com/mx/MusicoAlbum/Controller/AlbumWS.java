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

import com.mx.MusicoAlbum.Entity.Album;
import com.mx.MusicoAlbum.Service.AlbumServiceImpl;

@RestController
@RequestMapping("/Album")
@CrossOrigin
public class AlbumWS {
	
	@Autowired
	private AlbumServiceImpl service;
	
	// Get Listar
	// http://localhost:8004/Album
	@GetMapping
	public List<Album> listar(){
		return service.listar();
	}
	
	// Post Buscar
	// http://localhost:8004/Album
	@PostMapping("/{idAlbum}")
	public Album buscar(@PathVariable Long idAlbum) {
		return service.buscar(idAlbum);
	}
	
	// Post Guardar
	// http://localhost:8004/Album
	@PostMapping
	public Album guardar (@RequestBody Album album) {
		return service.guardar(album);
		}
	
	// Put Editar
	// http://localhost:8004/Album
	@PutMapping
	public Album editar (@RequestBody Album album) {
		return service.editar(album);
	}
	
	// Delete Eliminar
	// http://localhost:8004/Album
	@DeleteMapping
	public Album eliminar (@RequestBody Album album) {
		return service.eliminar(album);
	}
	
	// Metodo personalizado Buscar por nombre
	@PostMapping("buscarPorNombre")
	public List<Album> buscarPorNombre(@Param ("nombre") String nombre) {
		
		return service.buscarPorNombre(nombre);
	}
	
	

}
