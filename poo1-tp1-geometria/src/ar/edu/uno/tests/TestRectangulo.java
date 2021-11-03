package ar.edu.uno.tests;

import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;

import ar.edu.uno.excepciones.InvalidRectanguloException;
import ar.edu.uno.geometria.*;

public class TestRectangulo {
	private Rectangulo rectanguloUno;
	private Rectangulo rectanguloDos;
	private Rectangulo rectanguloTres;

	@Before
	public void setUp() throws Exception {
		rectanguloUno = new Rectangulo(new Punto(10.0, 10.0), new Punto(2.0, 6.0));
		rectanguloDos = new Rectangulo(new Punto(2.0, 5.0), new Punto(8.0, 4.0));
		rectanguloTres = new Rectangulo(new Punto(10.0, 4.0), new Punto(3.0, 6.0));
	}

	@Test
	public void testCreacionRectangulo() {
		assertNotNull(rectanguloUno);
		assertNotNull(rectanguloDos);
		assertNotNull(rectanguloTres);
	}
	
	@Test (expected = InvalidRectanguloException.class)
	public void testRectanguloInvalido() {
		rectanguloUno = new Rectangulo(new Punto(10.0, 4.0), new Punto(10.0, 6.0));
	}

	@Test
	public void testBaseRectangulo() {
		assertEquals("Base esperada 8.0", rectanguloUno.calcularBase(), 8, 0.0);
		assertEquals("Base esperada 6.0", rectanguloDos.calcularBase(), 6, 0.0);
		assertEquals("Base esperada 7", rectanguloTres.calcularBase(), 7, 0.0);
	}

	@Test
	public void testAlturaRectangulo() {
		assertEquals("Altura esperada 4", rectanguloUno.calcularAltura(), 4, 0.0);
		assertEquals("Altura esperada 1", rectanguloDos.calcularAltura(), 1, 0.0);
		assertEquals("Altura esperada 2", rectanguloTres.calcularAltura(), 2, 0.0);
	}

	@Test
	public void testDesplazarRectangulo() {

		assertEquals(rectanguloUno.getEsquina1(), new Punto(2.0, 6.0));
		assertEquals(rectanguloDos.getEsquina1(), new Punto(8.0, 4.0));
		assertEquals(rectanguloTres.getEsquina1(), new Punto(10.0, 4.0));

		assertEquals(rectanguloUno.getEsquina2(), new Punto(10.0, 10.0));
		assertEquals(rectanguloDos.getEsquina2(), new Punto(2.0, 5.0));
		assertEquals(rectanguloTres.getEsquina2(), new Punto(3.0, 6.0));

		rectanguloUno.desplazarEnX(2.0);
		rectanguloDos.desplazarEnX(3.0);
		rectanguloTres.desplazarEnX(-4.0);

		rectanguloUno.desplazarEnY(5.0);
		rectanguloDos.desplazarEnY(-3.0);
		rectanguloTres.desplazarEnY(1.0);

		assertEquals(rectanguloUno.getEsquina1(), new Punto(4.0, 11.0));
		assertEquals(rectanguloDos.getEsquina1(), new Punto(11.0, 1.0));
		assertEquals(rectanguloTres.getEsquina1(), new Punto(6.0, 5.0));

		assertEquals(rectanguloUno.getEsquina2(), new Punto(12.0, 15.0));
		assertEquals(rectanguloDos.getEsquina2(), new Punto(5.0, 2.0));
		assertEquals(rectanguloTres.getEsquina2(), new Punto(-1.0, 7.0));

	}

	@Test
	public void testCalcularAreaRectangulo() {
		assertEquals(rectanguloUno.calcularArea(), 32.0, 0.0);
		assertEquals(rectanguloDos.calcularArea(), 6.0, 0.0);
		assertEquals(rectanguloTres.calcularArea(), 14.0, 0.0);
	}

	@Test
	public void testCalcularPerimetroRectangulo() {
		assertEquals(rectanguloUno.calcularPerimetro(), 24.0, 0.0);
		assertEquals(rectanguloDos.calcularPerimetro(), 14.0, 0.0);
		assertEquals(rectanguloTres.calcularPerimetro(), 18.0, 0.0);
	}

	@Test
	public void compararAreas() {
		
		assertTrue(rectanguloUno.compareTo(rectanguloUno) == 0);
		assertTrue(rectanguloDos.compareTo(rectanguloDos) == 0);
		assertTrue(rectanguloTres.compareTo(rectanguloTres) == 0);

		assertTrue(rectanguloUno.compareTo(rectanguloDos) < 0);
		assertTrue(rectanguloUno.compareTo(rectanguloTres) < 0);
		assertTrue(rectanguloDos.compareTo(rectanguloTres) > 0);

	}
	
	@Test
	public void mostrarToString() {
		String esperado = "RECTANGULO,8.0,4.0,2.0,5.0";
		String obtenido = rectanguloDos.toString();
		
		assertEquals(esperado, obtenido);
	}
}
