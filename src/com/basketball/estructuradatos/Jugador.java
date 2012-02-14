package com.basketball.estructuradatos;

import java.io.Serializable;

public class Jugador implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private int idJugador;
	private int idEquipo;
	private String nombreJugador;
	private String email;
	private int numeroJugador;
	private int posicionJugador;
	private double estaturaJugador;
	private double pesoJugador;
	private boolean activoJugador;
	
	public Jugador(int idJugador, int idEquipo, String nombreJugador,String email,
			int numeroJugador, int posicionJugador, double estaturaJugador,
			double pesoJugador,boolean activoJugador) {
		super();
		this.idJugador = idJugador;
		this.idEquipo = idEquipo;
		this.nombreJugador = nombreJugador;
		this.email = email;
		this.numeroJugador = numeroJugador;
		this.posicionJugador = posicionJugador;
		this.estaturaJugador = estaturaJugador;
		this.pesoJugador = pesoJugador;
		this.activoJugador = activoJugador;
	}

	public int getIdEquipo() {
		return idEquipo;
	}

	public void setIdEquipo(int idEquipo) {
		this.idEquipo = idEquipo;
	}

	public String getNombreJugador() {
		return nombreJugador;
	}

	public void setNombreJugador(String nombreJugador) {
		this.nombreJugador = nombreJugador;
	}

	public String getEmail(){
		return this.email;
	}
	
	public void setEmail(String email){
		this.email = email;
	}
	
	public int getNumeroJugador() {
		return numeroJugador;
	}

	public void setNumeroJugador(int numeroJugador) {
		this.numeroJugador = numeroJugador;
	}

	public int getPosicionJugador() {
		return posicionJugador;
	}

	public void setPosicionJugador(int posicionJugador) {
		this.posicionJugador = posicionJugador;
	}

	public Double getEstaturaJugador() {
		return estaturaJugador;
	}

	public void setEstaturaJugador(double estaturaJugador) {
		this.estaturaJugador = estaturaJugador;
	}

	public Double getPesoJugador() {
		return pesoJugador;
	}

	public void setPesoJugador(double pesoJugador) {
		this.pesoJugador = pesoJugador;
	}

	public int getIdJugador() {
		return idJugador;
	}

	public void setIdJugador(int idJugador) {
		this.idJugador = idJugador;
	}
	
	public Boolean getActivoJugador() {
		return activoJugador;
	}
}
