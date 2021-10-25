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
	
	public Double obtenerLongLado(Punto p1, Punto p2) {
		Segmento aux = new Segmento(p1, p2);
		return aux.calcularLongitud();
	}

	@Override
	public Double calcularArea() {
		Double s = this.calcularPerimetro() / 2;
		Double area = Math.sqrt(s * 
				(s - obtenerLongLado(verticeUno, verticeDos)) * 
				(s - obtenerLongLado(verticeDos, verticeTres)) * 
				(s - obtenerLongLado(verticeTres, verticeUno)));
		return area;
	}

	@Override
	public Double calcularPerimetro() {
		return obtenerLongLado(verticeUno, verticeDos) + 
				obtenerLongLado(verticeDos, verticeTres) + 
				obtenerLongLado(verticeTres, verticeUno);
	}

	public Punto getVerticeUno() {
		return verticeUno;
	}

	public void setVerticeUno(Punto verticeUno) {
		this.verticeUno = verticeUno;
	}

	public Punto getVerticeDos() {
		return verticeDos;
	}

	public void setVerticeDos(Punto verticeDos) {
		this.verticeDos = verticeDos;
	}

	public Punto getVerticeTres() {
		return verticeTres;
	}

	public void setVerticeTres(Punto verticeTres) {
		this.verticeTres = verticeTres;
	}

	@Override
	public String toString() {
		return "[verticeUno=" + verticeUno + ", verticeDos=" + verticeDos + ", verticeTres=" + verticeTres
				+ "]";
	}

}
