package ar.edu.uno.geometria;

public abstract class Figura implements Desplazable, Comparable<Figura>{
	public abstract Double calcularArea();
	public abstract Double calcularPerimetro();
	
	/**
	 * post: Compara por area de mayor a menor.
	 */
	@Override
	public int compareTo(Figura f) {
		return -this.calcularArea().compareTo(f.calcularArea());
	}
	
	
	
}
