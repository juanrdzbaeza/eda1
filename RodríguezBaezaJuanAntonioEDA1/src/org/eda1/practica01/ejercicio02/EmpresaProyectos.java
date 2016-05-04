package org.eda1.practica01.ejercicio02;

import java.util.ArrayList;
import java.util.ListIterator;



public class EmpresaProyectos {
	private String empresa;
	private ArrayList<ProyectoCiudades> proyectoCiudades;
	
	public EmpresaProyectos(){
		proyectoCiudades = new ArrayList<ProyectoCiudades>();
		empresa = "";
	}
	
	
	public EmpresaProyectos(String empresa){
		proyectoCiudades = new ArrayList<ProyectoCiudades>();
		this.empresa = empresa;
	}


	public void addProyectoCiudad(String proyecto, String ciudad){
		boolean insertar = true;
		ProyectoCiudades proyectoTemp = null;
		ListIterator<ProyectoCiudades> iterador;
		iterador = proyectoCiudades.listIterator();
		
		while(iterador.hasNext()){
			proyectoTemp = iterador.next();
			if(proyectoTemp.getProyecto().equals(proyecto)){//Comprobamos si el proyecto ya existe
				insertar = false;
				break;
			}
		}
		
		if(insertar){
			proyectoTemp = new ProyectoCiudades(proyecto);//Si no existe lo creamos y agregamos la ciuddad
			proyectoTemp.addCiudad(ciudad);
			proyectoCiudades.add(proyectoTemp);
		}else{
			proyectoTemp.addCiudad(ciudad);//Si existe, agregamos la ciudad
		}
	}
	
	
	public void setEmpresa(String empresa){
		this.empresa = empresa;
	}
	
	
	public String getEmpresa(){
		return empresa;
	}
	
	
	public ArrayList<ProyectoCiudades> getProyectoCiudades(){
		return proyectoCiudades;
	}
	
	
	public ProyectoCiudades getProyectoCiudades(int i){
		return proyectoCiudades.get(i);
	}
	
	
	public int size(){
		return proyectoCiudades.size();
	}
}
