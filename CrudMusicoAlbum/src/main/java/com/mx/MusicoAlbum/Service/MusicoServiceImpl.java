package com.mx.MusicoAlbum.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.mx.MusicoAlbum.DAO.IMusicoDao;
import com.mx.MusicoAlbum.Entity.Musico;

@Service
@Transactional
public class MusicoServiceImpl implements IMusicoService {

	//Inyeccion de dependencia
	@Autowired
	private IMusicoDao dao;
	
	@Override
	public Musico guardar(Musico musico) {
		
		return dao.save(musico);
	}

	@Override
	public Musico editar(Musico musico) {
	Musico aux = this.buscar(musico.getIdMusico());
	if(aux != null) {
		return dao.save(musico);
	}
		return null;
	}

	@Override
	public Musico eliminar(Musico musico) {
		Musico aux = this.buscar(musico.getIdMusico());
		if(aux != null) {
			dao.delete(musico);
			return aux;
		}
		return null;
		
	}

	@Override
	public Musico buscar(Long idMusico) {
	
		return dao.findById(idMusico).orElse(null);  
	}
	

	@Override
	public List<Musico> listar() {
		
		return dao.findAll(Sort.by(Direction.ASC,"idMusico"));
	}

	//metodos personalizados
	public List<Musico> buscarPorGenero1(String genero) {
		
		return dao.findByGenero(genero);
	}

	public List<Musico> buscarPorGenero2(String genero) {
		
		return dao.findByGeneroIgnoreCaseOrderByIdMusico(genero);
	}

}
