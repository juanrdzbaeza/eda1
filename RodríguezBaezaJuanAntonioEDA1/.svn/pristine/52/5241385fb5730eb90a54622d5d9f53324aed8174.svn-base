package org.eda1.practica02.ejercicio01;

public class MaquinaContador implements Comparable<MaquinaContador>{

	//atributos
	String maquina;
	int contador;
	
	//constructor vacio
	public MaquinaContador() {
		this.maquina	 = "";
		this.contador	 = 1;
	}
	
	//constructor con paso de parametro maquina
	public MaquinaContador(String maquina) {
		this.maquina	= maquina;
		this.contador	= 1;
	}
	
	//contador con paso de parametro maquina y contador
	public MaquinaContador(String maquina, int contador) {
		this.maquina	= maquina;
		this.contador	= contador;
	}

	
	public void steMaquina(String maquina) {
		this.maquina = maquina;
	}
	
	public String getMaquina() {
		return this.maquina;
	}
	
	public void setContador(int c) {
		this.contador = c;
	}
	
	public int getContador() {
		return this.contador;
	}
	
	
	public void incremetarContador() {
		this.contador++;
	}
	
	public int compareTo(MaquinaContador otraMaquinContador) {
		
		MaquinaContador omc = (MaquinaContador) otraMaquinContador;
				
		return this.maquina.compareTo(omc.maquina);
	}
	
	public boolean equals(Object obj) {
		
		MaquinaContador omc = (MaquinaContador) obj;

		return this.maquina.equals(omc);
		
	}

	public String toString() {
		return "["+maquina+", "+contador+"]";
	}
	
		
}
