package ar.edu.uno.tests;

import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;
import ar.edu.uno.excepciones.InvalidRadioException;
import ar.edu.uno.geometria.Elipse;
import ar.edu.uno.geometria.Punto;

public class ElipseTest {

	private Elipse elipse1;
	private Elipse elipse2;
	
	@Before
	public void setUp() throws Exception {	
		
		elipse1 = new Elipse(2.0, 4.0, new Punto(1.0,1.0));
		elipse2 = new Elipse(3.0, 1.0, new Punto(4.0,4.0));
	}
		
	@Test
	
	public void testCreacionElipse() {
		assertNotNull(elipse1);
		assertNotNull(elipse2);
		}
	@Test (expected = InvalidRadioException.class)
	public void testRadioInvalido() {
		elipse1 = new Elipse(-4.0, 2.0, new Punto(1.0,1.0));
}
	@Test
	public void testDesplazarElipse() {
		assertEquals(elipse1.getCentro(), new Punto(1.0, 1.0));
		assertEquals(elipse2.getCentro(), new Punto(4.0, 4.0));

		elipse1.desplazarEnX(6.0);
		elipse1.desplazarEnY(1.0);
		elipse2.desplazarEnX(10.0);
		elipse2.desplazarEnY(-3.0);

		assertEquals(elipse1.getCentro(), new Punto(7.00, 2.00));
		assertEquals(elipse2.getCentro(), new Punto(14.00, 1.00));
}
	@Test
	public void testCalcularAreaElipse() {
		assertEquals(elipse1.calcularArea(), 25.13, 0.1);
		assertEquals(elipse2.calcularArea(), 9.42, 0.1);
	}

	@Test
	public void testCalcularPerimetroElipse() {
		assertEquals(elipse1.calcularPerimetro(), 19.40, 0.1);
		assertEquals(elipse2.calcularPerimetro(), 13.30, 0.1);

	}
	@Test
	public void compararAreas() {
		assertTrue(elipse1.compareTo(elipse1) == 0);
		assertTrue(elipse2.compareTo(elipse2) == 0);
		assertTrue(elipse1.compareTo(elipse2) < 0);

	}
	@Test
	public void mostrarToString() {
		String esperado = "ELIPSE,4.0,2.0,1.0,1.0";
		String obtenido = elipse1.toString();
		
		assertEquals(esperado, obtenido);
	}
}