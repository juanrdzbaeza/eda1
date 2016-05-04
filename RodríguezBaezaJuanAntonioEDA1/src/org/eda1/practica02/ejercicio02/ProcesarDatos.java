package org.eda1.practica02.ejercicio02;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

import org.eda1.estructurasdedatos.AVLTree;

public class ProcesarDatos {

	public static AVLTree<EmpresaProyectos> cargarArchivo(String archivo) {
		try {
			AVLTree<EmpresaProyectos> listadoDeEmpresas = new AVLTree<EmpresaProyectos>();
			BufferedReader bf = new BufferedReader(new FileReader(new File(archivo)));
			
			String linea = bf.readLine();
			while (linea != null) {
				Scanner sc 		= new Scanner(linea);
				String empresa	= sc.next();
				String proyecto	= sc.next();
				String ciudad	= sc.next();
				addEmpresaProyectoCiudadWithFind (listadoDeEmpresas, 
						empresa, proyecto, ciudad);
				sc.close();
				linea = bf.readLine();
			}
			bf.close();
			return listadoDeEmpresas;
		} catch (IOException e) {
			return null;
		}
	}
	
	public static boolean addEmpresaProyectoCiudad(AVLTree<EmpresaProyectos> listaEmpresas, String empresa, String proyecto, String ciudad) {
		EmpresaProyectos aux = new EmpresaProyectos(empresa);
		aux.addProyectoCiudad(proyecto, ciudad);
		return listaEmpresas.add(aux);
	}
	
	public static boolean addEmpresaProyectoCiudadWithFind(AVLTree<EmpresaProyectos> listaEmpresas, String empresa, String proyecto, String ciudad) {
		EmpresaProyectos aux = new EmpresaProyectos(empresa);
		EmpresaProyectos estara = listaEmpresas.find(aux);
		if (estara == null) {
			aux.addProyectoCiudad(proyecto, ciudad);
			listaEmpresas.add(aux);
			return false;
		}
		estara.addProyectoCiudadWithFind(proyecto, ciudad);
		return true;
	} 
	
	
	public static void mostrarEmpresasProyectosCiudades(AVLTree<EmpresaProyectos> listaEmpresas) {
		
	}
	public static void guardarEmpresasProyectosCiudades(AVLTree<EmpresaProyectos> listaEmpresas, String archivo) {
		
	}
	
	public static int numeroProyectosEmpresa(AVLTree<EmpresaProyectos> listaEmpresas, String empresa) {
		EmpresaProyectos aux = new EmpresaProyectos(empresa);
		EmpresaProyectos estara = listaEmpresas.find(aux);
		if (estara == null)
			return 0;
		return estara.size();
	}
	public static int numeroCiudadesProyecto(AVLTree<EmpresaProyectos> listaEmpresas, String proyecto) {
		ProyectoCiudades arbolAuxiliarProyectos = new ProyectoCiudades (proyecto);
		for (EmpresaProyectos empProy : listaEmpresas) {
			ProyectoCiudades esta = empProy.getProyectosCiudades().find(arbolAuxiliarProyectos);
			if (esta != null) 
				return esta.size();
		}
		return 0;
	}
	
	public static int numeroCiudadesEmpresa(AVLTree<EmpresaProyectos> listaEmpresas, String empresa) {
		EmpresaProyectos arbolAuxiliarEmpresas = new EmpresaProyectos(empresa);
		EmpresaProyectos estara = listaEmpresas.find(arbolAuxiliarEmpresas);
		if (estara == null)
			return 0;
		AVLTree<String> arbol = new AVLTree<String> ();
		for (ProyectoCiudades proyCit : estara.getProyectosCiudades()) {
			for (String ciudad : proyCit.getCiudades()) {
				arbol.add(ciudad);
			}
		}
		return arbol.size();
	}	
	
	
	public static String devolverEmpresasProyectosCiudades(AVLTree<EmpresaProyectos> listaEmpresas) {
		String cadena = "";
		for (EmpresaProyectos empProy : listaEmpresas) {
			cadena = cadena + empProy.getEmpresa()+": ";
			int i = 0;
			for (ProyectoCiudades proyCit : empProy.getProyectosCiudades()) {
				i++;
				cadena = cadena + proyCit.getProyecto()+"<";
				int j = 0;
				for (String ciudad : proyCit.getCiudades()) {
					j++;
					cadena = cadena + ciudad;					
					if (j < proyCit.size()) //no es la ultima
						cadena = cadena + ", ";
				}
				cadena = cadena + ">";
				if (i < empProy.size()) //no es el ultimo
					cadena = cadena + "; ";
			}
			cadena = cadena + "\n";
		}
		return cadena;
	}	
	
