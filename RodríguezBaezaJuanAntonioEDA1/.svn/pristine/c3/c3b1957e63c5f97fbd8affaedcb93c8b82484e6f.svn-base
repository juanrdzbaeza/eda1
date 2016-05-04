package org.eda1.practica02.ejercicio02;

import org.eda1.estructurasdedatos.AVLTree;

public class ProyectoCiudades implements Comparable {

	private String proyecto;
	private AVLTree<String> ciudades;
	
	public ProyectoCiudades() {
		this.proyecto = "";
		this.ciudades = new AVLTree<String>();	}
	
	public ProyectoCiudades(String proy) {
		this.proyecto = proy;
		this.ciudades = new AVLTree<String>();
	}

	public String getProyecto() {
		return proyecto;
	}

	public void setProyecto(String proyecto) {
		this.proyecto = proyecto;
	}

	public AVLTree<String> getCiudades() {
		return ciudades;
	}
	
	public boolean addCiudad(String ciudad) {
		return this.ciudades.add(ciudad);
	}
	
	public int compareTo(Object otroProyectoCiudades) {
		ProyectoCiudades elOtro = (ProyectoCiudades) otroProyectoCiudades;
		return this.proyecto.compareTo(elOtro.proyecto);
	}

	public int size() {
		return this.ciudades.size();
	}	
}//fin de la clase
