package org.eda1.practica03.ejercicio02;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.PriorityQueue;
import java.util.Stack;
import java.util.StringTokenizer;
import java.util.TreeMap;
import java.util.TreeSet;
import java.util.stream.Stream;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class ProcesarDatos {
	
	private TreeMap<String, TreeMap<String, TreeSet<String>>> mapa;
	
	public ProcesarDatos() {
		super();
		this.mapa = new TreeMap<String, TreeMap<String, TreeSet<String>>>();
	}

	/**
	 * Metodo que lee las lineas del archivo correspondiente y las devuelve en un
	 * ED de array de array de String
	 * 
	 * @param notas
	 *            ruta del archivo de las notas
	 * @return un array de String con las notas
	 */
	public void cargarArchivo(String archivo) {
		String archivoEntrada = archivo;
        String cadena;
        StringTokenizer tokenizer=null;
        BufferedReader in = null;
        String empresa="", proyecto="", ciudad="";
        Integer cont = null;
		
		try {
			in = new BufferedReader(new FileReader(archivoEntrada));
			
			while((cadena = in.readLine()) != null){
		    	tokenizer = new StringTokenizer(cadena, " ");
				while(tokenizer.hasMoreTokens()){
					empresa 	= tokenizer.nextToken();
					proyecto 	= tokenizer.nextToken();
					ciudad		= tokenizer.nextToken();
				}
				//leer empresa, proyecto, ciudad
				if (!mapa.containsKey(empresa)) {
					mapa.put(empresa, new TreeMap<String, TreeSet<String>>());
				}
				if(!mapa.get(empresa).containsKey(proyecto)){
					mapa.get(empresa).put(proyecto, new TreeSet<String>());
				}
				if (!mapa.get(empresa).get(proyecto).contains(ciudad)) {
					mapa.get(empresa).get(proyecto).add(ciudad);
				}
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	
	public int size(){
		return mapa.size();
	}


	public TreeSet<String> devolverCiudades() {
		TreeSet<String> listaDeCiudades = new TreeSet<String>();
		for (Entry<String, TreeMap<String, TreeSet<String>>> cadaEmpresa : this.mapa.entrySet()) {
			for (Entry<String, TreeSet<String>> cadaProyecto : cadaEmpresa.getValue().entrySet()) {
				for (String cadaCiudad : cadaProyecto.getValue()) {
					listaDeCiudades.add(cadaCiudad);
				}
			}
		}
		return listaDeCiudades;
	}

	public TreeSet<String> devolverProyectos() {
		TreeSet<String> listaDeProyectos = new TreeSet<String>();
		for (Entry<String, TreeMap<String, TreeSet<String>>> cadaEmpresa : this.mapa.entrySet()) {
			for (Entry<String, TreeSet<String>> cadaProyecto : cadaEmpresa.getValue().entrySet()) {
					listaDeProyectos.add(cadaProyecto.getKey());
			}
		}
		return listaDeProyectos;
	}


	public TreeSet<String> devolverEmpresas() {
		TreeSet<String> listaDeEmpresas = new TreeSet<String>();	
		for (Entry<String, TreeMap<String, TreeSet<String>>> cadaEmpresa : this.mapa.entrySet()) {
			listaDeEmpresas.add(cadaEmpresa.getKey());
		}
		return listaDeEmpresas;
	}


	public int numeroProyectosEmpresa(String empresa) {
		int numeroProyectosEmpresa = -1;
		for (Entry<String, TreeMap<String, TreeSet<String>>> cadaEmpresa : this.mapa.entrySet()) {
			if (cadaEmpresa.getKey().compareTo(empresa) == 0){
				numeroProyectosEmpresa = cadaEmpresa.getValue().size();
			}
		}
		return numeroProyectosEmpresa;
	}

	
	public int numeroCiudadesProyecto(String proyecto) {
		int numeroCiudadesProyecto = -1;
		for (Entry<String, TreeMap<String, TreeSet<String>>> cadaEmpresa : this.mapa.entrySet()) {
			for (Entry<String, TreeSet<String>> cadaProyecto : cadaEmpresa.getValue().entrySet()) {
				if (cadaProyecto.getKey().equals(proyecto)) {
					numeroCiudadesProyecto = cadaProyecto.getValue().size();
				}	
			}	
		}
		//System.out.println(numeroCiudadesProyecto);
		return numeroCiudadesProyecto;
	}

	
	public int numeroCiudadesEmpresa(String empresa) {
		int numeroCiudadesEmpresa = -1;
		Stack<String> pilaDeCiudadesPorEmpresa = new Stack<String>();
		for (Entry<String, TreeMap<String, TreeSet<String>>> cadaEmpresa : this.mapa.entrySet()) {
			if (cadaEmpresa.getKey().compareTo(empresa) == 0){
				for (Entry<String, TreeSet<String>> cadaProyecto : cadaEmpresa.getValue().entrySet()) {
					for (String cadaCiudad : cadaProyecto.getValue()) {
						if (!pilaDeCiudadesPorEmpresa.contains(cadaCiudad)) 
							pilaDeCiudadesPorEmpresa.add(cadaCiudad);
					}
				}
				numeroCiudadesEmpresa = pilaDeCiudadesPorEmpresa.size();
			}
		}
		//System.out.println(pilaDeCiudadesPorEmpresa.size());
		return numeroCiudadesEmpresa;
	}

	
	public String devolverEmpresasProyectosCiudades() {
		String resultado ="";
		int cuentaProyectos, cuentaCiudades;
		/*
		 *  "Adobe: Flash <Boston, Charleston, Washington>; 
		 *  		Illustrator <Miami, New_Orleans, Sacramento>; 
		 *  		Photoshop <Houston, San_Antonio, Seattle>" + "\n"
		 */
		for (Entry<String, TreeMap<String, TreeSet<String>>> cadaEmpresa : this.mapa.entrySet()) {
			cuentaProyectos = 0;
			resultado += cadaEmpresa.getKey()+": ";
			for (Entry<String, TreeSet<String>> cadaProyecto : cadaEmpresa.getValue().entrySet()) {
				cuentaCiudades = 0;
				cuentaProyectos++;
				resultado += cadaProyecto.getKey()+" <";
				//System.out.println(resultado);
				for (String cadaCiudad : cadaProyecto.getValue()) {
					cuentaCiudades++;
					resultado += cadaCiudad;
					if (cuentaCiudades < cadaProyecto.getValue().size()) {
						resultado += ", ";
					}else{
						resultado += ">";
					}
				}
				if (cuentaProyectos < cadaEmpresa.getValue().size()) {
					resultado += "; ";
				}
			}
			resultado += "\n";
		}
		//System.out.println(resultado);
		return resultado;
	}
	
	
	public TreeSet<String> devolverEmpresasCiudad(String ciudad) {
		TreeSet<String> empresasQueTrabajanEnUnaCiudad = new TreeSet<String>();
		for (Entry<String, TreeMap<String, TreeSet<String>>> cadaEmpresa : this.mapa.entrySet()) {
			for (Entry<String, TreeSet<String>> cadaProyecto : cadaEmpresa.getValue().entrySet()) {
				for (String cadaCiudad : cadaProyecto.getValue()) {
					if (cadaCiudad.equals(ciudad)) {
						empresasQueTrabajanEnUnaCiudad.add(cadaEmpresa.getKey());
					}
				}
			}
		}
		return empresasQueTrabajanEnUnaCiudad;
	}

	
	public TreeSet<String> devolverProyectosCiudad(String ciudad) {
		TreeSet<String> proyectosQueSeLLevanACavoEnUnaCiudad = new TreeSet<String>();
		
		for (Entry<String, TreeMap<String, TreeSet<String>>> cadaEmpresa : this.mapa.entrySet()) {
			for (Entry<String, TreeSet<String>> cadaProyecto : cadaEmpresa.getValue().entrySet()) {
				for (String cadaCiudad : cadaProyecto.getValue()) {
					if (cadaCiudad.equals(ciudad)) {
						proyectosQueSeLLevanACavoEnUnaCiudad.add(cadaProyecto.getKey());
					}
				}
			}
		}
		return proyectosQueSeLLevanACavoEnUnaCiudad;
	}
	
	public TreeSet<String> devolverCiudadesEmpresa(String empresa) {
		TreeSet<String> ciudadesDondeTrabajaUnaEmpresa = null;
		
		for (Entry<String, TreeMap<String, TreeSet<String>>> cadaEmpresa : this.mapa.entrySet()) {
			if (cadaEmpresa.getKey().equals(empresa)) {
				ciudadesDondeTrabajaUnaEmpresa = new TreeSet<String>();
				for (Entry<String, TreeSet<String>> cadaProyecto : cadaEmpresa.getValue().entrySet()) {
					 for (String cadaCiudad : cadaProyecto.getValue()) {
						ciudadesDondeTrabajaUnaEmpresa.add(cadaCiudad);
					}
				}	
			}
		}
		return ciudadesDondeTrabajaUnaEmpresa;
	}


	public TreeSet<String> devolverCiudadesProyectoEmpresa(String proyecto, String empresa) {
		TreeSet<String> ciudadesDondeUnaEmpresaRealizaUnProyecto = null;
		TreeSet<String> ciudadesdondeTrabajaEmpresaJuntoOtrasEmpresas = null;
		
		if (!this.mapa.containsKey(empresa)) return null;
		if (!this.mapa.get(empresa).containsKey(proyecto)) return null;
		
		ciudadesDondeUnaEmpresaRealizaUnProyecto = new TreeSet<String>();
		ciudadesdondeTrabajaEmpresaJuntoOtrasEmpresas = new TreeSet<String>();
		
		ciudadesDondeUnaEmpresaRealizaUnProyecto.addAll(this.mapa.get(empresa).get(proyecto));
		for (Entry<String, TreeMap<String, TreeSet<String>>> cadaEpresa : this.mapa.entrySet()) {
			if(!cadaEpresa.getKey().equals(empresa)){
				for (Entry<String, TreeSet<String>> cadaProyecto : cadaEpresa.getValue().entrySet()) {
					if (!cadaProyecto.getKey().equals(proyecto)) {
						for (String cadaCiudad : cadaProyecto.getValue()) {
							if (ciudadesDondeUnaEmpresaRealizaUnProyecto.contains(cadaCiudad)) {
								ciudadesdondeTrabajaEmpresaJuntoOtrasEmpresas.add(cadaCiudad);
							}
						}
					}
				}
			}
		}
		//System.out.println(ciudadesdondeTrabajaEmpresaJuntoOtrasEmpresas.size());
		return ciudadesdondeTrabajaEmpresaJuntoOtrasEmpresas;
	
	}
	

	public TreeSet<String> devolverEmpresaParesProyectoCiudadesComunes(String empresa) {

		if(!mapa.containsKey(empresa))return null;

		String cadena = "";
		TreeSet<String> temp = new TreeSet<String>();
		TreeSet<String> salida = new TreeSet<String>();

		for (Entry<String, TreeSet<String>> it1 : mapa.get(empresa).entrySet()) {
			temp.clear();
			temp.addAll(it1.getValue());
			for (Entry<String, TreeSet<String>> it2 : mapa.get(empresa).entrySet()) {
				if(it1.equals(it2))continue;
				for (String ciudad : it2.getValue()) {
					cadena = "";
					if(!temp.contains(ciudad) || salida.contains(it2.getKey() + " - " + it1.getKey() + " ==> " + ciudad))continue;
					cadena += it1.getKey() + " - " + it2.getKey() + " ==> " + ciudad;
					salida.add(cadena);
				}
			}
		}
		return salida;
	}
	
	public String devolverProyectoConMayorNumeroDeCiudades() {
		int aux = 0;
		String proyectoConMayorNumeroDeCiudades = "";
		for (Entry<String, TreeMap<String, TreeSet<String>>> cadaCiudad : this.mapa.entrySet()) {
			for (Entry<String, TreeSet<String>> cadaProyecto : cadaCiudad.getValue().entrySet()) {
				if (cadaProyecto.getValue().size() > aux) {
					proyectoConMayorNumeroDeCiudades = cadaProyecto.getKey();
					aux = cadaProyecto.getValue().size();
				}
				
			}
		}
		return proyectoConMayorNumeroDeCiudades;
	}

	
	public String devolverEmpresaConMayorNumeroDeProyectos() {
		int aux = 0;
		String empresaConMayorNumeroDeProyectos = "";
		for (Entry<String, TreeMap<String, TreeSet<String>>> cadaEmpresa : this.mapa.entrySet()) {
			if (cadaEmpresa.getValue().size() > aux) {
				empresaConMayorNumeroDeProyectos = cadaEmpresa.getKey();
				aux = cadaEmpresa.getValue().size();
			}
		}
		return empresaConMayorNumeroDeProyectos;
	}

	public String devolverCiudadConMayorNumeroDeProyectos() {
		
		ArrayList<String> todasLasCiudades = new ArrayList<String>();
		String ciudadConMayorNumeroDeProyectos = "";
		
		int max = 0, cuenta = 0;
		for (Entry<String, TreeMap<String, TreeSet<String>>> cadaEmpresa : this.mapa.entrySet()) {
			for (Entry<String, TreeSet<String>> cadaProyecto : cadaEmpresa.getValue().entrySet()) {
				for (String cadaCiudad : cadaProyecto.getValue()) {
					todasLasCiudades.add(cadaCiudad);
				}
			}
		}
		for (String ciudadACiudad : todasLasCiudades) {
			cuenta = 0;
			for (Entry<String, TreeMap<String, TreeSet<String>>> cadaEmpresa : this.mapa.entrySet()) {
				for (Entry<String, TreeSet<String>> cadaProyecto : cadaEmpresa.getValue().entrySet()) {
					for (String cadaCiudad : cadaProyecto.getValue()) {
						if(cadaCiudad.equals(ciudadACiudad)){
							cuenta++;
						}
					}
					if (cuenta > max) {
						max = cuenta;
						ciudadConMayorNumeroDeProyectos = ciudadACiudad;
					}
				}
			}
		}
		return ciudadConMayorNumeroDeProyectos;
	}
}// fin de la clase
