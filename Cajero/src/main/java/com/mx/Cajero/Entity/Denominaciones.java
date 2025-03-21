package com.mx.Cajero.Entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Getter
@Setter
public class Denominaciones {

	/*
	 * CREATE TABLE DENOMINACIONES( 
	 * ID_DENOMINACION NUMBER, 
	 * TIPO NVARCHAR2 (20),
	 * VALOR NUMBER, 
	 * CANTIDAD NUMBER, 
	 * CONSTRAINT ID_DENOMINACION_PK PRIMARY KEY(ID_DENOMINACION) );
	 */
	
	@Id
	private Long idDenominacion;
	private String tipo;
	private double valor;
	private int cantidad;
	


}
