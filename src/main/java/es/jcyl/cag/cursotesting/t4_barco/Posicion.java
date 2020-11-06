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

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + x;
		result = prime * result + y;
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Posicion other = (Posicion) obj;
		if (x != other.x)
			return false;
		if (y != other.y)
			return false;
		return true;
	}

	
	
}
