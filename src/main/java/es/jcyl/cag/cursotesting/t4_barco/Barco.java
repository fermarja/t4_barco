package es.jcyl.cag.cursotesting.t4_barco;

public class Barco {

	private Posicion posicion;
	private Direccion direccion;
	
	public Barco(Posicion posicion, Direccion direccion) {
		super();
		this.posicion = posicion;
		this.direccion = direccion;
	}

	public Posicion getPosicion() {
		return posicion;
	}

	public Direccion getDireccion() {
		return direccion;
	}
	
	public void mover(String sentido) {
		this.mover(Sentido.byCode(sentido));
	}
	
	public void mover(Sentido sentido) {
		int nuevoX = posicion.getX();
		int nuevoY = posicion.getY();
		
		if (direccion == Direccion.ESTE && sentido == Sentido.ADELANTE) {
			nuevoX++;
		}
		if (direccion == Direccion.ESTE && sentido == Sentido.ATRAS) {
			nuevoX--;
		}
		if (direccion == Direccion.OESTE && sentido == Sentido.ADELANTE) {
			nuevoX--;
		}
		if (direccion == Direccion.OESTE && sentido == Sentido.ATRAS) {
			nuevoX++;
		}
		if (direccion == Direccion.NORTE && sentido == Sentido.ATRAS) {
			nuevoY++;
		}
		if (direccion == Direccion.NORTE && sentido == Sentido.ADELANTE) {
			nuevoY--;
		}
		if (direccion == Direccion.SUR && sentido == Sentido.ADELANTE) {
			nuevoY++;
		}
		if (direccion == Direccion.SUR && sentido == Sentido.ATRAS) {
			nuevoY--;
		}
		
		
		this.posicion = new Posicion(nuevoX, nuevoY);
		
	}

	public void girar(String giro) {
		girar(Giro.byCode(giro));
	}
	public void girar(Giro giro) {
		if (giro == Giro.IZQUIERDA) {
			switch(this.direccion) {
			case NORTE:
				this.direccion = Direccion.OESTE;
				break;
			case ESTE:
				this.direccion = Direccion.NORTE;
				break;
			case OESTE:
				this.direccion = Direccion.SUR;
				break;
			case SUR:
				this.direccion = Direccion.ESTE;
				break;
			}
		}
		else if (giro == Giro.DERECHA) {
			switch(this.direccion) {
			case NORTE:
				this.direccion = Direccion.ESTE;
				break;
			case ESTE:
				this.direccion = Direccion.SUR;
				break;
			case OESTE:
				this.direccion = Direccion.NORTE;
				break;
			case SUR:
				this.direccion = Direccion.OESTE;
				break;
			}
		}
	}
	
}
