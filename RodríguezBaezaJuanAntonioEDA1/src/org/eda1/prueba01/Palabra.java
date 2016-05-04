package org.eda1.prueba01;

public class Palabra implements Comparable<Palabra>{
	private String palabra;
	private int frecuencia;
	
	Palabra(){
		this.palabra 	= "";
		this.frecuencia	= 0;
	}
	
	Palabra(String palabra){
		this.palabra 	= palabra.toLowerCase();
		this.frecuencia = 1;
	}
	
	Palabra(Palabra pal){
		this.palabra 	= pal.palabra;
		this.frecuencia = pal.frecuencia;
	}
	
	public int getFrecuencia(){
		return this.frecuencia;
	}
	
	public void incrementaFrecuencia(){
		this.frecuencia++;
	}
	
	public int getLongitud(){
		return this.palabra.length();
	}

	@Override
	public int compareTo(Palabra other) {
		if (this.palabra.compareTo(other.palabra) < 0) return -1; 
		if (this.palabra.compareTo(other.palabra) > 0) return 1;
		return 0;
	}

	@Override
	public String toString(){
		if(this.palabra.equals("") || this.frecuencia==0) return "[?]";
		return this.palabra+" <"+getLongitud()+","+getFrecuencia()+">";
	}
}
