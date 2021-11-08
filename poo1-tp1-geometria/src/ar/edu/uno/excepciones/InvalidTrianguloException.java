package ar.edu.uno.excepciones;

/***
 * InvalidTrianguloException se lanza cuando hay vertices 
 * que coinciden o sus lados estan alineados.
 *
 */
@SuppressWarnings("serial")
public class InvalidTrianguloException extends RuntimeException {

	public InvalidTrianguloException(String message) {
		super(message);
	}

}
