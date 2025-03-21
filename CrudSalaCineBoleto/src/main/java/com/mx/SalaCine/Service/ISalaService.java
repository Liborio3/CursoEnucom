package com.mx.SalaCine.Service;

import java.util.List;

import com.mx.SalaCine.Entity.Sala;

public interface ISalaService {

	public Sala gurdar(Sala sala);
	
	public Sala editar(Sala sala);
	
	public Sala eliminar(Sala sala);
	
	public Sala buscar(Sala sala);
	
	public List<Sala> listar();
}
