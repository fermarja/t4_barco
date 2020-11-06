package es.jcyl.cag.cursotesting.t4_barco;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;


public class BarcoTest {

	private Posicion posicionInicial;
	
	public BarcoTest() {
		super();
	}
	
	@Before
	public void before() {
		this.posicionInicial = new Posicion(2,2);
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
		Assert.assertEquals(3, barco.getPosicion().getY());
	}
	@Test
	public void atrasNorteSumaY() {
		Barco barco = new Barco(posicionInicial, Direccion.NORTE);
		barco.mover("b");
		Assert.assertEquals(3, barco.getPosicion().getY());
	}
	@Test
	public void atrasSurRestaY() {
		Barco barco = new Barco(posicionInicial, Direccion.SUR);
		barco.mover("b");
		Assert.assertEquals(1, barco.getPosicion().getY());
	}
	@Test
	public void adelanteEsteSumaX() {
		Barco barco = new Barco(posicionInicial, Direccion.ESTE);
		barco.mover("f");
		Assert.assertEquals(3, barco.getPosicion().getX());
	}
	@Test
	public void adelanteOesteRestaX() {
		Barco barco = new Barco(posicionInicial, Direccion.OESTE);
		barco.mover("f");
		Assert.assertEquals(1, barco.getPosicion().getX());
	}
	@Test
	public void atrasOesteSumaX() {
		Barco barco = new Barco(posicionInicial, Direccion.OESTE);
		barco.mover("b");
		Assert.assertEquals(3, barco.getPosicion().getX());
	}
	@Test
	public void atrasEsteRestaX() {
		Barco barco = new Barco(posicionInicial, Direccion.OESTE);
		barco.mover("b");
		Assert.assertEquals(1, barco.getPosicion().getX());
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void valorInvalidoMover() {
		Barco barco = new Barco(posicionInicial, Direccion.OESTE);
		barco.mover("0");
	}
}
