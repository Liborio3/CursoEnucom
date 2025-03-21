package com.mx.MusicoAlbum.Entity;

import java.sql.Date;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
@Entity
public class Album {
	/*
	 * CREATE TABLE ALBUM( ID_ALBUM NUMBER, NOMBRE NVARCHAR2(100), TRACKS NUMBER,
	 * FECHA_PUBLICACION DATE, MUSICO_ID NUMBER,
	 * 
	 * CONSTRAINT ID_ALBUM_PK PRIMARY KEY (ID_ALBUM), CONSTRAINT FK_MUSICO_ID
	 * FOREIGN KEY (MUSICO_ID) REFERENCES MUSICO(ID_MUSICO) );
	 */
	@Id
	@Column
	private Long idAlbum;
	@Column
	private String nombre;
	@Column
	private int tracks;
	@Column
	private Date fechaPublicacion;
	@ManyToOne(fetch = FetchType.EAGER) //EAGER = Carga inmediata 
	@JoinColumn(name = "MUSICO_ID")
	private Musico musicoId;

	public Album() {
	}

	public Album(long idAlbum, String nombre, int tracks, Date fechaPublicacion, Musico musicoId) {
		this.idAlbum = idAlbum;
		this.nombre = nombre;
		this.tracks = tracks;
		this.fechaPublicacion = fechaPublicacion;
		this.musicoId = musicoId;
	}

	@Override
	public String toString() {
		return "Album [idAlbum=" + idAlbum + ", nombre=" + nombre + ", tracks=" + tracks + ", fechaPublicacion="
				+ fechaPublicacion + ", musicoId=" + musicoId + "]";
	}

	public long getIdAlbum() {
		return idAlbum;
	}

	public void setIdAlbum(long idAlbum) {
		this.idAlbum = idAlbum;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public int getTracks() {
		return tracks;
	}

	public void setTracks(int tracks) {
		this.tracks = tracks;
	}

	public Date getFechaPublicacion() {
		return fechaPublicacion;
	}

	public void setFechaPublicacion(Date fechaPublicacion) {
		this.fechaPublicacion = fechaPublicacion;
	}

	public Musico getMusicoId() {
		return musicoId;
	}

	public void setMusicoId(Musico musicoId) {
		this.musicoId = musicoId;
	}

}
