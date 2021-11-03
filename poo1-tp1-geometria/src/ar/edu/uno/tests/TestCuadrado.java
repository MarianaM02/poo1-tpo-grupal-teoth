package ar.edu.uno.tests;

import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;

import ar.edu.uno.excepciones.InvalidCuadradoException;
import ar.edu.uno.geometria.*;

public class TestCuadrado {

	private Cuadrado cuadradoUno;
	private Cuadrado cuadradoDos;

	@Before
	public void setUp() throws Exception {
		cuadradoUno = new Cuadrado(6.00, new Punto(7.00, 6.00));
		cuadradoDos = new Cuadrado(8.00, new Punto(4.0, 9.0));

	}

	@Test
	public void testCreacionCuadrado() {
		assertNotNull(cuadradoUno);
		assertNotNull(cuadradoDos);
	}
	
	@Test (expected = InvalidCuadradoException.class)
	public void testLadoInvalido() {
		cuadradoUno = new Cuadrado(-3.0, new Punto(7.00, 6.00));
	}

	@Test
	public void testLadoCuadrado() {
		assertEquals(cuadradoUno.getLado(), 6.00, 0.00);
		assertEquals(cuadradoDos.calcularBase(), 8.00, 0.00);

	}

	@Test
	public void testDesplazarCuadrado() {
		assertEquals(cuadradoUno.getEsquina1(), new Punto(7.00, 6.00));
		assertEquals(cuadradoDos.getEsquina1(), new Punto(4.00, 9.00));

		cuadradoUno.desplazarEnX(6.0);
		cuadradoDos.desplazarEnX(-13.0);

		cuadradoUno.desplazarEnY(1.0);
		cuadradoDos.desplazarEnY(54.0);

		assertEquals(cuadradoUno.getEsquina1(), new Punto(13.00, 7.00));
		assertEquals(cuadradoDos.getEsquina1(), new Punto(-9.00, 63.0));
	}

	@Test
	public void testCalcularAreaCuadrado() {
		assertEquals(cuadradoUno.calcularArea(), 36.0, 0.00);
		assertEquals(cuadradoDos.calcularArea(), 64.0, 0.00);

	}

	@Test
	public void testCalcularPerimetroCuadrado() {
		assertEquals(cuadradoUno.calcularPerimetro(), 24.0, 0.00);
		assertEquals(cuadradoDos.calcularPerimetro(), 32.0, 0.00);

	}

	@Test
	public void compararAreas() {
		assertTrue(cuadradoUno.compareTo(cuadradoUno) == 0);
		assertTrue(cuadradoDos.compareTo(cuadradoDos) == 0);
		assertTrue(cuadradoUno.compareTo(cuadradoDos) > 0);

	}
	
	@Test
	public void mostrarToString() {
		String esperado = "CUADRADO,8.0,4.0,9.0";
		String obtenido = cuadradoDos.toString();
		
		assertEquals(esperado, obtenido);
	}
}
