package ar.edu.uno.geometria;

import ar.edu.uno.excepciones.InvalidCuadradoException;

public class Cuadrado extends Rectangulo {
	private Double lado;

	/**
	 * pre: Lado valor mayor a 0
	 * 
	 * post: Crea un Cuadrado
	 * 
	 * @param lado     Valor Double de la longitud de un lado
	 * @param esquina1 Valor punto de la esquina inferior izquierda
	 * @throws InvalidCuadradoException
	 */
	public Cuadrado(Double lado, Punto esquina1) throws InvalidCuadradoException {
		super(esquina1, new Punto(esquina1.getX() + lado, esquina1.getY() + lado));
		this.lado = lado;
		if (lado <= 0) {
			throw new InvalidCuadradoException("LADO INVALIDO: Lado menor o igual a 0");
		}
	}

	public Double getLado() {
		return lado;
	}

	@Override
	public Double calcularArea() {
		return Math.pow(this.lado, 2);
	}

	@Override
	public Double calcularPerimetro() {
		return this.lado * 4;
	}

	@Override
	public String toString() {
		return "CUADRADO," + lado + "," + getEsquina1();
	}

}
