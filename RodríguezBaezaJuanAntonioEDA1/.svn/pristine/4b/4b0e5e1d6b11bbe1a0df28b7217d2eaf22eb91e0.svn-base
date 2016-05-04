package org.eda1.practica03.ejercicio01;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.StringTokenizer;
import java.util.TreeMap;

import javax.swing.SingleSelectionModel;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

public class ProcesarDirecciones {	
	
	private TreeMap<String, TreeMap<String, Integer>> mapa;
	
	public ProcesarDirecciones() {
		super();
		this.mapa = new TreeMap<String, TreeMap<String, Integer>>();
	}

	/**
	* Metodo que lee las lineas (IP, maquina) del archivo de entrada correspondiente y genera un TreeMap de objetos Direccion-Maquina
	* @param ruta del archivo de las lineas (IP, maquina)
	* @return 
	*/
	public void cargarArchivo(String archivo){
		
        String archivoEntrada = archivo;
        String cadena;
        StringTokenizer tokenizer=null;
        BufferedReader in = null;
        String dir="", maq="";
        Integer cont = null;

        try {
		    in = new BufferedReader(new FileReader(archivoEntrada));
		    while((cadena = in.readLine()) != null){
		    	tokenizer = new StringTokenizer(cadena, " ");
				while(tokenizer.hasMoreTokens()){
					dir = tokenizer.nextToken();
					maq = tokenizer.nextToken();
				}
				//Si no existe la dirección en el mapa...creamos una nueva entrada;
				if (!this.mapa.containsKey(dir)){
					this.mapa.put(dir, new TreeMap<String,Integer>());
				}
				//Si no existe este nombre de máquina --> creamos una nueva entrada en el mapa anidado
				//Si existe --> actualizamos contador.
				cont = this.mapa.get(dir).get(maq);
				if (cont == null)
					this.mapa.get(dir).put(maq, 1);
				else
					this.mapa.get(dir).put(maq, cont+1);
				
		    }		    
		    in.close();
		}catch (IOException e){
		}
		
	}

	public int tamano(){
		return this.mapa.size();
	}
	
