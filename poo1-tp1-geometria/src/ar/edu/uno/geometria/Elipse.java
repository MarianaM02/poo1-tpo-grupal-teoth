package ar.edu.uno.geometria;

import ar.edu.uno.excepciones.InvalidRadioException;

public class Elipse extends Figura {
	private Punto centro;
	private Double radioMayor;
	private Double radioMenor;

	/**
	 * pre: Radios con valores positivos y orden de los radios ingresados
	 * 
	 * post: Crea un Elipse
	 * 
	 * @param radio1 Valor Double del radio 1 del elipse
	 * @param radio2 Valor Double del radio 2 del elipse
	 * @param centro Valor Punto del centro del elipse
	 * @throws InvalidRadioException
	 */
	public Elipse(Double radio1, Double radio2, Punto centro) throws InvalidRadioException {
		if (radio1 <= 0 || radio2 <= 0) {
			throw new InvalidRadioException("RADIO INVALIDO: Radios menores o iguales a 0");
		}
		this.centro = centro;
		if (radio1 > radio2) {
			this.radioMayor = radio1;
			this.radioMenor = radio2;
		} else {
			this.radioMayor = radio2;
			this.radioMenor = radio1;
		}
	}

	public Punto getCentro() {
		return centro;
	}

	public Double getRadioMayor() {
		return radioMayor;
	}

	public Double getRadioMenor() {
		return radioMenor;
	}

	@Override
	public void desplazarEnX(Double distancia) {
		this.centro.desplazarEnX(distancia);
	}

	@Override
	public void desplazarEnY(Double distancia) {
		this.centro.desplazarEnY(distancia);
	}

	@Override
	public Double calcularArea() {
		return Math.PI * this.radioMayor * this.radioMenor;
	}

	@Override
	public Double calcularPerimetro() {
		// aproximacion formula de Ramanujan
		Double h = Math.pow((radioMayor - radioMenor) / (radioMayor + radioMenor), 2);
		Double p = Math.PI * (radioMayor + radioMenor) * (1 + ((3 * h) / (10 + Math.sqrt(4 - 3 * h))));
		return p;
	}

//	public Double calcularPerimetro2() {
//		// aproximacion aproximada
//		return Math.PI * (this.radioMayor + this.radioMenor);
//	}

	@Override
	public String toString() {
		return "ELIPSE," + getRadioMayor() + "," + getRadioMenor() + "," + getCentro();
	}

}
