package com.basketball;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ListView;
import android.widget.Toast;

import com.basketball.estructuradatos.Equipo;

public class EquiposActivity extends Activity implements OnItemClickListener{
	
	Intent equipoAlta;
	EquiposAdapter adapter;
	
	 /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.equipos_list);
        ListView listView = (ListView) findViewById(R.id.list_view_equipos);
        adapter = new EquiposAdapter(this);
        listView.setAdapter(adapter);
        listView.setOnItemClickListener(this);
    }
    
    @Override
	public boolean onCreateOptionsMenu(Menu m){
    	super.onCreateOptionsMenu(m);
    	MenuInflater menuInflater = getMenuInflater();
    	menuInflater.inflate(R.menu.equipos_menu, m);
    	return true;
    }
    
    
    @Override
	public boolean onMenuItemSelected(int featured, MenuItem item)
    {
    	if(item.getItemId() == R.id.item_menu_agregarEquipo) 
    	{
    		equipoAlta = new Intent(this,EquipoManejadorActivity.class);
    		startActivityForResult(equipoAlta, I.ADD_EQUIPO);
    	}
    	if(item.getItemId() == R.id.item_menu_editarEquipo){
    		
    	}
    	return super.onOptionsItemSelected(item);
    }
    
    @Override
	protected void onActivityResult(int requestCode, int resultCode, Intent data){
    	Toast.makeText(this, "Activity Result", Toast.LENGTH_LONG);
    	if(requestCode == I.ADD_EQUIPO && resultCode == RESULT_OK){
    		String nombreEquipo = data.getStringExtra(I.NOMBRE_EQUIPO);
    		String categoriaEquipo = data.getStringExtra(I.CATEGORIA_EQUIPO);
    		if(adapter.addEquipo(nombreEquipo, categoriaEquipo))
    			Toast.makeText(this, "inserto", Toast.LENGTH_LONG);
    		adapter.notifyDataSetChanged();
			ListView listView = (ListView) findViewById(R.id.list_view_equipos);
			listView.requestLayout();
    	}
    	if(requestCode == I.EDIT_EQUIPO && resultCode == RESULT_OK){
    		int posicion = data.getIntExtra(I.POSICION,-1);
    		String nombreEquipo = data.getStringExtra(I.NOMBRE_EQUIPO);
    		String categoriaEquipo = data.getStringExtra(I.CATEGORIA_EQUIPO);
    		Equipo equipo = (Equipo) data.getSerializableExtra(I.EQUIPO);
    		equipo.setCategoriaEquipo(categoriaEquipo);
    		equipo.setNombreEquipo(nombreEquipo);
    		adapter.editaEquipo(equipo, posicion);
    		adapter.notifyDataSetChanged();
			ListView listView = (ListView) findViewById(R.id.list_view_equipos);
			listView.requestLayout();
    	}
    	if(resultCode == I.DELETE_EQUIPO){
    		int posicion = data.getIntExtra(I.POSICION,-1);
    		adapter.eliminaEquipo(posicion);
    	}
    }

	@Override
	public void onItemClick(AdapterView<?> adapter, View view, int position, long arg3) {
		// TODO Auto-generated method stub
		equipoAlta = new Intent(this,EquipoManejadorActivity.class);
		equipoAlta.putExtra(I.EQUIPO, (Equipo)adapter.getItemAtPosition(position));
		equipoAlta.putExtra(I.POSICION, position);
		startActivityForResult(equipoAlta, I.EDIT_EQUIPO);
	}
	
	
}
