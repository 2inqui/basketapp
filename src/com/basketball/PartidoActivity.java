package com.basketball;

import java.sql.Timestamp;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ListView;

import com.basketball.estructuradatos.Partido;

public class PartidoActivity extends Activity implements OnItemClickListener{

	PartidosAdapter adapter;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.partidos_list);
		adapter = new PartidosAdapter(this);
		ListView listView = (ListView) findViewById(R.id.partidos_list_view);
		listView.setAdapter(adapter);
		listView.setOnItemClickListener(this);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// TODO Auto-generated method stub
		super.onCreateOptionsMenu(menu);
		MenuInflater menuInflater = getMenuInflater();
    	menuInflater.inflate(R.menu.partidos_menu, menu);
		return true;
	}

	@Override
	public void onItemClick(AdapterView<?> adapter, View view, int position, long arg3) {
		// TODO Auto-generated method stub
		final PartidoActivity aux = this;
		final PartidosAdapter auxAdapter = (PartidosAdapter) adapter.getAdapter();
		final int auxPosition = position;
		AlertDialog.Builder builder = new AlertDialog.Builder(this);
		builder.setMessage("Que deseas Hacer?")
		       .setCancelable(false)
		       .setPositiveButton("Editar", new DialogInterface.OnClickListener() {
		           @Override
				public void onClick(DialogInterface dialog, int id) {
		        	   Intent intent = new Intent(aux,GameManejadorActivity.class);
		               	intent.putExtra(I.PARTIDO, auxAdapter.getPartido(auxPosition));
		               	intent.putExtra(I.EQUIPO_A, auxAdapter.getEquipoA(auxPosition));
		               	intent.putExtra(I.EQUIPO_B, auxAdapter.getEquipoB(auxPosition));
		               	aux.startActivityForResult(intent,I.EDIT_GAME);
		           }
		       })
		       .setNegativeButton("Jugar", new DialogInterface.OnClickListener() {
		           @Override
				public void onClick(DialogInterface dialog, int id) {
		               	Intent intent = new Intent(aux,PartidoManagerActivity.class);
		               	intent.putExtra(I.PARTIDO, auxAdapter.getPartido(auxPosition));
		               	aux.startActivity(intent);
		           }
		       }).setNeutralButton("Notificar Jugadores", new DialogInterface.OnClickListener() {
		           @Override
				public void onClick(DialogInterface dialog, int id) {
		        	   Partido partido = auxAdapter.getItem(auxPosition);
		        	   String jugadoresMail[] =  auxAdapter.getListJugadores(auxPosition);
		        	   final Intent emailIntent = new Intent(android.content.Intent.ACTION_SEND);
	                     emailIntent.setType("plain/text");
	                     emailIntent.putExtra(android.content.Intent.EXTRA_EMAIL, jugadoresMail);
	                     emailIntent.putExtra(android.content.Intent.EXTRA_SUBJECT, "Partido de basketball");
	                     emailIntent.putExtra(android.content.Intent.EXTRA_TEXT, "Tenemos partido el "+partido.getFechaPartido()+" en "+partido.getLugarPartido());
	                     PartidoActivity.this.startActivity(Intent.createChooser(emailIntent, "Send mail..."));
		           }
		       });
		
		AlertDialog alert = builder.create();
		alert.show();
	}
	
	@Override
	public boolean onMenuItemSelected(int featured, MenuItem item)
    {
    	if(item.getItemId() == R.id.partido_agregar_menu) 
    	{
    		Intent intent = new Intent(this,GameManejadorActivity.class);
    		startActivityForResult(intent, I.ADD_GAME);
    	}
    	if(item.getItemId() == R.id.partido_buscar_menu){
    		
    	}
    	return super.onOptionsItemSelected(item);
    }

	@Override
	protected void onActivityResult(int requestCode, int resultCode, Intent data) {
		// TODO Auto-generated method stub
		if(requestCode == I.ADD_GAME && resultCode == RESULT_OK){
			int dia = data.getIntExtra(I.DIA, 0);
			int mes = data.getIntExtra(I.MES, 0);
			int ano = data.getIntExtra(I.ANO, 0);
			int hora = data.getIntExtra(I.HORA, 0);
			int minuto = data.getIntExtra(I.MINUTO, 0);
			Timestamp fecha = new Timestamp(ano-1900,mes-1,dia,hora,minuto,0,0);
			String lugar = data.getStringExtra(I.LUGAR_PARTIDO);
			int idEquipoA = data.getIntExtra(I.EQUIPO_A, 0);
			int idEquipoB = data.getIntExtra(I.EQUIPO_B, 0);
			adapter.addPartido(fecha, lugar, idEquipoA, idEquipoB);
			adapter.notifyDataSetChanged();
			ListView listView = (ListView) findViewById(R.id.partidos_list_view);
			listView.requestLayout();
		}
		if(requestCode == I.EDIT_GAME && resultCode == RESULT_OK){
			int dia = data.getIntExtra(I.DIA, 0);
			int mes = data.getIntExtra(I.MES, 0);
			int ano = data.getIntExtra(I.ANO, 0);
			int hora = data.getIntExtra(I.HORA, 0);
			int minuto = data.getIntExtra(I.MINUTO, 0);
			
			Timestamp fecha = new Timestamp(ano-1900,mes-1,dia,hora,minuto,0,0);
			
			String lugar = data.getStringExtra(I.LUGAR_PARTIDO);
			int idEquipoA = data.getIntExtra(I.EQUIPO_A, 0);
			int idEquipoB = data.getIntExtra(I.EQUIPO_B, 0);
			Partido par = (Partido) data.getSerializableExtra(I.PARTIDO);
			par.setFechaPartido(fecha);
			par.setLugarPartido(lugar);
			adapter.editPartido(par,idEquipoA,idEquipoB);
			adapter.notifyDataSetChanged();
			ListView listView = (ListView) findViewById(R.id.partidos_list_view);
			listView.requestLayout();
		}
		
	}
	
}
