package ar.edu.uno.geometria;

import ar.edu.uno.excepciones.InvalidTrianguloException;

public class Triangulo extends Figura {

	private Punto verticeUno;
	private Punto verticeDos;
	private Punto verticeTres;

	/**
	 * pre: Vertices no iguales y que no formen una linea
	 * 
	 * post: Crea un Triangulo
	 * 
	 * @param verticeUno  Valor punto del vertice 1
	 * @param verticeDos  Valor punto del vertice 2
	 * @param verticeTres Valor punto del vertice 3
	 * @throws InvalidTrianguloException
	 */
	public Triangulo(Punto verticeUno, Punto verticeDos, Punto verticeTres) throws InvalidTrianguloException {
		this.verticeUno = verticeUno;
		this.verticeDos = verticeDos;
		this.verticeTres = verticeTres;
		if (esTrianguloInvalido()) {
			throw new InvalidTrianguloException("TRIANGULO INVALIDO: Hay vertices que coinciden o es una linea");
		}
	}

	private boolean esTrianguloInvalido() {
		boolean formanUnaLinea = (verticeUno.getX().equals(verticeDos.getX())
				&& verticeDos.getX().equals(verticeTres.getX()))
				|| (verticeUno.getY().equals(verticeDos.getY()) && verticeDos.getY().equals(verticeTres.getY()));
		boolean hayVerticesIguales = verticeUno.equals(verticeDos) || verticeDos.equals(verticeTres)
				|| verticeTres.equals(verticeUno);

		return formanUnaLinea || hayVerticesIguales;
	}

	public Double obtenerLongLado(Punto p1, Punto p2) {
		Segmento aux = new Segmento(p1, p2);
		return aux.calcularLongitud();
	}

	public boolean esParaleloAUnEje() {
		Segmento seg1 = new Segmento(verticeUno, verticeDos);
		Segmento seg2 = new Segmento(verticeDos, verticeTres);
		Segmento seg3 = new Segmento(verticeTres, verticeUno);

		return seg1.esParaleloX() || seg1.esParaleloY() || seg2.esParaleloX() || seg2.esParaleloY()
				|| seg3.esParaleloX() || seg3.esParaleloY();
	}

	public Punto getVerticeUno() {
		return verticeUno;
	}

	public Punto getVerticeDos() {
		return verticeDos;
	}

	public Punto getVerticeTres() {
		return verticeTres;
	}

	@Override
	public void desplazarEnX(Double distancia) {
		this.verticeUno.desplazarEnX(distancia);
		this.verticeDos.desplazarEnX(distancia);
		this.verticeTres.desplazarEnX(distancia);
	}

	@Override
	public void desplazarEnY(Double distancia) {
		this.verticeUno.desplazarEnY(distancia);
		this.verticeDos.desplazarEnY(distancia);
		this.verticeTres.desplazarEnY(distancia);
	}

	@Override
	public Double calcularArea() {
		Double s = this.calcularPerimetro() / 2;
		Double area = Math.sqrt(s * (s - obtenerLongLado(verticeUno, verticeDos))
				* (s - obtenerLongLado(verticeDos, verticeTres)) * (s - obtenerLongLado(verticeTres, verticeUno)));
		return area;
	}

	@Override
	public Double calcularPerimetro() {
		return obtenerLongLado(verticeUno, verticeDos) + obtenerLongLado(verticeDos, verticeTres)
				+ obtenerLongLado(verticeTres, verticeUno);
	}

	@Override
	public String toString() {
		return "TRIANGULO," + verticeUno + "," + verticeDos + "," + verticeTres;
	}

}
