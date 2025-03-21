package com.mx.Cajero.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mx.Cajero.Dao.IDenominacionesDao;
import com.mx.Cajero.Entity.Denominaciones;

@Service
public class DenominacionServiceImpl implements IDenominacionesService{

	@Autowired
	private IDenominacionesDao dao;
	
	@Override
	public void guardar(Denominaciones deno) {
		dao.save(deno);
	}

	@Override
	public void editar(Denominaciones deno) {
	dao.save(deno);
		
	}

	@Override
	public void eliminar(int idDenominacion) {
	dao.deleteById((long) idDenominacion);
		
	}

	@Override
	public Denominaciones buscar(int idDenominacion) {
		return dao.findById((long) idDenominacion).orElse(null);
	}

	@Override
	public List<Denominaciones> listar() {
		return (List<Denominaciones>) dao.findAll();
	}
	
	//	Metodo personalizado
    // Actualizar la cantidad de una denominacion
    public void actualizarCantidadDenominacion(long idDenominacion, int cantidad) {
        dao.actualizarCantidad(idDenominacion, cantidad);
    }
}
