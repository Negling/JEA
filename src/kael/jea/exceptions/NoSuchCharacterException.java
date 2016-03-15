package kael.jea.exceptions;

/**
 * This is a subclass of checked exception {@link Exception} , which throws if
 * initialize method in some JEA classes takes character info, which doesn't
 * exist in ereality.ru API.
 * 
 * @author Kael
 * @see java.lang.Exception
 * @since JEA1.0
 */
public class NoSuchCharacterException extends Exception {
	private static final long serialVersionUID = 6305222900089545752L;

	/**
	 * Constructs a new exception with {@code null} as its detail message.
	 */
	public NoSuchCharacterException() {
	}

	/**
	 * Constructs a new exception with the specified detail message.
	 * 
	 * @param message
	 *            - the detail message.
	 */
	public NoSuchCharacterException(String message) {
		super(message);
	}
}
