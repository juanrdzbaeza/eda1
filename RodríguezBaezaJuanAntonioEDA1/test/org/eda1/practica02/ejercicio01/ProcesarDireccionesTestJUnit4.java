package org.eda1.practica02.ejercicio01;

import static org.junit.Assert.*;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import org.eda1.estructurasdedatos.BSTree;
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
				"practica02" + File.separator +
				"ejercicio01" + File.separator;
	}

	@Test
	public void testCargarArchivoDireccionesMaquinaCasosSencillos() throws FileNotFoundException {
		
		String stringArchivoEntrada = "entradas.txt";
		stringArchivoEntrada = directorioEntrada + stringArchivoEntrada;

		String entradas = "";
		
		//ninguna entrada
		generarArchivo(entradas, stringArchivoEntrada);
		
		BSTree<DireccionMaquinas> treeDireccionesMaquina = new BSTree<DireccionMaquinas>();
		
		ProcesarDirecciones procesarDirecciones = new ProcesarDirecciones(treeDireccionesMaquina);

		treeDireccionesMaquina = procesarDirecciones
				.cargarArchivo(stringArchivoEntrada);

		assertTrue(treeDireccionesMaquina.size()==0);
		
		// tres iguales
		entradas = "";
		entradas = entradas + "192.146.1.234 pedro.ual.es" + "\n";
		entradas = entradas + "192.146.1.234 pedro.ual.es" + "\n";
		entradas = entradas + "192.146.1.234 pedro.ual.es" + "\n";

		generarArchivo(entradas, stringArchivoEntrada);
		
		procesarDirecciones = new ProcesarDirecciones(new BSTree<DireccionMaquinas>());

		treeDireccionesMaquina = procesarDirecciones
				.cargarArchivo(stringArchivoEntrada);

		assertTrue(treeDireccionesMaquina.size()==1);
		
		// tres distintas ordenadas
		entradas = "";
		entradas = entradas + "192.146.1.231 pedro.ual.es" + "\n";
		entradas = entradas + "192.146.1.232 pedro.ual.es" + "\n";
		entradas = entradas + "192.146.1.233 pedro.ual.es" + "\n";

		generarArchivo(entradas, stringArchivoEntrada);
		
		procesarDirecciones = new ProcesarDirecciones(new BSTree<DireccionMaquinas>());

		treeDireccionesMaquina = procesarDirecciones
				.cargarArchivo(stringArchivoEntrada);

		assertTrue(treeDireccionesMaquina.size() == 3);

		// tres distintas no ordenadas
		entradas = "";
		entradas = entradas + "192.146.1.233 pedro.ual.es" + "\n";
		entradas = entradas + "192.146.1.231 pedro.ual.es" + "\n";
		entradas = entradas + "192.146.1.232 pedro.ual.es" + "\n";

		generarArchivo(entradas, stringArchivoEntrada);
		
		procesarDirecciones = new ProcesarDirecciones(new BSTree<DireccionMaquinas>());

		treeDireccionesMaquina = procesarDirecciones
				.cargarArchivo(stringArchivoEntrada);

		assertTrue(treeDireccionesMaquina.size() == 3);	
		
	}

	@Test
	public void testCargarArchivoDireccionesMaquinaCasoEjemplo() throws FileNotFoundException {

		String stringArchivoEntrada = "entradas.txt";
		stringArchivoEntrada = directorioEntrada + stringArchivoEntrada;

		String entradas = "";
		entradas = entradas + "192.146.1.234 pedro.ual.es" + "\n";
		entradas = entradas + "150.214.156.17 rosa.ual.es" + "\n";
		entradas = entradas + "192.146.1.234 voltaire.ual.es" + "\n";
		entradas = entradas + "192.146.1.233 pascal.ual.es" + "\n";
		entradas = entradas + "150.214.156.17 almirez.ual.es" + "\n";
		entradas = entradas + "192.113.2.4 jupiter.ual.es" + "\n";
		entradas = entradas + "150.214.20.25 nacho.ugr.es" + "\n";
		
		entradas = entradas + "192.146.1.234 leo.ual.es" + "\n";
		entradas = entradas + "113.213.12.1 epicuro.ual.es" + "\n";
		entradas = entradas + "192.146.1.234 voltaire.ual.es" + "\n";
		entradas = entradas + "150.214.156.17 antonio.ual.es" + "\n";
		entradas = entradas + "113.213.12.1 epi.ual.es" + "\n";
		entradas = entradas + "97.100.7.155 antonio.ual.es" + "\n";
		entradas = entradas + "150.214.156.17 almirez.ual.es" + "\n";
		entradas = entradas + "150.214.156.32 antonio.ual.es" + "\n";
		entradas = entradas + "192.146.1.244 ant.ual.es" + "\n";
		entradas = entradas + "150.214.194.195 nevada.ugr.es" + "\n";
		
		entradas = entradas + "92.140.12.255 rosa.ual.es" + "\n";
		entradas = entradas + "97.100.7.155 antonio.ual.es" + "\n";
		entradas = entradas + "92.140.12.255 rosa.ual.es" + "\n";
		entradas = entradas + "97.100.7.155 antonio.ual.es" + "\n";
		entradas = entradas + "192.146.1.234 voltaire.ual.es" + "\n";
		entradas = entradas + "150.214.156.2 calido.ual.es" + "\n";
		entradas = entradas + "97.100.7.155 antonio.ual.es" + "\n";
		entradas = entradas + "150.214.156.32 alboran.ual.es" + "\n";
		entradas = entradas + "192.146.1.234 leo.ual.es" + "\n";
		entradas = entradas + "192.146.1.233 pascal.ual.es" + "\n";

		entradas = entradas + "150.214.194.195 nevada.ugr.es" + "\n";
		entradas = entradas + "150.214.20.25 veleta.ugr.es" + "\n";
		entradas = entradas + "192.146.1.234 pedro.ual.es" + "\n";
		entradas = entradas + "192.146.1.244 antonio.ual.es" + "\n";
		entradas = entradas + "192.146.1.233 poisson.ual.es" + "\n";
		entradas = entradas + "150.214.156.2 filabres.ual.es" + "\n";
		entradas = entradas + "150.214.194.195 nevada.ugr.es" + "\n";
		entradas = entradas + "150.214.156.17 almirez.ual.es" + "\n";
		entradas = entradas + "150.214.156.32 alboran.ual.es" + "\n";
		entradas = entradas + "150.214.156.2 pedro.ual.es" + "\n";

		generarArchivo(entradas, stringArchivoEntrada);

		BSTree<DireccionMaquinas> treeDirecciones = new BSTree<DireccionMaquinas>();
		
		ProcesarDirecciones procesarDirecciones = new ProcesarDirecciones(treeDirecciones);

		BSTree<DireccionMaquinas> treeDireccionesMaquina = procesarDirecciones
				.cargarArchivo(stringArchivoEntrada);

		assertTrue(treeDireccionesMaquina.size() == 12);
		
		assertTrue(procesarDirecciones.maquinasConContador(1) == 14);
		
		String salida = "(150.214.156.32, alboran.ual.es)" + "\n";
		salida += "(192.146.1.233, pascal.ual.es)" + "\n";
		salida += "(192.146.1.234, leo.ual.es)" + "\n";
		salida += "(192.146.1.234, pedro.ual.es)" + "\n";
		salida += "(92.140.12.255, rosa.ual.es)" + "\n";
		
		assertEquals(salida, procesarDirecciones.direccionMaquinasConContador(2));

		assertTrue(procesarDirecciones.contadorDeDireccionMaquina("192.146.1.234", "voltaire.ual.es") == 3);
		assertTrue(procesarDirecciones.contadorDeDireccionMaquina("150.214.156.17", "antonio.ual.es") == 1);
		assertTrue(procesarDirecciones.contadorDeDireccionMaquina("97.100.7.155", "antonio.ual.es") == 4);
	}

	@Test
	public void testGuardarArchivoDireccionesMaquina() throws IOException {
		
		String stringArchivoEntrada = "entradas.txt";
		stringArchivoEntrada = directorioEntrada + stringArchivoEntrada;

		//El ejemplo del pdf de la practica
		String entradas = "";
		entradas = entradas + "192.146.1.234 voltaire.ual.es" + "\n";
		entradas = entradas + "192.113.2.4 jupiter.ual.es" + "\n";
		entradas = entradas + "192.146.1.234 leo.ual.es" + "\n";
		entradas = entradas + "113.213.12.1 epicuro.ual.es" + "\n";
		entradas = entradas + "192.146.1.234 voltaire.ual.es" + "\n";
		
	    generarArchivo(entradas, stringArchivoEntrada);

		BSTree<DireccionMaquinas> treeDirecciones = new BSTree<DireccionMaquinas>();
		
		ProcesarDirecciones procesarDirecciones = new ProcesarDirecciones(treeDirecciones);

	    
		procesarDirecciones.cargarArchivo(stringArchivoEntrada);	
		
		String archivoSalida = directorioEntrada + "direccionesIncidencias.txt";

		
		procesarDirecciones.guardarDireccionesIncidencias(archivoSalida);
				

	    ArrayList<String> salidaEsperada = new ArrayList<String>();
		salidaEsperada
				.add("[(113.213.12.1, [[epicuro.ual.es, 1]])");
		salidaEsperada
				.add("(192.113.2.4, [[jupiter.ual.es, 1]])");
		salidaEsperada
				.add("(192.146.1.234, [[leo.ual.es, 1]");
		salidaEsperada
				.add("[voltaire.ual.es, 2]])]");
		
		BufferedReader in = new BufferedReader(new FileReader(archivoSalida));
		String cadena;
		int i = 0;
		while ((cadena = in.readLine()) != null) {
			assertTrue(cadena.contains(salidaEsperada.get(i)));
			i++;
		}
		in.close();
	}
	
	private void generarArchivo(String cadena, String stringArchivoEntrada)
			throws FileNotFoundException {

		archivoEntradas = new File(stringArchivoEntrada);
		PrintWriter pw = new PrintWriter(archivoEntradas);
		pw.print(cadena);
		pw.close();

	}

}
