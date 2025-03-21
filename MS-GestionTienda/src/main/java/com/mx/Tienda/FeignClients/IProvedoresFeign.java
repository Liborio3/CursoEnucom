package com.mx.Tienda.FeignClients;

import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.mx.Tienda.Models.Provedores;

@FeignClient(
		name = "MS-Provedores",
		url = "http://localhost:8011",
		path = "/Provedores"
		)
public interface IProvedoresFeign {
	
	//Declaracion de los controladores del Microservicio MS-Provedores
	
	@GetMapping
	public List<Provedores> listProvedores();
	
	@PostMapping("/{idProvedor")
	public Provedores search(@PathVariable Long idProvedor);
	
	@PostMapping
	public Provedores save(@RequestBody Provedores provedor);
	
	@PutMapping
	public Provedores updateProvedor(@RequestBody Provedores provedor);
	
	@DeleteMapping("/idProvedor")
	public Provedores deleteProvedores(@PathVariable Long idProvedor);
	
	@PostMapping("buscarPorTienda/{tiendaId}")
	public List<Provedores> getProvedoresByTiendaId(@PathVariable int tiendaId);
	
	

}
