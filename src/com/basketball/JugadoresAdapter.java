package com.basketball;

import java.util.ArrayList;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.basketball.estructuradatos.Jugador;
import com.basketball.modelo.Modelo;

public class JugadoresAdapter extends BaseAdapter{

	Modelo model;
	ArrayList<Jugador> jugadores;
	
	public JugadoresAdapter(Context con){
		model = new Modelo(con, I.DATABA_BASE, null, I.DATABASE_VERSION);
		jugadores = model.getJugadores();
	}
	
	public JugadoresAdapter(Context con,
			int idEquipo, int idEquipo2) {
		// TODO Auto-generated constructor stub
		model = new Modelo(con, I.DATABA_BASE, null, I.DATABASE_VERSION);
		jugadores = model.getJugadores(idEquipo,idEquipo2);
	}

	@Override
	public int getCount() {
		// TODO Auto-generated method stub
		return jugadores.size();
	}

	@Override
	public Jugador getItem(int arg0) {
		// TODO Auto-generated method stub
		return jugadores.get(arg0);
	}

	@Override
	public long getItemId(int arg0) {
		// TODO Auto-generated method stub
		return jugadores.get(arg0).getIdJugador();
	}

	@Override
	public View getView(int position, View view, ViewGroup parent) {
		// TODO Auto-generated method stub
		if(view==null){
			LayoutInflater inflater = LayoutInflater.from(parent.getContext());
			view = inflater.inflate(R.layout.jugador_item_list, parent, false);
		}
		Jugador jug = jugadores.get(position);
		TextView nombreTextView = (TextView) view.findViewById(R.id.text_view_jugador_nombre);
		nombreTextView.setText(jug.getNombreJugador());
		TextView numeroTextView = (TextView) view.findViewById(R.id.text_view_numero_jugador_aux);
		numeroTextView.setText(""+jug.getNumeroJugador());
		TextView posicionTextView = (TextView) view.findViewById(R.id.text_view_posicion_jugador_aux);
		posicionTextView.setText(I.getStringPosicionJugador(jug.getPosicionJugador()));
		return view;
	}
	

	public boolean addJugador(Integer equipo, 
			String nombreJugador,
			String email,
			Integer numero,
			Integer posicion,
			Double estatura,
			Double peso,
			Boolean activo){
		if(model.insertaJugardor(equipo, nombreJugador,email, numero, posicion, estatura, peso, activo)){
			jugadores = model.getJugadores();
			return true;
		}else{
			return false;
		}
	}
	public boolean editaJugador(Jugador jugador, int posicion){
		if(model.updateJugardor(jugador.getIdJugador(),jugador.getIdEquipo(), jugador.getNombreJugador(),jugador.getEmail(), jugador.getNumeroJugador(), jugador.getPosicionJugador(), jugador.getEstaturaJugador(), jugador.getPesoJugador(), jugador.getActivoJugador())){
			jugadores.set(posicion, jugador);
			return true;
		}
		return false;
	}
	public boolean eliminaJugador(int position){
		if(model.deleteJugador(jugadores.get(position).getIdJugador())){
			jugadores.remove(position);
			return true;
		}
		return false;
	}

}
