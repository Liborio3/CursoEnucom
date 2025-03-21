package com.mx.Provedores.Entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@Table
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Setter

public class Provedores {

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE,generator = "SEQ_ID_PROVEDOR")
	@SequenceGenerator(name = "SEQ_ID_PROVEDOR", sequenceName = "S_ID_PROVEDOR", allocationSize = 1)
	private Long idProvedor;
	private String nombre;
	private Long contacto;
	private String empresa;
	private int tiendaId;
	
	
	public Long getIdProvedor() {
		return idProvedor; 
	}
	public String getNombre() {
		return nombre;
	}
	public Long getContacto() {
		return contacto;
	}
	public String getEmpresa() {
		return empresa;
	}
	public int getTiendaId() {
		return tiendaId;
	}
	
	
}
