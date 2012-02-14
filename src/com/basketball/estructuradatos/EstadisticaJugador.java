package com.basketball.estructuradatos;

import java.io.Serializable;

public class EstadisticaJugador implements Serializable {

	public EstadisticaJugador(int idJugador, int idPartido,int idEquipo, int puntos,
			int tirosLibres, int tirosDos, int tirosTres, int faltas,
			int bloqueos, int rebotes,int asistencias,int robos, boolean participo) {
		super();
		this.idJugador = idJugador;
		this.idPartido = idPartido;
		this.idEquipo = idEquipo;
		this.puntos = puntos;
		this.tirosLibres = tirosLibres;
		this.tirosDos = tirosDos;
		this.tirosTres = tirosTres;
		this.faltas = faltas;
		this.bloqueos = bloqueos;
		this.rebotes = rebotes;
		this.asistencias = asistencias;
		this.robos = robos;
		this.participo = participo;
	}
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	int idJugador;
	int idPartido;
	int idEquipo;
	int puntos;
	int tirosLibres;
	int tirosDos;
	int tirosTres;
	int faltas;
	int bloqueos;
	int rebotes;
	int asistencias;
	int robos;
	boolean participo;
	public int getIdJugador() {
		return idJugador;
	}
	public void setIdJugador(int idJugador) {
		this.idJugador = idJugador;
	}
	public int getIdPartido() {
		return idPartido;
	}
	public void setIdPartido(int idPartido) {
		this.idPartido = idPartido;
	}
	public int getTirosDos() {
		return tirosDos;
	}
	public void setTirosDos(int puntosDos) {
		this.tirosDos += puntosDos;
	}
	public int getTirosTres() {
		return tirosTres;
	}
	public void setTirosTres(int puntosTres) {
		this.tirosTres += puntosTres;
	}
	public int getFaltas() {
		return faltas;
	}
	public void setFaltas(int faltas) {
		this.faltas += faltas;
	}
	public int getTirosLibres() {
		return tirosLibres;
	}
	public void setTirosLibres(int tirosLibres) {
		this.tirosLibres += tirosLibres;
	}
	public int getBloqueos() {
		return bloqueos;
	}
	public void setBloqueos(int bloqueos) {
		this.bloqueos += bloqueos;
	}
	public int getRebotes() {
		return rebotes;
	}
	public void setRebotes(int rebotes) {
		this.rebotes += rebotes;
	}
	public int getAsistencias() {
		return asistencias;
	}
	public void setAsistencias(int asistencias) {
		this.asistencias += asistencias;
	}
	public boolean isParticipo() {
		return participo;
	}
	public void setParticipo(boolean participo) {
		this.participo = participo;
	}
	public int getIdEquipo(){
		return this.idEquipo;
	}
	public void setIdEquipo(int idEquipo){
		this.idEquipo = idEquipo;
	}
	public int getPuntos(){
		return puntos;
	}
	public void setPuntos(int puntos){
		this.puntos += puntos;
	}
	public int getRobos(){
		return robos;
	}
	public void setRobos(int robos){
		this.robos += robos;
	}
}
