package ar.edu.uno.geometria;

public class Triangulo extends Figura {

	private Punto verticeUno;
	private Punto verticeDos;
	private Punto verticeTres;

	public Triangulo(Punto verticeUno, Punto verticeDos, Punto verticeTres) {
		this.verticeUno = verticeUno;
		this.verticeDos = verticeDos;
		this.verticeTres = verticeTres;
	}

	public Double obtenerLongLado(Punto p1, Punto p2) {
		Segmento aux = new Segmento(p1, p2);
		return aux.calcularLongitud();
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
		return "TRIANGULO," + verticeUno+ "," + verticeDos + "," + verticeTres;
	}

}
