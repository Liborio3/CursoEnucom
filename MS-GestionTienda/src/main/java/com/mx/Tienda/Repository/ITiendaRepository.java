package com.mx.Tienda.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.mx.Tienda.Entity.Tienda;


@Repository
public interface ITiendaRepository extends JpaRepository<Tienda, Integer>{
	
	//Metodo personalizado
	public List<Tienda> findByNombre(String nombre);
}
