package es.jcyl.cag.cursotesting.t4_barco;

import java.util.ArrayList;
import java.util.List;

public class Planeta {

	private int tamano = 10;
	private List<Posicion> terreno = new ArrayList<Posicion>();
	
	public Planeta() {
		this(10);
	}
	
	public Planeta(int tamano) {
		super();
		this.tamano = tamano;
	}
	
	
	public int getTamano() {
		return this.tamano;
	}
	
	public boolean esTierra(Posicion posicion) {
		return this.terreno.contains(posicion); 
	}
	
	public void addTierra(Posicion... posiciones) {
		for (Posicion posicion: posiciones) {
			terreno.add(posicion);
		}
	};
}
