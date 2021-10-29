package ar.edu.uno.geometria;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class App {
	public static void main(String[] args) {
		List<Figura> figuras = new ArrayList<Figura>();
		Triangulo tri = new Triangulo(new Punto(2.0,1.0), new Punto(5.0,2.0), new Punto(7.0,4.0));
		Circulo cir = new Circulo(5.0, new Punto(2.0,1.0));
		Elipse eli = new Elipse(5.0, 3.0, new Punto(2.0,1.0));
		Rectangulo rec = new Rectangulo(new Punto(2.0,1.0), new Punto(7.0,7.0));
		Cuadrado cua = new Cuadrado(6.0, new Punto(2.0,1.0));
		Segmento seg = new Segmento(new Punto(2.0,1.0), new Punto(8.0,9.0));
		
		figuras.add(tri);
		figuras.add(cir);
		figuras.add(eli);
		figuras.add(rec);
		figuras.add(cua);
		
		Collections.sort(figuras);
		for (Figura f : figuras) {
			System.out.println(f);
			System.out.println(f.calcularArea());
		}
		System.out.println(seg);

		
	}
}
