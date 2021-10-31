package ar.edu.uno.tests;

import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;
import ar.edu.uno.geometria.*;

public class TestCuadrado {

	private Cuadrado CuadradoUno;
	private Cuadrado CuadradoDos;

	@Before
	public void setUp() throws Exception {
		CuadradoUno = new Cuadrado(6.00, new Punto(7.00, 6.00));
		CuadradoDos = new Cuadrado(8.00, new Punto(4.0, 9.0));

	}

	@Test
	public void testCreacionCuadrado() {
		assertNotNull(CuadradoUno);
		assertNotNull(CuadradoDos);
	}

	@Test
	public void testLadoCuadrado() {
		assertEquals(CuadradoUno.getLado(), 6.00, 0.00);
		assertEquals(CuadradoDos.calcularBase(), 8.00, 0.00);

	}

	@Test
	public void testDesplazarCuadrado() {
		assertEquals(CuadradoUno.getEsqInfIzq(), new Punto(7.00, 6.00));
		assertEquals(CuadradoDos.getEsqInfIzq(), new Punto(4.00, 9.00));

		CuadradoUno.desplazarEnX(6.0);
		CuadradoDos.desplazarEnX(-13.0);

		CuadradoUno.desplazarEnY(1.0);
		CuadradoDos.desplazarEnY(54.0);

		assertEquals(CuadradoUno.getEsqInfIzq(), new Punto(13.00, 7.00));
		assertEquals(CuadradoDos.getEsqInfIzq(), new Punto(-9.00, 63.0));
	}

	@Test
	public void testCalcularAreaCuadrado() {
		assertEquals(CuadradoUno.calcularArea(), 36.0, 0.00);
		assertEquals(CuadradoDos.calcularArea(), 64.0, 0.00);

	}

	@Test
	public void testCalcularPerimetroCuadrado() {
		assertEquals(CuadradoUno.calcularPerimetro(), 24.0, 0.00);
		assertEquals(CuadradoDos.calcularPerimetro(), 32.0, 0.00);

	}

	@Test
	public void CompararAreas() {
		assertTrue(CuadradoUno.compareTo(CuadradoUno) == 0);
		assertTrue(CuadradoDos.compareTo(CuadradoDos) == 0);
		assertTrue(CuadradoUno.compareTo(CuadradoDos) > 0);

	}
}
