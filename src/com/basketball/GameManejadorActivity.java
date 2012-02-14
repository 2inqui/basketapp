package com.basketball;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TimePicker;

import com.basketball.estructuradatos.Equipo;
import com.basketball.estructuradatos.Partido;

public class GameManejadorActivity extends Activity{
	Partido partido;
	EquiposAdapter equipos;
	
	 @Override
	public void onCreate(Bundle savedInstanceState) {
	        super.onCreate(savedInstanceState);
	        setContentView(R.layout.agregar_partido_view);
	        Intent intent = getIntent();
	        equipos = new EquiposAdapter(this);
        	Spinner equipoA = (Spinner) findViewById(R.id.spinner_equipo);
        	equipoA.setAdapter(equipos);
        	Spinner equipoB = (Spinner) findViewById(R.id.spinner_contrincante);
        	equipoB.setAdapter(equipos);
	        if(intent.getSerializableExtra(I.PARTIDO) != null ){
	        	partido = (Partido) intent.getSerializableExtra(I.PARTIDO);
	        	setPartido(partido);
	        }
	    }
	    public void onGuardar(View view){
	
	    	Intent intent = getIntent();
	    	DatePicker fechaPartido = (DatePicker) findViewById(R.id.datePicker1);
	    	TimePicker horaPartido = (TimePicker) findViewById(R.id.timePicker1);
	    	EditText lugarPartido = (EditText) findViewById(R.id.editText_lugar);
	    	Spinner equipoA = (Spinner) findViewById(R.id.spinner_equipo);
	    	Spinner equipoB = (Spinner) findViewById(R.id.spinner_contrincante);
	    	
	    	int dia = fechaPartido.getDayOfMonth();
	    	int mes = fechaPartido.getMonth()+1;
	    	int ano = fechaPartido.getYear();
	    	
	    	int hora = horaPartido.getCurrentHour();
	    	int minuto = horaPartido.getCurrentMinute(); 
	    	
	    	intent.putExtra(I.DIA, dia);
	    	intent.putExtra(I.MES, mes);
	    	intent.putExtra(I.ANO, ano);
	    	intent.putExtra(I.HORA, hora);
	    	intent.putExtra(I.MINUTO, minuto);
	    	intent.putExtra(I.LUGAR_PARTIDO, lugarPartido.getText().toString());
	    	
	    	EquiposAdapter adapter = (EquiposAdapter) equipoA.getAdapter();
	    	
	    	Equipo equipo1 = (Equipo) adapter.getItem(equipoA.getSelectedItemPosition());
	    	intent.putExtra(I.EQUIPO_A, equipo1.getIdEquipo());
	    	
	    	Equipo equipo2 = (Equipo) adapter.getItem(equipoB.getSelectedItemPosition());
	    	intent.putExtra(I.EQUIPO_B, equipo2.getIdEquipo());
	    		    	
	    	Log.v(I.PROJECT,""+equipo1.getIdEquipo());
	    	Log.v(I.PROJECT,""+equipo2.getIdEquipo());
	    	if(intent.getSerializableExtra(I.PARTIDO) != null ){
	    		intent.putExtra(I.PARTIDO, partido);
	    	}
	    	
	    	setResult(RESULT_OK, intent);
	    	finish();
	    }
	    
	    public void onEliminar(View view){
	    	Intent intent = getIntent();
	    	if(intent.getSerializableExtra(I.PARTIDO) != null ){
	    		intent.putExtra(I.PARTIDO, partido);
	    	}
	    	setResult(I.DELETE_GAME,intent);
	    	finish();
	    }
	    
	    public void setPartido(Partido pa){
	    	DatePicker fechaPartido = (DatePicker) findViewById(R.id.datePicker1);
	    	fechaPartido.updateDate(
	    			pa.getFechaPartido().getYear()+1900,
	    			pa.getFechaPartido().getMonth(), 
	    			pa.getFechaPartido().getDate());
	    	
	    	TimePicker horaPartido = (TimePicker) findViewById(R.id.timePicker1);
	    	horaPartido.setCurrentHour(pa.getFechaPartido().getHours());
	    	horaPartido.setCurrentMinute(pa.getFechaPartido().getMinutes());
	    		    	
	    	EditText lugarPartido = (EditText) findViewById(R.id.editText_lugar);
	    	lugarPartido.setText(pa.getLugarPartido());
	    	
	    	Equipo equipoA = (Equipo) getIntent().getSerializableExtra(I.EQUIPO_A);
	    	Equipo equipoB = (Equipo) getIntent().getSerializableExtra(I.EQUIPO_B);
	    	
	    	Spinner equipoASpinner = (Spinner) findViewById(R.id.spinner_equipo);
	    	Spinner equipoBSpinner = (Spinner) findViewById(R.id.spinner_contrincante);
	    	equipoASpinner.setSelection(equipoA.getIdEquipo()-1);
	    	equipoBSpinner.setSelection(equipoB.getIdEquipo()-1);
	    	
	    }
}
