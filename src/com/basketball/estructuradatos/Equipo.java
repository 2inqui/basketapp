package com.basketball.estructuradatos;

import java.io.Serializable;

import android.os.Parcel;


public class Equipo implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	int idEquipo;
	String nombreEquipo;
	String categoriaEquipo;
	boolean activo;
	
	public Equipo(Parcel in){
		
	}
	
	public Equipo(int idEquipo,String nombreEquipo,String categoriaEquipo,boolean activo){
		this.idEquipo = idEquipo;
		this.nombreEquipo = nombreEquipo;
		this.categoriaEquipo = categoriaEquipo;
	}
	
	public void setNombreEquipo(String nombre){
		nombreEquipo = nombre;
	}
	public void setCategoriaEquipo(String categoria){
		categoriaEquipo = categoria;
	}
	
	public int getIdEquipo(){
		return idEquipo;
	}
	public String getNombreEquipo(){
		return nombreEquipo;
	}
	public String getCategoriaEquipo(){
		return categoriaEquipo;
	}
	public boolean isActivo(){
		return activo;
	}
	
}
