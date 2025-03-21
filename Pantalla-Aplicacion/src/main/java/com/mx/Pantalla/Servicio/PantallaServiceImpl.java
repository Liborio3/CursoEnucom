package com.mx.Pantalla.Servicio;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mx.Pantalla.Dominio.Pantalla;
import com.mx.Pantalla.Repositorio.IPantallaRepository;

@Service
public class PantallaServiceImpl implements IPantallaService{

	/*en programacion Orientada a Objetos en esta parte añadiamos una lista para almacenar pero ya no tenemos eso  esta vez tenemos una base de datos fisica 
	 * donde vamos a recuperar informacion y vamos a enviar información
	 * 
	 * nuestro paquete de repository es quien se encarga de la comunicacion entre la base de datos y el servicio
	*/
	
	//inyeccion de dependencias
	@Autowired
	private IPantallaRepository repository;
	
	@Override
	public void guardar(Pantalla pantalla) {
	
		repository.save(pantalla);
	}

	@Override
	public void editar(Pantalla pantalla) {
		repository.save(pantalla);
		
	}

	@Override
	public void eliminar(int IdPantalla) {
		repository.deleteById(IdPantalla);
		
	}

	@Override
	public Pantalla buscar(int IdPantalla) {
		
		return repository.findById(IdPantalla).orElse(null);
	}

	@Override
	public List<Pantalla> listar() {
		
		return (List<Pantalla>) repository.findAll();
	}

}
