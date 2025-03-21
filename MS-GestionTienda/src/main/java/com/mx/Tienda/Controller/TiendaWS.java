package com.mx.Tienda.Controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.mx.Tienda.Entity.Tienda;
import com.mx.Tienda.Models.Clientes;
import com.mx.Tienda.Models.Productos;
import com.mx.Tienda.Models.Provedores;
import com.mx.Tienda.Service.TiendaServiceImpl;

@RestController
@RequestMapping("/Tienda")
public class TiendaWS {
	
	@Autowired
	TiendaServiceImpl service;
	//---------------------------------- Tienda
	@GetMapping
	public ResponseEntity<?> listarTiendas(){
		List<Tienda> tienda = service.listar();
		if (tienda.isEmpty()) {
			return ResponseEntity.noContent().build();
		} else {
			return ResponseEntity.ok(tienda);
		}
	}
	
	// httphost:
	// Metodo buscar
	@PostMapping("/{idTienda}")
	public ResponseEntity<?> obtenerTienda(@PathVariable Integer idTienda) {
		Tienda t = service.buscar(idTienda);
		if (t != null) {
			return ResponseEntity.ok(t);
		} else {
			return ResponseEntity.notFound().build();
		}

	}
	
	
	// guardar
	@PostMapping
	public ResponseEntity<?> guardartienda(@RequestBody Tienda t) {
		//
		//
		return ResponseEntity.ok(service.guardar(t));
	}
	
	//editar
	@PutMapping
	public ResponseEntity<?> actualizarTienda(@RequestBody Tienda t) {
		Tienda tiendaBD = service.buscar(t.getIdTienda());
		if (tiendaBD != null) {

			return ResponseEntity.ok(service.editar(t));
		} else {
			return ResponseEntity.notFound().build();
		}
	} 
	
	@DeleteMapping("{idTienda}")
	public ResponseEntity<?> eliminarTienda(@PathVariable Integer idTienda) {
		Tienda t = service.buscar(idTienda);
		if (t != null) {
			service.eliminar(idTienda);
			return ResponseEntity.ok(t);
		} else {
			return ResponseEntity.notFound().build();
		}

	}
	
	
	//Metodo personalizado
	@PostMapping("buscarPorNombre/{nombre}")
	public ResponseEntity<List<Tienda>> buscarPorNombre(@PathVariable String nombre) {
		List<Tienda> tiendaLista = service.buscarPorNombreTienda(nombre);

		if (tiendaLista != null) {
			return ResponseEntity.ok(tiendaLista);
		} else {
			return ResponseEntity.notFound().build();
		}

	}
	
	//------------------------------------------------- C L I E N T E S
	//Endpoint Guardar CLIENTE
	// http://localhost:8013/Tienda/Clientes
	
	
	
	
	@PostMapping("/Clientes")
	public ResponseEntity<?> guardarCliente(@RequestBody Clientes cliente){
		Clientes nuevoCliente = service.saveClientes(cliente);
		if(nuevoCliente == null)
		return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
		
	return ResponseEntity.status(HttpStatus.CREATED).body(nuevoCliente);
	}
	
	@GetMapping("/Clientes/{tiendaId}")
	public ResponseEntity<?> obtenerCliente(@PathVariable int tiendaId){
		List<Clientes> clientes = service.getClientes(tiendaId);
		if(clientes.isEmpty() || clientes == null)
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
		return ResponseEntity.status(HttpStatus.CREATED).body(clientes);
	}
	
	//------------------- P R O D U C T O S--------------------------
	//ENDPOINT GUARDAR PRODUCTOS
	// http://localhost:8010/Tienda/Productos
	@PostMapping("/Productos")
	public ResponseEntity<?> guardarProducto(@RequestBody  Productos producto){
		Productos nuevoProductos = service.saveProducto(producto);
		if(nuevoProductos == null) 
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
		
		return ResponseEntity.status(HttpStatus.CREATED).body(nuevoProductos);
	}
	
	@GetMapping("/Productos/{tiendaId}")
	public ResponseEntity<?> obtenerProductos(@PathVariable  int tiendaId){
		List<Productos> productos = service.getProductos(tiendaId);
		if(productos.isEmpty())
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
		return ResponseEntity.status(HttpStatus.CREATED).body(productos);
		
	}
	
	//------------------- P R O V E D O R E S--------------------------
	//ENDPOINT GUARDAR PROVEDORES
	// http://localhost:8011/Provedores/Provedores
	@PostMapping("/Provedores")
	public ResponseEntity<?> guardarProvedor(@RequestBody  Provedores provedor){
		Provedores nuevoProvedor = service.saveProvedores(provedor);
		if (nuevoProvedor == null) 
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
		
		return ResponseEntity.status(HttpStatus.CREATED).body(nuevoProvedor);
		
	}
	
	@GetMapping("/Provedores/{tiendaId}")
	public ResponseEntity<?> obtenerProvedores(@PathVariable int tiendaId){
		List<Provedores> provedores = service.getProvedores(tiendaId);
		if (provedores.isEmpty()) 
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
		return ResponseEntity.status(HttpStatus.CREATED).body(provedores);
	}
	
	//***************************************************
	//metodo para obtener todos los modulos
	//***************************************************
	
	@PostMapping("/todo/{tiendaId}")
	public ResponseEntity<?> obtenerTodosLosModulos(@PathVariable int tiendaId){
		Map<String,Object> modulos = service.obtenerTodosLosModulos(tiendaId);
		return ResponseEntity.status(HttpStatus.OK).body(modulos);
	}
}
