package com.mx.MusicoAlbum.Entity;

import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "MUSICO")
public class Musico {
	/*
	 * 
	 * CREATE TABLE MUSICO ( ID_MUSICO NUMBER, NOMBRE NVARCHAR2(100), GENERO
	 * NVARCHAR2(50), PAIS NVARCHAR2(50),
	 * 
	 * CONSTRAINT ID_MUSICO_PK PRIMARY KEY(ID_MUSICO) );
	 */
	@Id
	@Column
	private long idMusico;
	@Column
	private String nombre;
	@Column
	private String genero;
	@Column
	private String pais;

	//Referencia a la otra tabla
	@OneToMany(mappedBy="musicoId",cascade=CascadeType.ALL)
	List<Album> lista = new ArrayList<>();
	
	public Musico() {
	}

	public Musico(long idMusico, String nombre, String genero, String pais) {
		this.idMusico = idMusico;
		this.nombre = nombre;
		this.genero = genero;
		this.pais = pais;
	}

	@Override
	public String toString() {
		return "Musico [idMusico=" + idMusico + ", nombre=" + nombre + ", genero=" + genero + ", pais=" + pais + "]";
	}

	public long getIdMusico() {
		return idMusico;
	}

	public void setIdMusico(long idMusico) {
		this.idMusico = idMusico;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getGenero() {
		return genero;
	}

	public void setGenero(String genero) {
		this.genero = genero;
	}

	public String getPais() {
		return pais;
	}

	public void setPais(String pais) {
		this.pais = pais;
	}

}
