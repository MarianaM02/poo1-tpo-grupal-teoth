package ar.edu.uno.geometria;

public abstract class Figura implements Desplazable, Comparable<Figura> {

	/**
	 * post: Calcula el area de la figura
	 * 
	 * @return Valor Double del area
	 */
	public abstract Double calcularArea();

	/**
	 * post: Calcula el perimetro de la figura
	 * 
	 * @return Valor Double del area
	 */
	public abstract Double calcularPerimetro();

	/**
	 * post: Compara figuras por area de mayor a menor.
	 * 
	 * @return un entero negativo, cero o un entero positivo si este objeto es
	 *         mayor, igual o menor que el objeto especificado
	 */
	@Override
	public int compareTo(Figura f) {
		return -this.calcularArea().compareTo(f.calcularArea());
	}

}
