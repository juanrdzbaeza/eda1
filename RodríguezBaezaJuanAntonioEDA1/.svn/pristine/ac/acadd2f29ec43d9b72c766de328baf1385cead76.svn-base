package org.eda1.practica02.ejercicio02;

import static org.junit.Assert.*;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;

import org.eda1.estructurasdedatos.AVLTree;
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
				"practica02" + File.separator +
				"ejercicio02" + File.separator;
	}

	@Test
	public void testProcesarDatos() throws FileNotFoundException {
		
		String stringArchivoEntrada = "nuevasEmpresasProyectosCiudades.txt";
		stringArchivoEntrada = directorioEntrada + stringArchivoEntrada;
		
		AVLTree<EmpresaProyectos> listaEmpresas = ProcesarDatos.cargarArchivo(stringArchivoEntrada);

		assertTrue(listaEmpresas.size() == 6);
		assertTrue(ProcesarDatos.numeroProyectosEmpresa(listaEmpresas, "Oracle") == 3);
		assertTrue(ProcesarDatos.numeroCiudadesProyecto(listaEmpresas, "iWork") == 7);
		assertTrue(ProcesarDatos.numeroCiudadesEmpresa(listaEmpresas, "Microsoft") == 18);
		
		String salida = ProcesarDatos.devolverEmpresasProyectosCiudades(listaEmpresas);
		
		String cadenaSalida = "";
		cadenaSalida = cadenaSalida + "Adobe: Flash<Boston, Charleston, Washington>; Illustrator<Miami, New_Orleans, Sacramento>; Photoshop<Houston, San_Antonio, Seattle>" + "\n";
		cadenaSalida = cadenaSalida + "Apple: IOS<Dallas, Los_Angeles, New_York, Washington>; Xcode<Atlanta, Berkeley, Detroit, Houston, Miami, Stanford, Washington>; iWork<Atlanta, Chicago, Los_Angeles, Miami, New_Orleans, New_York, Stanford>" + "\n";
		cadenaSalida = cadenaSalida + "Borland: C++Builder<Berkeley, Ohio, Portland, Washington, Wisconsin>; Delphi<Chicago, Detroit, Jackson, Miami, Milwaukee>; JBuilder<Denver, Miami, Santa_Fe, Tucson>" + "\n";
		cadenaSalida = cadenaSalida + "Microsoft: Excel<Las_Vegas, Los_Angeles, Phoenix, Sacramento, San_Francisco>; OutLook<Atlanta, Miami, New_Jersey, New_York, Washington>; PowerPoint<Augusta, Dallas, Helena, Miami, Washington>; VisualC++<Miami, New_York, Philadelphia, Stanford, Washington>; Word<Maryland, Memphis, Miami, New_York, Orlando, Washington>" + "\n";
		cadenaSalida = cadenaSalida + "Oracle: Database_11g<Augusta, Denver, Los_Angeles, Miami, Redwood_City>; Java<Dallas, Miami, New_York, Sacramento, Washington>; Solaris<Atlanta, Berkeley, New_York, Washington>" + "\n";
		cadenaSalida = cadenaSalida + "Ramsoft: EZJava<New_York, Stanford, Washington>" + "\n";		
		assertEquals(salida, cadenaSalida);
				
		ArrayList<String> empresas = ProcesarDatos.devolverEmpresasCiudad(listaEmpresas, "Miami");
		assertTrue(empresas.size() == 5);
		salida = "";
		for (int i = 0; i < empresas.size(); i++)
			salida = salida + empresas.get(i) + "\n";
		cadenaSalida = "";
		cadenaSalida = cadenaSalida + "Adobe" + "\n";
		cadenaSalida = cadenaSalida + "Apple" + "\n";
		cadenaSalida = cadenaSalida + "Borland" + "\n";
		cadenaSalida = cadenaSalida + "Microsoft" + "\n";
		cadenaSalida = cadenaSalida + "Oracle" + "\n";
		assertEquals(salida, cadenaSalida);
		
		ArrayList<String> proyectos = ProcesarDatos.devolverProyectosCiudad(listaEmpresas, "Washington");
		assertTrue(proyectos.size() == 11);
		salida = "";
		for (int i = 0; i < proyectos.size(); i++)
			salida = salida + proyectos.get(i) + "\n";
		cadenaSalida = "";
		cadenaSalida = cadenaSalida + "Flash" + "\n";
		cadenaSalida = cadenaSalida + "IOS" + "\n";
		cadenaSalida = cadenaSalida + "Xcode" + "\n";
		cadenaSalida = cadenaSalida + "C++Builder" + "\n";
		cadenaSalida = cadenaSalida + "OutLook" + "\n";
		cadenaSalida = cadenaSalida + "PowerPoint" + "\n";
		cadenaSalida = cadenaSalida + "VisualC++" + "\n";
		cadenaSalida = cadenaSalida + "Word" + "\n";
		cadenaSalida = cadenaSalida + "Java" + "\n";
		cadenaSalida = cadenaSalida + "Solaris" + "\n";
		cadenaSalida = cadenaSalida + "EZJava" + "\n";
		assertEquals(salida, cadenaSalida);

		ArrayList<String> ciudades = ProcesarDatos.devolverCiudadesEmpresa(listaEmpresas, "Apple");
		assertTrue(ciudades.size() == 12);
		salida = "";
		for (int i = 0; i < ciudades.size(); i++)
			salida = salida + ciudades.get(i) + "\n";
		cadenaSalida = "";
		cadenaSalida = cadenaSalida + "Dallas" + "\n";
		cadenaSalida = cadenaSalida + "Los_Angeles" + "\n";
		cadenaSalida = cadenaSalida + "New_York" + "\n";
		cadenaSalida = cadenaSalida + "Washington" + "\n";
		cadenaSalida = cadenaSalida + "Atlanta" + "\n";
		cadenaSalida = cadenaSalida + "Berkeley" + "\n";
		cadenaSalida = cadenaSalida + "Detroit" + "\n";
		cadenaSalida = cadenaSalida + "Houston" + "\n";
		cadenaSalida = cadenaSalida + "Miami" + "\n";
		cadenaSalida = cadenaSalida + "Stanford" + "\n";
		cadenaSalida = cadenaSalida + "Chicago" + "\n";
		cadenaSalida = cadenaSalida + "New_Orleans" + "\n";
		assertEquals(salida, cadenaSalida);
		
		ArrayList<String> cuidadesProyectoEmpresa = ProcesarDatos.devolverCiudadesProyectoEmpresa(listaEmpresas, "PowerPoint", "Microsoft");
		assertTrue(cuidadesProyectoEmpresa.size() == 4);
		salida = "";
		for (int i = 0; i < cuidadesProyectoEmpresa.size(); i++)
			salida = salida + cuidadesProyectoEmpresa.get(i) + "\n";
		cadenaSalida = "";
		cadenaSalida = cadenaSalida + "Washington" + "\n";
		cadenaSalida = cadenaSalida + "Miami" + "\n";
		cadenaSalida = cadenaSalida + "Dallas" + "\n";
		cadenaSalida = cadenaSalida + "Augusta" + "\n";
		assertEquals(salida, cadenaSalida);

		ArrayList<String> paresProyectos = ProcesarDatos.devolverEmpresaParesProyectoCiudadesComunes(listaEmpresas, "Oracle");
		assertTrue(paresProyectos.size() == 3);
		salida = "";
		for (int i = 0; i < paresProyectos.size(); i++)
			salida = salida + paresProyectos.get(i) + "\n";
		cadenaSalida = "";
		cadenaSalida = cadenaSalida + "Database_11g - Java => Miami" + "\n";
		cadenaSalida = cadenaSalida + "Java - Solaris => New_York" + "\n";
		cadenaSalida = cadenaSalida + "Java - Solaris => Washington" + "\n";
		assertEquals(salida, cadenaSalida);

		ArrayList<String> paresProyectos1 = ProcesarDatos.devolverEmpresaParesProyectoCiudadesComunes(listaEmpresas, "Microsoft");
		assertTrue(paresProyectos1.size() == 15);
		salida = "";
		for (int i = 0; i < paresProyectos1.size(); i++)
			salida = salida + paresProyectos1.get(i) + "\n";
		cadenaSalida = "";
		cadenaSalida = cadenaSalida + "OutLook - PowerPoint => Miami" + "\n";
		cadenaSalida = cadenaSalida + "OutLook - PowerPoint => Washington" + "\n";
		cadenaSalida = cadenaSalida + "OutLook - VisualC++ => Miami" + "\n";
		cadenaSalida = cadenaSalida + "OutLook - VisualC++ => New_York" + "\n";
		cadenaSalida = cadenaSalida + "OutLook - VisualC++ => Washington" + "\n";
		cadenaSalida = cadenaSalida + "OutLook - Word => Miami" + "\n";
		cadenaSalida = cadenaSalida + "OutLook - Word => New_York" + "\n";
		cadenaSalida = cadenaSalida + "OutLook - Word => Washington" + "\n";
		cadenaSalida = cadenaSalida + "PowerPoint - VisualC++ => Miami" + "\n";
		cadenaSalida = cadenaSalida + "PowerPoint - VisualC++ => Washington" + "\n";
		cadenaSalida = cadenaSalida + "PowerPoint - Word => Miami" + "\n";
		cadenaSalida = cadenaSalida + "PowerPoint - Word => Washington" + "\n";
		cadenaSalida = cadenaSalida + "VisualC++ - Word => Miami" + "\n";
		cadenaSalida = cadenaSalida + "VisualC++ - Word => New_York" + "\n";
		cadenaSalida = cadenaSalida + "VisualC++ - Word => Washington" + "\n";
		assertEquals(salida, cadenaSalida);
				
	}

}
