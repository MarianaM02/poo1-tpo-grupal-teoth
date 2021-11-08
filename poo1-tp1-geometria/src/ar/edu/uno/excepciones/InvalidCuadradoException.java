package ar.edu.uno.excepciones;

import ar.edu.uno.geometria.Rectangulo;

/***
 * InvalidCuadradoException se lanza cuando un Cuadrado tienen algun lado igual
 * a cero o negativo, degenerando la figura y por lo tanto no se puede
 * representar correctamente en el plano.
 * 
 * @see Rectangulo
 *
 */
@SuppressWarnings("serial")
public class InvalidCuadradoException extends RuntimeException {

	public InvalidCuadradoException(String s) {
		super(s);
	}

}