	public static ArrayList<String> devolverEmpresasCiudad(AVLTree<EmpresaProyectos> listaEmpresas, String ciudad) {
		ArrayList<String> listaEmpresasCiudades = new ArrayList<String> ();
		for (EmpresaProyectos empProy : listaEmpresas) {
			for (ProyectoCiudades proyCit : empProy.getProyectosCiudades()) {
				if (proyCit.getCiudades().contains(ciudad)) {
					listaEmpresasCiudades.add(empProy.getEmpresa());
					break;
				}
			}
		}
		return listaEmpresasCiudades;
	}
	

	public static ArrayList<String> devolverProyectosCiudad(AVLTree<EmpresaProyectos> listaEmpresas, String ciudad) {
		ArrayList<String> listaProyectosCiudades = new ArrayList<String> ();
		for (EmpresaProyectos empProy : listaEmpresas) {
			for (ProyectoCiudades proyCit : empProy.getProyectosCiudades()) {
				if (proyCit.getCiudades().contains(ciudad)) {
					listaProyectosCiudades.add(proyCit.getProyecto());
				}
			}
		}
		return listaProyectosCiudades;
	}

	
	public static ArrayList<String> devolverCiudadesEmpresa(AVLTree<EmpresaProyectos> listaEmpresas, String empresa) {
		ArrayList<String> listaCiudadesEmpresa = new ArrayList<String> ();
		EmpresaProyectos empProy = new EmpresaProyectos(empresa);
		EmpresaProyectos estara = listaEmpresas.find(empProy);
		if (estara == null)
			return listaCiudadesEmpresa;
		for (ProyectoCiudades proyCit : estara.getProyectosCiudades()) {
			for (String ciudad : proyCit.getCiudades()) {
				if ( ! listaCiudadesEmpresa.contains(ciudad))
					listaCiudadesEmpresa.add(ciudad);
			}
		}
		return listaCiudadesEmpresa;
	}	
	
	
	
	public static ArrayList<String> devolverCiudadesProyectoEmpresa(AVLTree<EmpresaProyectos> listaEmpresas, String proyecto, String empresa) {
		ArrayList<String> listaCiudadesProyectoEmpresa = new ArrayList<String> ();
		EmpresaProyectos empProy = new EmpresaProyectos(empresa);
		EmpresaProyectos estara = listaEmpresas.find(empProy);
		if (estara == null)
			return listaCiudadesProyectoEmpresa;
		ProyectoCiudades proyCit = new ProyectoCiudades (proyecto);
		ProyectoCiudades estaProycit = estara.getProyectosCiudades().find(proyCit);
		if (estaProycit == null)
			return listaCiudadesProyectoEmpresa;
		for (EmpresaProyectos empProy2 : listaEmpresas) {
			if (estara.compareTo (empProy2) != 0) {
				for (ProyectoCiudades proyCit2 : empProy2.getProyectosCiudades()) {
					for (String ciudad : proyCit2.getCiudades()) {
						if (estaProycit.getCiudades().contains(ciudad)) {
							if ( ! listaCiudadesProyectoEmpresa.contains(ciudad))
								listaCiudadesProyectoEmpresa.add(ciudad);
						}
					}
				}
			}
		}
		return listaCiudadesProyectoEmpresa;
	}
	
	public static ArrayList<String> devolverEmpresaParesProyectoCiudadesComunes(AVLTree<EmpresaProyectos> listaEmpresas, String empresa) {
		ArrayList<String> listaEmpresasParesProyectociudadesComunes = new ArrayList<String> ();
		EmpresaProyectos empProy = new EmpresaProyectos(empresa);
		EmpresaProyectos estara = listaEmpresas.find(empProy);
		if (estara == null)
			return listaEmpresasParesProyectociudadesComunes;
		for (ProyectoCiudades proyCit : estara.getProyectosCiudades()) {
			for (ProyectoCiudades proyCit2 : estara.getProyectosCiudades()) {
				if (proyCit.compareTo(proyCit2) < 0) {
					for (String ciudad : proyCit.getCiudades()) {
						if (proyCit2.getCiudades().contains(ciudad)) {
							String cadena = proyCit.getProyecto() + " - "+
									proyCit2.getProyecto()+" => "+ciudad;
							listaEmpresasParesProyectociudadesComunes.add(cadena);
						}
					}
				}
			}
		}
		return listaEmpresasParesProyectociudadesComunes;
	}	
}//fin de la clase
