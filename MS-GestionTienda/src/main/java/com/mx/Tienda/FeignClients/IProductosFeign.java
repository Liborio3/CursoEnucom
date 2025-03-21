package com.mx.Tienda.FeignClients;

import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.mx.Tienda.Models.Productos;

@FeignClient(
		name = "MS-Productos",
		url = "http://localhost:8010",
		path = "/Productos"
		)
public interface IProductosFeign {
	//Declaracion de los controladores del Microservicio MS-Productos
	
	@GetMapping
	public List<Productos> listarProducts();
	
	@PostMapping("/{idProducto}")
	public Productos search(@PathVariable Long idProducto);
	
	@PostMapping
	public Productos save(@RequestBody Productos producto);
	
	@PutMapping
	public Productos updateProduct(@RequestBody Productos producto);
	
	@DeleteMapping("/{idProducto}")
	public Productos deleteProduct(@PathVariable Long idProducto);
	
	@GetMapping("/tienda/{tiendaId}") 
	List<Productos> getProductoByTiendaId (@PathVariable int tiendaId);
	
}
