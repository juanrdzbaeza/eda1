package org.eda1.prueba01;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Scanner;

import org.eda1.estructurasdedatos.BSTree;
import org.junit.experimental.theories.Theories;

public class GestionTexto {
	private BSTree<Palabra> arbolPalabra = new BSTree<Palabra>();
	
	public void cargarTexto (String nombreArchivo) throws FileNotFoundException{
		//Atención a los comentarios (@) y caracteres no deseados... "[+-.,( )[ ]¡?!¿^]+"
		this.arbolPalabra.clear();
		try {
			BufferedReader br = new BufferedReader(new FileReader(nombreArchivo));
			String linea= "";
			String lineaLimpia="";
			Palabra auxiliar = null;
			while ((linea = br.readLine()) != null) {
				if(linea.startsWith("@") || linea.isEmpty()) continue;
				lineaLimpia = linea;
				String quitandoComentariosInternos[] = lineaLimpia.split("@");
				String lineaLimpia2 = quitandoComentariosInternos[0];
				String quitandoCaracteresRaros[] = lineaLimpia2.split("[+-.,( )[ ]¡?!¿^]+");
				for (int i = 0; i < quitandoCaracteresRaros.length; i++) {
					//System.out.println(quitandoCaracteresRaros[i]);
					auxiliar = new Palabra(quitandoCaracteresRaros[i]);
					if (arbolPalabra.contains(auxiliar)) {
						arbolPalabra.find(auxiliar).incrementaFrecuencia();
					}else{
						//System.out.println(auxiliar.toString());
						
						arbolPalabra.add(auxiliar);	
					}
				}
				//System.out.println(arbolPalabra.size());
			}
			//System.out.println(arbolPalabra.size());
			br.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public int size(){
		return arbolPalabra.size();
	}
	
	public ArrayList<Palabra> toArray(){
		//Siguiendo el orden natural --> palabra
		ArrayList<Palabra> listado = new ArrayList<Palabra>();
		for (Palabra cadaPalabra : arbolPalabra) {
			listado.add(cadaPalabra);
		}
		return listado;
	}

	
	public ArrayList<Palabra> toArrayWithOrder(Comparator<Palabra> comp){
		//Siguiendo el orden impuesto por el comparator comp
		if (comp == null) return null;
		ArrayList<Palabra> listaOrdenada = new ArrayList<Palabra>();
		for (Palabra palabra : arbolPalabra) {
			listaOrdenada.add(palabra);
		}
		Collections.sort(listaOrdenada, comp);
		return listaOrdenada;
	}
	
	@Override
	public String toString(){
		//Orden natural
		ArrayList<Palabra> listado = new ArrayList<Palabra>();
		for (Palabra cadaPalabra : arbolPalabra) {
			listado.add(cadaPalabra);
		}
		return listado.toString();
	}
	
}