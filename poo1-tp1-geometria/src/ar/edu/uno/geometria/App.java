package ar.edu.uno.geometria;

import java.io.FileNotFoundException;
import java.util.Collections;
import java.util.LinkedList;

import java.util.Map;

public class App {
	public static void main(String[] args) throws FileNotFoundException {
		
		LectorArchivos lector = new LectorArchivos();
		
		lector.setListas("./arch/input.csv");
		
		for (Map.Entry<String, LinkedList<Figura>> m : lector.getFiguras().entrySet()) {
			Collections.sort(m.getValue());
			System.out.println(m.getKey());
			for (Figura f : m.getValue()) {
				System.out.println(f.calcularArea());
			}
		}
		
	}
}
