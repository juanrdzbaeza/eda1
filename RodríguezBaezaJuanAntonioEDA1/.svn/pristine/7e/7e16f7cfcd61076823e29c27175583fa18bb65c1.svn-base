package org.eda1.practica03.ejercicio01;

import static org.junit.Assert.*;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import org.junit.Before;
import org.junit.Test;

public class ProcesarDireccionesTestJUnit4 {

	String directorioEntrada;
	File archivoEntradas;

	@Before
	public void setUp() throws Exception {
		directorioEntrada = System.getProperty("user.dir");

		directorioEntrada = directorioEntrada + File.separator + 
				"src" + File.separator + 
				"org" + File.separator + 
				"eda1" + File.separator + 
				"practica03" + File.separator + 
				"ejercicio01" + File.separator;
	}

	@Test
	public void testProcesarDirecciones() throws IOException {

		ProcesarDirecciones procesarDirecciones = new ProcesarDirecciones();

		String stringArchivoEntrada = "entradas.txt";
		stringArchivoEntrada = directorioEntrada + stringArchivoEntrada;

		String entradas = "";

		entradas = entradas + "192.146.1.234 pedro.ual.es" + "\n";
		entradas = entradas + "192.146.1.234 voltaire.ual.es" + "\n";
		entradas = entradas + "192.146.1.233 pascal.ual.es" + "\n";
		entradas = entradas + "192.113.2.4 jupiter.ual.es" + "\n";
		entradas = entradas + "192.146.1.234 leo.ual.es" + "\n";
		entradas = entradas + "113.213.12.1 epicuro.ual.es" + "\n";
		entradas = entradas + "192.146.1.234 voltaire.ual.es" + "\n";
		entradas = entradas + "113.213.12.1 epi.ual.es" + "\n";
		entradas = entradas + "192.146.1.245 ant.ual.es" + "\n";
		entradas = entradas + "192.146.1.234 voltaire.ual.es" + "\n";
		entradas = entradas + "192.146.1.234 leo.ual.es" + "\n";
		entradas = entradas + "192.146.1.233 pascal.ual.es" + "\n";
		entradas = entradas + "192.146.1.234 pedro.ual.es" + "\n";
		entradas = entradas + "192.146.1.244 antonio.ual.es" + "\n";
		entradas = entradas + "192.146.1.233 poisson.ual.es" + "\n";
		entradas = entradas + "113.213.12.1 epicuro.ual.es" + "\n";

		generarArchivo(entradas, stringArchivoEntrada);

		procesarDirecciones.cargarArchivo(stringArchivoEntrada);
		
		assertTrue(procesarDirecciones.tamano() == 6);

		String archivoSalida = directorioEntrada + "direcciones.txt";

		procesarDirecciones.generarDirecciones(archivoSalida);
		
		ArrayList<String> salidaEsperada = new ArrayList<String>();
		salidaEsperada
				.add("113.213.12.1 ==> {epi.ual.es=1, epicuro.ual.es=2}");
		salidaEsperada
				.add("192.113.2.4 ==> {jupiter.ual.es=1}");
		salidaEsperada
				.add("192.146.1.233 ==> {pascal.ual.es=2, poisson.ual.es=1}");
		salidaEsperada
				.add("192.146.1.234 ==> {leo.ual.es=2, pedro.ual.es=2, voltaire.ual.es=3}");
		salidaEsperada
				.add("192.146.1.244 ==> {antonio.ual.es=1}");
		salidaEsperada
				.add("192.146.1.245 ==> {ant.ual.es=1}");

		BufferedReader in = new BufferedReader(new FileReader(archivoSalida));
		String cadena;
		int i = 0;
		while ((cadena = in.readLine()) != null) {
			assertTrue(cadena.contains(salidaEsperada.get(i)));
			i++;
		}
		in.close();
		
		ArrayList<String> maquinasContadorMayor = procesarDirecciones.maquinasConContadorMayorQue(1);
		assertTrue(maquinasContadorMayor.size() == 5);
		salidaEsperada.clear();
		salidaEsperada.add("epicuro.ual.es");
		salidaEsperada.add("pascal.ual.es");		
		salidaEsperada.add("leo.ual.es");
		salidaEsperada.add("pedro.ual.es");
		salidaEsperada.add("voltaire.ual.es");
		assertEquals(maquinasContadorMayor, salidaEsperada);
		
		maquinasContadorMayor = procesarDirecciones.maquinasConContadorMayorQue(2);
		assertTrue(maquinasContadorMayor.size() == 1);
		salidaEsperada.clear();
		salidaEsperada.add("voltaire.ual.es");
		assertEquals(maquinasContadorMayor, salidaEsperada);
		
		assertTrue(procesarDirecciones.maquinasConContadorIgualA(2) == 4);
		assertTrue(procesarDirecciones.maquinasConContadorIgualA(3) == 1);
		assertTrue(procesarDirecciones.maquinasConContadorIgualA(-1) == 0);
		
		assertTrue(procesarDirecciones.valorContador("192.146.1.233", "pascal.ual.es") == 2);
		assertTrue(procesarDirecciones.valorContador("192.146.1.234", "voltaire.ual.es") == 3);
		assertTrue(procesarDirecciones.valorContador("192.146.1.999", "pascal.ual.es") == 0);
		
	}

