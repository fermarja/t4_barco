package es.jcyl.cag.cursotesting.t4_barco;

public class TierraException extends RuntimeException {


	private static final long serialVersionUID = -2864531724805377453L;

	public TierraException() {
		super();
	}

	public TierraException(String message) {
		super(message);
	}

	public TierraException(Throwable cause) {
		super(cause);
	}

	public TierraException(String message, Throwable cause) {
		super(message, cause);
	}

	public TierraException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
	}

}
