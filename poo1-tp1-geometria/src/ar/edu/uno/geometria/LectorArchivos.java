package ar.edu.uno.geometria;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.LinkedList;
import java.util.Locale;
import java.util.Scanner;
import java.util.TreeMap;

public class LectorArchivos {
	private TreeMap<String, LinkedList<Figura>> figuras = new TreeMap<String,LinkedList<Figura>>();
	private LinkedList<Segmento> segmentos = new LinkedList<Segmento>();

	public TreeMap<String, LinkedList<Figura>> getFiguras() {
		return figuras;
	}

	public LinkedList<Segmento> getSegmentos() {
		return segmentos;
	}

	public void setListas(String ruta) throws FileNotFoundException {
		Scanner sc = new Scanner(new File(ruta));
		sc.useLocale(Locale.ENGLISH);
		String datos;
		String[] arrDatos;
		String tipo;
		Figura fig = null;
		Segmento seg = null;
		String key = null;
		int contadorLinea = 1;

		while (sc.hasNext()) {
			try {
				datos = sc.nextLine(); // CUADRADO,6.00,7.00,6.00
				arrDatos = datos.split(",");// {CUADRADO , 6.00 , 7.00 , 6.00 }
				tipo = arrDatos[0];
				if (tipo.equals("SEGMENTO")) {
					Punto p1 = new Punto(Double.parseDouble(arrDatos[1]), Double.parseDouble(arrDatos[2]));
					Punto p2 = new Punto(Double.parseDouble(arrDatos[3]), Double.parseDouble(arrDatos[4]));
					seg = new Segmento(p1, p2);
					this.segmentos.add(seg);

				} else {

					if (tipo.equals("CIRCULO")) {
						key = "Círculo";
						Double radio = Double.parseDouble(arrDatos[1]);
						Punto p1 = new Punto(Double.parseDouble(arrDatos[2]), Double.parseDouble(arrDatos[3]));
						fig = new Circulo(radio, p1);
					}

					if (tipo.equals("ELIPSE")) {
						key = "Elípse";
						Double radio1 = Double.parseDouble(arrDatos[1]);
						Double radio2 = Double.parseDouble(arrDatos[2]);
						Punto p1 = new Punto(Double.parseDouble(arrDatos[3]), Double.parseDouble(arrDatos[4]));
						fig = new Elipse(radio1, radio2, p1);
					}

					if (tipo.equals("CUADRADO")) {
						key = "Cuadrado";
						Double lado = Double.parseDouble(arrDatos[1]);
						Punto p1 = new Punto(Double.parseDouble(arrDatos[2]), Double.parseDouble(arrDatos[3]));
						fig = new Cuadrado(lado, p1);
					}

					if (tipo.equals("RECTANGULO")) {
						key = "Rectángulo";
						Punto p1 = new Punto(Double.parseDouble(arrDatos[1]), Double.parseDouble(arrDatos[2]));
						Punto p2 = new Punto(Double.parseDouble(arrDatos[3]), Double.parseDouble(arrDatos[4]));
						fig = new Rectangulo(p1, p2);
					}

					if (tipo.equals("TRIANGULO")) {
						key = "Triángulo";
						Punto p1 = new Punto(Double.parseDouble(arrDatos[1]), Double.parseDouble(arrDatos[2]));
						Punto p2 = new Punto(Double.parseDouble(arrDatos[3]), Double.parseDouble(arrDatos[4]));
						Punto p3 = new Punto(Double.parseDouble(arrDatos[5]), Double.parseDouble(arrDatos[6]));
						fig = new Triangulo(p1, p2, p3);
					}

					if (fig != null && key !=null) {
						LinkedList<Figura> listaAux = this.figuras.getOrDefault(key, new LinkedList<Figura>());
						listaAux.add(fig);
						this.figuras.put(key, listaAux);
					}
				}

			} catch (Exception e) {
				System.out.println(e.getMessage());
				System.out.println(contadorLinea);
				e.printStackTrace();
				
			}
			contadorLinea++;

		}
		sc.close();
	}


}
