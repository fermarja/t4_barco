package es.jcyl.cag.cursotesting.t4_barco;

public enum Giro {

	IZQUIERDA("l"),
	DERECHA("r");
	
	private String giro;
	
	private Giro (String giro) {
		this.giro = giro;
	}
	
	public static Giro byCode(String code) {
		return null;
	}
}
