package es.jcyl.cag.cursotesting.t4_barco;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;


public class BarcoTest {

	private static final int MAXIMO = 10;
	private static final int INICIAL = 2;
	private Posicion posicionInicial;
	
	public BarcoTest() {
		super();
	}
	
	@Before
	public void before() {
		this.posicionInicial = new Posicion(INICIAL,INICIAL);
	}
	
	@Test
	public void adelanteNorteRestaY() {
		Barco barco = new Barco(posicionInicial, Direccion.NORTE);
		barco.mover("f");
		Assert.assertEquals(1, barco.getPosicion().getY());
	}
	@Test
	public void adelanteSurSumaY() {
		Barco barco = new Barco(posicionInicial, Direccion.SUR);
		barco.mover("f");
		Assert.assertEquals(INICIAL+1, barco.getPosicion().getY());
	}
	@Test
	public void atrasNorteSumaY() {
		Barco barco = new Barco(posicionInicial, Direccion.NORTE);
		barco.mover("b");
		Assert.assertEquals(INICIAL+1, barco.getPosicion().getY());
	}
	@Test
	public void atrasSurRestaY() {
		Barco barco = new Barco(posicionInicial, Direccion.SUR);
		barco.mover("b");
		Assert.assertEquals(INICIAL-1, barco.getPosicion().getY());
	}
	@Test
	public void adelanteEsteSumaX() {
		Barco barco = new Barco(posicionInicial, Direccion.ESTE);
		barco.mover("f");
		Assert.assertEquals(INICIAL+1, barco.getPosicion().getX());
	}
	@Test
	public void adelanteOesteRestaX() {
		Barco barco = new Barco(posicionInicial, Direccion.OESTE);
		barco.mover("f");
		Assert.assertEquals(INICIAL-1, barco.getPosicion().getX());
	}
	@Test
	public void atrasOesteSumaX() {
		Barco barco = new Barco(posicionInicial, Direccion.OESTE);
		barco.mover("b");
		Assert.assertEquals(INICIAL+1, barco.getPosicion().getX());
	}
	@Test
	public void atrasEsteRestaX() {
		Barco barco = new Barco(posicionInicial, Direccion.ESTE);
		barco.mover("b");
		Assert.assertEquals(INICIAL-1, barco.getPosicion().getX());
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void valorInvalidoMover() {
		Barco barco = new Barco(posicionInicial, Direccion.OESTE);
		barco.mover("0");
	}
	
	@Test
	public void girarIzquieradaNorteOeste() {
		Barco barco = new Barco(posicionInicial, Direccion.NORTE);
		barco.girar("l");
		Assert.assertEquals(Direccion.OESTE, barco.getDireccion());
	}
	@Test
	public void girarIzquierdaOesteSur() {
		Barco barco = new Barco(posicionInicial, Direccion.OESTE);
		barco.girar("l");
		Assert.assertEquals(Direccion.SUR, barco.getDireccion());
	}
	@Test
	public void girarIzquierdaSurEste() {
		Barco barco = new Barco(posicionInicial, Direccion.SUR);
		barco.girar("l");
		Assert.assertEquals(Direccion.ESTE, barco.getDireccion());
	}
	@Test
	public void girarIzquierdaEsteNorte() {
		Barco barco = new Barco(posicionInicial, Direccion.ESTE);
		barco.girar("l");
		Assert.assertEquals(Direccion.NORTE, barco.getDireccion());
	}
	@Test
	public void girarDerechaNorteEste() {
		Barco barco = new Barco(posicionInicial, Direccion.NORTE);
		barco.girar("r");
		Assert.assertEquals(Direccion.ESTE, barco.getDireccion());
	}
	@Test
	public void girarDerechaEsteSur() {
		Barco barco = new Barco(posicionInicial, Direccion.ESTE);
		barco.girar("r");
		Assert.assertEquals(Direccion.SUR, barco.getDireccion());
	}
	@Test
	public void girarDerechaSurOeste() {
		Barco barco = new Barco(posicionInicial, Direccion.SUR);
		barco.girar("r");
		Assert.assertEquals(Direccion.OESTE, barco.getDireccion());
	}
	@Test
	public void girarDerechaOesteNorte() {
		Barco barco = new Barco(posicionInicial, Direccion.OESTE);
		barco.girar("r");
		Assert.assertEquals(Direccion.NORTE, barco.getDireccion());
		
	}
	@Test(expected = IllegalArgumentException.class)
	public void valorInvalidoGirar() {
		Barco barco = new Barco(posicionInicial, Direccion.OESTE);
		barco.girar("0");
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void valorInvalidoSecuenciaOrdenes() {
		Barco barco = new Barco(posicionInicial, Direccion.OESTE);
		barco.moverSecuenciaOrdenes("0");
	}
	
	@Test
	public void moverSecuenciaOrdenes() {
		Barco barco = new Barco(posicionInicial, Direccion.NORTE);
		barco.moverSecuenciaOrdenes("rff");
		Assert.assertEquals(Direccion.ESTE, barco.getDireccion());
		Assert.assertEquals(INICIAL, barco.getPosicion().getY());
		Assert.assertEquals(INICIAL+2, barco.getPosicion().getX());
	}
	@Test
	public void izquierdaVuelvePorDerecha() {
		Barco barco = new Barco(new Posicion(0,0), Direccion.OESTE, new Planeta(MAXIMO));
		barco.mover(Sentido.ADELANTE);
		Assert.assertEquals(MAXIMO-1, barco.getPosicion().getX());
		Assert.assertEquals(0, barco.getPosicion().getY());
		

	}
	@Test
	public void derechaVuelvePorIzquierda() {
		Barco barco = new Barco(new Posicion(MAXIMO-1,MAXIMO-1), Direccion.ESTE, new Planeta(MAXIMO));
		barco.mover(Sentido.ADELANTE);
		Assert.assertEquals(0, barco.getPosicion().getX());
		Assert.assertEquals(MAXIMO-1, barco.getPosicion().getY());
	}
	@Test
	public void arribaVuelvePorAbajo() {
		Barco barco = new Barco(new Posicion(0,0), Direccion.NORTE, new Planeta(MAXIMO));
		barco.mover(Sentido.ADELANTE);
		Assert.assertEquals(0, barco.getPosicion().getX());
		Assert.assertEquals(MAXIMO-1, barco.getPosicion().getY());

	}
	@Test
	public void abajoVuelvePorArriba() {
		Barco barco = new Barco(new Posicion(MAXIMO-1,MAXIMO-1), Direccion.SUR, new Planeta(MAXIMO));
		barco.mover(Sentido.ADELANTE);
		Assert.assertEquals(MAXIMO-1, barco.getPosicion().getX());
		Assert.assertEquals(0, barco.getPosicion().getY());

	}
	
	@Test(expected=TierraException.class)
	public void testTierra() {
		Planeta planeta = new Planeta();
		planeta.addTierra(new Posicion(2,1));
		Barco barco = new Barco(posicionInicial, Direccion.NORTE, planeta);
		barco.mover(Sentido.ADELANTE);
	}
}
