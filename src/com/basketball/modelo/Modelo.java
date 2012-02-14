package com.basketball.modelo;

import java.sql.Timestamp;
import java.util.ArrayList;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteDatabase.CursorFactory;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import com.basketball.I;
import com.basketball.estructuradatos.Equipo;
import com.basketball.estructuradatos.EquiposPartidos;
import com.basketball.estructuradatos.EstadisticaJugador;
import com.basketball.estructuradatos.Jugador;
import com.basketball.estructuradatos.Partido;

public class Modelo extends SQLiteOpenHelper{

	private final String TABLA_EQUIPOS = "Equipos";
	private final String TABLA_JUGADORES = "Jugadores";
	private final String TABLA_EQUIPOS_PARTIDOS = "Equipos_Partidos";
	private final String TABLA_ESTADISTICAS_JUGADOR = "Estadistica_Jugador";
	private final String TABLA_PARTIDOS = "Partidos";
	private final String BD_NOMBRE;
	
	
	
	private final String sqlCreateEquipos = 
			"CREATE  TABLE IF NOT EXISTS Equipos (" +
			"idEquipos INTEGER NOT NULL PRIMARY KEY AUTOINCREMENT," +
			"nombre VARCHAR(45) NOT NULL ," +
			"categoria VARCHAR(45) NOT NULL ," +
			"activo TINYINT(1)  NOT NULL )";
	
	private final String sqlCreateJugadores=
		"CREATE TABLE IF NOT EXISTS Jugadores (" +
		"idJugadores INTEGER NOT NULL PRIMARY KEY AUTOINCREMENT," +
		"idEquipo VARCHAR(45) NOT NULL ," +
		"nombre VARCHAR(45) NOT NULL ," +
		"email VARCHAR(45) NOT NULL ," +
		"numero INTEGER NOT NULL ," +
		"posicion VARCHAR(45) NOT NULL ," +
		"estatura DOUBLE NOT NULL ," +
		"peso DOUBLE NOT NULL ," +
		"activo TINYINT(1)  NOT NULL )";

	private final String sqlCreateEquiposPartidos=
			"CREATE TABLE IF NOT EXISTS Equipos_Partidos (" +
			"idEquipo INTEGER NOT NULL ," +
			"idPartido INTEGER NOT NULL ," +
			"puntosEquipo INTEGER NOT NULL ," +
			"faltas INTEGER NOT NULL ," +
			"tirosLibres INTEGER NOT NULL ," +
			"bloqueos INTEGER NOT NULL ," +
			"rebotes INTEGER NOT NULL ," +
			"asistencias INTEGER NOT NULL ," +
			"jugado TINYINT(1) NOT NULL )";
	
	private final String sqlCreatePartidos=
			"CREATE TABLE IF NOT EXISTS Partidos (" +
			"idPartido INTEGER NOT NULL PRIMARY KEY  AUTOINCREMENT , " +
			"fecha TIMESTAMP NOT NULL , " +
			"lugar VARCHAR(100) NOT NULL , " +
			"jugado TINYINT(1) NOT NULL )";

	private final String sqlCreateEstadisticaJugador =
			"CREATE TABLE IF NOT EXISTS Estadistica_Jugador (" +
			"idJugador INTEGER NOT NULL ," +
			"idPartido INTEGER NOT NULL , " +
			"idEquipo INTEGER NOT NULL , " +
			"puntos INTEGER NOT NULL , " +
			"tirosLibres INTEGER NOT NULL, " +
			"tirosDos INTEGER NOT NULL, " +
			"tirosTres INTEGER NOT NULL , " +
			"faltas INTEGER NOT NULL, " +
			"bloqueos INTEGER NOT NULL, " +
			"rebotes INTEGER NOT NULL, " +
			"asistencias INTEGER NOT NULL, " +
			"robos INTEGER NOT NULL, " +
			"participo TINYINT(1) NOT NULL)";
	
	public Modelo(Context context, String name, CursorFactory factory,
			int version) {
		super(context, name, factory, version);
		// TODO Auto-generated constructor stub
		BD_NOMBRE = name;
	}
	
