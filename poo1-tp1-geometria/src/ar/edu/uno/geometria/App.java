package ar.edu.uno.geometria;

import java.io.IOException;

public class App {
	public static void main(String[] args) throws IOException {

		/* Creamos nuestro manejador de Archivos con la ruta del archivo a leer */
		ManejadorDeArchivos manejador = new ManejadorDeArchivos("./arch/input.csv");
	
		/* Hacemos el output */
		manejador.escribirSalidas();

	}
}
