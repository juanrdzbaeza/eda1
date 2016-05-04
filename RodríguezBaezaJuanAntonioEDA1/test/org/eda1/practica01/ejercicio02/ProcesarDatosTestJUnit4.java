package org.eda1.practica01.ejercicio02;

import static org.junit.Assert.*;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;

import org.eda1.practica01.ejercicio02.EmpresaProyectos;
import org.eda1.practica01.ejercicio02.ProcesarDatos;
import org.junit.Before;
import org.junit.Test;

public class ProcesarDatosTestJUnit4 {

	String directorioEntrada;
	File archivoEntrada;

	@Before
	public void setUp() throws Exception {		
		
		directorioEntrada = System.getProperty("user.dir");

		directorioEntrada = directorioEntrada + File.separator + 
				"src" + File.separator + 
				"org" + File.separator + 
				"eda1" + File.separator + 
				"practica01" + File.separator +
				"ejercicio02" + File.separator;
	}

	@Test
	public void testProcesarDatos() throws FileNotFoundException {
		
		String stringArchivoEntrada = "empresasProyectosCiudades.txt";
		stringArchivoEntrada = directorioEntrada + stringArchivoEntrada;
		
		ArrayList<EmpresaProyectos> listaEmpresas = ProcesarDatos.cargarArchivo(stringArchivoEntrada);

		assertTrue(listaEmpresas.size() == 4);
		assertTrue(listaEmpresas.get(1).size() == 3);
		assertTrue(listaEmpresas.get(1).getProyectoCiudades(1).size() == 5);
		
		String salida = ProcesarDatos.devolverEmpresasProyectosCiudades(listaEmpresas);
		
		String cadenaSalida = "";
		cadenaSalida = cadenaSalida + "Adobe: Photoshop<San_Antonio, Houston, Seattle>; Flash<Charleston, Boston, Washington>; Illustrator<Miami, Sacramento, New_Orleans>" + "\n";
		cadenaSalida = cadenaSalida + "Microsoft: Word<Washington, New_York, Orlando, Miami, Memphis, Maryland>; VisualC++<Stanford, Philadelphia, Miami, Washington, New_York>; Excel<Sacramento, Los_Angeles, Phoenix, San_Francisco, Las_Vegas>" + "\n";
		cadenaSalida = cadenaSalida + "Ramsoft: EZJava<New_York, Stanford, Washington>" + "\n";
		cadenaSalida = cadenaSalida + "Borland: Delphi<Jackson, Detroit, Chicago, Milwaukee, Miami>; C++Builder<Ohio, Portland, Berkeley, Wisconsin, Washington>; JBuilder<Miami, Tucson, Santa_Fe, Denver>" + "\n";		
		assertEquals(salida, cadenaSalida);
		
		ArrayList<String> empresas = ProcesarDatos.enumerarEmpresasCiudad(listaEmpresas, "Miami");
		assertTrue(empresas.size() == 3);
		salida = "";
		for (int i = 0; i < empresas.size(); i++)
			salida = salida + empresas.get(i) + "\n";
		cadenaSalida = "";
		cadenaSalida = cadenaSalida + "Adobe" + "\n";
		cadenaSalida = cadenaSalida + "Microsoft" + "\n";
		cadenaSalida = cadenaSalida + "Borland" + "\n";
		assertEquals(salida, cadenaSalida);
		
		ArrayList<String> proyectos = ProcesarDatos.enumerarProyectosCiudad(listaEmpresas, "Washington");
		assertTrue(proyectos.size() == 5);
		salida = "";
		for (int i = 0; i < proyectos.size(); i++)
			salida = salida + proyectos.get(i) + "\n";
		cadenaSalida = "";
		cadenaSalida = cadenaSalida + "Flash" + "\n";
		cadenaSalida = cadenaSalida + "Word" + "\n";
		cadenaSalida = cadenaSalida + "VisualC++" + "\n";
		cadenaSalida = cadenaSalida + "EZJava" + "\n";
		cadenaSalida = cadenaSalida + "C++Builder" + "\n";
		assertEquals(salida, cadenaSalida);

		assertTrue(ProcesarDatos.contarCiudadesEmpresa(listaEmpresas, "Microsoft") == 13);

		ArrayList<String> cuidadesProyectoEmpresa = ProcesarDatos.enumerarCiudadesProyectoEmpresa(listaEmpresas, "Word", "Microsoft");
		assertTrue(cuidadesProyectoEmpresa.size() == 3);
		salida = "";
		for (int i = 0; i < cuidadesProyectoEmpresa.size(); i++)
			salida = salida + cuidadesProyectoEmpresa.get(i) + "\n";
		cadenaSalida = "";
		cadenaSalida = cadenaSalida + "Washington" + "\n";
		cadenaSalida = cadenaSalida + "Miami" + "\n";
		cadenaSalida = cadenaSalida + "New_York" + "\n";
		assertEquals(salida, cadenaSalida);
		
	}

}
