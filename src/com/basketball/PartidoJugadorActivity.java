package com.basketball;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.TextView;

import com.basketball.estructuradatos.EstadisticaJugador;
import com.basketball.estructuradatos.Jugador;
import com.basketball.estructuradatos.Partido;

public class PartidoJugadorActivity extends Activity implements OnClickListener{

	Jugador jugador;
	Partido partido;
	EstadisticaJugador ej;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.partido_jugador);
		
		Intent intent = getIntent();
		jugador = (Jugador)intent.getSerializableExtra(I.JUGADOR);
		partido = (Partido)intent.getSerializableExtra(I.PARTIDO);
		ej = (EstadisticaJugador)intent.getSerializableExtra(I.ESTADDISTICA_JUGADOR);;
				
		TextView textViewJugador = (TextView) findViewById(R.id.text_view_partido_jugador_nombre);
		textViewJugador.setText(jugador.getNombreJugador());
		TextView textViewNumero = (TextView) findViewById(R.id.text_view_partido_numero_jugador);
		textViewNumero.setText(""+jugador.getNumeroJugador());
		TextView textViewPuntos = (TextView) findViewById(R.id.text_view_partidos_jugador_puntos);
		textViewPuntos.setText(""+ej.getPuntos());
		Button btnAddPuntos = (Button) findViewById(R.id.btn_add_puntos);
		btnAddPuntos.setOnClickListener(this);
		Button btnSubstractPuntos = (Button) findViewById(R.id.btn_substract_puntos);
		btnSubstractPuntos.setOnClickListener(this);
		TextView textViewFaltas = (TextView) findViewById(R.id.text_view_partido_jugador_faltas);
		textViewFaltas.setText(""+ej.getFaltas());
		Button btnAddFaltas = (Button) findViewById(R.id.btn_add_faltas);
		btnAddFaltas.setOnClickListener(this);
		Button btnSubstractFaltas = (Button) findViewById(R.id.btn_substract_faltas);
		btnSubstractFaltas.setOnClickListener(this);
		TextView textViewTirosUno = (TextView) findViewById(R.id.text_view_partido_jugador_tiros_uno);
		textViewTirosUno.setText(""+ej.getTirosLibres());
		Button btnAddTirosUno = (Button) findViewById(R.id.btn_add_tiros_uno);
		btnAddTirosUno.setOnClickListener(this);
		Button btnSubstractTirosUno = (Button) findViewById(R.id.btn_substract_tiros_uno);
		btnSubstractTirosUno.setOnClickListener(this);
		TextView textViewTirosDos = (TextView) findViewById(R.id.text_view_partido_jugador_tiros_dos);
		textViewTirosDos.setText(""+ej.getTirosDos());
		Button btnAddTirosDos = (Button) findViewById(R.id.btn_add_tiros_dos);
		btnAddTirosDos.setOnClickListener(this);
		Button btnSubstractTirosDos = (Button) findViewById(R.id.btn_substract_tiros_dos);
		btnSubstractTirosDos.setOnClickListener(this);
		TextView textViewTirosTres = (TextView) findViewById(R.id.text_view_partido_jugador_tirostres);
		textViewTirosTres.setText(""+ej.getTirosTres());
		Button btnAddTirosTres = (Button) findViewById(R.id.btn_add_tiros_tres);
		btnAddTirosTres.setOnClickListener(this);
		Button btnSubstractTirosTres = (Button) findViewById(R.id.btn_substract_tiros_tres);
		btnSubstractTirosTres.setOnClickListener(this);
		TextView textViewRobos = (TextView) findViewById(R.id.text_view_partido_jugador_robos);
		textViewRobos.setText(""+ej.getRobos());
		Button btnAddRobos = (Button) findViewById(R.id.btn_add_robos);
		btnAddRobos.setOnClickListener(this);
		Button btnSubstractRobos = (Button) findViewById(R.id.btn_substract_robos);
		btnSubstractRobos.setOnClickListener(this);
		TextView textViewRebotes = (TextView) findViewById(R.id.text_view_partido_jugador_rebotes);
		textViewRebotes.setText(""+ej.getRebotes());
		Button btnAddRebotes = (Button) findViewById(R.id.btn_add_rebotes);
		btnAddRebotes.setOnClickListener(this);
		Button btnSubstractRebotes = (Button) findViewById(R.id.btn_substract_rebotes);
		btnSubstractRebotes.setOnClickListener(this);
		TextView textViewAsistencias = (TextView) findViewById(R.id.text_view_partido_jugador_asistencias);
		textViewAsistencias.setText(""+ej.getAsistencias());
		Button btnAddAsistencia = (Button) findViewById(R.id.btn_add_asistencias);
		btnAddAsistencia.setOnClickListener(this);
		Button btnSubstractAsistencia = (Button) findViewById(R.id.btn_substract_asistencias);
		btnSubstractAsistencia.setOnClickListener(this);
		TextView textViewBloqueos = (TextView) findViewById(R.id.text_view_partido_jugador_bloqueos);
		textViewBloqueos.setText(""+ej.getBloqueos());
		Button btnAddBloqueo = (Button) findViewById(R.id.btn_add_bloqueos);
		btnAddBloqueo.setOnClickListener(this);
		Button btnSubstractBloqueo = (Button) findViewById(R.id.btn_substract_bloqueos);
		btnSubstractBloqueo.setOnClickListener(this);
	}
	
	@Override
	public boolean onKeyDown(int keyCode, KeyEvent event) {
	    if ((keyCode == KeyEvent.KEYCODE_BACK)) {
	        Intent intent = getIntent();
	        
			TextView textViewPuntos = (TextView) findViewById(R.id.text_view_partidos_jugador_puntos);
			int puntos = Integer.parseInt(textViewPuntos.getText().toString());
			
			
			
			TextView textViewFaltas = (TextView) findViewById(R.id.text_view_partido_jugador_faltas);
			int faltas = Integer.parseInt(textViewFaltas.getText().toString());
			
			
			
			TextView textViewTirosUno = (TextView) findViewById(R.id.text_view_partido_jugador_tiros_uno);
			int tirosUno = Integer.parseInt(textViewTirosUno.getText().toString());
			
			
			TextView textViewTirosDos = (TextView) findViewById(R.id.text_view_partido_jugador_tiros_dos);
			int tirosDos = Integer.parseInt(textViewTirosDos.getText().toString());
			
			
			TextView textViewTirosTres = (TextView) findViewById(R.id.text_view_partido_jugador_tirostres);
			int tirosTres = Integer.parseInt(textViewTirosTres.getText().toString());
			
			
			TextView textViewRobos = (TextView) findViewById(R.id.text_view_partido_jugador_robos);
			int robos = Integer.parseInt(textViewRobos.getText().toString());
			
			
			TextView textViewRebotes = (TextView) findViewById(R.id.text_view_partido_jugador_rebotes);
			int rebotes = Integer.parseInt(textViewRebotes.getText().toString());
			
			
			TextView textViewAsistencias = (TextView) findViewById(R.id.text_view_partido_jugador_asistencias);
			int asistencias = Integer.parseInt(textViewAsistencias.getText().toString());
			
			
			TextView textViewBloqueos = (TextView) findViewById(R.id.text_view_partido_jugador_bloqueos);
			int bloqueos = Integer.parseInt(textViewBloqueos.getText().toString());
			
			EstadisticaJugador ej = new EstadisticaJugador(jugador.getIdJugador(), partido.getIdPartido(), jugador.getIdEquipo(), puntos, tirosUno, tirosDos, tirosTres, faltas, bloqueos, rebotes, asistencias, robos, true);
			
			intent.putExtra(I.ESTADDISTICA_JUGADOR, ej);
			
			setResult(RESULT_OK,intent);
			finish();
			
	    }
	    return super.onKeyDown(keyCode, event);
	}

	@Override
	public void onClick(View view) {
		// TODO Auto-generated method stub
		TextView txtView  = null;
		int cant = 0;
		switch(view.getId()){
			case R.id.btn_add_puntos:
				txtView = (TextView) findViewById(R.id.text_view_partidos_jugador_puntos);
				cant = Integer.parseInt(txtView.getText().toString());
				cant ++;
				break;
			case R.id.btn_substract_puntos:
				txtView = (TextView) findViewById(R.id.text_view_partidos_jugador_puntos);
				cant = Integer.parseInt(txtView.getText().toString());
				cant --;
				break;
			case R.id.btn_add_faltas:
				txtView = (TextView) findViewById(R.id.text_view_partido_jugador_faltas);
				cant = Integer.parseInt(txtView.getText().toString());
				cant ++;
				break;
			case R.id.btn_substract_faltas:
				txtView = (TextView) findViewById(R.id.text_view_partido_jugador_faltas);
				cant = Integer.parseInt(txtView.getText().toString());
				cant --;
				break;
			case R.id.btn_add_rebotes:
				txtView = (TextView) findViewById(R.id.text_view_partido_jugador_rebotes);
				cant = Integer.parseInt(txtView.getText().toString());
				cant ++;
				break;
			case R.id.btn_substract_rebotes:
				txtView = (TextView) findViewById(R.id.text_view_partido_jugador_rebotes);
				cant = Integer.parseInt(txtView.getText().toString());
				cant --;
				break;
			case R.id.btn_add_bloqueos:
				txtView = (TextView) findViewById(R.id.text_view_partido_jugador_bloqueos);
				cant = Integer.parseInt(txtView.getText().toString());
				cant ++;
				break;
			case R.id.btn_substract_bloqueos:
				txtView = (TextView) findViewById(R.id.text_view_partido_jugador_bloqueos);
				cant = Integer.parseInt(txtView.getText().toString());
				cant --;
				break;
			case R.id.btn_add_robos:
				txtView = (TextView) findViewById(R.id.text_view_partido_jugador_robos);
				cant = Integer.parseInt(txtView.getText().toString());
				cant ++;
				break;
			case R.id.btn_substract_robos:
				txtView = (TextView) findViewById(R.id.text_view_partido_jugador_robos);
				cant = Integer.parseInt(txtView.getText().toString());
				cant --;
				break;
			case R.id.btn_add_tiros_uno:
				txtView = (TextView) findViewById(R.id.text_view_partido_jugador_tiros_uno);
				cant = Integer.parseInt(txtView.getText().toString());
				cant ++;
				break;
			case R.id.btn_substract_tiros_uno:
				txtView = (TextView) findViewById(R.id.text_view_partido_jugador_tiros_uno);
				cant = Integer.parseInt(txtView.getText().toString());
				cant --;
				break;
			case R.id.btn_add_tiros_dos:
				txtView = (TextView) findViewById(R.id.text_view_partido_jugador_tiros_dos);
				cant = Integer.parseInt(txtView.getText().toString());
				cant ++;
				break;
			case R.id.btn_substract_tiros_dos:
				txtView = (TextView) findViewById(R.id.text_view_partido_jugador_tiros_dos);
				cant = Integer.parseInt(txtView.getText().toString());
				cant --;
				break;
			case R.id.btn_add_tiros_tres:
				txtView = (TextView) findViewById(R.id.text_view_partido_jugador_tirostres);
				cant = Integer.parseInt(txtView.getText().toString());
				cant ++;
				break;
			case R.id.btn_substract_tiros_tres:
				txtView = (TextView) findViewById(R.id.text_view_partido_jugador_tirostres);
				cant = Integer.parseInt(txtView.getText().toString());
				cant --;
				break;
		}
		txtView.setText(""+cant);
	}
	
}
