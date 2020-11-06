package es.jcyl.cag.cursotesting.t4_barco;

public enum Direccion {

	NORTE("N"),
	SUR("S"),
	ESTE("E"),
	OESTE("W");
	
	private String dir;
	
	private Direccion(String dir) {
		this.dir = dir;
	}
	
	public static Direccion byCode(String code) {
		for (Direccion d : values()) {
			if (d.dir.equalsIgnoreCase(code)) {
				return d;
			}
		}
		throw new IllegalArgumentException("No reconocido:" + code);
	}
}
