package com.mx.Tienda.FeignClients;

import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.data.repository.query.Param;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.mx.Tienda.Models.Clientes;

@FeignClient(
			name = "MS-Clientes",
			url = "http://localhost:8013",
			path = "/Clientes"
		)
public interface IClientesFeign {
	
	//Declaracion de los controladores del Microservicio MS-Clientes
	
	@GetMapping
	public List<Clientes> listClientes();
	
	@PostMapping("/{idCliente}")
	public Clientes search(@PathVariable Long idProvedor);
	
	@PostMapping
	public Clientes save(@RequestBody Clientes cliente);
	
	@PutMapping
	public Clientes updateCliente (@RequestBody Clientes cliente);
	
	@DeleteMapping 
	public Clientes deleteCliente(@Param("idCliente") Long idCliente);
	
	@PostMapping("/Tienda/{tiendaId}")
	public List<Clientes> getClientesByTiendaId(@PathVariable int tiendaId);
	
}
