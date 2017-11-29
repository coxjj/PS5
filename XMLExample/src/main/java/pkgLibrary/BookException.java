package pkgLibrary;

public class BookException extends Exception {

	public BookException(String message) {
		super(message);
		System.out.println(message);
	}
}
