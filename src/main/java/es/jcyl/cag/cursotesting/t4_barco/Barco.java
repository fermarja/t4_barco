package es.jcyl.cag.cursotesting.t4_barco;

import java.util.ArrayList;
import java.util.List;

public class Barco {

	private Posicion posicion;
	private Direccion direccion;
	private int maximo;
	
	private List<Posicion> terreno = new ArrayList<Posicion>();
	
	public Barco(Posicion poisicion, Direccion direccion) {
		this(poisicion, direccion, 10);
	}
	public Barco(Posicion posicion, Direccion direccion, int maximo) {
		super();
		this.posicion = posicion;
		this.direccion = direccion;
		this.maximo = maximo;
	}

	public Posicion getPosicion() {
		return posicion;
	}

	public Direccion getDireccion() {
		return direccion;
	}
	
	
	public void moverSecuenciaOrdenes(String secuencia) {
		comprobarSecuenciaValida(secuencia);
		for (char c: secuencia.toCharArray()) {
			try {
				Giro g = Giro.byCode(Character.toString(c));
				girar(g);
			}
			catch (IllegalArgumentException e) {
				// nop
			}
			try {
				Sentido s = Sentido.byCode(Character.toString(c));
				mover(s);
			}
			catch (IllegalArgumentException e) {
				// nop
			}
		}
	}
	
	private void comprobarSecuenciaValida(String secuencia) {
		for (char c: secuencia.toCharArray()) {
			boolean giroValido = false;
			boolean sentidoValido = false;
			try {
				Giro.byCode(Character.toString(c));
				giroValido = true;
			}
			catch (IllegalArgumentException ignored) {
				giroValido = false;
			}
			try {
				Sentido.byCode(Character.toString(c));
				sentidoValido = true;
			}
			catch (IllegalArgumentException ignored) {
				sentidoValido = false;
			}
			if (!giroValido && !sentidoValido) {
				throw new IllegalArgumentException("Comando no reconocido:" + c);
			}
		}
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
		
		if (nuevoX < 0) {
			nuevoX = maximo -1;
		}
		if (nuevoY < 0) {
			nuevoY = maximo -1;
		}
		if (nuevoX >= maximo) {
			nuevoX = 0;
		}
		if (nuevoY >= maximo) {
			nuevoY = 0;
		}
		
		Posicion posicionPropuesta = new Posicion(nuevoX, nuevoY);
		if (terreno.contains(posicionPropuesta)) {
			throw new TierraException("Se ha encontrado tierra en al posicion " + nuevoX + ", " + nuevoY);
		}
		
		this.posicion = posicionPropuesta;
		
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
	
	public void addTierra(Posicion posicion) {
		terreno.add(posicion);
	}
	
}
