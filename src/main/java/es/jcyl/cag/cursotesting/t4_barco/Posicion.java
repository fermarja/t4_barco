package es.jcyl.cag.cursotesting.t4_barco;

public class Posicion {

	private int x; 
	private int y;
	
	public Posicion(int x, int y) {
		super();
		if (x < 0 || y < 0) {
			throw new IllegalArgumentException("Valores negativos no permitidos");
		}
		this.x = x;
		this.y = y;
	}

	public int getX() {
		return x;
	}


	public int getY() {
		return y;
	}

	
}
