package ar.edu.uno.geometria;

import java.util.Objects;

public class Punto implements Desplazable {

	private Double x;
	private Double y;

	/**
	 * post: Crea un punto
	 * 
	 * @param x Valor Double de la coordenada en x
	 * @param y Valor Double de la coordenada en y
	 */
	public Punto(Double x, Double y) {
		this.x = x;
		this.y = y;
	}

	public boolean estaSobreEjeY() {
		return x.equals(0.0);
	}

	public boolean estaSobreEjeX() {
		return y.equals(0.0);
	}

	public boolean esCoordenadaOrigen() {
		return (estaSobreEjeX() && estaSobreEjeY());
	}

	public Double distanciaA(Punto p) {
		double diferenciaEnX = this.getX() - p.getX();
		double diferenciaEnY = this.getY() - p.getY();
		return Math.hypot(diferenciaEnX, diferenciaEnY);
	}

	public Double getX() {
		return x;
	}

	public void setX(Double x) {
		this.x = x;
	}

	public Double getY() {
		return y;
	}

	public void setY(Double y) {
		this.y = y;
	}

	@Override
	public void desplazarEnX(Double distancia) {
		this.setX(this.getX() + distancia);
	}

	@Override
	public void desplazarEnY(Double distancia) {
		this.setY(this.getY() + distancia);
	}

	@Override
	public int hashCode() {
		return Objects.hash(x, y);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Punto other = (Punto) obj;
		return Objects.equals(x, other.x) && Objects.equals(y, other.y);
	}

	@Override
	public String toString() {
		return x + "," + y;
	}
}
