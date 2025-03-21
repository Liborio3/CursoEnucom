package com.mx.MusicoAlbum.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.mx.MusicoAlbum.DAO.IAlbumDao;
import com.mx.MusicoAlbum.Entity.Album;

@Service
@Transactional
public class AlbumServiceImpl implements IAlbumService{

	@Autowired 
	public IAlbumDao dao;
	@Override
	public Album guardar(Album album) {
		
		return dao.save(album);
	}

	@Override
	public Album editar(Album album) {
		Album aux = this.buscar(album.getIdAlbum());
		if(aux != null) {
			return dao.save(album);
		}
		return null;
	}

	@Override
	public Album eliminar(Album album) {
		Album aux = this.buscar(album.getIdAlbum());
		if (aux != null) {
			dao.delete(album);
			return aux;
		}
		return null;
	}

	@Override
	public Album buscar(Long idAlbum) {
	
		return dao.findById(idAlbum).orElse(null);
	}

	@Override
	public List<Album> listar() {
		
		return dao.findAll(Sort.by(Direction.ASC,"idAlbum"));
	}
	
	//Metodos Personalizado
	public List<Album> buscarPorNombre(String nombre){
		return dao.findByNombreIgnoreCaseOrderByMusicoId(nombre);
	}
	

}
