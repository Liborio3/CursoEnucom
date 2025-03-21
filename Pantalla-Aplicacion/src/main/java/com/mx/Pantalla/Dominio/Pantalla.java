package com.mx.Pantalla.Dominio;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "Pantalla")
public class Pantalla {

	/*
	 * 
	 * CREATE TABLE PANTALLA ( ID_PANTALLA NUMBER, MARCA NVARCHAR2(50), TIPO
	 * NVARCHAR2(50) , TAMAÑO NUMBER(5,2), RESOLUCION NVARCHAR2(20),
	 * TECNOLOGIA_PANEL NVARCHAR2(20), PRECIO NUMBER(7,2) , DESCRIPCION
	 * NVARCHAR2(255), CONSTRAINT PK_PANTALLA PRIMARY KEY (ID_PANTALLA));
	 * 
	 */

	@Id
	@Column(name = "ID_PANTALLA", columnDefinition = "NUMBER")
	private int idPantalla;
	@Column(name = "MARCA", columnDefinition = "NVARCHAR2(50)")
	private String marca;
	@Column(name = "TIPO", columnDefinition = "NVARCHAR2(50)")
	private String tipo;
	@Column(name = "TAMAÑO", columnDefinition = "NUMBER(5,2)")
	private double tamaño;
	@Column(name = "RESOLUCION", columnDefinition = "NVARCHAR2(20)")
	private String resolucion;
	@Column(name = "TECNOLOGIA_PANEL", columnDefinition = "NVARCHAR2(20)")
	private String tecnologiaPanel;
	@Column(name = "PRECIO", columnDefinition = " NUMBER(7,2)")
	private double precio;
	@Column(name = "DESCRIPCION", columnDefinition = " NVARCHAR2(255)")
	private String descripcion;

	public Pantalla() {
	}

	public Pantalla(int pantalla, String marca, String tipo, double tamaño, String resolucion, String tecnologiaPanel,
			double precio, String descripcion) {
		this.idPantalla = pantalla;
		this.marca = marca;
		this.tipo = tipo;
		this.tamaño = tamaño;
		this.resolucion = resolucion;
		this.tecnologiaPanel = tecnologiaPanel;
		this.precio = precio;
		this.descripcion = descripcion;
	}

	@Override
	public String toString() {
		return "Pantalla [pantalla=" + idPantalla + ", marca=" + marca + ", tipo=" + tipo + ", tamaño=" + tamaño
				+ ", resolucion=" + resolucion + ", tecnologiaPanel=" + tecnologiaPanel + ", precio=" + precio
				+ ", descripcion=" + descripcion + "]";
	}

	public int getPantalla() {
		return idPantalla;
	}

	public void setPantalla(int pantalla) {
		this.idPantalla = pantalla;
	}

	public String getMarca() {
		return marca;
	}

	public void setMarca(String marca) {
		this.marca = marca;
	}

	public String getTipo() {
		return tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}

	public double getTamaño() {
		return tamaño;
	}

	public void setTamaño(double tamaño) {
		this.tamaño = tamaño;
	}

	public String getResolucion() {
		return resolucion;
	}

	public void setResolucion(String resolucion) {
		this.resolucion = resolucion;
	}

	public String getTecnologiaPanel() {
		return tecnologiaPanel;
	}

	public void setTecnologiaPanel(String tecnologiaPanel) {
		this.tecnologiaPanel = tecnologiaPanel;
	}

	public double getPrecio() {
		return precio;
	}

	public void setPrecio(double precio) {
		this.precio = precio;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

}
