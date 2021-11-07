package ar.edu.uno.tests;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import ar.edu.uno.excepciones.InvalidRadioException;
import ar.edu.uno.geometria.Circulo;
import ar.edu.uno.geometria.Elipse;
import ar.edu.uno.geometria.Punto;


public class CirculoTest {

	private Elipse circulo1;
	private Elipse circulo2;
	
	@Before
	public void setUp() throws Exception {	
		
		circulo1 = new Circulo(4.0, new Punto(6.0,2.0));
		circulo2 = new Circulo(3.0, new Punto(4.0,7.0));
	}
	
	@Test

	public void testCreacionCirculo() {
		assertNotNull(circulo1);
		assertNotNull(circulo2);
		}
	@Test (expected = InvalidRadioException.class)
	public void testRadioInvalido() {
		circulo1 = new Elipse(-4.0, 2.0, new Punto(1.0,1.0));
}
	@Test
	public void testDesplazarElipse() {
		assertEquals(circulo1.getCentro(), new Punto(6.0, 2.0));
		assertEquals(circulo2.getCentro(), new Punto(4.0, 7.0));

		circulo1.desplazarEnX(6.0);
		circulo1.desplazarEnY(1.0);
		circulo2.desplazarEnX(10.0);
		circulo2.desplazarEnY(-3.0);

	
		assertEquals(circulo1.getCentro(), new Punto(12.00, 3.00));
		assertEquals(circulo2.getCentro(), new Punto(14.00, 4.00));
}
	@Test
	public void testCalcularAreaElipse() {
		assertEquals(circulo1.calcularArea(), 50.27, 0.1);
		assertEquals(circulo2.calcularArea(), 28.27, 0.1);
	}

	@Test
	public void testCalcularPerimetroElipse() {
		assertEquals(circulo1.calcularPerimetro(), 25.13, 0.1);
		assertEquals(circulo2.calcularPerimetro(), 18.85, 0.1);

	}
	@Test
	public void compararAreas() {
		assertTrue(circulo1.compareTo(circulo1) == 0);
		assertTrue(circulo2.compareTo(circulo2) == 0);
		assertTrue(circulo1.compareTo(circulo2) < 0);

	}
	@Test
	public void mostrarToString() {
		String esperado = "CIRCULO,4.0,6.0,2.0";
		String obtenido = circulo1.toString();
		
		assertEquals(esperado, obtenido);
	}


	}

