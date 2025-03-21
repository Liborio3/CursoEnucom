package com.mx.Cajero.Service;

import java.util.List;

import com.mx.Cajero.Entity.Denominaciones;

public interface IDenominacionesService {

	public void guardar(Denominaciones deno);

	public void editar(Denominaciones deno);

	public void eliminar(int idDenominacion);

	public Denominaciones buscar(int idDenominacion);

	public List<Denominaciones> listar();

}
