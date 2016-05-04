package org.eda1.practica02.ejercicio03;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.PriorityQueue;

import org.eda1.estructurasdedatos.AVLTree;

public class CorrectorOrtografico {
	
	private AVLTree<String> treePalabras;
	
	public CorrectorOrtografico() {
		treePalabras = null;
	}
	
	public CorrectorOrtografico(AVLTree<String> treePalabras) {
		this.treePalabras = treePalabras;
	}
	
	public AVLTree<String> cargarDiccionario(String archivo) {
		AVLTree<String> arboleteMajete = new AVLTree<String>();
		
		try {
			BufferedReader bf = new BufferedReader(new FileReader(new File(archivo)));
			String linea = "";
			while ((linea = bf.readLine()) != null) {
				arboleteMajete.add(linea);
				//bf.readLine();
			}
			bf.close();
			this.treePalabras = arboleteMajete;
			return arboleteMajete;
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}
	}//fin de cargar diccionario
	
	
	public void guardarDiccionario(String archivo) {
		
		try {
			PrintWriter pw = new PrintWriter(new FileWriter(new File(archivo), true));
			for (String palabra : treePalabras) {
				pw.println(palabra);
			}
			pw.close();
		} catch (IOException e) {
			// TODO: handle exception
		}

	}// fin guardar diccionario
	
	
	 private static int minimum(int a, int b, int c) {
	        if(a<=b && a<=c)
	        {
	            return a;
	        } 
	        if(b<=a && b<=c)
	        {
	            return b;
	        }
	        return c;
	    }

	    public static int computeLevenshteinDistance(String str1, String str2) {
	        return computeLevenshteinDistance(str1.toCharArray(),
	                                          str2.toCharArray());
	    }

	    private static int computeLevenshteinDistance(char [] str1, char [] str2) {
	        int [][]distance = new int[str1.length+1][str2.length+1];

	        for(int i=0;i<=str1.length;i++)
	        {
	                distance[i][0]=i;
	        }
	        for(int j=0;j<=str2.length;j++)
	        {
	                distance[0][j]=j;
	        }
	        for(int i=1;i<=str1.length;i++)
	        {
	            for(int j=1;j<=str2.length;j++)
	            { 
	                  distance[i][j]= minimum(distance[i-1][j]+1,
	                                        distance[i][j-1]+1,
	                                        distance[i-1][j-1]+
	                                        ((str1[i-1]==str2[j-1])?0:1));
	            }
	        }
	        return distance[str1.length][str2.length];
	        
	    }
	
	public ArrayList<String> listaSugerencias(int n, String s) {
		ArrayList<String> listaDeSugerencias 			= new ArrayList<String>();
		DistanceComparator comparadorDeDistancias 		= new DistanceComparator();
		PriorityQueue<PalabraDistancia> colaDePrioridad = new PriorityQueue<PalabraDistancia>(comparadorDeDistancias);
		
		String palabraTemporal;
		
		for (String palabraDelDiccionario : this.treePalabras) {
			PalabraDistancia palabrota = new PalabraDistancia(palabraDelDiccionario, computeLevenshteinDistance(palabraDelDiccionario, s));
				colaDePrioridad.add(palabrota);
		}
		for (int i=0; i<n; i++)
			listaDeSugerencias.add(colaDePrioridad.remove().getPalabra());
		return listaDeSugerencias;
	}//fin de la lista de sugerencias
	
	
	
	
	public void addPalabra(String palabra) {
		this.treePalabras.add(palabra);
	}//fin de addpalabra

	
	
	
	public boolean containsPalabra(String palabra) {
		//return this.treePalabras.contains(palabra);
		
		for (String cadaPalabra : treePalabras) {
			if (cadaPalabra.compareTo(palabra) == 0) {
				return true;
			}
		}
		return false;
	}//fin de contains palabra
	
	
	public int size(){
		return treePalabras.size();
	}

	public boolean add(String palabra){
		return treePalabras.add(palabra);
	}
	
	public boolean find(String palabra){
		return treePalabras.contains(palabra);
	}
	
}//fin de clase
