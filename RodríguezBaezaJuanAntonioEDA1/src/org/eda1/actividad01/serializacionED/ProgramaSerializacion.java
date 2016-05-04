package org.eda1.actividad01.serializacionED;

import java.io.*;
import java.util.Locale;
import java.util.Scanner;


public class ProgramaSerializacion {

	public ArrayList<CiudadBarrios> cargarArchivo(String inputFile) {
		
		ArrayList<CiudadBarrios> listaCiudadesLocalizacionBarrios = new ArrayList<CiudadBarrios>();
		CiudadBarrios ciudadBarrio;
		
		try {
			
			BufferedReader br = new BufferedReader (new FileReader (inputFile));
			String linea = br.readLine();
			
			while(linea != null) {
				//Cambio el uso del . como una , para leer los decimales
				Scanner sc = new Scanner (linea);
				sc.useLocale(Locale.ENGLISH);
				
				String ciudad = sc.next();
				Double latitud = sc.nextDouble();
				Double longitud = sc.nextDouble();
				ciudadBarrio = new CiudadBarrios(ciudad, latitud, longitud);
				
				// Número de barrios
				int n = sc.nextInt();
				
				for(int i = 0; i < n; i++){
					String barrio = sc.next();
					ciudadBarrio.addBarrio(barrio);
				}
				
				listaCiudadesLocalizacionBarrios.add(ciudadBarrio);
				linea = br.readLine();
			}
			
			br.close();
			return listaCiudadesLocalizacionBarrios;
			
			
		} catch (Exception e) {
			return null;
		}
	}

	
	public String mostrarEstructura(ArrayList<CiudadBarrios> cB) {
		if(cB == null)
			return null;
		if(cB.isEmpty())
			return "[]";
		
		String salida = "";
		for(int i = 0; i < cB.size(); i++){
			//Creo la variable auxiliar para no tener que repetir cB.get(i) más adelante
			CiudadBarrios aux = cB.get(i);
			
			//El formato de salida para los datos del fichero según el test
			salida = salida + "[";
			salida = salida + aux.ciudad + ", ";
			salida = salida + aux.latitud + ", ";
			salida = salida + aux.longitud + ", ";
			salida = salida + "{";
			
			//Creo la variable 'barrios' de forma auxiliar para no usar aux.getBarrios();
			LinkedList<String> barrios = (LinkedList<String>) aux.getBarrios();
			
			for(int j = 0; j < barrios.size(); j++){
				String barrio = barrios.get(j);
				salida = salida + barrio;
				if(j < barrios.size() - 1)
					salida = salida + ", ";
			}
			salida = salida + "}";
			salida = salida + "]" + "\n";
		}
		
		return salida;
	}

}
