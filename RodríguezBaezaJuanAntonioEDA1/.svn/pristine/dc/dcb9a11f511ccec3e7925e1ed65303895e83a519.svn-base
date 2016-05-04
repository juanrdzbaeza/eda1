package org.eda1.practica03.ejercicio02;

import static org.junit.Assert.*;

import java.io.File;
import java.util.TreeSet;

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
				"practica03" + File.separator +
				"ejercicio02" + File.separator;
	}

	@Test
	public void testProcesarDatos() {
		String stringArchivoEntrada = "masNuevasEmpresasProyectosCiudades.txt";
		stringArchivoEntrada = directorioEntrada + stringArchivoEntrada;

		ProcesarDatos procesarDatos = new ProcesarDatos();

		procesarDatos.cargarArchivo(stringArchivoEntrada);
		
		assertTrue(procesarDatos.size() == 7);
		assertTrue(procesarDatos.numeroProyectosEmpresa("Google") == 6);
		assertTrue(procesarDatos.numeroProyectosEmpresa("LaKika") == -1);
		assertTrue(procesarDatos.numeroCiudadesProyecto("Earth") == 8);
		assertTrue(procesarDatos.numeroCiudadesProyecto("EDAI") == -1);
		assertTrue(procesarDatos.numeroCiudadesEmpresa("Google") == 20);
		assertTrue(procesarDatos.numeroCiudadesEmpresa("Martinika") == -1);

		String salida = procesarDatos.devolverEmpresasProyectosCiudades();
		String cadenaSalida = "";
		cadenaSalida = cadenaSalida + "Adobe: Flash <Boston, Charleston, Washington>; Illustrator <Miami, New_Orleans, Sacramento>; Photoshop <Houston, San_Antonio, Seattle>" + "\n";
		cadenaSalida = cadenaSalida + "Apple: IOS <Dallas, Los_Angeles, Miami, New_York, Washington>; Xcode <Atlanta, Berkeley, Detroit, Houston, Miami, Stanford, Washington>; iWork <Atlanta, Chicago, Los_Angeles, Miami, New_Orleans, New_York, Stanford>" + "\n";
		cadenaSalida = cadenaSalida + "Borland: C++Builder <Berkeley, Ohio, Portland, Washington, Wisconsin>; Delphi <Chicago, Detroit, Jackson, Miami, Milwaukee>; JBuilder <Denver, Miami, Santa_Fe, Tucson>" + "\n";
		cadenaSalida = cadenaSalida + "Google: Chrome <Berkeley, Denver, Houston, New_Jersey, New_York, Orlando>; Earth <Atlanta, Boston, Los_Angeles, Miami, New_Jersey, Ohio, Philadelphia, Washington>; Gmail <Miami, New_York, Phoenix, Portland, Wisconsin>; Maps <Detroit, Miami, New_York, Stanford, Washington>; Talk <Detroit, Los_Angeles, Miami, Washington>; Translate <Dallas, Miami, New_York, Sacramento>" + "\n";
		cadenaSalida = cadenaSalida + "Microsoft: Excel <Las_Vegas, Los_Angeles, Phoenix, Sacramento, San_Francisco>; OutLook <Atlanta, Miami, New_Jersey, New_York, Washington>; PowerPoint <Augusta, Dallas, Helena, Miami, Seattle, Washington>; VisualC++ <Miami, New_York, Philadelphia, Stanford, Washington>; Word <Maryland, Memphis, Miami, New_York, Orlando, Washington>" + "\n";
		cadenaSalida = cadenaSalida + "Oracle: Database_11g <Augusta, Denver, Los_Angeles, Miami, Redwood_City>; Java <Dallas, Miami, New_York, Sacramento, Washington>; Solaris <Atlanta, Berkeley, New_York, Washington>" + "\n";
		cadenaSalida = cadenaSalida + "Ramsoft: EZJava <New_York, Stanford, Washington>" + "\n";		
	
		assertEquals(salida, cadenaSalida);

		TreeSet<String> empresas = procesarDatos.devolverEmpresas();
		assertTrue(empresas.size() == 7);
		
		TreeSet<String> proyectos = procesarDatos.devolverProyectos();
		assertTrue(proyectos.size() == 24);
		
		TreeSet<String> ciudades = procesarDatos.devolverCiudades();
		assertTrue(ciudades.size() == 36);

		TreeSet<String> empresasCiudad = procesarDatos.devolverEmpresasCiudad("Miami");
		assertTrue(empresasCiudad.size() == 6);
		cadenaSalida =  "[Adobe, Apple, Borland, Google, Microsoft, Oracle]";
		assertEquals(empresasCiudad.toString(), cadenaSalida);
		
	
		TreeSet<String> proyectosCiudad = procesarDatos.devolverProyectosCiudad("Washington");
		assertTrue(proyectosCiudad.size() == 14);
		cadenaSalida = "[C++Builder, EZJava, Earth, Flash, IOS, Java, Maps, OutLook, PowerPoint, Solaris, Talk, VisualC++, Word, Xcode]";
		assertEquals(proyectosCiudad.toString(), cadenaSalida);
		
		assertEquals(procesarDatos.devolverProyectosCiudad("Madrid").toString(),"[]");
		

		TreeSet<String> ciudadesEmpresa = procesarDatos.devolverCiudadesEmpresa("Google");
		assertTrue(ciudadesEmpresa.size() == 20);
		cadenaSalida = "[Atlanta, Berkeley, Boston, Dallas, Denver, Detroit, Houston, Los_Angeles, Miami, New_Jersey, New_York, Ohio, Orlando, Philadelphia, Phoenix, Portland, Sacramento, Stanford, Washington, Wisconsin]";
		assertEquals(ciudadesEmpresa.toString(), cadenaSalida);

		assertEquals(procesarDatos.devolverCiudadesEmpresa("Toshiba"),null);

		
		TreeSet<String> ciudadesProyectoEmpresa = procesarDatos.devolverCiudadesProyectoEmpresa("Word", "Microsoft");
		assertTrue(ciudadesProyectoEmpresa.size() == 4);
		cadenaSalida = "[Miami, New_York, Orlando, Washington]";
		assertEquals(ciudadesProyectoEmpresa.toString(), cadenaSalida);

		assertEquals( procesarDatos.devolverCiudadesProyectoEmpresa("Wordi", "Microsoft"),null);
		assertEquals( procesarDatos.devolverCiudadesProyectoEmpresa("Word", "Microzoft"),null);
		
		///
		TreeSet<String> paresProyectos = procesarDatos.devolverEmpresaParesProyectoCiudadesComunes("Oracle");
		assertTrue(paresProyectos.size() == 3);
		cadenaSalida = "[Database_11g - Java ==> Miami" + ", ";
		cadenaSalida = cadenaSalida + "Java - Solaris ==> New_York" + ", ";
		cadenaSalida = cadenaSalida + "Java - Solaris ==> Washington" + "]";
	
		assertEquals(paresProyectos.toString(), cadenaSalida);

		TreeSet<String> paresProyectos1 = procesarDatos.devolverEmpresaParesProyectoCiudadesComunes("Microsoft");
		assertTrue(paresProyectos1.size() == 15);
		cadenaSalida = "[OutLook - PowerPoint ==> Miami" + ", ";
		cadenaSalida = cadenaSalida + "OutLook - PowerPoint ==> Washington" + ", ";
		cadenaSalida = cadenaSalida + "OutLook - VisualC++ ==> Miami" + ", ";
		cadenaSalida = cadenaSalida + "OutLook - VisualC++ ==> New_York" + ", ";
		cadenaSalida = cadenaSalida + "OutLook - VisualC++ ==> Washington" + ", ";
		cadenaSalida = cadenaSalida + "OutLook - Word ==> Miami" + ", ";
		cadenaSalida = cadenaSalida + "OutLook - Word ==> New_York" + ", ";
		cadenaSalida = cadenaSalida + "OutLook - Word ==> Washington" + ", ";
		cadenaSalida = cadenaSalida + "PowerPoint - VisualC++ ==> Miami" + ", ";
		cadenaSalida = cadenaSalida + "PowerPoint - VisualC++ ==> Washington" + ", ";
		cadenaSalida = cadenaSalida + "PowerPoint - Word ==> Miami" + ", ";
		cadenaSalida = cadenaSalida + "PowerPoint - Word ==> Washington" + ", ";
		cadenaSalida = cadenaSalida + "VisualC++ - Word ==> Miami" + ", ";
		cadenaSalida = cadenaSalida + "VisualC++ - Word ==> New_York" + ", ";
		cadenaSalida = cadenaSalida + "VisualC++ - Word ==> Washington" + "]";
	
		assertEquals(paresProyectos1.toString(), cadenaSalida);

		TreeSet<String> paresProyectos2 = procesarDatos.devolverEmpresaParesProyectoCiudadesComunes("Google");
		assertTrue(paresProyectos2.size() == 22);
		cadenaSalida = "[Chrome - Earth ==> New_Jersey" + ", ";
		cadenaSalida = cadenaSalida + "Chrome - Gmail ==> New_York" + ", ";
		cadenaSalida = cadenaSalida + "Chrome - Maps ==> New_York" + ", ";
		cadenaSalida = cadenaSalida + "Chrome - Translate ==> New_York" + ", ";
		cadenaSalida = cadenaSalida + "Earth - Gmail ==> Miami" + ", ";
		cadenaSalida = cadenaSalida + "Earth - Maps ==> Miami" + ", ";
		cadenaSalida = cadenaSalida + "Earth - Maps ==> Washington" + ", ";
		cadenaSalida = cadenaSalida + "Earth - Talk ==> Los_Angeles" + ", ";
		cadenaSalida = cadenaSalida + "Earth - Talk ==> Miami" + ", ";
		cadenaSalida = cadenaSalida + "Earth - Talk ==> Washington" + ", ";
		cadenaSalida = cadenaSalida + "Earth - Translate ==> Miami" + ", ";
		cadenaSalida = cadenaSalida + "Gmail - Maps ==> Miami" + ", ";
		cadenaSalida = cadenaSalida + "Gmail - Maps ==> New_York" + ", ";
		cadenaSalida = cadenaSalida + "Gmail - Talk ==> Miami" + ", ";
		cadenaSalida = cadenaSalida + "Gmail - Translate ==> Miami" + ", ";
		cadenaSalida = cadenaSalida + "Gmail - Translate ==> New_York" + ", ";
		cadenaSalida = cadenaSalida + "Maps - Talk ==> Detroit" + ", ";
		cadenaSalida = cadenaSalida + "Maps - Talk ==> Miami" + ", ";
		cadenaSalida = cadenaSalida + "Maps - Talk ==> Washington" + ", ";
		cadenaSalida = cadenaSalida + "Maps - Translate ==> Miami" + ", ";
		cadenaSalida = cadenaSalida + "Maps - Translate ==> New_York" + ", ";
		cadenaSalida = cadenaSalida + "Talk - Translate ==> Miami" + "]";
		assertEquals(paresProyectos2.toString(), cadenaSalida);
		
		salida = procesarDatos.devolverProyectoConMayorNumeroDeCiudades();
		assertEquals(salida, "Earth");

		salida = procesarDatos.devolverEmpresaConMayorNumeroDeProyectos();
		assertEquals(salida, "Google");
		
		salida = procesarDatos.devolverCiudadConMayorNumeroDeProyectos();
		assertEquals(salida, "Miami");
		
	}

}
