package com.mx.MusicoAlbum.DAO;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.mx.MusicoAlbum.Entity.Album;

@Repository
public interface IAlbumDao extends JpaRepository<Album,Long>{
	
	//Metodo personalizado con palabra clave
	public List<Album> findByNombreIgnoreCaseOrderByMusicoId(String nombre);

}
