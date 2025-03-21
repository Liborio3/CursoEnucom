package com.mx.MusicoAlbum.Service;

import java.util.List;

import com.mx.MusicoAlbum.Entity.Album;

public interface IAlbumService {
	
	public Album guardar(Album album);
	      
	public Album editar(Album album);
	  
	public Album eliminar (Album album);
	   
	public Album buscar(Long idAlbum);
	
	public List<Album> listar();

}
