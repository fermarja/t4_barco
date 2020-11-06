package es.jcyl.cag.cursotesting.t4_barco;

public enum Sentido {
	ADELANTE("f"),
	ATRAS("b");
	
	private String sentido;
	
	private Sentido(String sentido) {
		this.sentido = sentido;
	}
	
	public static Sentido byCode(String code) {
		for (Sentido s: values() ) {
			if (s.sentido.equalsIgnoreCase(code)) {
				return s;
			}
		}
		throw new IllegalArgumentException("Sentido no reconocido:" + code);
	}

	public static boolean isValidCode(String code) {
		for (Sentido s: values() ) {
			if (s.sentido.equalsIgnoreCase(code)) {
				return true;
			}
		}
		return false;
	}
}