	public void generarDirecciones(String archivo){   
		//System.out.println(archivo);
		try {
			PrintWriter pw = new PrintWriter(new FileWriter(new File(archivo)));
			String linea = "";
			int cuenta;
			// "113.213.12.1 ==> {epi.ual.es=1, epicuro.ual.es=2}"
			for (Entry<String, TreeMap<String, Integer>> cadaIP : this.mapa.entrySet()) {
				cuenta = 0;
				linea += cadaIP.getKey()+" ==> {";
				//pw.print(cadaIP.getKey()+" ==> {");
				for (Entry<String, Integer> cadaMaquina : cadaIP.getValue().entrySet()) {
					cuenta++;
					linea += cadaMaquina.getKey()+"="+cadaMaquina.getValue();
					//pw.print(cadaMaquina.getKey()+"="+cadaMaquina.getValue());
					if (cuenta < cadaIP.getValue().size()) {
						linea += ", ";
						//pw.print(", ");
					}else{
						linea += "}";
						//pw.print("}");
					}
				}
				linea += " \n";
				//pw.print(" \n");
			}
			//System.out.println(linea);
			pw.print(linea);
			pw.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}// generarDirecciones


	public void generarIncidencias(String archivo){
		//System.out.println(archivo);
		try {
			PrintWriter pw = new PrintWriter(new FileWriter(new File(archivo)));
			String linea = "";
			int cuenta;
			// "113.213.12.1 ==> {epi.ual.es=1, epicuro.ual.es=2}"
			for ( Entry<String, TreeMap<String, Integer>> cadaIP  : this.mapa.entrySet() ) {
				cuenta = 0;
				if (cadaIP.getValue().size()>1) {
					linea += cadaIP.getKey()+" ==> {";
					for (Entry<String, Integer> cadaMaquina : cadaIP.getValue().entrySet()) {
						cuenta++;
						linea += cadaMaquina.getKey()+"="+cadaMaquina.getValue();
						if (cuenta < cadaIP.getValue().size()) {
							linea += ", ";
						}else{
							linea += "}";
						}
					}
					linea += " \n";
				}
			}
			//System.out.println(linea);
			pw.print(linea);
			pw.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
    }// generarIncidencias
	

	public ArrayList<String> maquinasConContadorMayorQue(int c){
		ArrayList<String> maquinasMayoresQueC = new ArrayList<String>();
		maquinasMayoresQueC.clear();
		// "epicuro.ual.es"
		for (Entry<String, TreeMap<String, Integer>>cadaIP : this.mapa.entrySet()) {
			for (Entry<String, Integer>cadaMaquina : cadaIP.getValue().entrySet()) {
				if (cadaMaquina.getValue()> c) {
					//System.out.println(cadaMaquina.getKey()+"__"+cadaMaquina.getValue());
					if (!maquinasMayoresQueC.contains(cadaMaquina.getKey())) {
						maquinasMayoresQueC.add(cadaMaquina.getKey());
					}
				}
			}
		}
		return maquinasMayoresQueC;
	}// maquinasConContadorMayorQue

	public int maquinasConContadorIgualA(int c){
		int numeroDeMaquinasConContadorIgualAC = 0;
		
		for (Entry<String, TreeMap<String, Integer>>cadaIP : this.mapa.entrySet()) {
			for (Entry<String, Integer>cadaMaquina : cadaIP.getValue().entrySet()) {
				if (cadaMaquina.getValue()==c) {
					numeroDeMaquinasConContadorIgualAC++;
				}
				
			}
		}
		return numeroDeMaquinasConContadorIgualAC;
	}// maquinasConContadorIgualA

	public int valorContador(String direccion, String maquina){
		int valosDelContadorDeLaMaquinaConDireccion = 0;
		for (Entry<String, TreeMap<String, Integer>>cadaIP : this.mapa.entrySet()) {
			if (cadaIP.getKey().compareTo(direccion) == 0) {
				//System.out.println(cadaIP.getKey());
				for (Entry<String, Integer>cadaMaquina : cadaIP.getValue().entrySet()) {
					if (cadaMaquina.getKey().compareTo(maquina) == 0) {
						valosDelContadorDeLaMaquinaConDireccion = cadaMaquina.getValue();
					}
				}
			}
		}
		return valosDelContadorDeLaMaquinaConDireccion;
	}// valorContador

	public ArrayList<String> incidenciasGeneradasPor(String direccion) {
		ArrayList<String> incidenciasGeneradasPorDireccion= new ArrayList<String>();
		if (!this.mapa.containsKey(direccion)) {
			return null;
		}
		// "pascal.ual.es"
		for (Entry<String, TreeMap<String, Integer>>cadaIP : this.mapa.entrySet()) {
			if (cadaIP.getKey().compareTo(direccion) == 0) {
				//System.out.println(cadaIP.getKey());
				for (Entry<String, Integer>cadaMaquina : cadaIP.getValue().entrySet()) {
					incidenciasGeneradasPorDireccion.add(cadaMaquina.getKey());
				}
			}
		}
		return incidenciasGeneradasPorDireccion;
	}// incidenciasGeneradasPor

	public int numeroDeIncidenciasGeneradasPor(String direccion) {
		int numeroDeIncidenciasGeneradasPorDireccion = 0;
		for (Entry<String, TreeMap<String, Integer>>cadaIP : this.mapa.entrySet()) {
			if (cadaIP.getKey().compareTo(direccion) == 0) {
				//System.out.println(cadaIP.getKey());
				for (Entry<String, Integer>cadaMaquina : cadaIP.getValue().entrySet()) {
					numeroDeIncidenciasGeneradasPorDireccion++;
				}
			}
		}
		return numeroDeIncidenciasGeneradasPorDireccion;
	}// numeroDeIncidenciasGeneradasPor
}
