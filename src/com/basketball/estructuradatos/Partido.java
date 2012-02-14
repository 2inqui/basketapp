package com.basketball.estructuradatos;

import java.io.Serializable;
import java.sql.Timestamp;

public class Partido implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private int idPartido;
	private Timestamp fechaPartido;
	private String lugarPartido;
	private boolean activo;
	
	public Partido(int idPartido, Timestamp fechaPartido,
			String lugarPartido, boolean activo) {
		super();
		this.idPartido = idPartido;
		this.fechaPartido = fechaPartido;
		this.lugarPartido = lugarPartido;
		this.activo = activo;
	}

	public int getIdPartido() {
		return idPartido;
	}

	public void setIdPartido(int ifPartido) {
		this.idPartido = ifPartido;
	}

	public Timestamp getFechaPartido() {
		return fechaPartido;
	}

	public void setFechaPartido(Timestamp fechaPartido) {
		this.fechaPartido = fechaPartido;
	}

	public String getLugarPartido() {
		return lugarPartido;
	}

	public void setLugarPartido(String lugarPartido) {
		this.lugarPartido = lugarPartido;
	}

	public boolean isActivo() {
		return activo;
	}

	public void setActivo(boolean activo) {
		this.activo = activo;
	}

	
}
