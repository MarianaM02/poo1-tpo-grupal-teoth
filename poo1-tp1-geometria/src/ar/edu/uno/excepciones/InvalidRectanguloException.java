package ar.edu.uno.excepciones;

/***
 * InvalidRectanguloException se lanza cuando las 
 * esquinas estan alineadas y por ende no tiene 
 * base o no tiene altura.
 *
 */
@SuppressWarnings("serial")
public class InvalidRectanguloException extends RuntimeException {

	public InvalidRectanguloException(String message) {
		super(message);
	}

}
