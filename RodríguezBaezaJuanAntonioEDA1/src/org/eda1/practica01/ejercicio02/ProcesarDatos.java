package org.eda1.practica01.ejercicio02;


import java.io.*;
import java.util.*;



public class ProcesarDatos {

	public static ArrayList<EmpresaProyectos> cargarArchivo(String archivo){
		
		
		ArrayList<EmpresaProyectos> empresasDatos = new ArrayList<EmpresaProyectos>();
		EmpresaProyectos empTemporal = null;
		EmpresaProyectos empresa;

		boolean insertar;
		String linea = "";
		ArrayList<String> todasLineas = new ArrayList<String>();
		String[] lineaSep;
		ListIterator<EmpresaProyectos> iterador;
		
		try{
		File file = new File(archivo);
		FileReader fr = new FileReader(file);
		BufferedReader br = new BufferedReader(fr);

		//Leemos el archivo y almacenamos las lineas
		while((linea = br.readLine()) != null){
			todasLineas.add(linea);	
		}
		br.close();
		fr.close();
		
		}catch(Exception e){
			e.printStackTrace();
		}
		
		for(int i = 0; i < todasLineas.size(); i++){
			insertar = true;
			lineaSep = todasLineas.get(i).split(" ");//Introducimos en un array las distintas partes de una linea
			
			iterador = empresasDatos.listIterator();
			while(iterador.hasNext()){
				empTemporal = iterador.next();
				if(empTemporal.getEmpresa().equals(lineaSep[0])){//si el nombre ya se encuenta en el ArrayList salimos
					insertar = false;
					break;
				}
			}
			
			//Si la empresa no esta registrada
			if(insertar){
				empresa = new EmpresaProyectos(lineaSep[0]);
				empresa.addProyectoCiudad(lineaSep[1], lineaSep[2]);
				empresasDatos.add(empresa);
			}else{                                            //Si la empresa esta registrada
				empTemporal.addProyectoCiudad(lineaSep[1], lineaSep[2]);
			}	
		}//Cierre del for
		
		return empresasDatos;
	}
	
	
	public static void guardarEmpresasProyectosCiudades(ArrayList<EmpresaProyectos> listaEmpresas , String archivo){
		
		try{
			File file = new File(archivo);
			FileWriter fw = new FileWriter(file, true);
			PrintWriter pw = new PrintWriter(fw);
			
			//CODIGO
			
			pw.close();
			fw.close();
		}catch(Exception e){
			e.printStackTrace();
		}
		
	}
	
	
	public static String devolverEmpresasProyectosCiudades(ArrayList<EmpresaProyectos> listaEmpresas){
		String cadena = "";
		EmpresaProyectos empTemp = null;
		ProyectoCiudades proyTemp = null;
		ListIterator<EmpresaProyectos> iteradorEmpresas = listaEmpresas.listIterator();
		ArrayList<ProyectoCiudades> listaProyectos;
		ListIterator<ProyectoCiudades> iteradorProyectos;
		ArrayList<String> ciudades;

		
		//Descomponemos cada elemento del arraylist y vamos creando la cadena
		while(iteradorEmpresas.hasNext()){                //Iteramos entre las empresas
			empTemp = iteradorEmpresas.next();
			cadena += empTemp.getEmpresa() + ": ";
			listaProyectos = empTemp.getProyectoCiudades();
			iteradorProyectos = listaProyectos.listIterator();
			while(iteradorProyectos.hasNext()){           //Iteramos entre los proyectos de las empresas
				proyTemp = iteradorProyectos.next();
				cadena += proyTemp.getProyecto() + "<";
				ciudades = proyTemp.getCiudades();
				for(int i = 0; i < ciudades.size(); i++){ //Iteramos entre las ciudades de cada proyecto
					if(i+1 == ciudades.size()){
						cadena += ciudades.get(i);
					}else{
					cadena += ciudades.get(i) + ", ";
					}
				}
				if(!iteradorProyectos.hasNext()){
					cadena += ">";
				}else{
					cadena += ">; ";
				}
			}
			cadena += "\n";
		}
		return cadena;
	}
	
	
	public static ArrayList<String> enumerarEmpresasCiudad(ArrayList<EmpresaProyectos> listaEmpresas , String ciudad){
		
		//Aprovechamos el metodo devolverEmpresasProyectosCiudades para tener ya el listado
		String cadena = devolverEmpresasProyectosCiudades(listaEmpresas);
		ArrayList<String> enumeracion = new ArrayList<String>();
		
		
		String[] empresas = cadena.split("\n");//Dividimos cada empresa en una posicion del array
		String[] empresa;
		
		for(int i = 0; i < empresas.length; i++){
			if(empresas[i].contains(ciudad)){//Si el String referenta a la primera empresa contiene la ciudad..
				empresa = empresas[i].split(":");//Nos quedamos con el nombre de la empresa y lo agregamos al ArrayList
				enumeracion.add(empresa[0]);
			}
		}

		return enumeracion;
	}
	
	
	public static ArrayList<String> enumerarProyectosCiudad(ArrayList<EmpresaProyectos> listaEmpresas , String ciudad){
		ListIterator<EmpresaProyectos> iteradorEmpresas = listaEmpresas.listIterator();
		EmpresaProyectos empTemporal = null;
		
		ArrayList<ProyectoCiudades> listaProyectos;
		ListIterator<ProyectoCiudades> iteradorProyectos;
		ProyectoCiudades proyTemporal = null;
		
		ArrayList<String> enumeracion = new ArrayList<String>();

		//Recorremos todos los proyectos de todas las ciudades para comprobar la ciudad.
		while(iteradorEmpresas.hasNext()){
			empTemporal = iteradorEmpresas.next();
			listaProyectos = empTemporal.getProyectoCiudades();
			iteradorProyectos = listaProyectos.listIterator();
			while(iteradorProyectos.hasNext()){
				proyTemporal = iteradorProyectos.next();
				if(proyTemporal.getCiudades().contains(ciudad)){//Si el proyecto examinado contiene la ciudad lo agregamos
					enumeracion.add(proyTemporal.getProyecto());
				}
			}
			
		}
		
		return enumeracion;
	}
	
	
	public static int contarCiudadesEmpresa(ArrayList<EmpresaProyectos> listaEmpresas , String empresa){
		
		
		ListIterator<EmpresaProyectos> iteradorEmpresas = listaEmpresas.listIterator();
		EmpresaProyectos empTemporal = null;
		int numeroCiudades = 0;
		
		ArrayList<ProyectoCiudades> listaProyectos;
		ListIterator<ProyectoCiudades> iteradorProyectos;
		ProyectoCiudades proyTemporal = null;
		
		ArrayList<String> ciudades = new ArrayList<String>();
		ArrayList<String> ciudadesRevisadas = new ArrayList<String>();

		
		String ciudad = "";

		
		while(iteradorEmpresas.hasNext()){
			empTemporal = iteradorEmpresas.next();
			if(empTemporal.getEmpresa().equals(empresa)){
				listaProyectos = empTemporal.getProyectoCiudades();
				iteradorProyectos = listaProyectos.listIterator();
				while(iteradorProyectos.hasNext()){
					proyTemporal = iteradorProyectos.next();
					ciudades = proyTemporal.getCiudades();
					for(int i = 0; i < ciudades.size(); i++){//Recorremos las ciudades
						ciudad = ciudades.get(i);
						if(!ciudadesRevisadas.contains(ciudad)){//Comprobamos si la ciudad ya ha sido insertada, sino, la insertamos
							ciudadesRevisadas.add(ciudad);
						}
					} 
				}
			}
		}
		numeroCiudades = ciudadesRevisadas.size();
		return numeroCiudades;
		
	}
	
	
	public static ArrayList<String> enumerarCiudadesProyectoEmpresa(ArrayList<EmpresaProyectos> listaEmpresas , String proyecto, String empresa){
		
		ListIterator<EmpresaProyectos> iteradorEmpresas = listaEmpresas.listIterator();
		EmpresaProyectos empTemporal = null;
		
		ArrayList<ProyectoCiudades> listaProyectos;
		ListIterator<ProyectoCiudades> iteradorProyectos;
		ProyectoCiudades proyTemporal = null;
		
		ArrayList<String> ciudadesProyecto = new ArrayList<String>();
		ArrayList<String> ciudades = new ArrayList<String>();
		ArrayList<String> ciudadesCompartidas = new ArrayList<String>();


		//Obtenemos la lista de ciudades del proyecto en cuestion
		while(iteradorEmpresas.hasNext()){
			empTemporal = iteradorEmpresas.next();
			if(empTemporal.getEmpresa().equals(empresa)){
				listaProyectos = empTemporal.getProyectoCiudades();
				iteradorProyectos = listaProyectos.listIterator();
				while(iteradorProyectos.hasNext()){
					proyTemporal = iteradorProyectos.next();
					if(proyTemporal.getProyecto().equals(proyecto)){
						ciudadesProyecto = proyTemporal.getCiudades();
					}
				}
			}
		}
		//Ahora comprobamos los proyectos que no son de la empresa citada para ver si contienen alguna ciudad compartida
		iteradorEmpresas = listaEmpresas.listIterator();
		while(iteradorEmpresas.hasNext()){
			empTemporal = iteradorEmpresas.next();
			if(!empTemporal.getEmpresa().equals(empresa)){
				listaProyectos = empTemporal.getProyectoCiudades();
				iteradorProyectos = listaProyectos.listIterator();
				while(iteradorProyectos.hasNext()){
					proyTemporal = iteradorProyectos.next();
					ciudades = proyTemporal.getCiudades();
					for (int i = 0; i < ciudades.size(); i++) {
						if(ciudadesProyecto.contains(ciudades.get(i))){
							if(!ciudadesCompartidas.contains(ciudades.get(i)))//Comprobamos que la ciudad no esta insertada
							ciudadesCompartidas.add(ciudades.get(i));
					}
					}
				}
			}
		}
		return ciudadesCompartidas;
	}
}
