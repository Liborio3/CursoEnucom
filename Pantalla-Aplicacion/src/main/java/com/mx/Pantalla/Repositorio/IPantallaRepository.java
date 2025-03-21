package com.mx.Pantalla.Repositorio;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.mx.Pantalla.Dominio.Pantalla;

//indica al framework que esa interfaz contendra metodos que se encargara de extraer informacion de la base de datos 
@Repository
public interface IPantallaRepository extends CrudRepository<Pantalla, Integer> {
	

}
 