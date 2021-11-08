package ar.edu.uno.geometria;

import ar.edu.uno.excepciones.InvalidSegmentoException;

public class Segmento implements Desplazable, Comparable<Segmento> {

	private Punto punto1;
	private Punto punto2;

	/**
	 * pre: Puntos no iguales
	 * 
	 * post: Crea un segmento
	 * 
	 * @param punto1 Valor punto de la primera coodenada
	 * @param punto2 Valor punto de la segunda coodenada
	 * @throws InvalidSegmentoException
	 */
	public Segmento(Punto punto1, Punto punto2) throws InvalidSegmentoException{
		if (punto1.equals(punto2)) {
			throw new InvalidSegmentoException("PUNTOS INVALIDOS: Los dos puntos son iguales");
		}
		this.punto1 = punto1;
		this.punto2 = punto2;
	}

	public Double calcularLongitud() {
		return punto1.distanciaA(punto2);
	}

	public Double calcularPendiente() {
		double divisor = punto2.getX() - punto1.getX();
		return (divisor != 0) ? ((punto2.getY() - punto1.getY()) / divisor) : Double.POSITIVE_INFINITY; // Recta paralela al eje Y
	}

	public Boolean esParaleloA(Segmento seg) {
		return this.calcularPendiente().equals(seg.calcularPendiente());
	}

	public Boolean esParaleloX() {
		return punto1.getY().equals(punto2.getY());
	}

	public Boolean esParaleloY() {
		return punto1.getX().equals(punto2.getX());
	}

	@Override
	public void desplazarEnX(Double distancia) {
		this.punto1.desplazarEnX(distancia);
		this.punto2.desplazarEnX(distancia);
	}

	@Override
	public void desplazarEnY(Double distancia) {
		this.punto1.desplazarEnY(distancia);
		this.punto2.desplazarEnY(distancia);
	}
	
	public Punto getPunto1() {
		return punto1;
	}

	public Punto getPunto2() {
		return punto2;
	}

	@Override
	public int compareTo(Segmento o) {
		return -this.calcularLongitud().compareTo(o.calcularLongitud());
	}

	@Override
	public String toString() {
		return "SEGMENTO," + punto1 + "," + punto2;
	}

}
