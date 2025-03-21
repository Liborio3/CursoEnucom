package com.mx.Productos.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.orm.ObjectOptimisticLockingFailureException;
import org.springframework.stereotype.Service;

import com.mx.Productos.Dao.IProductosDao;
import com.mx.Productos.Entity.Productos;

@Service
public class ProductosServiceImpl implements IProductosService{

	@Autowired
	private IProductosDao dao;
	
	
	@Override
	public Productos guardar(Productos pro) {
		try {
		return dao.save(pro);
		}catch (ObjectOptimisticLockingFailureException ex) {
            // Manejar la excepción (por ejemplo, lanzar una excepción personalizada)
            throw new RuntimeException("El producto ha sido modificado por otro usuario.", ex);
        }
	}
	
	
	
	@Override
	public Productos editar(Productos pro) {
		Productos aux = this.buscar(pro.getIdProducto());
		if(aux != null) {
			
			return dao.save(pro);
		}
		return null;
	}

	@Override
	public Productos eliminar(Long idProducto) {
	
		Productos aux = this.buscar(idProducto);
		if(aux != null) {
			dao.deleteById(idProducto);
			return aux;
		}
		return aux;
	}

	@Override
	public Productos buscar(Long idProducto) {
	
		return dao.findById(idProducto).orElse(null);
	}

	@Override
	public List<Productos> listar() {
	
		return dao.findAll(Sort.by(Direction.DESC,"idProducto"));
	}
	
	//Metodo personalizado
	public List<Productos>byTiendaId(int tiendaId){
		return dao.findByTiendaId(tiendaId);
	}

}
