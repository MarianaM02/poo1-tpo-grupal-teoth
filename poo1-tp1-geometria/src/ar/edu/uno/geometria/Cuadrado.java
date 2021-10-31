package ar.edu.uno.geometria;

public class Cuadrado extends Rectangulo {
	private Double lado;

	public Cuadrado(Double lado, Punto esquina1) throws Exception {
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
		return "CUADRADO," + lado + "," + getEsqInfIzq();
	}

}