	public String getDatabaseName(){
		return BD_NOMBRE;
	}

	@Override
	public void onCreate(SQLiteDatabase db) {
		// TODO Auto-generated method stub
		db.execSQL(sqlCreateEquipos);
		String defalut = "insert into "+TABLA_EQUIPOS+" values (NULL,'Spymonkeys', 'C', 1)";
		db.execSQL(defalut);
		defalut = "insert into "+TABLA_EQUIPOS+" values (NULL,'Lobos', 'C', 1)";
		db.execSQL(defalut);
		
		db.execSQL(sqlCreateJugadores);
		defalut = "insert into "+TABLA_JUGADORES+" values (NULL,'1', 'Fernando','fernando_bmx@hotmail.com','13','1','1.95','90',1)";
		db.execSQL(defalut);
		defalut = "insert into "+TABLA_JUGADORES+" values (NULL,'1', 'Beto','beto@hotmail.com','6','1','1.95','90',1)";
		db.execSQL(defalut);
		
		db.execSQL(sqlCreatePartidos);
		defalut = "insert into "+TABLA_PARTIDOS+" values (NULL,datetime(),'Pajarito', 1)";
		db.execSQL(defalut);
		
		db.execSQL(sqlCreateEquiposPartidos);
		defalut = "insert into "+TABLA_EQUIPOS_PARTIDOS+" values (1,1,0,0,0,0,0,0,0)";
		db.execSQL(defalut);
		defalut = "insert into "+TABLA_EQUIPOS_PARTIDOS+" values (2,1,0,0,0,0,0,0,0)";
		db.execSQL(defalut);
		
		
		db.execSQL(sqlCreateEstadisticaJugador);
		defalut = "insert into "+TABLA_ESTADISTICAS_JUGADOR+" values (1,1,1,0,0,0,0,0,0,0,0,0,1)";
		db.execSQL(defalut);
		defalut = "insert into "+TABLA_ESTADISTICAS_JUGADOR+" values (2,1,1,0,0,0,0,0,0,0,0,0,1)";
		db.execSQL(defalut);
	}

