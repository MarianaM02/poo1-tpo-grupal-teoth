package ar.edu.uno.geometria;

public interface Desplazable {
	
	/**
	 * post: Desplaza el elemento sobre el eje X
	 * @param distancia	Valor a desplazar en eje X
	 */
	void desplazarEnX(Double distancia);

	/**
	 * post: Desplaza el elemento sobre el eje Y
	 * @param distancia	Valor a desplazar en eje Y
	 */
	void desplazarEnY(Double distancia);
}
