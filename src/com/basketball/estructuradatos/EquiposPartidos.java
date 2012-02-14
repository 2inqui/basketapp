package com.basketball.estructuradatos;

import java.io.Serializable;

public class EquiposPartidos implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private int idEquipo;
	private int idPartido;
	private int puntosEquipo;
	private int faltas;
	private int tirosLibresEquipo;
	private int bloqueos;
	private int asistencias;
	private int rebotes;
	private boolean participo;
	
	public EquiposPartidos(int idEquipo, int idPartido, int puntosEquipo,
			int faltas,int tirosLibresEquipo, int bloqueos, int rebotes, int asistencias, boolean participo) {
		super();
		this.idEquipo = idEquipo;
		this.idPartido = idPartido;
		this.puntosEquipo = puntosEquipo;
		this.faltas = faltas;
		this.setTirosLibresEquipo(tirosLibresEquipo);
		this.bloqueos = bloqueos;
		this.asistencias = asistencias;
		this.rebotes = rebotes;
		this.participo = participo;
	}

	public int getIdEquipo() {
		return idEquipo;
	}

	public void setIdEquipo(int idEquipo) {
		this.idEquipo = idEquipo;
	}

	public int getIdPartido() {
		return idPartido;
	}

	public void setIdPartido(int idPartido) {
		this.idPartido = idPartido;
	}

	public int getPuntosEquipo() {
		return puntosEquipo;
	}

	public void setPuntosEquipo(int puntosEquipo) {
		this.puntosEquipo = puntosEquipo;
	}

	public int getFaltas() {
		return faltas;
	}

	public void setFaltas(int faltas) {
		this.faltas = faltas;
	}

	public int getBloqueos() {
		return bloqueos;
	}

	public void setBloqueos(int bloqueos) {
		this.bloqueos = bloqueos;
	}

	public int getAsistencias() {
		return asistencias;
	}

	public void setAsistencias(int asistencias) {
		this.asistencias = asistencias;
	}

	public int getRebotes() {
		return rebotes;
	}

	public void setRebotes(int rebotes) {
		this.rebotes = rebotes;
	}
	
	public boolean getParticipo(){
		return participo;
	}

	public int getTirosLibresEquipo() {
		return tirosLibresEquipo;
	}

	public void setTirosLibresEquipo(int tirosLibresEquipo) {
		this.tirosLibresEquipo = tirosLibresEquipo;
	}
}
