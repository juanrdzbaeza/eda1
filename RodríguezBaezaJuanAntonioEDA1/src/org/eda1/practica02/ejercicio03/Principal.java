package org.eda1.practica02.ejercicio03;

import java.io.File;
import java.util.ArrayList;
import java.util.Scanner;

public class Principal {

	private static Scanner entrada = new Scanner (System.in);
	
	public static void main(String[] args) {
		ArrayList<String> lista = leerFrase ();
		CorrectorOrtografico corrector = new CorrectorOrtografico();
		String archivo = System.getProperty("user.dir") + 
				File.separator + "src" + File.separator + 
				"org" + File.separator + "eda1" + File.separator +
				"practica02" + File.separator + "ejercicio03" + 
				File.separator + "diccionario.txt";
		corrector.cargarDiccionario(archivo);
		for (String palabra : lista) {
			if (corrector.containsPalabra(palabra))
				System.out.println("Palabra: "+palabra+"  OK");
			else {
				System.out.println("Palabra: "+palabra+" no existe");
				ArrayList<String> similares = 
							corrector.listaSugerencias(5, palabra);
				System.out.println("Similares: ");
				System.out.println("0. Omitir la palabra");
				for (int i=0; i<similares.size(); i++) {
					System.out.println((i+1)+". "+similares.get(i));
				}
				System.out.println("6. Añadir palabra al diccionario");
				int n;
				do {
					System.out.println("Introduce opcion: ");
					n = entrada.nextInt();
				}while (n<0 || n>6);
				if (n == 6)
					corrector.add(palabra);
			}
		}
		corrector.guardarDiccionario(archivo);
	}
	
	public static ArrayList<String> leerFrase () {
		System.out.println("Introduce frase: ");
		String frase = entrada.nextLine();
		Scanner sc = new Scanner (frase);
		ArrayList<String> lista = new ArrayList<String>();
		while (sc.hasNext()) {
			String palabra = sc.next();
			lista.add(palabra);
		}
		return lista;
	}

}
