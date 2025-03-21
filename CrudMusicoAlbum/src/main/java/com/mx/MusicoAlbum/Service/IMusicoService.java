package com.mx.MusicoAlbum.Service;

import java.util.List;

import com.mx.MusicoAlbum.Entity.Musico;

public interface IMusicoService {
	
	public Musico guardar(Musico musico);
	
	public Musico editar(Musico musico);
	
	public Musico eliminar(Musico musico);
	
	public Musico buscar(Long idMusico);
	
	public List<Musico> listar();

}
