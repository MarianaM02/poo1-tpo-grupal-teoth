package ar.edu.uno.geometria;

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
		return (divisor != 0) ? ((punto2.getY() - punto1.getY()) / divisor) : (0); // Recta paralela al eje Y
	}

	public Boolean esParaleloA(Segmento seg) {
		return this.calcularPendiente().compareTo(seg.calcularPendiente()) == 0;
	}

	public Boolean esParaleloX() {
		return punto1.getY().compareTo(punto2.getY()) == 0;
	}

	public Boolean esParaleloY() {
		return punto1.getX().compareTo(punto2.getX()) == 0;
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

	@Override
	public int compareTo(Segmento o) {
		return this.calcularLongitud().compareTo(o.calcularLongitud());
	}

	@Override
	public String toString() {
		return "SEGMENTO," + punto1 + "," + punto2;
	}

}
