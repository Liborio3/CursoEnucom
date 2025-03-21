package com.mx.Cajero.Service;

import java.util.List;


import com.mx.Cajero.Entity.Transacciones;

public interface ITransaccionesService {
	

	public void guardar(Transacciones tra);

	public void editar(Transacciones tra);

	public void eliminar(int idTransaccion);

	public Transacciones buscar(int idTransaccion);

	public List<Transacciones> listar();
}
