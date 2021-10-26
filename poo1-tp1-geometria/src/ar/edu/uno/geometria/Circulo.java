package ar.edu.uno.geometria;

public class Circulo extends Elipse {

	public Circulo(Double radio1, Punto centro) {
		super(radio1, radio1, centro);
	}
	
	@Override
	public Double calcularPerimetro() {
		return 2 * Math.PI * getRadioMayor();
	}

	@Override
	public String toString() {
		return "CIRCULO," + getRadioMayor() + "," + getCentro();
	}

}
