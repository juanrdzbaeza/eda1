package org.eda1.practica02.ejercicio03;

public class PalabraDistancia implements Comparable<Object> {

	private String palabra;
	private int distancia;

	public PalabraDistancia(String pal, int dis) {
		this.palabra	= pal;
		this.distancia	= dis;
	}
	public PalabraDistancia(String pal) {
		this.palabra	= pal;
	}
	public PalabraDistancia() {

	}
	
	
	
	public String getPalabra() {
		return palabra;
	}
	public void setPalabra(String palabra) {
		this.palabra = palabra;
	}
	public int getDistancia() {
		return distancia;
	}
	public void setDistancia(int distancia) {
		this.distancia = distancia;
	}
	
	
	
	public int compareTo(Object other) {
		PalabraDistancia laOtra = (PalabraDistancia)other;
		return this.palabra.compareTo(laOtra.palabra);
	}
	public boolean equals(Object obj) {
		PalabraDistancia laOtra = (PalabraDistancia)obj;
		return this.palabra.equals(laOtra);
	}
	public String toString() {
		return "PalabraDistancia [palabra=" + palabra + ", distancia=" + distancia + "]";
	}

}//fin de la clase
