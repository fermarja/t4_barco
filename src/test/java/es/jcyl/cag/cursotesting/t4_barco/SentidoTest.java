package es.jcyl.cag.cursotesting.t4_barco;

import org.junit.Assert;
import org.junit.Test;

public class SentidoTest {

	public SentidoTest() {
		super();
	}
	
	@Test
	public void forward() {
		Assert.assertEquals(Sentido.ADELANTE, Sentido.byCode("f"));
	}
	
	@Test
	public void backward() {
		Assert.assertEquals(Sentido.ATRAS, Sentido.byCode("b"));
	}
	
	@Test
	public void bacwardMayusculas() {
		Assert.assertEquals(Sentido.ATRAS, Sentido.byCode("B"));
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void invalido() {
		Sentido.byCode("0");
	}
	
}
