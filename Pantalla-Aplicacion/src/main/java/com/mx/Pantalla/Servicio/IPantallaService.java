package com.mx.Pantalla.Servicio;

import java.util.List;

import com.mx.Pantalla.Dominio.Pantalla;

public interface IPantallaService {

	public void guardar(Pantalla pantalla);
	
	public void editar(Pantalla pantalla);
	
	public void eliminar(int IdPantalla);
	
	public Pantalla buscar(int IdPantalla);
	
	public List<Pantalla> listar();
}
