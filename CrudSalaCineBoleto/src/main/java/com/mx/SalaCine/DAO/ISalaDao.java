package com.mx.SalaCine.DAO;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.mx.SalaCine.Entity.Sala;

@Repository
public interface ISalaDao extends JpaRepository<Sala, Long>{
	
	//Creamos metodos personalizados con "Palabras clave" o con la anotaacion "@Quey"
	
	//Metodo que buscara una sala por CATEGORIA
	@Query(nativeQuery = true,
			value = "SELECT ID_SALA, NO_ASIENTOS, TIPO_PANTALLA, CATEGORIA "
					+ "FROM SALA_CINE "
					+ "WHERE UPPER(CATEGORIA) =UPPER(:categoria) "
					+ "ORDER BY ID_SALA ASC")
	public List<Sala> findByCategoria(String categoria);

	
	//Metodo personalizado con palabras clave
	public List<Sala> findByCategoriaIgnoreCaseOrderByIdSala(String categoria);
}
