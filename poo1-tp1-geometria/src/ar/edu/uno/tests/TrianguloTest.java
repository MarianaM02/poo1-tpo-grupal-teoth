package ar.edu.uno.tests;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import ar.edu.uno.excepciones.InvalidTrianguloException;
import ar.edu.uno.geometria.Punto;
import ar.edu.uno.geometria.Triangulo;



public class TrianguloTest {
	
	private Triangulo trianguloUno;
	private Triangulo trianguloDos;
	private Triangulo trianguloTres;

	@Before
	public void setUp() throws Exception {
		trianguloUno = new Triangulo (new Punto (7.0 , 2.0), new Punto (6.0, 5.0), new Punto(3.0, 3.0));
		trianguloDos = new Triangulo (new Punto (2.0 , 8.0), new Punto (2.0, 9.0), new Punto(10.0, 5.0));
		trianguloTres = new Triangulo (new Punto (5.0 , 7.0), new Punto (6.0, 3.0), new Punto(3.0, 5.0));
	}

	@Test
	public void testCreacionTriangulo() {
		assertNotNull(trianguloUno);
		assertNotNull(trianguloDos);
		assertNotNull(trianguloTres);
	}
	
	@Test (expected = InvalidTrianguloException.class)
    public void testCreacionTrianguloVerticesIgualesInvalido() {
        trianguloTres = new Triangulo (new Punto (3.0 , 5.0), new Punto (5.0, 3.0), new Punto(5.0, 3.0));
    }
	
	@Test (expected = InvalidTrianguloException.class)
    public void testCreacionTrianguloFormanLineaXInvalido() {
        trianguloTres = new Triangulo (new Punto (5.0 , 5.0), new Punto (5.0, 3.0), new Punto(5.0, 2.0));
    }
	
	@Test (expected = InvalidTrianguloException.class)
    public void testCreacionTrianguloFormanLineaYInvalido() {
        trianguloTres = new Triangulo (new Punto (3.0 , 5.0), new Punto (4.0, 5.0), new Punto(5.0, 5.0));
    }
	
	@Test
	public void esParaleloAUnEjeTest() {
		assertFalse(trianguloTres.esParaleloAUnEje());
		
		assertTrue(trianguloDos.esParaleloAUnEje());
	}
	
	@Test
	public void testObtenerLado() {
		assertEquals(trianguloUno.getVerticeUno(), new Punto (7.0, 2.0));
		assertEquals(trianguloUno.getVerticeDos(), new Punto (6.0, 5.0));
		assertEquals(trianguloUno.getVerticeTres(), new Punto (3.0, 3.0));
		
	}
	
	@Test
	public void testPerimetro() {
		assertEquals(trianguloUno.calcularPerimetro(), 10.89093456125003, 0.0);
		assertEquals(trianguloDos.calcularPerimetro(), 18.48827565531669, 0.0);
		assertEquals(trianguloTres.calcularPerimetro(), 10.55708402582784, 0.0);
	}
	
	@Test
	public void testArea() {
		assertEquals(trianguloUno.calcularArea(), 5.5, 0.0);
		assertEquals(trianguloDos.calcularArea(), 4.000000000000006, 0.0);
		assertEquals(trianguloTres.calcularArea(), 4.999999999999997, 0.0);
	}
	
	
	@Test
	public void testDesplasarTriangulo() {
		assertEquals(trianguloUno.getVerticeUno(), new Punto(7.0, 2.0));
		assertEquals(trianguloUno.getVerticeDos(), new Punto(6.0, 5.0));
		assertEquals(trianguloUno.getVerticeTres(), new Punto(3.0, 3.0));
		
		trianguloUno.desplazarEnX(2.0);
		trianguloUno.desplazarEnY(4.0);
		
		assertEquals(trianguloUno.getVerticeUno(), new Punto(9.0, 6.0));
		assertEquals(trianguloUno.getVerticeDos(), new Punto(8.0, 9.0));
		assertEquals(trianguloUno.getVerticeTres(), new Punto(5.0, 7.0));
		
		trianguloDos.desplazarEnX(8.0);
		trianguloDos.desplazarEnY(-2.0);
		
		//(new Punto (2.0 , 8.0), new Punto (2.0, 9.0), new Punto(10.0, 5.0)
		
		assertEquals(trianguloDos.getVerticeUno(), new Punto(10.0, 6.0));
		assertEquals(trianguloDos.getVerticeDos(), new Punto(10.0, 7.0));
		assertEquals(trianguloDos.getVerticeTres(), new Punto(18.0, 3.0));
		
		
	}
	
	@Test
	public void testToString() {
		String esperado = "TRIANGULO,7.0,2.0,6.0,5.0,3.0,3.0";
		String obtenido = trianguloUno.toString();
		assertEquals(esperado, obtenido);
	}
	
	
	

}
