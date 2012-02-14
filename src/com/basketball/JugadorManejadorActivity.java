package com.basketball;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.Spinner;

import com.basketball.estructuradatos.Equipo;
import com.basketball.estructuradatos.Jugador;

public class JugadorManejadorActivity extends Activity{
	Jugador jugador;
	EquiposAdapter equipos;
	
	 @Override
	public void onCreate(Bundle savedInstanceState) {
	        super.onCreate(savedInstanceState);
	        setContentView(R.layout.agregar_jugador_view);
	        Intent intent = getIntent();
	        equipos = new EquiposAdapter(this);
	        ArrayAdapter<CharSequence> posiciones = ArrayAdapter.createFromResource(this, R.array.posiciones_array, android.R.layout.simple_spinner_item);
	        Spinner equipo = (Spinner) findViewById(R.id.spinner_equipo);
	    	equipo.setAdapter(equipos);
	    	Spinner posicionJugador = (Spinner) findViewById(R.id.spinner_posiciones);
	    	posicionJugador.setAdapter(posiciones);
	        if(intent.getSerializableExtra(I.JUGADOR) != null ){
	        	jugador = (Jugador) intent.getSerializableExtra(I.JUGADOR);
	        	setJugador(jugador);
	        }
	    }
	    public void onGuardar(View view){
	    	Intent intent = getIntent();
	    	EditText nombreJugador = (EditText) findViewById(R.id.txt_nombre_jugador);
	    	EditText email = (EditText) findViewById(R.id.edit_text_email);
	    	EditText numeroJugador = (EditText) findViewById(R.id.txt_numero_jugador);
	    	EditText estaturaJugador = (EditText) findViewById(R.id.txt_estatura_jugador);
	    	EditText pesoJugador = (EditText) findViewById(R.id.txt_peso_jugador);
	    	Spinner posicionJugador = (Spinner) findViewById(R.id.spinner_posiciones);
	    	CheckBox activoJugador = (CheckBox) findViewById(R.id.checkBox_activo_jugador);
	    	Spinner equipoSpinner = (Spinner) findViewById(R.id.spinner_equipo);
	    	Equipo equipo = (Equipo) equipoSpinner.getAdapter().getItem(equipoSpinner.getSelectedItemPosition());
	    	
	    	intent.putExtra(I.EQUIPO,equipo.getIdEquipo());
	    	intent.putExtra(I.NOMBRE_JUGADOR, nombreJugador.getText().toString());
	    	intent.putExtra(I.EMAIL, email.getText().toString());
	    	intent.putExtra(I.NUMERO_JUGADOR, Integer.parseInt(numeroJugador.getText().toString()));
	    	intent.putExtra(I.ESTATURA_JUGADOR, Double.parseDouble(estaturaJugador.getText().toString()));
	    	
	    	intent.putExtra(I.PESO_JUGADOR, pesoJugador.getText().toString());
	    	
	    	intent.putExtra(I.POSICION_JUGADOR,posicionJugador.getSelectedItemPosition());
	    	intent.putExtra(I.ACTIVO_JUGADOR, activoJugador.isSelected());
	    	
	    	if(intent.getSerializableExtra(I.JUGADOR) != null ){
	    		intent.putExtra(I.JUGADOR, jugador);
	    	}
	    	setResult(RESULT_OK, intent);
	    	finish();
	    }
	    public void onEliminar(View view){
	    	Intent intent = getIntent();
	    	if(intent.getSerializableExtra(I.JUGADOR) != null ){
	    		intent.putExtra(I.JUGADOR, jugador);
	    	}
	    	setResult(I.DELETE_JUGADOR,intent);
	    	finish();
	    }
	    public void setJugador(Jugador ju){
	    	
	    	EditText nombreJugador = (EditText) findViewById(R.id.txt_nombre_jugador);
	    	nombreJugador.setText(""+ju.getNombreJugador());
	    	
	    	EditText email = (EditText) findViewById(R.id.edit_text_email);
	    	email.setText(ju.getEmail());
	    	
	    	EditText numeroJugador = (EditText) findViewById(R.id.txt_numero_jugador);
	    	numeroJugador.setText(""+ju.getNumeroJugador());
	    		    		
	    	EditText estaturaJugador = (EditText) findViewById(R.id.txt_estatura_jugador);
	    	estaturaJugador.setText(""+ju.getEstaturaJugador().toString());
	    	
	    	EditText pesoJugador = (EditText) findViewById(R.id.txt_peso_jugador);
	    	pesoJugador.setText(""+ju.getPesoJugador().toString());
	    	
	    	Spinner equipoJugador = (Spinner) findViewById(R.id.spinner_equipo);
	    	equipoJugador.setSelection(ju.getIdEquipo()-1);
	    	
	    	Spinner posicionJugador = (Spinner) findViewById(R.id.spinner_posiciones);
	    	posicionJugador.setSelection(ju.getPosicionJugador());
	    	
	    	CheckBox activoJugador = (CheckBox) findViewById(R.id.checkBox_activo_jugador);
	    	activoJugador.setSelected(ju.getActivoJugador());
	    }

}
