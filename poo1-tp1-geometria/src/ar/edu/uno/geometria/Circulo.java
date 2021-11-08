package ar.edu.uno.geometria;

public class Circulo extends Elipse {

	/**
	 * post: Crea un Circulo
	 * 
	 * @param radio1	Valor Double de la longitud del radio
	 * @param centro	Valor punto del centro del circulo
	 */
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
