package com.mx.Provedores.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.orm.ObjectOptimisticLockingFailureException;
import org.springframework.stereotype.Service;

import com.mx.Provedores.Dao.IProvedoresDao;
import com.mx.Provedores.Entity.Provedores;

@Service
public class ProvedoresServiceImpl implements IProvedoresService{
	@Autowired
	private IProvedoresDao dao;

	@Override
	public Provedores gurdar(Provedores provedores) {
		try {
		return dao.save(provedores);
		}catch (ObjectOptimisticLockingFailureException ex) {
            // Manejar la excepción (por ejemplo, lanzar una excepción personalizada)
            throw new RuntimeException("El provedor ha sido modificado por otro usuario.", ex);
        }
	}

	@Override
	public Provedores editar(Provedores provedores) {
		Provedores aux = this.buscar(provedores.getIdProvedor());
		if(aux != null) {
			
			return dao.save(provedores);
		}
		return null;

	}

	@Override
	public Provedores eliminar(Long idProvedor) {
		Provedores aux = this.buscar(idProvedor);
		if(aux != null) {
			dao.deleteById(idProvedor);
			return aux;
		}
		return aux;
		
	}

	@Override
	public Provedores buscar(Long idProvedor) {
		
		return dao.findById(idProvedor).orElse(null);
	}

	@Override
	public List<Provedores> listar() {
		
		return dao.findAll(Sort.by(Direction.DESC,"idProvedor"));
	}
	
	//Metodo personalizado
	//public List<Provedores> findByTiendaId(int tiendaId);
	public List<Provedores> buscarPorTienda(int tiendaId){
		return dao.findByTiendaId(tiendaId);
	}

}
