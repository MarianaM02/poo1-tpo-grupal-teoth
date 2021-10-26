package ar.edu.uno.geometria;

public class Rectangulo extends Figura{
	private Punto esqInfIzq;
	private Punto esqSupDer;
	
	public Rectangulo(Punto esqInfIzq, Punto esqSupDer) {
		super();
		this.esqInfIzq = esqInfIzq;
		this.esqSupDer = esqSupDer;
	}

	public Double calcularBase() {
		Punto esqInfDer = new Punto(esqSupDer.getX(), esqInfIzq.getY());
		Segmento base = new Segmento(esqInfIzq, esqInfDer);
		
		return base.calcularLongitud();
	}

	public Double calcularAltura() {
		Punto esqSupIzq = new Punto(esqInfIzq.getX(), esqSupDer.getY());
		Segmento altura = new Segmento(esqInfIzq, esqSupIzq);
		
		return altura.calcularLongitud();
	}
	
	public Punto getEsqInfIzq() {
		return esqInfIzq;
	}

	public Punto getEsqSupDer() {
		return esqSupDer;
	}

	@Override
	public void desplazarEnX(Double distancia) {
		esqInfIzq.desplazarEnX(distancia);
		esqSupDer.desplazarEnX(distancia);
	}

	@Override
	public void desplazarEnY(Double distancia) {
		esqInfIzq.desplazarEnY(distancia);
		esqSupDer.desplazarEnY(distancia);
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
		return "RECTANGULO," + esqInfIzq + "," + esqSupDer;
	}

}
