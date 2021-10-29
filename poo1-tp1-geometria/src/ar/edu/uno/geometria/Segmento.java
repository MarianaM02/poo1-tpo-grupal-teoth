package ar.edu.uno.geometria;

import java.util.Objects;

public class Segmento implements Desplazable, Comparable<Segmento> {

	private Punto punto1;
	private Punto punto2;

	public Segmento(Punto punto1, Punto punto2) {
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
	public int hashCode() {
		return Objects.hash(punto1, punto2);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Segmento other = (Segmento) obj;
		return Objects.equals(punto1, other.punto1) && Objects.equals(punto2, other.punto2);
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
