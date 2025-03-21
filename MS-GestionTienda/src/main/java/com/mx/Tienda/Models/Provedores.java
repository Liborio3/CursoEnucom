package com.mx.Tienda.Models;

import lombok.Data;

@Data
public class Provedores {

	private Long idProvedor;
	private String nombre;
	private Long contacto;
	private String empresa;
	private int tiendaId;

}
