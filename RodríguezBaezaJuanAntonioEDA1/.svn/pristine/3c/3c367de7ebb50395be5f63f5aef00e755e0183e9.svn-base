package org.eda1.practica02.ejercicio01;

import org.eda1.estructurasdedatos.BSTree;
import org.eda1.estructurasdedatos.Iterator;

public class DireccionMaquinas implements Comparable<DireccionMaquinas>{
	
	//atributos
	String direccion;
	BSTree<MaquinaContador> maquinas = new BSTree<MaquinaContador>();
	
	//constructor vacio
	public DireccionMaquinas(){
		this.direccion = "";
		
	}
	
	//constructor con paso de parametro direccion
	public DireccionMaquinas(String direccion){
		this.direccion = direccion;
		
	}
	
	//constructor con paso de parametro direccion y maquina
	public DireccionMaquinas(String direccion, String maquina){
		this.direccion = direccion;
		this.maquinas.add(new MaquinaContador(maquina));
		
	}
	
	//constructor con paso de parametro direccion, maquina y contador
	public DireccionMaquinas(String direccion, String maquina, int contador){
		this.direccion = direccion;
		this.maquinas.add(new MaquinaContador(maquina));
		this.maquinas.add(new MaquinaContador(maquina, contador));
		
	}

	
	
	
	public void setDireccion(String dir){
		this.direccion = dir;
	}
	
	public String getDireccion() {
		return this.direccion;
	}
	
	public BSTree<MaquinaContador> getMaquinas() {
		return this.maquinas;
	}
	
	
	
	public boolean addMaquina(MaquinaContador mc) {
		return maquinas.add(mc);
	}
	
	public boolean addMaquinaWithFind(MaquinaContador mc) {
		if (this.maquinas.find(mc) == null) {
			return maquinas.add(mc);
		}
		return false;
	}


	
	public int compareTo(DireccionMaquinas otraDireccionMaquina) {
		
		DireccionMaquinas odm = (DireccionMaquinas) otraDireccionMaquina;
		
		return(this.direccion.compareTo(odm.direccion));
			
	}

	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		DireccionMaquinas other = (DireccionMaquinas) obj;
		if (direccion == null) {
			if (other.direccion != null)
				return false;
		} else if (!direccion.equals(other.direccion))
			return false;
		return true;
	}

	public String toString() {
		String cadenaDeSalida = "("+direccion+", [";
		Iterator<MaquinaContador> iterador = maquinas.iterator();
		while(iterador.hasNext()){
			cadenaDeSalida += iterador.next();
			if(iterador.hasNext())
				cadenaDeSalida += " ";
			else
				cadenaDeSalida += "])";
		}
		return cadenaDeSalida;
	}
		
}
