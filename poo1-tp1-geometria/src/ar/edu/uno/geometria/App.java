package ar.edu.uno.geometria;

import java.io.IOException;

public class App {
	public static void main(String[] args) throws IOException {

		/* Creamos nuestro manejador de Archivos */
		ManejadorDeArchivos manejador = new ManejadorDeArchivos();
		/* Cargamos el archivo input */
		manejador.setListas("./arch/input.csv");
		/* Hacemos el output de todas las figuras ordenadas por area */
		manejador.escribirListadoTodasLasFiguras();
		/* Hacemos el output de las figuras mas grandes y los segmentos mas grandes */
		manejador.escribirGrandotes();
		/* Hacemos el output de los triangulos y los segmentos paralelos a alguno de los ejes */
		manejador.escribirParalelos();

	}
}
