package es.jcyl.cag.cursotesting.t4_barco;

import org.junit.Assert;
import org.junit.Test;


public class PosicionTest {
	
	public PosicionTest() {
		super();
	}
	
	@Test
	public void mantieneCoorenadas() {
		Posicion p = new Posicion (1,2);
		Assert.assertEquals(1, p.getX());
		Assert.assertEquals(2, p.getY());
	}

	@Test(expected = IllegalArgumentException.class)
	public void noAdmiteNegativosEnX() {
		new Posicion(-1, 1);
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void noAdmiteNegativosEnY() {
		new Posicion(1, -1);
	}

}
