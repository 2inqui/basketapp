package com.basketball;

import java.io.Serializable;
import java.util.ArrayList;

import android.content.Context;

import com.basketball.estructuradatos.Equipo;
import com.basketball.estructuradatos.EquiposPartidos;
import com.basketball.estructuradatos.EstadisticaJugador;
import com.basketball.estructuradatos.Jugador;
import com.basketball.estructuradatos.Partido;
import com.basketball.modelo.Modelo;

public class PartidoManagerAdapter implements Serializable{
	
	private static final long serialVersionUID = 1L;
	
	ArrayList<EstadisticaJugador> estadisticas;
	
	Partido partido;
	
	Equipo equipoA ;
	Equipo equipoB ;
	
	Modelo model;
	
	public PartidoManagerAdapter(Context con,Partido par){
		model = new Modelo(con,I.DATABA_BASE,null,I.DATABASE_VERSION);
		partido = par;
		estadisticas = model.getEstadisticasPartido(par);
		equipoA = getEquipoA();
		equipoB = getEquipoB();
	}
	
	public void addPuntos(Jugador jug, int puntos){
		model.addPuntosJugador(partido, jug, puntos);
	}
	public void setEstadisticaJugador(EstadisticaJugador ej){
		model.updateEstadisticaJugador(ej);
		estadisticas = model.getEstadisticasPartido(partido);
	}
	
	public int getPuntosEquipoA(){
		int puntos = 0;
		for(EstadisticaJugador ej: estadisticas){
			if(ej.getIdEquipo() == equipoA.getIdEquipo()){
				puntos += ej.getPuntos();
			}
		}
		return puntos;
	}
	public int getPuntosEquipoB(){
		int puntos = 0;
		for(EstadisticaJugador ej: estadisticas){
			if(ej.getIdEquipo() == equipoB.getIdEquipo()){
				puntos += ej.getPuntos();
			}
		}
		return puntos;
	}
	
	//**Mark**//
	public EstadisticaJugador getEstadisticasJugador(Jugador jug){
		for(EstadisticaJugador ej : estadisticas){
			if(ej.getIdJugador() == jug.getIdJugador())
				return ej;
		}
		EstadisticaJugador ej = new EstadisticaJugador(jug.getIdJugador(),
				partido.getIdPartido(),
				jug.getIdEquipo(),
				0,0,0,0,0,0,0,0,0,true);
		model.insertaEstadisticaJugador(ej);
		estadisticas = model.getEstadisticasPartido(partido);
		return getEstadisticasJugador(jug);
	}
	
	public Equipo getEquipoA(){
		EquiposPartidos[] equipos = model.getEquipos(partido.getIdPartido());
		return model.getEquipo(equipos[0].getIdEquipo());
	}
	public Equipo getEquipoB(){
		EquiposPartidos[] equipos = model.getEquipos(partido.getIdPartido());
		return model.getEquipo(equipos[1].getIdEquipo());
	}
		
}
