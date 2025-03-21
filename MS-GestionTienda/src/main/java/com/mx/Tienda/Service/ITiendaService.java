package com.mx.Tienda.Service;

import java.util.List;

import com.mx.Tienda.Entity.Tienda;

public interface ITiendaService {
	
	public Tienda guardar(Tienda tienda);
	
	public Tienda editar(Tienda tienda);
	
	public Tienda eliminar(Integer idTienda);
	
	public Tienda buscar(Integer idTienda); 
	
	public List<Tienda> listar();

}
