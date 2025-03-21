package com.mx.Productos.Service;

import java.util.List;

import com.mx.Productos.Entity.Productos;

public interface IProductosService {

	public Productos guardar(Productos productos);
	
	public Productos editar(Productos productos);
	
	public Productos eliminar(Long idProducto);
	
	public Productos buscar(Long idProducto);
	
	public List<Productos> listar();
}
