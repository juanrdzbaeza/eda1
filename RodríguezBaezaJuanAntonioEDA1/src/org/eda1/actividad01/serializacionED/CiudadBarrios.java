package org.eda1.actividad01.serializacionED;

import java.io.Serializable;

public class CiudadBarrios implements Serializable{
	
	//atributos
	public String ciudad;
	public Double latitud;
	public Double longitud;
	LinkedList<String> barrios = new LinkedList<String>();
	
	//constructor base
	public CiudadBarrios(){
		this.ciudad = "";
		this.latitud = null;
		this.longitud = null;
	}
	
	//constructor de entradas
	public CiudadBarrios(String ciudad, Double latitud, Double longitud){
		this.ciudad = ciudad;
		this.latitud = latitud;
		this.longitud = longitud;
	}
	
	//   setters
	public void setCiudad(String ciudad) {
		this.ciudad = ciudad;
	}



	public void setLatitud(Double latitud) {
		this.latitud = latitud;
	}



	public void setLongitud(Double longitud) {
		this.longitud = longitud;
	}
	//fin de setters
	
	
	
	public boolean addBarrio(String barrio){
		return barrios.add(barrio);
	}
	
	public LinkedList<String> getBarrios(){
		return this.barrios;
	}
}
