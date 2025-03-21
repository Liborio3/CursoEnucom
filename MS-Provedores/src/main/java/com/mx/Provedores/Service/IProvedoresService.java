package com.mx.Provedores.Service;

import java.util.List;

import com.mx.Provedores.Entity.Provedores;

public interface IProvedoresService {
	
	public Provedores gurdar(Provedores provedores);
	
	public Provedores editar(Provedores provedores);
	
	public Provedores eliminar(Long idProvedor);
	
	public Provedores buscar(Long idProvedor );
	
	public List<Provedores> listar();

}
