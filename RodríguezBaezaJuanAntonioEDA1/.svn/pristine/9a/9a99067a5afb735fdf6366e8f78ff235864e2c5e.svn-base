package org.eda1.prueba01;

import static org.junit.Assert.*;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;

import org.junit.Before;
import org.junit.Test;

public class GestionTextoTestJUnit4 {
	String directorioEntrada = "";
	GestionTexto textoEntrada = new GestionTexto();
	
	@Before
	public void setUp() throws Exception {
		directorioEntrada = System.getProperty("user.dir") + File.separator +
						    "src" + File.separator + 
						    "org" + File.separator +
						    "eda1" + File.separator + 
						    "prueba01" + File.separator;
	}

	@Test
	public void testToStringPalabra(){
		Palabra pal1 = null, pal2 = null, pal3 = null;
		
		pal1 = new Palabra("PePa");
		pal2 = new Palabra();
		pal3 = new Palabra(new Palabra("JoaQuin"));
		
		assertEquals(pal1.toString(),"pepa <4,1>");
		
		assertTrue(pal1.getFrecuencia() == 1);
		assertTrue(pal1.getLongitud() == 4);
		
		assertEquals(pal3.toString(),"joaquin <7,1>");
		assertTrue(pal3.getLongitud() == 7);
			
		assertEquals(pal2.toString(),"[?]");
		
		for (int i=0; i<50; i++)
			pal1.incrementaFrecuencia();
		
		assertTrue(pal1.getFrecuencia() == 51);
		assertEquals(pal1.toString(),"pepa <4,51>");
		
		pal1 = pal2 = pal3 = null;
	}
	
	@Test
	public void testArbolVacio(){
		assertTrue(textoEntrada.toString().equals("[]"));
		assertTrue(textoEntrada.toArray().equals(new ArrayList<Palabra>()));
		assertTrue(textoEntrada.toArrayWithOrder(null) == null);
		assertTrue(textoEntrada.size() == 0);
	}
	
	@Test
	public void testcargaArchivo() throws FileNotFoundException{
		textoEntrada.cargarTexto(directorioEntrada + "texto");
		assertTrue(textoEntrada.size() == 12);
		assertTrue(textoEntrada.toArray().size() == 12);
		
		assertEquals(textoEntrada.toString(), "[a <1,1>, ejemplo <7,3>, el <2,2>, es <2,3>, esto <4,1>, no <2,1>, que <3,1>, solo <4,2>, texto <5,4>, un <2,5>, ver <3,1>, ya <2,6>]");
		
		assertEquals(textoEntrada.toArray().toString(),"[a <1,1>, ejemplo <7,3>, el <2,2>, es <2,3>, esto <4,1>, no <2,1>, que <3,1>, solo <4,2>, texto <5,4>, un <2,5>, ver <3,1>, ya <2,6>]");
		
		textoEntrada.cargarTexto(directorioEntrada + "cancion");
		assertTrue(textoEntrada.size()==70);
		assertTrue(textoEntrada.toArray().size() == 70);
		assertEquals(textoEntrada.toArray().get(0).toString(),"a <1,11>");
		assertEquals(textoEntrada.toArray().get(69).toString(),"yellow <6,27>");

		textoEntrada = null;
		
	}
	
	@Test
	public void testToArrayWithComparatorPalabra() throws FileNotFoundException{
		ArrayList<Palabra> toArrayInverso = null;
		ArrayList<Palabra> toArray = null;
		
		textoEntrada.cargarTexto(directorioEntrada + "texto");
		assertEquals(textoEntrada.toArray(), textoEntrada.toArrayWithOrder(new PalabraComparatorLess()));
		
		toArray = textoEntrada.toArray();		
		toArrayInverso = new ArrayList<Palabra>(toArray.size());
		
		for (int i=0; i<toArray.size(); i++){
			toArrayInverso.add(toArray.get(toArray.size() - i - 1));
		}
		
		assertEquals(toArrayInverso, textoEntrada.toArrayWithOrder(new PalabraComparatorGreater()));
	}
	
	@Test
	public void testToArrayWithComparatorLongitud() throws FileNotFoundException{
		ArrayList<Palabra> array = null;
		textoEntrada.cargarTexto(directorioEntrada + "texto");
		
		array = textoEntrada.toArrayWithOrder(new LongitudComparatorLess());
		assertEquals(array.toString(), "[a <1,1>, el <2,2>, es <2,3>, no <2,1>, un <2,5>, ya <2,6>, que <3,1>, ver <3,1>, esto <4,1>, solo <4,2>, texto <5,4>, ejemplo <7,3>]");
		array = null;
		
		array = textoEntrada.toArrayWithOrder(new LongitudComparatorGreater());
		assertEquals(array.toString(), "[ejemplo <7,3>, texto <5,4>, esto <4,1>, solo <4,2>, que <3,1>, ver <3,1>, el <2,2>, es <2,3>, no <2,1>, un <2,5>, ya <2,6>, a <1,1>]");
		array = null;
	}

	@Test
	public void testToArrayWithComparatorContador() throws FileNotFoundException{
		ArrayList<Palabra> array = null;
		textoEntrada.cargarTexto(directorioEntrada + "texto");
		
		array = textoEntrada.toArrayWithOrder(new FrecuenciaComparatorLess());
		assertEquals(array.toString(), "[a <1,1>, esto <4,1>, no <2,1>, que <3,1>, ver <3,1>, el <2,2>, solo <4,2>, ejemplo <7,3>, es <2,3>, texto <5,4>, un <2,5>, ya <2,6>]");
		array = null;
		
		array = textoEntrada.toArrayWithOrder(new FrecuenciaComparatorGreater());
		assertEquals(array.toString(), "[ya <2,6>, un <2,5>, texto <5,4>, ejemplo <7,3>, es <2,3>, el <2,2>, solo <4,2>, a <1,1>, esto <4,1>, no <2,1>, que <3,1>, ver <3,1>]");
		array = null;
	}
	
	@Test
	public void testToArrayWithComparatorMedia() throws FileNotFoundException{
		ArrayList<Palabra> array = null;
		textoEntrada.cargarTexto(directorioEntrada + "texto");
		
		array = textoEntrada.toArrayWithOrder(new MediaComparatorLess());
		assertEquals(array.toString(), "[a <1,1>, no <2,1>, el <2,2>, que <3,1>, ver <3,1>, es <2,3>, esto <4,1>, solo <4,2>, un <2,5>, ya <2,6>, texto <5,4>, ejemplo <7,3>]");
		array = null;
		
		array = textoEntrada.toArrayWithOrder(new MediaComparatorGreater());
		assertEquals(array.toString(), "[ejemplo <7,3>, texto <5,4>, ya <2,6>, un <2,5>, solo <4,2>, es <2,3>, esto <4,1>, el <2,2>, que <3,1>, ver <3,1>, no <2,1>, a <1,1>]");
		array = null;
	}
}