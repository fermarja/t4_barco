package es.jcyl.cag.cursotesting.t4_barco;

import org.junit.Assert;
import org.junit.Test;


public class GiroTest {

	public GiroTest() {
		super();
	}
	
	@Test
	public void giroIzquierdaByCode() {
		Assert.assertEquals(Giro.IZQUIERDA, Giro.byCode("l"));
	}
	@Test
	public void giroDerechaByCode() {
		Assert.assertEquals(Giro.DERECHA, Giro.byCode("r"));
	}
	@Test
	public void giroDerechaMayusculaByCode() {
		Assert.assertEquals(Giro.DERECHA, Giro.byCode("R"));
	}
	@Test(expected = IllegalArgumentException.class)
	public void giroInvalido() {
		Giro.byCode("0");
	}
}
