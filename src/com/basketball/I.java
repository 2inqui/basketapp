package com.basketball;

/**
 * @author inqui
 * 
 */
public class I {

	public static final String PROJECT = "Basketball Project";

	public static final int ADD_EQUIPO = 1;
	public static final int EDIT_EQUIPO = 2;
	public static final int DELETE_EQUIPO = 3;

	public static final String EMAIL = "EMAIL";

	public static final String EQUIPO = "E";
	public static final String EQUIPO_A = "EA";
	public static final String EQUIPO_B = "EB";
	public static final String NOMBRE_EQUIPO = "NE";
	public static final String CATEGORIA_EQUIPO = "CE";
	public static final String POSICION = "P";

	public static final String PARTIDO = "PARTIDO";
	public static final String ESTADDISTICA_JUGADOR = "ESTJ";

	public static final String DATABA_BASE = "BasketbollDB";
	public static final int DATABASE_VERSION = 1;

	public static final int ADD_JUGADOR = 4;
	public static final int EDIT_JUGADOR = 5;
	public static final int DELETE_JUGADOR = 6;
	public static final int ADD_ESTADISTICA_JUGADOR = 7;

	public static final String JUGADOR = "J";
	public static final String NOMBRE_JUGADOR = "NJ";
	public static final String NUMERO_JUGADOR = "NUMJ";
	public static final String POSICION_JUGADOR = "POSICIONJ";
	public static final String ESTATURA_JUGADOR = "EJ";
	public static final String PESO_JUGADOR = "PESOJ";
	public static final String ACTIVO_JUGADOR = "AJ";

	public static final String PUNTOS = "PUNTOS";
	public static final String FALTAS = "FALTAS";
	public static final String REBOTES = "REBOTES";
	public static final String BLOQUEOS = "BLOQUEOS";
	public static final String ROBOS = "ROBOS";
	public static final String TIROS_UNO = "TIROS_UNO";
	public static final String TIROS_DOS = "TIROS_DOS";
	public static final String TIROS_TRES = "TIROS_TRES";
	public static final String ASISTENCIAS = "ASISTENCIAS";

	public static final int ADD_GAME = 7;
	public static final int EDIT_GAME = 8;
	public static final int DELETE_GAME = 9;

	public static final String FECHA_PARTIDO = "FP";
	public static final String LUGAR_PARTIDO = "LP";
	public static final String PARTIDO_JUGADO = "PJ";

	public static final String DIA = "DIA";
	public static final String MES = "MES";
	public static final String ANO = "ANO";
	public static final String HORA = "HORA";
	public static final String MINUTO = "MINUTO";

		
	public static String getStringPosicionJugador(int posicion) {
		switch (posicion) {
		case 0:
			return "ALA";
		case 1:
			return "POSTE";
		case 2:
			return "TABLA";
		case 3:
			return "BANCA";
		default:
			return "DESCONOCIDA";
		}
	}

}
