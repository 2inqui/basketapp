package com.basketball;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.Button;
import android.widget.Chronometer;
import android.widget.ListView;
import android.widget.TextView;

import com.basketball.estructuradatos.Equipo;
import com.basketball.estructuradatos.EstadisticaJugador;
import com.basketball.estructuradatos.Jugador;
import com.basketball.estructuradatos.Partido;

public class PartidoManagerActivity extends Activity implements OnClickListener,OnItemClickListener{
	
	JugadoresAdapter jugadores;
	
	boolean auxCron = false;// Indica si el cronometro esta corriendo
	Chronometer cron;
	
	Button btnCronometro;
	
	Equipo equipoA;
	Equipo equipoB;
	
	Partido partido;
	
	PartidoManagerAdapter adapter;
	
	/** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.partido_view);
        
        cron = (Chronometer) findViewById(R.id.partido_chronometer);
        btnCronometro = (Button) findViewById(R.id.btn_cronometro);
        btnCronometro.setOnClickListener(this);
        btnCronometro.setText("Start");
        
        Intent intent = getIntent();
        partido = (Partido) intent.getSerializableExtra(I.PARTIDO);
        adapter = new PartidoManagerAdapter(this,partido);
        equipoA = adapter.getEquipoA();
        equipoB = adapter.getEquipoB();
        setPartido(partido);
        
        ListView listView = (ListView) findViewById(R.id.partido_jugadores_list);
        jugadores = new JugadoresAdapter(this,equipoA.getIdEquipo(),equipoB.getIdEquipo());
        listView.setAdapter(jugadores);
        listView.setOnItemClickListener(this);
        TextView puntosA = (TextView) findViewById(R.id.textView4);
		puntosA.setText(""+adapter.getPuntosEquipoA());
		TextView puntosB = (TextView) findViewById(R.id.TextView01);
		puntosB.setText(""+adapter.getPuntosEquipoB());
        
    }

	private void setPartido(Partido partido) {
		// TODO Auto-generated method stub
		TextView textViewEquipoA = (TextView) findViewById(R.id.textView2);
		textViewEquipoA.setText(equipoA.getNombreEquipo());
		TextView textViewEquipoB = (TextView) findViewById(R.id.textView3);
		textViewEquipoB.setText(equipoB.getNombreEquipo());
	}
	
	@Override
	public void onClick(View view) {
		// TODO Auto-generated method stub
		if(view.getId() == R.id.btn_cronometro){
			if(!auxCron){
				cron.start();
				btnCronometro.setText("Stop");
				auxCron = true;
			}else{
				cron.stop();
				btnCronometro.setText("Start");
				auxCron = false;
			}
		}
	}

	@Override
	public void onItemClick(AdapterView<?> arg0, View arg1, int arg2, long arg3) {
		// TODO Auto-generated method stub
		Intent intent = new Intent(this,PartidoJugadorActivity.class);
		Jugador jug = (Jugador)arg0.getAdapter().getItem(arg2);
		EstadisticaJugador ej = adapter.getEstadisticasJugador(jug);
		intent.putExtra(I.JUGADOR, jug);
		intent.putExtra(I.PARTIDO, partido);
		intent.putExtra(I.ESTADDISTICA_JUGADOR, ej);
		startActivityForResult(intent,I.ADD_ESTADISTICA_JUGADOR);
	}

	@Override
	protected void onActivityResult(int requestCode, int resultCode, Intent data) {
		// TODO Auto-generated method stub
		if(requestCode == I.ADD_ESTADISTICA_JUGADOR && resultCode == RESULT_OK){
			EstadisticaJugador ej =(EstadisticaJugador) data.getSerializableExtra(I.ESTADDISTICA_JUGADOR);
			adapter.setEstadisticaJugador(ej);
			TextView puntosA = (TextView) findViewById(R.id.textView4);
			puntosA.setText(""+adapter.getPuntosEquipoA());
			TextView puntosB = (TextView) findViewById(R.id.TextView01);
			puntosB.setText(""+adapter.getPuntosEquipoB());
			
		}
	}	
	
}
