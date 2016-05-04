package org.eda1.practica02.ejercicio02;

import org.eda1.estructurasdedatos.AVLTree;

public class EmpresaProyectos implements Comparable {

	private String empresa;
	private AVLTree<ProyectoCiudades> proyectosCiudades;


	public EmpresaProyectos() {
		this.empresa = "";
		this.proyectosCiudades = new AVLTree<ProyectoCiudades>();
	}

	public EmpresaProyectos(String empr) {
		this.empresa = empr;
		this.proyectosCiudades = new AVLTree<ProyectoCiudades>();	
	}

	public boolean addProyectoCiudad(String proyecto, String ciudad) {
		ProyectoCiudades auxiliar = new ProyectoCiudades(proyecto);
		auxiliar.addCiudad(ciudad);
		return this.proyectosCiudades.add(auxiliar);	
	}


	public boolean addProyectoCiudadWithFind(String proyecto, String ciudad) {
		ProyectoCiudades auxiliar = new ProyectoCiudades(proyecto);
		ProyectoCiudades estara = this.proyectosCiudades.find(auxiliar);
		if (estara == null) {
			auxiliar.addCiudad(ciudad);
			return this.proyectosCiudades.add(auxiliar);
		}
		estara.addCiudad(ciudad);
		return false;
	}

	public String getEmpresa() {
		return empresa;
	}

	public void setEmpresa(String empresa) {
		this.empresa = empresa;
	}

	public AVLTree<ProyectoCiudades> getProyectosCiudades() {
		return proyectosCiudades;
	}

	public int compareTo(Object otraEmpresaProyectos) {
		EmpresaProyectos laOtra = (EmpresaProyectos) otraEmpresaProyectos;
		return this.empresa.compareTo(laOtra.empresa);
	}

	public int size() {
		return proyectosCiudades.size();
	}
}//fin de la clase
