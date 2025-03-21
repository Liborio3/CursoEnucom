package com.mx.SalaCine.Entity;

import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "SALA_CINE")
public class Sala {

	/*
	 * CREATE TABLE SALA_CINE(
	 * 
	 * ID_SALA NUMBER, 
	 * NO_ASIENTOS NUMBER, 
	 * TIPO_PANTALLA NVARCHAR2(50), 
	 * CATEGORIA NVARCHAR2(50),
	 * 
	 * CONSTRAINT ID_SALA_PK PRIMARY KEY (ID_SALA)
	 * 
	 * );
	 * 
	 */
	
	@Id
	@Column
	private long idSala;
	@Column
	private int noAsientos;
	@Column
	private String tipoPantalla;
	@Column
	private String categoria;
	
	//Referencia a la otra tabla
	@OneToMany(mappedBy= "salaId",cascade = CascadeType.ALL)
	List<Boleto> lista = new ArrayList<>();
	
	public Sala(long idSala, int noAsientos, String tipoPantalla, String categoria) {

		this.idSala = idSala;
		this.noAsientos = noAsientos;
		this.tipoPantalla = tipoPantalla;
		this.categoria = categoria;
	}

	public Sala() {

	}

	@Override
	public String toString() {
		return "Sala [idSala=" + idSala + ", noAsientos=" + noAsientos + ", tipoPantalla=" + tipoPantalla
				+ ", categoria=" + categoria + "]";
	}

	public long getIdSala() {
		return idSala;
	}

	public void setIdSala(int idSala) {
		this.idSala = idSala;
	}

	public int getNoAsientos() {
		return noAsientos;
	}

	public void setNoAsientos(int noAsientos) {
		this.noAsientos = noAsientos;
	}

	public String getTipoPantalla() {
		return tipoPantalla;
	}

	public void setTipoPantalla(String tipoPantalla) {
		this.tipoPantalla = tipoPantalla;
	}

	public String getCategoria() {
		return categoria;
	}

	public void setCategoria(String categoria) {
		this.categoria = categoria;
	}
	
	
	
}
