package com.mx.MusicoAlbum.DAO;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.mx.MusicoAlbum.Entity.Musico;

@Repository
public interface IMusicoDao extends JpaRepository<Musico, Long>{
	
	//Creacion de Metodos personalizados con la "Palabras claves"
	// o con la anotacion "@Querry
	
	//Metodo que busca un Musico por Genero
	@Query(nativeQuery = true, 
			value = "SELECT ID_MUSICO, NOMBRE, GENERO, PAIS "
					+ "FROM MUSICO "
					+ "WHERE UPPER(GENERO) = UPPER(:genero) "
					+ "ORDER BY ID_MUSICO")
	public List<Musico> findByGenero(String genero);
	
	//Metodo personalizado con palabra clave
	public List<Musico> findByGeneroIgnoreCaseOrderByIdMusico(String genero);

}
