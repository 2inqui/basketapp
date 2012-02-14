package com.basketball;

import java.sql.Timestamp;
import java.util.ArrayList;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.basketball.estructuradatos.Equipo;
import com.basketball.estructuradatos.EquiposPartidos;
import com.basketball.estructuradatos.Jugador;
import com.basketball.estructuradatos.Partido;
import com.basketball.modelo.Modelo;

public class PartidosAdapter extends BaseAdapter {

	ArrayList<Partido> partidos;
	Modelo model;
	
	int lastInserted = 0;
	
	public PartidosAdapter(Context cont){
		model = new Modelo(cont,I.DATABA_BASE,null,I.DATABASE_VERSION);
		partidos = model.getPartidos();
		lastInserted = partidos.size()-1;
	}
	
	@Override
	public int getCount() {
		// TODO Auto-generated method stub
		return partidos.size();
	}

	@Override
	public Partido getItem(int arg0) {
		// TODO Auto-generated method stub
		return partidos.get(arg0);
	}

	@Override
	public long getItemId(int arg0) {
		// TODO Auto-generated method stub
		return partidos.get(arg0).getIdPartido();
	}

	@Override
	public View getView(int position, View view, ViewGroup parent) {
		// TODO Auto-generated method stub
		if(view==null){
			LayoutInflater inflater = LayoutInflater.from(parent.getContext());
			view = inflater.inflate(R.layout.partido_item_list, parent, false);
		}
		
		Partido partido = partidos.get(position);		
		
		EquiposPartidos[] equipos = model.getEquipos(partido.getIdPartido());
		
		TextView textViewEquipoA = (TextView) view.findViewById(R.id.text_view_equipo_a);
		
		Equipo equipoA = model.getEquipo(equipos[0].getIdEquipo());
		textViewEquipoA.setText(equipoA.getNombreEquipo());
		
		Equipo equipoB = model.getEquipo(equipos[1].getIdEquipo());
		
		TextView textViewEquipoB = (TextView) view.findViewById(R.id.text_view_equibo_b);
		textViewEquipoB.setText(equipoB.getNombreEquipo());
		
		TextView textViewFecha = (TextView) view.findViewById(R.id.partido_fecha);
		textViewFecha.setText(partido.getFechaPartido().toString());
		
		return view;
	}
	
	
	public Partido getPartido(int position){
		return partidos.get(position);
	}
	
	public Equipo getEquipoA(int position){
		Partido partido = partidos.get(position);
		EquiposPartidos[] equipos = model.getEquipos(partido.getIdPartido());
		return model.getEquipo(equipos[0].getIdEquipo());
	}
	public Equipo getEquipoB(int position){
		Partido partido = partidos.get(position);
		EquiposPartidos[] equipos = model.getEquipos(partido.getIdPartido());
		return model.getEquipo(equipos[1].getIdEquipo());
	}
	
	public boolean addPartido(Timestamp fecha, String lugar, int idEquipoA, int idEquipoB){
		if(model.insertPartido(fecha, lugar, idEquipoA, idEquipoB)){
			partidos = model.getPartidos();
			lastInserted ++;
			return true;
		}else{
			return false;
		}
	}
	public boolean editPartido(Partido par,int equipoA,int equipoB){
		if(model.updatePartido(par, equipoA, equipoB)){
			partidos = model.getPartidos();
			return true;
		}
		return false;
	}
	
	public String[] getListJugadores(int position){
		String [] listJugadores;
		Equipo equipoA = getEquipoA(position);
		Equipo equipoB = getEquipoB(position);
		ArrayList<Jugador> jugadores = model.getJugadores(equipoA.getIdEquipo(), equipoB.getIdEquipo());
		listJugadores = new String[jugadores.size()];
		for(int i = 0 ; i<jugadores.size();i++){
			listJugadores[i] = jugadores.get(i).getEmail();
		}
		return listJugadores;
	}
	
}
