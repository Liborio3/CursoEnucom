package com.mx.Bicicleta.Controller;

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

import com.mx.Bicicleta.Dominio.Bicicleta;
import com.mx.Bicicleta.Servicio.BicicletaServiceImpl;

@RestController
@RequestMapping(path = "/api/v1/Bici")
public class BicicletaWS {
	
	//inyeccion de dependencias del @Service
	@Autowired
	private BicicletaServiceImpl service;
	
	//-------------Creacion de EndPonts
	
	//------------ Endpoint: "Listar"
	//------------ URL: 	http://localhost:8001/api/v1/Bici/listar
	@GetMapping(value = "listar")
	public List<Bicicleta> listar(){
		return service.listar();
		
	}
	
	//EndPoint: "Buscar"
	//URL: 	http://localhost:8001/api/v1/Bici/buscar/{1}
	@PostMapping(value = "buscar/{idBici}")
	public Bicicleta buscar(@PathVariable int idBici) {
		return service.buscar(idBici);
	}
	
	//------------ Endpoint: "Guardar"
	//------------ URL: 	http://localhost:8001/api/v1/Bici/guardar
	@PostMapping(value = "guardar")
	public void guardar(@RequestBody Bicicleta bici) {
		
		/*
		 * @RequestBody: sirve para deserealizar el documento JSON y convertirlo en un Object Java
		 * @ResponseBody: Sirve para serializar el Objeto Java y convertirlo en un Documento Json
		 * */
		service.guardar(bici);
		
	}
	
	//------------ Endpoint: "Editar"
		//------------ URL: 	http://localhost:8001/api/v1/Bici/editar
	@PutMapping(value ="editar")
	public void  editar(@RequestBody Bicicleta bici) {
		service.editar(bici);
	}
	
	//------------ Endpoint: "Elimniar"
		//------------ URL: 	http://localhost:8001/api/v1/Bici/eliminar{1}
	@DeleteMapping(value = "eliminar/{idBici}")
	public void eliminar(@PathVariable int idBici) {
		service.eliminar(idBici);
	}
	
}
