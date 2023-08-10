package cinephile.validation.exceptions;

public class ValidationException extends Exception {

	private static final long serialVersionUID = -1194860954774008955L;

	public ValidationException(String msg) {
		super(msg);
	}

	public ValidationException(Throwable e) {
		super(e);
	}
}
