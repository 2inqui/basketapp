package com.basketball;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

public class BasketballActivity extends Activity implements OnClickListener {
	
	Button equipos;
	Button jugadores;
	Button partidos;
	
	Intent intent;
	
    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
        equipos = (Button) findViewById(R.id.btn_equipo_main);
        equipos.setOnClickListener(this);
        jugadores = (Button) findViewById(R.id.btn_jugador_main);
        jugadores.setOnClickListener(this);
        partidos = (Button) findViewById(R.id.btn_partidos_main);
        partidos.setOnClickListener(this);
    }	

	@Override
	public void onClick(View v) {
		// TODO Auto-generated method stub
		if(v.getId() == R.id.btn_equipo_main){
			intent = new Intent(this,EquiposActivity.class);
			startActivity(intent);
		}
		if(v.getId() == R.id.btn_jugador_main){
			intent = new Intent(this,JugadoresActivity.class);
			startActivity(intent);
		}
		if(v.getId() == R.id.btn_partidos_main){
			intent = new Intent(this,PartidoActivity.class);
			startActivity(intent);
		}
	}
}