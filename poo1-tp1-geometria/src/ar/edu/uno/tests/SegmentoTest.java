package ar.edu.uno.tests;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import ar.edu.uno.excepciones.InvalidSegmentoException;
import ar.edu.uno.geometria.Punto;
import ar.edu.uno.geometria.Segmento;

public class SegmentoTest {

	Segmento seg1;
	Segmento seg2;
	Segmento seg3;
	Segmento seg4;
	Segmento seg5;
	
	@Before
	public void setUp() throws Exception {
		seg1 = new Segmento(new Punto(-6.0, -2.0), new Punto(2.0, 3.0));
		seg2 = new Segmento(new Punto(-4.0, 2.0), new Punto(0.0, 0.0));
		seg3 = new Segmento(new Punto(8.0, -3.0), new Punto(6.0, -2.0));
		seg4 = new Segmento(new Punto(-2.0, -3.0), new Punto(1.0, -3.0));
		seg5 = new Segmento(new Punto(-1.0, 6.0), new Punto(-1.0, 4.0));
	}

	@Test
	public void crearSegmentoTest() {
		assertNotNull(seg1);
	}
	
	@Test (expected = InvalidSegmentoException.class )
	public void crearSegmentoPuntosInvalidosTest() {
		seg4 = new Segmento(new Punto(-6.0, -2.0), new Punto(-6.0, -2.0));
	}

	@Test
	public void calcularLongitudTest() {
		assertEquals(4.47213595499958, seg2.calcularLongitud(), 0.0000001);
		assertEquals(3.0, seg4.calcularLongitud(), 0.0000001);
		
	}
	
	@Test
	public void calcularPendienteTest() {
		assertEquals(-0.5, seg3.calcularPendiente(), 0.0000001);
		assertEquals(0.0, seg4.calcularPendiente(), 0.0000001);
		Double esperado = Double.POSITIVE_INFINITY;
		assertEquals(esperado, seg5.calcularPendiente());
	}
	
	@Test
	public void esParaleloTest() {
		assertFalse(seg1.esParaleloA(seg2));
		assertTrue(seg2.esParaleloA(seg3));
		
		assertFalse(seg1.esParaleloX());
		assertTrue(seg4.esParaleloX());
		
		assertFalse(seg1.esParaleloY());
		assertTrue(seg5.esParaleloY());
	}
	
	@Test
	public void desplazarTest() {
		seg1.desplazarEnX(5.2);
		assertEquals(-0.8, seg1.getPunto1().getX(), 0.0000001);
		assertEquals(-2.0, seg1.getPunto1().getY(), 0.0000001);
		assertEquals(7.2, seg1.getPunto2().getX(), 0.0000001);
		assertEquals(3.0, seg1.getPunto2().getY(), 0.0000001);

		seg2.desplazarEnY(-2.7);
		assertEquals(-4, seg2.getPunto1().getX(), 0.0000001);
		assertEquals(-0.7, seg2.getPunto1().getY(), 0.0000001);
		assertEquals(0.0, seg2.getPunto2().getX(), 0.0000001);
		assertEquals(-2.7, seg2.getPunto2().getY(), 0.0000001);
		
	}
	
	@Test
	public void compareToTest() {
		System.out.println(seg1.calcularLongitud());
		System.out.println(seg2.calcularLongitud());
		System.out.println(seg3.calcularLongitud());
		assertTrue(seg1.compareTo(seg2) == -1);
		assertTrue(seg1.compareTo(seg1) == 0);
		assertTrue(seg3.compareTo(seg2) == 1);
	}
	
	@Test
	public void mostrarToString() {
		String esperado = "SEGMENTO,-6.0,-2.0,2.0,3.0";
		String obtenido = seg1.toString();
		
		assertEquals(esperado, obtenido);
	}
	
}
