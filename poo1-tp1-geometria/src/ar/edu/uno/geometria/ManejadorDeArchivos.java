package ar.edu.uno.geometria;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Locale;
import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

public class ManejadorDeArchivos {
	private TreeMap<String, LinkedList<Figura>> figuras = new TreeMap<String, LinkedList<Figura>>();
	private LinkedList<Segmento> segmentos = new LinkedList<Segmento>();

	/**
	 * post: Constructor al que se le pasa una ruta del archivo con la lista de
	 * figuras y segmentos a leer
	 * 
	 * @param ruta String con la ruta del archivo a leer
	 * @throws FileNotFoundException
	 */
	public ManejadorDeArchivos(String ruta) throws FileNotFoundException {
		this.setListas(ruta);
	}

	/**
	 * post: Setea los atributos figuras y segmentos segun el contenido de un
	 * archivo y las ordena al finalizar la carga.
	 * 
	 * @param ruta String con la ruta del archivo a leer
	 * @throws FileNotFoundException
	 */
	private void setListas(String ruta) throws FileNotFoundException {
		File archivo = new File(ruta);
		Scanner sc = new Scanner(archivo);
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
				if (tipo.equalsIgnoreCase("SEGMENTO")) {
					Punto p1 = new Punto(Double.parseDouble(arrDatos[1]), Double.parseDouble(arrDatos[2]));
					Punto p2 = new Punto(Double.parseDouble(arrDatos[3]), Double.parseDouble(arrDatos[4]));
					seg = new Segmento(p1, p2);
					this.segmentos.add(seg);
				} else {
					if (tipo.equalsIgnoreCase("CIRCULO")) {
						key = "Círculos";
						Double radio = Double.parseDouble(arrDatos[1]);
						Punto p1 = new Punto(Double.parseDouble(arrDatos[2]), Double.parseDouble(arrDatos[3]));
						fig = new Circulo(radio, p1);
					} else if (tipo.equalsIgnoreCase("ELIPSE")) {
						key = "Elipses";
						Double radio1 = Double.parseDouble(arrDatos[1]);
						Double radio2 = Double.parseDouble(arrDatos[2]);
						Punto p1 = new Punto(Double.parseDouble(arrDatos[3]), Double.parseDouble(arrDatos[4]));
						fig = new Elipse(radio1, radio2, p1);
					} else if (tipo.equalsIgnoreCase("CUADRADO")) {
						key = "Cuadrados";
						Double lado = Double.parseDouble(arrDatos[1]);
						Punto p1 = new Punto(Double.parseDouble(arrDatos[2]), Double.parseDouble(arrDatos[3]));
						fig = new Cuadrado(lado, p1);
					} else if (tipo.equalsIgnoreCase("RECTANGULO")) {
						key = "Rectángulos";
						Punto p1 = new Punto(Double.parseDouble(arrDatos[1]), Double.parseDouble(arrDatos[2]));
						Punto p2 = new Punto(Double.parseDouble(arrDatos[3]), Double.parseDouble(arrDatos[4]));
						fig = new Rectangulo(p1, p2);
					} else if (tipo.equalsIgnoreCase("TRIANGULO")) {
						key = "Triángulos";
						Punto p1 = new Punto(Double.parseDouble(arrDatos[1]), Double.parseDouble(arrDatos[2]));
						Punto p2 = new Punto(Double.parseDouble(arrDatos[3]), Double.parseDouble(arrDatos[4]));
						Punto p3 = new Punto(Double.parseDouble(arrDatos[5]), Double.parseDouble(arrDatos[6]));
						fig = new Triangulo(p1, p2, p3);
					} else {
						System.out.println(archivo.getPath() + ": Linea " + contadorLinea);
						System.out.println("El tipo de figura es incorrecto (mal tipeado)");
					}

					if (fig != null && key != null) {
						LinkedList<Figura> listaAux = this.figuras.getOrDefault(key, new LinkedList<Figura>());
						listaAux.add(fig);
						this.figuras.put(key, listaAux);
					}
				}

			} catch (Exception e) {
				System.out.println(archivo.getPath() + ": Linea " + contadorLinea);
				System.out.println(e.getMessage());
				e.printStackTrace();
			}
			contadorLinea++;
		}
		sc.close();

		// Al finalizar el ingreso, ordenar nuestras figuras y segmentos
		for (Map.Entry<String, LinkedList<Figura>> m : this.figuras.entrySet()) {
			Collections.sort(m.getValue());

		}
		Collections.sort(this.segmentos);
	}

	/**
	 * post: Crea y escribe los archivos de salida
	 * 
	 * @throws IOException
	 */
	public void escribirSalidas() throws IOException {
		this.escribirListadoTodasLasFiguras();
		this.escribirParalelos();
		this.escribirGrandotes();
	}

	/**
	 * post: Crea y escribe el archivo con el listado de todas las figuras
	 * 
	 * @throws IOException
	 */
	private void escribirListadoTodasLasFiguras() throws IOException {
		// preparo el arch de salida
		FileWriter archivo = new FileWriter("arch/figuras.out");
		PrintWriter salida = new PrintWriter(archivo);

		for (Map.Entry<String, LinkedList<Figura>> m : this.figuras.entrySet()) {
			salida.println(m.getKey());
			for (Figura f : m.getValue()) {
				salida.println(f);
			}
		}
		salida.close();
	}

	/**
	 * post: Crea y escribe el archivo con el listado de las figuras de mayor area y
	 * los segmentos mas largos
	 * 
	 * @throws IOException
	 */
	private void escribirGrandotes() throws IOException {
		// preparo el arch de salida
		FileWriter archivo = new FileWriter("arch/grandotes.out");
		PrintWriter salida = new PrintWriter(archivo);

		LinkedList<Figura> figurasMasGrandes = new LinkedList<Figura>();
		LinkedList<Segmento> segmentosMasLargos = new LinkedList<Segmento>();
		Double mayorArea = 0.0;
		Double mayorLargo = 0.0;
		Double areaFigura;
		Double largoSegmento;
		boolean seguir;
		
		Iterator<Map.Entry<String, LinkedList<Figura>>> itrSF = this.figuras.entrySet().iterator();
		while (itrSF.hasNext()) {
			Iterator<Figura> itrF = itrSF.next().getValue().iterator();
			seguir = true;
			while (itrF.hasNext() && seguir) {
				Figura f = itrF.next();
				areaFigura = f.calcularArea();
				if (areaFigura > mayorArea) {
					mayorArea = areaFigura;
					figurasMasGrandes.clear();
					figurasMasGrandes.add(f);
				} else if (areaFigura.equals(mayorArea)) {
					figurasMasGrandes.add(f);
				} else {
					seguir = false;
				}
			}
		}

		seguir = true;

		Iterator<Segmento> itrS = this.segmentos.iterator();
		while (itrS.hasNext() && seguir) {
			Segmento s = itrS.next();
			largoSegmento = s.calcularLongitud();
			if (largoSegmento > mayorLargo) {
				mayorLargo = largoSegmento;
				segmentosMasLargos.add(s);
			} else if (largoSegmento.equals(mayorLargo)) {
				segmentosMasLargos.add(s);
			} else {
				seguir = false;
			}
		}

		for (Figura f : figurasMasGrandes) {
			salida.println(f);
		}
		for (Segmento s : segmentosMasLargos) {
			salida.println(s);
		}

		salida.close();
	}

	/**
	 * post: Crea y escribe el archivo con el listado de todos los triangulos y
	 * segmentos que son paralelaos a uno de los ejes
	 * 
	 * @throws IOException
	 */
	private void escribirParalelos() throws IOException {

		// preparo el arch de salida
		FileWriter archivo = new FileWriter("arch/paralelos.out");
		PrintWriter salida = new PrintWriter(archivo);

		LinkedList<Figura> listaTriangulos = this.figuras.get("Triángulos");

		for (Figura f : listaTriangulos) {
			Triangulo triangulo = (Triangulo) f;
			if (triangulo.esParaleloAUnEje()) {
				salida.println(triangulo);
			}
		}

		for (Segmento s : this.segmentos) {
			if (s.esParaleloX() || s.esParaleloY()) {
				salida.println(s);
			}
		}

		salida.close();
	}

	public TreeMap<String, LinkedList<Figura>> getFiguras() {
		return figuras;
	}

	public LinkedList<Segmento> getSegmentos() {
		return segmentos;
	}
}
