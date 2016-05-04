package org.eda1.practica02.ejercicio03;

import static org.junit.Assert.*;

import java.io.File;
import java.util.ArrayList;

import org.junit.Before;
import org.junit.Test;

public class CorrectorOrtograficoTestJUnit4 {
	String directorioEntrada;
	File archivoEntradas;

	@Before
	public void setUp() throws Exception {
		directorioEntrada = System.getProperty("user.dir");

		directorioEntrada = directorioEntrada + File.separator +
				"src" + File.separator + 
				"org" + File.separator +
				"eda1" + File.separator + 
				"practica02" + File.separator +
				"ejercicio03" + File.separator;
	}

	@Test
	public void testLevenshteinDistance()  {
		
		CorrectorOrtografico procesarTextos = new CorrectorOrtografico();
		
		assertTrue(procesarTextos.computeLevenshteinDistance("", "") == 0);
		assertTrue(procesarTextos.computeLevenshteinDistance(" ", " ") == 0);
		assertTrue(procesarTextos.computeLevenshteinDistance("calle", "calle") == 0);
		assertTrue(procesarTextos.computeLevenshteinDistance("calle", "calle ") == 1);
		assertTrue(procesarTextos.computeLevenshteinDistance("calle", "calla") == 1);		
		assertTrue(procesarTextos.computeLevenshteinDistance("calle", "casa") == 3);
	}
	
	@Test
	public void testListaSugerencias()  {
		
		CorrectorOrtografico correctorOrtografico = new CorrectorOrtografico();
		
		String archivoEntrada = "diccionario.txt";
		archivoEntrada = directorioEntrada + archivoEntrada;
		
		correctorOrtografico.cargarDiccionario(archivoEntrada);
				
		ArrayList<String> listaSugerencias = correctorOrtografico.listaSugerencias(5, "abracadabra");
		
		assertFalse(listaSugerencias.contains("abracadabra"));
		
		listaSugerencias = correctorOrtografico.listaSugerencias(5, "abrazar");
		
		assertTrue(listaSugerencias.contains("abrazar"));
	}

	@Test	
	public void testAddPalabra()  {
		
		CorrectorOrtografico correctorOrtografico = new CorrectorOrtografico();
		
		String archivoEntrada = "diccionario.txt";
		archivoEntrada = directorioEntrada + archivoEntrada;
		
		correctorOrtografico.cargarDiccionario(archivoEntrada);
		
		ArrayList<String> listaSugerencias = correctorOrtografico.listaSugerencias(5, "abracadabra");
		
		assertFalse(listaSugerencias.contains("abracadabra"));
		
		correctorOrtografico.addPalabra("abracadabra");
		
		listaSugerencias = correctorOrtografico.listaSugerencias(5, "abracadabra");
		
		assertTrue(listaSugerencias.contains("abracadabra"));
		
		assertTrue(listaSugerencias.get(0).equals("abracadabra"));
		
		assertTrue(correctorOrtografico.containsPalabra("abracadabra") == true);
	}

	@Test
	public void testDiccionarioIngles()  {
		
		CorrectorOrtografico correctorOrtografico = new CorrectorOrtografico();
		
		String archivoEntrada = "dictionary.txt";
		archivoEntrada = directorioEntrada + archivoEntrada;
		
		correctorOrtografico.cargarDiccionario(archivoEntrada);
		
		assertTrue(correctorOrtografico.find("neighbour"));
		assertFalse(correctorOrtografico.find("neighbor"));
		
		ArrayList<String> listaSugerencias = correctorOrtografico.listaSugerencias(5, "abracadabra");
		
		assertFalse(listaSugerencias.contains("zugzwang"));
		
		assertTrue(correctorOrtografico.size() == 58109);
		
		assertTrue(correctorOrtografico.add("zugzwang"));
		
		listaSugerencias = correctorOrtografico.listaSugerencias(5, "zugzwang");
		
		assertTrue(listaSugerencias.contains("zugzwang"));
		
		assertTrue(correctorOrtografico.size() == 58110);
	}

}
