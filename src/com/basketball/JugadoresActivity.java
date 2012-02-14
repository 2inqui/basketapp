package com.basketball;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ListView;

import com.basketball.estructuradatos.Jugador;

public class JugadoresActivity extends Activity implements OnItemClickListener{
	
	JugadoresAdapter adapter;
	
	/** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.jugadores_list);
        ListView listView = (ListView) findViewById(R.id.jugadores_list);
        adapter = new JugadoresAdapter(this);
        listView.setAdapter(adapter);
        listView.setOnItemClickListener(this);
    }
    
    
    @Override
	public boolean onCreateOptionsMenu(Menu m){
    	super.onCreateOptionsMenu(m);
    	MenuInflater menuInflater = getMenuInflater();
    	menuInflater.inflate(R.menu.jugadores_menu, m);
    	return true;
    }
    
    
    @Override
	public boolean onMenuItemSelected(int featured, MenuItem item)
    {
    	if(item.getItemId() == R.id.jugador_add_menu) 
    	{
    		Intent intent = new Intent(this,JugadorManejadorActivity.class);
    		startActivityForResult(intent, I.ADD_JUGADOR);
    	}
    	if(item.getItemId() == R.id.jugador_buscar_menu){
    		
    	}
    	return super.onOptionsItemSelected(item);
    }
    
    @Override
	protected void onActivityResult(int requestCode, int resultCode, Intent data){
    	if(requestCode == I.ADD_JUGADOR && resultCode == RESULT_OK){
    		int idEquipo = data.getIntExtra(I.EQUIPO, 0);
    		String nombreJugador= data.getStringExtra(I.NOMBRE_JUGADOR);
    		String email= data.getStringExtra(I.EMAIL);
    		int numero = data.getIntExtra(I.NUMERO_JUGADOR,0);
    		int posicion = data.getIntExtra(I.POSICION_JUGADOR, 0);
    		double estatura = data.getDoubleExtra(I.ESTATURA_JUGADOR, 0.0);
    		double peso = Double.parseDouble(data.getStringExtra(I.PESO_JUGADOR));
    		boolean activo = data.getBooleanExtra(I.ACTIVO_JUGADOR, true);
    		adapter.addJugador(idEquipo, nombreJugador,email, numero, posicion, estatura, peso, activo);
    	}
    	if(requestCode == I.EDIT_JUGADOR && resultCode == RESULT_OK){
    		int idEquipo = data.getIntExtra(I.EQUIPO, 0);
    		String nombreJugador= data.getStringExtra(I.NOMBRE_JUGADOR);
    		String email= data.getStringExtra(I.EMAIL);
    		int numero = data.getIntExtra(I.NUMERO_JUGADOR,0);
    		int posicion = data.getIntExtra(I.POSICION_JUGADOR, 0);
    		double estatura = data.getDoubleExtra(I.ESTATURA_JUGADOR, 0.0);
    		double peso = Double.parseDouble(data.getStringExtra(I.PESO_JUGADOR));
    		Log.v(I.PROJECT,"Peso "+ peso);
    		int position = data.getIntExtra(I.POSICION, 0);
    		Jugador jug = (Jugador)data.getSerializableExtra(I.JUGADOR);
    		jug.setIdEquipo(idEquipo);
    		jug.setNombreJugador(nombreJugador);
    		jug.setEmail(email);
    		jug.setNumeroJugador(numero);
    		jug.setPosicionJugador(posicion);
    		jug.setEstaturaJugador(estatura);
    		jug.setPesoJugador(peso);
    		adapter.editaJugador(jug, position);
    	}
    	adapter.notifyDataSetChanged();
		ListView listView = (ListView) findViewById(R.id.jugadores_list);
		listView.requestLayout();
    }

	@Override
	public void onItemClick(AdapterView<?> adapter, View view, int position, long arg3) {
		// TODO Auto-generated method stub
		JugadoresAdapter adapt = (JugadoresAdapter) adapter.getAdapter();
		Jugador jug = adapt.getItem(position);
		Intent intent = new Intent(this,JugadorManejadorActivity.class);
		intent.putExtra(I.JUGADOR, jug);
		intent.putExtra(I.POSICION, position);
		startActivityForResult(intent,I.EDIT_JUGADOR);
	}
}
