package com.mx.Pantalla.Controller;

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

import com.mx.Pantalla.Dominio.Pantalla;
import com.mx.Pantalla.Servicio.PantallaServiceImpl;

@RestController
@RequestMapping(path = "/api/v1/Pantalla")
public class PantallaWS {
	
	
	//inyeccion de dependencias del @Service
	@Autowired
	private PantallaServiceImpl service;
	
	//Creacion del endpoint
	
	//Endpoint: "Listar"
	//URL http://localhost:8002/api/v1/Pantalla/listar
	@GetMapping(value = "listar")
	public List<Pantalla> listar(){
		return service.listar();
		
	}
	
	//EndPoint: "Buscar"
		//URL: 	http://localhost:8002/api/v1/Pantalla/buscar/{1} 
	@PostMapping(value = "buscar/{idPantalla}")
	public Pantalla buscar(@PathVariable int idPantalla) {
		return service.buscar(idPantalla);
	}
	
	//------------ Endpoint: "Guardar"
	//------------ URL: 	http://localhost:8002/api/v1/Pantalla/guardar
	@PostMapping(value = "guardar") 
	public void guardar(@RequestBody Pantalla pantalla) {
		
		/*
		 * @RequestBody: sirve para deserealizar el documento JSON y convertirlo en un Object Java
		 * @ResponseBody: Sirve para serializar el Objeto Java y convertirlo en un Documento Json
		 * */
		service.guardar(pantalla);
		
	}
	
	//------------ Endpoint: "Editar"
	//------------ URL: 	http://localhost:8002/api/v1/Pantalla/editar
		@PutMapping(value ="editar")
		public void  editar(@RequestBody Pantalla pantalla) {
			service.editar(pantalla);
		}
		
		//------------ Endpoint: "Elimniar"
		//------------ URL: 	http://localhost:8002/api/v1/Pantalla/eliminar{1}
			@DeleteMapping(value = "eliminar/{idPantalla}")
			public void eliminar(@PathVariable int idPantalla) {
				service.eliminar(idPantalla);
			}
	
}
