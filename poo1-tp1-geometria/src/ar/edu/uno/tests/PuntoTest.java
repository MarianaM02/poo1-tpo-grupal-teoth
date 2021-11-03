package ar.edu.uno.tests;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import ar.edu.uno.geometria.Punto;

public class PuntoTest {

	private Punto puntoUno;
	private Punto puntoDos;
	private Punto puntoTres;

	@Before
	public void setUp() throws Exception {
		puntoUno = new Punto(4.0, 4.0);
		puntoDos = new Punto(-2.0, -2.0);
		puntoTres = new Punto(0.0, 0.0);
	}

	@Test
	public void testExistePunto() {
		assertNotNull(puntoUno);
		assertNotNull(puntoDos);
		assertNotNull(puntoTres);
	}

	@Test
	public void testEstaSobreEjeY() {
		assertFalse(puntoUno.estaSobreEjeY());
		assertFalse(puntoDos.estaSobreEjeY());
		assertTrue(puntoTres.estaSobreEjeY());
	}

	@Test
	public void testEstaSobreEjeX() {
		assertFalse(puntoUno.estaSobreEjeX());
		assertFalse(puntoDos.estaSobreEjeX());
		assertTrue(puntoTres.estaSobreEjeX());
	}

	@Test
	public void testEstaSobreCoordenadaOrigen() {
		assertFalse(puntoUno.esCoordenadaOrigen());
		assertFalse(puntoDos.esCoordenadaOrigen());
		assertTrue(puntoTres.esCoordenadaOrigen());
	}

	@Test
	public void testDistanciaA() {
		assertEquals(8.48, puntoUno.distanciaA(puntoDos), 0.01);
		assertEquals(2.82, puntoDos.distanciaA(puntoTres), 0.01);
		assertEquals(5.65, puntoTres.distanciaA(puntoUno), 0.01);
	}

	@Test
	public void desplazarTest() {
		// PuntoUno(4.0,4.0)
		puntoUno.desplazarEnX(4.0);
		assertEquals(8.0, puntoUno.getX(), 0.0000001);
		assertEquals(4.0, puntoUno.getY(), 0.0000001);

		puntoUno.desplazarEnY(2.0);
		assertEquals(8.0, puntoUno.getX(), 0.0000001);
		assertEquals(6.0, puntoUno.getY(), 0.0000001);

		// PuntoDos(-2.0,-2.0)
		puntoDos.desplazarEnX(4.0);
		assertEquals(2.0, puntoDos.getX(), 0.0000001);
		assertEquals(-2.0, puntoDos.getY(), 0.0000001);

		puntoDos.desplazarEnY(2.0);
		assertEquals(2.0, puntoDos.getX(), 0.0000001);
		assertEquals(0.0, puntoDos.getY(), 0.0000001);

		// PuntoTres(0.0,0.0)
		puntoTres.desplazarEnX(-1.0);
		assertEquals(-1.0, puntoTres.getX(), 0.0000001);
		assertEquals(0.0, puntoTres.getY(), 0.0000001);

		puntoTres.desplazarEnY(-1.0);
		assertEquals(-1.0, puntoTres.getX(), 0.0000001);
		assertEquals(-1.0, puntoTres.getY(), 0.0000001);

	}
	
	@Test
	public void mostrarToString() {
		String esperado = "4.0,4.0";
		String obtenido = puntoUno.toString();
		
		assertEquals(esperado, obtenido);
	}
}
