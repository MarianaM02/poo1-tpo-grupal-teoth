package ar.edu.uno.geometria;

import ar.edu.uno.excepciones.InvalidRectanguloException;

public class Rectangulo extends Figura {
	private Punto esquina1;
	private Punto esquina2;

	/**
	 * pre: Orden de las esquinas y que no formen una linea
	 * 
	 * post: Crea un Rectangulo
	 * 
	 * @param esquina1	Valor punto de la esquina 1
	 * @param esquina2	Valor punto de la esquina 2
	 * @throws InvalidRectanguloException
	 */
	public Rectangulo(Punto esquina1, Punto esquina2) throws InvalidRectanguloException {
		super();
		if (esq1EstaAbajo(esquina1, esquina2)) {
			this.esquina1 = esquina1;
			this.esquina2 = esquina2;
		} else {
			this.esquina1 = esquina2;
			this.esquina2 = esquina1;
		}
		if (esUnSegmento()) {
			throw new InvalidRectanguloException("RECTANGULO INVALIDO: Las esquinas forman una linea");
		}
	}

	private boolean esUnSegmento() {
		return this.esquina1.getX().equals(this.esquina2.getX()) 
				|| this.esquina1.getY().equals(this.esquina2.getY());
	}

	private boolean esq1EstaAbajo(Punto esquina1, Punto esquina2) {
		return esquina1.getY() < esquina2.getY();
	}

	public Double calcularBase() {
		Punto esqInfDer = new Punto(esquina2.getX(), esquina1.getY());
		Segmento base = new Segmento(esquina1, esqInfDer);

		return base.calcularLongitud();
	}

	public Double calcularAltura() {
		Punto esqSupIzq = new Punto(esquina1.getX(), esquina2.getY());
		Segmento altura = new Segmento(esquina1, esqSupIzq);

		return altura.calcularLongitud();
	}

	public Punto getEsquina1() {
		return esquina1;
	}

	public Punto getEsquina2() {
		return esquina2;
	}

	@Override
	public void desplazarEnX(Double distancia) {
		esquina1.desplazarEnX(distancia);
		esquina2.desplazarEnX(distancia);
	}

	@Override
	public void desplazarEnY(Double distancia) {
		esquina1.desplazarEnY(distancia);
		esquina2.desplazarEnY(distancia);
	}

	@Override
	public Double calcularArea() {
		return this.calcularBase() * this.calcularAltura();
	}

	@Override
	public Double calcularPerimetro() {
		return this.calcularAltura() * 2 + this.calcularBase() * 2;
	}

	@Override
	public String toString() {
		return "RECTANGULO," + esquina1 + "," + esquina2;
	}

}
