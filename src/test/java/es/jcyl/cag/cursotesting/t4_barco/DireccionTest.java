package es.jcyl.cag.cursotesting.t4_barco;

import org.junit.Assert;
import org.junit.Test;


public class DireccionTest {
	
	public DireccionTest() {
		super();
	}
	
	@Test
	public void este_E() {
		Assert.assertEquals(Direccion.ESTE, Direccion.byCode("E"));
	}
	
	@Test
	public void oeste_W () {
		Assert.assertEquals(Direccion.OESTE, Direccion.byCode("W"));
	}
	
	@Test
	public void norte_N() {
		Assert.assertEquals(Direccion.NORTE, Direccion.byCode("N"));
	}
	
	@Test
	public void norte_n() {
		Assert.assertEquals(Direccion.NORTE, Direccion.byCode("n"));
	}
	
	@Test
	public void sur_S() {
		Assert.assertEquals(Direccion.SUR, Direccion.byCode("S"));
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void direccionInvalida() {
		Direccion.byCode("0");
	}

}