	@Override
	public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
		// TODO Auto-generated method stub
		//Se elimina la versi—n anterior de la tabla
        db.execSQL("DROP TABLE IF EXISTS "+TABLA_EQUIPOS);
        db.execSQL("DROP TABLE IF EXISTS "+TABLA_JUGADORES);
        db.execSQL("DROP TABLE IF EXISTS "+TABLA_PARTIDOS);
        db.execSQL("DROP TABLE IF EXISTS "+TABLA_ESTADISTICAS_JUGADOR);
        db.execSQL("DROP TABLE IF EXISTS "+TABLA_EQUIPOS_PARTIDOS);
        //Se crea la nueva versi—n de la tabla
        onCreate(db);
	}
	
	public ArrayList<Equipo> getEquipos(){
		ArrayList<Equipo> equipos = new ArrayList<Equipo>();
		String equiposQuery = "SELECT * FROM "+TABLA_EQUIPOS;
		SQLiteDatabase database = getReadableDatabase();
		Cursor cursor = database.rawQuery(equiposQuery, null);
		cursor.moveToFirst();
		do{
			int idEquipo = cursor.getInt(0);
			String nombreEquipo = cursor.getString(1);
			String categoria = cursor.getString(2);
			boolean activo = Boolean.parseBoolean(cursor.getString(3));
			Equipo equipo = new Equipo(idEquipo,nombreEquipo,categoria,activo);
			equipos.add(equipo);
		}while(cursor.moveToNext());
		database.close();
		cursor.close();
		return equipos;
	}
	public Equipo getEquipo(int id){
		String equipoQuery = "SELECT * FROM "+TABLA_EQUIPOS+" WHERE idEquipos = "+id;
		SQLiteDatabase database = getReadableDatabase();
		Cursor cursor = database.rawQuery(equipoQuery, null);
		if(cursor != null){
			cursor.moveToFirst();
			int idEquipo = cursor.getInt(0);
			String nombreEquipo = cursor.getString(1);
			String categoria = cursor.getString(2);
			boolean activo = Boolean.parseBoolean(cursor.getString(3));
			database.close();
			cursor.close();
			return new Equipo(idEquipo,nombreEquipo,categoria,activo);
		}else{
			database.close();
			return null;
		}
	}
	public int getEquiposCount(){
		String countQuery = "SELECT count(*) FROM "+TABLA_EQUIPOS;
		SQLiteDatabase database = getReadableDatabase();
	    Cursor cursor = database.rawQuery(countQuery, null);
	    if(cursor != null){
	    	cursor.moveToFirst();
	    	int count = cursor.getInt(0);
	    	database.close();
	    	cursor.close();
	    	return count;
	    }
	    return -1;
	}
	public boolean insertaEquipo(String nombre,String categoria){
		String insertQuery = "insert into "+TABLA_EQUIPOS+" values (NULL,'"+nombre+"','"+categoria+"',1)";
		SQLiteDatabase database = getWritableDatabase();
	    database.execSQL(insertQuery);
	    database.close();
	    return true;
	}
	public boolean updateEquipo(int idEquipo,String nombre, String categoria, boolean activo){
		String insertQuery = "update "+TABLA_EQUIPOS+" set nombre = '"+nombre+"', categoria = '"+categoria+"' where idEquipos ="+idEquipo;
		SQLiteDatabase database = getWritableDatabase();
	    database.execSQL(insertQuery);
	    database.close();
	    return true;
	}
	public boolean deleteEquipo(int idEquipo){
		String insertQuery = "delete from "+TABLA_EQUIPOS+" where idEquipos ="+idEquipo;
		SQLiteDatabase database = getWritableDatabase();
	    database.execSQL(insertQuery);
	    database.close();
	    return true;
	}
	public boolean insertaJugardor(String nombreJugador,
			String numero,
			String posicion,
			Double estatura,
			Double peso){
		String insertQuery = "insert into "+TABLA_JUGADORES+" values (NULL,'"+nombreJugador+"','"+numero+"','"+posicion+"','"+estatura+"','"+peso+"', 1)";
		SQLiteDatabase database = getWritableDatabase();
	    database.execSQL(insertQuery);
	    database.close();
		return true;
	}
	
	public ArrayList<Jugador> getJugadores(){
		ArrayList<Jugador> jugadores = new ArrayList<Jugador>();
		String equiposQuery = "SELECT * FROM "+TABLA_JUGADORES;
		SQLiteDatabase database = getReadableDatabase();
		Cursor cursor = database.rawQuery(equiposQuery, null);
		cursor.moveToFirst();
		do{
			int idJugador = cursor.getInt(0);
			int idEquipo = cursor.getInt(1);
			String nombreJugador = cursor.getString(2);
			String email = cursor.getString(3);
			int numeroJugador = cursor.getInt(4);
			int posicionJugador = cursor.getInt(5);
			double estaturaJugador = cursor.getDouble(6);
			double pesoJugador = cursor.getDouble(7);
			boolean activoJugador = Boolean.parseBoolean(cursor.getString(8));
			Jugador jugador = new Jugador(idJugador, idEquipo, nombreJugador,email, numeroJugador, posicionJugador, estaturaJugador, pesoJugador,activoJugador);
			jugadores.add(jugador);
		}while(cursor.moveToNext());
		database.close();
		cursor.close();
		return jugadores;
	}
	public ArrayList<Jugador> getJugadores(int idEquipoA, int idEquipoB){
		ArrayList<Jugador> jugadores = new ArrayList<Jugador>();
		String equiposQuery = "SELECT * FROM "+TABLA_JUGADORES+" where idEquipo in ("+idEquipoA+","+idEquipoB+")";
		SQLiteDatabase database = getReadableDatabase();
		Cursor cursor = database.rawQuery(equiposQuery, null);
		cursor.moveToFirst();
		do{
			int idJugador = cursor.getInt(0);
			int idEquipo = cursor.getInt(1);
			String nombreJugador = cursor.getString(2);
			String email = cursor.getString(3);
			int numeroJugador = cursor.getInt(4);
			int posicionJugador = cursor.getInt(5);
			double estaturaJugador = cursor.getDouble(6);
			double pesoJugador = cursor.getDouble(7);
			boolean activoJugador = Boolean.parseBoolean(cursor.getString(8));
			Jugador jugador = new Jugador(idJugador, idEquipo, nombreJugador,email, numeroJugador, posicionJugador, estaturaJugador, pesoJugador,activoJugador);
			jugadores.add(jugador);
		}while(cursor.moveToNext());
		database.close();
		cursor.close();
		return jugadores;
	}
	
	public ArrayList<Partido> getPartidos(){
		ArrayList<Partido> partidos = new ArrayList<Partido>();
		String equiposQuery = "SELECT * FROM "+TABLA_PARTIDOS;
		SQLiteDatabase database = getReadableDatabase();
		Cursor cursor = database.rawQuery(equiposQuery, null);
		cursor.moveToFirst();
		do{
			int idPartido = cursor.getInt(0);
			String fech = cursor.getString(1);
			Timestamp fecha = Timestamp.valueOf(fech);
			String lugar = cursor.getString(2);
			boolean jugado = Boolean.parseBoolean(cursor.getString(3));
			Partido partido = new Partido(idPartido, fecha, lugar, jugado);
			partidos.add(partido);
		}while(cursor.moveToNext());
		database.close();
		cursor.close();
		return partidos;
	}
	
	public EquiposPartidos[] getEquipos(int idPartido){
		EquiposPartidos[] equipos = new EquiposPartidos[2];
		String equiposQuery = "SELECT * FROM "+TABLA_EQUIPOS_PARTIDOS+" WHERE idPartido ="+idPartido ;
		SQLiteDatabase database = getReadableDatabase();
		Cursor cursor = database.rawQuery(equiposQuery, null);
		cursor.moveToFirst();
		int idEquipo = cursor.getInt(0);
//		int idPartido = cursor.getInt(1);
		int puntosEquipo = cursor.getInt(2);
		int faltasEquipo = cursor.getInt(3);
		int tirosLibresEquipo = cursor.getInt(4);
		int rebotesEquipo = cursor.getInt(5);
		int bloqueosEquipo = cursor.getInt(6);
		int asistenciasEquipo = cursor.getInt(7);
		boolean participo = Boolean.parseBoolean(cursor.getString(8));
		EquiposPartidos equipoA = new EquiposPartidos(idEquipo, idPartido, puntosEquipo, faltasEquipo,tirosLibresEquipo, bloqueosEquipo,rebotesEquipo, asistenciasEquipo, participo);
		equipos[0] = equipoA;
		cursor.moveToNext();
		idEquipo = cursor.getInt(0);
//		int idPartido = cursor.getInt(1);
		puntosEquipo = cursor.getInt(2);
		faltasEquipo = cursor.getInt(3);
		tirosLibresEquipo = cursor.getInt(4);
		rebotesEquipo = cursor.getInt(5);
		bloqueosEquipo = cursor.getInt(6);
		asistenciasEquipo = cursor.getInt(7);
		participo = Boolean.parseBoolean(cursor.getString(8));
		EquiposPartidos equipoB = new EquiposPartidos(idEquipo, idPartido, puntosEquipo, faltasEquipo,tirosLibresEquipo, bloqueosEquipo, rebotesEquipo, asistenciasEquipo, participo);
		equipos[1]= equipoB;
		database.close();
		cursor.close();
		return equipos;
	}
	
	public boolean insertaJugardor(Integer equipo, 
			String nombreJugador,
			String email,
			Integer numero,
			Integer posicion,
			Double estatura,
			Double peso,
			Boolean activo){
		String insertQuery = "insert into "+TABLA_JUGADORES+" values (NULL,'"+equipo +"','"+nombreJugador+"','"+email+"','"+numero+"','"+posicion+"','"+estatura+"','"+peso+"','"+activo+"')";
		SQLiteDatabase database = getWritableDatabase();
	    database.execSQL(insertQuery);
	    database.close();
		return true;
	}
	public boolean updateJugardor(int idJugador, Integer equipo, 
			String nombreJugador,
			String email,
			Integer numero,
			Integer posicion,
			Double estatura,
			Double peso,
			Boolean activo){
		String insertQuery = "update "+TABLA_JUGADORES+" set idEquipo = '"+equipo +"', nombre= '"+nombreJugador+"' , email ='"+email+"', numero = '"+numero+"', posicion = '"+posicion+"', estatura = '"+estatura+"', peso = '"+peso+"', activo = '"+activo+"' where idJugadores = '"+idJugador+"'";
		SQLiteDatabase database = getWritableDatabase();
	    database.execSQL(insertQuery);
	    String updateQuery = "update "+TABLA_ESTADISTICAS_JUGADOR+"  set" +
				" idEquipo = "+equipo+" where idJugador="+idJugador;
	    database.execSQL(updateQuery);
	    database.close();
		return true;
	}
	public boolean deleteJugador(int idJugador){
		String insertQuery = "update "+TABLA_JUGADORES+" set activo = false where idJugador ='"+idJugador;
		SQLiteDatabase database = getWritableDatabase();
	    database.execSQL(insertQuery);
	    database.close();
	    return true;
	}
	
	public boolean addPuntosJugador(Partido par,Jugador jug, int puntos){
		String updateQuery="";
		switch(puntos){
			case 1:
				updateQuery = "update "+TABLA_ESTADISTICAS_JUGADOR+" set puntos=puntoss+1 , tirosLibres=tirosLibres+1 where idJugador = "+jug.getIdJugador()+" and idPartido ="+par.getIdPartido();
				break;
			case 2:
				updateQuery = "update "+TABLA_ESTADISTICAS_JUGADOR+" set puntos=puntos+2 tirosDos=tirosDos+1 where idJugador = "+jug.getIdJugador()+" and idPartido ="+par.getIdPartido();
				break;
			case 3:
				updateQuery = "update "+TABLA_ESTADISTICAS_JUGADOR+" set puntos=puntos+3 tirosTres=tirosTres+1 where idJugador = "+jug.getIdJugador()+" and idPartido ="+par.getIdPartido();
				break;
		}
		SQLiteDatabase database = getWritableDatabase();
	    database.execSQL(updateQuery);
	    database.close();
		return true;
		
	}
	
	public boolean insertaEstadisticaJugador(EstadisticaJugador ej){
		String updateQuery = "insert into "+TABLA_ESTADISTICAS_JUGADOR+"  values (" +
				" "+ej.getIdJugador()+", " +
				" "+ej.getIdPartido()+", " +
				" "+ej.getIdEquipo()+", " +
				"0,0,0,0,0,0,0,0,0,1 )";// Por default los ingresamos en cero aunque se pueden tomar los valores de ej
		SQLiteDatabase database = getWritableDatabase();
	    database.execSQL(updateQuery);
	    database.close();
	    return true;
	}
	
	public boolean updateEstadisticaJugador(EstadisticaJugador ej){
		String updateQuery = "update "+TABLA_ESTADISTICAS_JUGADOR+"  set" +
				" puntos = "+ej.getPuntos()+
				", tirosLibres = "+ej.getTirosLibres()+
				", tirosDos = "+ej.getTirosDos() +
				", tirosTres = "+ej.getTirosTres()+
				", faltas = "+ej.getFaltas()+
				", bloqueos = " +ej.getBloqueos()+
				", rebotes = " +ej.getRebotes()+
				", asistencias = " +ej.getAsistencias()+
				", robos = "+ej.getRobos()+
				" where idJugador="+ ej.getIdJugador()+
				" and idEquipo="+ej.getIdEquipo()+
				" and idPartido="+ej.getIdPartido()+"";
		SQLiteDatabase database = getWritableDatabase();
	    database.execSQL(updateQuery);
	    database.close();
	    return true;
		
	}
	
	public ArrayList<EstadisticaJugador> getEstadisticasPartido(Partido par){
		ArrayList<EstadisticaJugador> estadisticas = new ArrayList<EstadisticaJugador>();
		String estadisticasQuery = "select * from "+TABLA_ESTADISTICAS_JUGADOR+" where idPartido ="+par.getIdPartido()+" ";
		SQLiteDatabase database = getReadableDatabase();
		Cursor cursor = database.rawQuery(estadisticasQuery, null);
		cursor.moveToFirst();
		try{
			do{
				int idJugador = cursor.getInt(0);
				int idPartido = cursor.getInt(1);
				int idEquipo = cursor.getInt(2);
				int puntos = cursor.getInt(3);
				int tirosLibres = cursor.getInt(4);
				int tirosDos = cursor.getInt(5);
				int tirosTres = cursor.getInt(6);
				int faltas = cursor.getInt(7);
				int bloqueos = cursor.getInt(8);
				int rebotes = cursor.getInt(9);
				int robos = cursor.getInt(10);
				int asistencias = cursor.getInt(11);
				boolean participo = Boolean.parseBoolean(cursor.getString(12));
				EstadisticaJugador estadistica = new EstadisticaJugador(idJugador, idPartido,idEquipo, puntos, tirosLibres, tirosDos, tirosTres, faltas, bloqueos, rebotes, asistencias,robos,participo);
				estadisticas.add(estadistica);
			}while(cursor.moveToNext());
		}catch(Exception e){
			Log.v(I.PROJECT,"No encontre estadisticas jugadores: "+e.toString());
			database.close();
			cursor.close();
		}
		database.close();
		cursor.close();
		return estadisticas;
	}
	

	public boolean insertPartido(Timestamp fecha, String lugar, int idEquipoA, int idEquipoB){
		String insertQuery = "insert into "+TABLA_PARTIDOS+" values (NULL,'"+fecha+"','"+lugar+"','"+false+"')";
		SQLiteDatabase database = getWritableDatabase();
	    database.execSQL(insertQuery);
	    
	    String ultimoQuery = "select idPartido from "+TABLA_PARTIDOS+" ORDER BY idPartido DESC ";
	    SQLiteDatabase databasePartidos = getReadableDatabase();
		Cursor cursor = databasePartidos.rawQuery(ultimoQuery, null);
		cursor.moveToFirst();
		int idPartido = cursor.getInt(0);
		 		 
		String insertaQuery;
		insertaQuery  = "insert into "+TABLA_EQUIPOS_PARTIDOS+" values ('"+idEquipoA +"','"+idPartido +"',0,0,0,0,0,0,0)";
		database.execSQL(insertaQuery);
		insertaQuery = "insert into "+TABLA_EQUIPOS_PARTIDOS+" values ('"+idEquipoB +"','"+idPartido +"',0,0,0,0,0,0,0)";
		database.execSQL(insertaQuery);
		 
	    database.close();
	    databasePartidos.close();
	    cursor.close();
	    
		return true;
	}
	public boolean updatePartido(Partido par,int equipoA,int equipoB){
		String updateQuery = "update "+TABLA_PARTIDOS+" set fecha='"+par.getFechaPartido()+"', lugar='"+par.getLugarPartido()+"' where idPartido = "+par.getIdPartido();
		SQLiteDatabase database = getWritableDatabase();
	    database.execSQL(updateQuery);
	    
		String deleteQuery = "delete from "+TABLA_EQUIPOS_PARTIDOS+" where idPartido ="+par.getIdPartido();
		database = getWritableDatabase();
	    database.execSQL(deleteQuery);
		String insertaQuery;
		insertaQuery  = "insert into "+TABLA_EQUIPOS_PARTIDOS+" values ('"+equipoA +"','"+par.getIdPartido() +"',0,0,0,0,0,0,0)";
		database.execSQL(insertaQuery);
		insertaQuery = "insert into "+TABLA_EQUIPOS_PARTIDOS+" values ('"+equipoB +"','"+par.getIdPartido() +"',0,0,0,0,0,0,0)";
		database.execSQL(insertaQuery);
		
	    database.close();
		return true;
	}
	
}