	@Test
	public void testGenerarIncidencias() throws IOException {

		ProcesarDirecciones procesarDirecciones = new ProcesarDirecciones();

		String stringArchivoEntrada = "entradas.txt";
		stringArchivoEntrada = directorioEntrada + stringArchivoEntrada;

		String entradas = "";

		entradas = entradas + "192.146.1.234 pedro.ual.es" + "\n";
		entradas = entradas + "192.146.1.234 voltaire.ual.es" + "\n";
		entradas = entradas + "192.146.1.233 pascal.ual.es" + "\n";
		entradas = entradas + "192.113.2.4 jupiter.ual.es" + "\n";
		entradas = entradas + "192.146.1.234 leo.ual.es" + "\n";
		entradas = entradas + "113.213.12.1 epicuro.ual.es" + "\n";
		entradas = entradas + "192.146.1.234 voltaire.ual.es" + "\n";
		entradas = entradas + "113.213.12.1 epi.ual.es" + "\n";
		entradas = entradas + "192.146.1.245 ant.ual.es" + "\n";
		entradas = entradas + "192.146.1.234 voltaire.ual.es" + "\n";
		entradas = entradas + "192.146.1.234 leo.ual.es" + "\n";
		entradas = entradas + "192.146.1.233 pascal.ual.es" + "\n";
		entradas = entradas + "192.146.1.234 pedro.ual.es" + "\n";
		entradas = entradas + "192.146.1.244 antonio.ual.es" + "\n";
		entradas = entradas + "192.146.1.233 poisson.ual.es" + "\n";
		entradas = entradas + "113.213.12.1 epicuro.ual.es" + "\n";

		generarArchivo(entradas, stringArchivoEntrada);

		procesarDirecciones.cargarArchivo(stringArchivoEntrada);
		
		assertTrue(procesarDirecciones.tamano() == 6);

		String archivoSalida = directorioEntrada + "incidencias.txt";

		procesarDirecciones.generarIncidencias(archivoSalida);
		
		ArrayList<String> salidaEsperada = new ArrayList<String>();
		salidaEsperada
				.add("113.213.12.1 ==> {epi.ual.es=1, epicuro.ual.es=2}");
		salidaEsperada
				.add("192.146.1.233 ==> {pascal.ual.es=2, poisson.ual.es=1}");
		salidaEsperada
				.add("192.146.1.234 ==> {leo.ual.es=2, pedro.ual.es=2, voltaire.ual.es=3}");

		BufferedReader in = new BufferedReader(new FileReader(archivoSalida));
		String cadena;
		int i = 0;
		while ((cadena = in.readLine()) != null) {
			assertTrue(cadena.contains(salidaEsperada.get(i)));
			i++;
		}
		
		in.close();
		ArrayList<String> incidenciasGeneradas = procesarDirecciones.incidenciasGeneradasPor("192.146.1.233");
		incidenciasGeneradas.toString();
		assertTrue(incidenciasGeneradas.size() == 2);
		salidaEsperada.clear();
		salidaEsperada.add("pascal.ual.es");
		salidaEsperada.add("poisson.ual.es");		
		assertEquals(incidenciasGeneradas, salidaEsperada);

		incidenciasGeneradas = procesarDirecciones.incidenciasGeneradasPor("192.146.1.999");
		assertTrue(incidenciasGeneradas==null);
		
		incidenciasGeneradas = procesarDirecciones.incidenciasGeneradasPor("192.146.1.234");
		salidaEsperada.clear();
		salidaEsperada.add("leo.ual.es");
		salidaEsperada.add("pedro.ual.es");		
		salidaEsperada.add("voltaire.ual.es");
		assertEquals(incidenciasGeneradas, salidaEsperada);

		assertTrue(procesarDirecciones.numeroDeIncidenciasGeneradasPor("113.213.12.1") == 2);
		assertTrue(procesarDirecciones.numeroDeIncidenciasGeneradasPor("192.146.1.234") == 3);
		assertTrue(procesarDirecciones.numeroDeIncidenciasGeneradasPor("192.146.1.125") == 0);
	}

	private void generarArchivo(String cadena, String stringArchivoEntrada)	throws FileNotFoundException {

		archivoEntradas = new File(stringArchivoEntrada);
		PrintWriter pw = new PrintWriter(archivoEntradas);

		pw.print(cadena);

		pw.close();

	}

}
