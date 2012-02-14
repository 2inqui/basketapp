package com.basketball;

import java.util.ArrayList;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.SpinnerAdapter;
import android.widget.TextView;

import com.basketball.estructuradatos.Equipo;
import com.basketball.modelo.Modelo;

public class EquiposAdapter extends BaseAdapter implements SpinnerAdapter{
	
	Modelo model;
	ArrayList<Equipo> equipos;
	
	public EquiposAdapter(Context context){
		model = new Modelo(context, I.DATABA_BASE, null, I.DATABASE_VERSION);
		equipos = model.getEquipos();
	}

	@Override
	public int getCount() {
		// TODO Auto-generated method stub
		return equipos.size();
	}

	@Override
	public Object getItem(int position) {
		// TODO Auto-generated method stub
		return equipos.get(position);
	}

	@Override
	public long getItemId(int position) {
		// TODO Auto-generated method stub
		return equipos.get(position).getIdEquipo();
	}

	@Override
	public View getView(int position, View view, ViewGroup parent) {
		// TODO Auto-generated method stub
		if(view==null){
			LayoutInflater inflater = LayoutInflater.from(parent.getContext());
			view = inflater.inflate(R.layout.equipo_item_list, parent, false);
		}
		Equipo equipo = equipos.get(position);
				
		TextView nombreTextView = (TextView) view.findViewById(R.id.text_view_nombre_equipo);
		nombreTextView.setText(equipo.getNombreEquipo());
		TextView categoriaEquipo = (TextView) view.findViewById(R.id.textview_equipo_categoria);
		categoriaEquipo.setText(equipo.getCategoriaEquipo());
		return view;
	}
	public boolean addEquipo(String nombre,String categoria){
		if(model.insertaEquipo(nombre, categoria)){
			equipos = model.getEquipos();
			return true;
		}else{
			return false;
		}
	}
	public boolean editaEquipo(Equipo equipo,int position){
		if(model.updateEquipo(equipo.getIdEquipo(), equipo.getNombreEquipo(), equipo.getCategoriaEquipo(), true)){
			equipos.set(position, equipo);
			return true;
		}
		return false;
	}
	public boolean eliminaEquipo(int position){
		if(model.deleteEquipo(equipos.get(position).getIdEquipo())){
			equipos = model.getEquipos();
			return true;
		}
		return false;
	}

}
