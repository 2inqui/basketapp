package com.basketball;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

import com.basketball.estructuradatos.Equipo;

public class EquipoManejadorActivity extends Activity {
	
	Equipo equipo;
	
	 /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.agregar_equipo_view);
        Intent intent = getIntent();
        if(intent.getSerializableExtra(I.EQUIPO) != null ){
        	equipo = (Equipo) intent.getSerializableExtra(I.EQUIPO);
        	setEquipo(equipo);
        }
    }
    public void onGuardar(View view){
    	Intent intent = getIntent();
    	EditText nombreEquipo = (EditText) findViewById(R.id.txt_nombre_equipo);
    	EditText categoriaEquipo = (EditText) findViewById(R.id.txt_categoria_equipo);
    	intent.putExtra(I.NOMBRE_EQUIPO, nombreEquipo.getText().toString());
    	intent.putExtra(I.CATEGORIA_EQUIPO, categoriaEquipo.getText().toString());
    	//Para cuando se esta editando
    	if(intent.getSerializableExtra(I.EQUIPO) != null ){
    		intent.putExtra(I.EQUIPO, equipo);
    	}
    	setResult(RESULT_OK, intent);
    	finish();
    }
    public void onEliminar(View view){
    	Intent intent = getIntent();
    	if(intent.getSerializableExtra(I.EQUIPO) != null ){
    		intent.putExtra(I.EQUIPO, equipo);
    	}
    	setResult(I.DELETE_EQUIPO,intent);
    	finish();
    }
    public void setEquipo(Equipo eq){
    	EditText nombreEquipo = (EditText) findViewById(R.id.txt_nombre_equipo);
    	nombreEquipo.setText(eq.getNombreEquipo());
    	EditText categoriaEquipo = (EditText) findViewById(R.id.txt_categoria_equipo);
    	categoriaEquipo.setText(eq.getCategoriaEquipo());
    }
	
}
