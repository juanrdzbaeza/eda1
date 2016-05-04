package org.eda1.practica02.ejercicio01;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOError;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.ListIterator;

import org.eda1.estructurasdedatos.BSTree;
import org.eda1.estructurasdedatos.Iterator;

public class ProcesarDirecciones {

	/**
	 * atributos
	 */
	BSTree<DireccionMaquinas> treeDirecciones;
	
	/**
	 * constructor sin parametros
	 */
	public ProcesarDirecciones(){
		this.treeDirecciones = new BSTree<DireccionMaquinas>();
	}
	
	/**
	 * constructor con parametros
	 * @param treeDirecciones
	 */
	public ProcesarDirecciones(BSTree<DireccionMaquinas> treeDirecciones){
		this.treeDirecciones = treeDirecciones;
	}
	
	/**
	 * metodo cargararchivo
	 * @param archivo
	 * @return
	 */
	public BSTree<DireccionMaquinas> cargarArchivo(String archivo) {
		ProcesarDirecciones tempProcesarDir = new ProcesarDirecciones();
		String linea 		= "";
		String[] ipNombre	= null;
		DireccionMaquinas tempIP;
		MaquinaContador tempName;

		try {
			File file = new File(archivo);
			FileReader fl = new FileReader(file);
			BufferedReader br = new BufferedReader(fl);
			while ((linea = br.readLine()) !=null) {
				ipNombre 	= linea.split(" ");
				tempIP 		= new DireccionMaquinas(ipNombre[0], ipNombre[1]);
				tempName	= new MaquinaContador(ipNombre[1]);
				
				if (!tempProcesarDir.addDireccionMaquina(ipNombre[0], ipNombre[1])){
					if (!tempProcesarDir.treeDirecciones.find(tempIP).addMaquina(tempName)){
						tempProcesarDir.treeDirecciones.find(tempIP).getMaquinas().find(tempName).incremetarContador();						
					}
				}				
			}//cierro el while
			br.close();
			fl.close();
		} catch (Exception e) {
			e.printStackTrace();
		}

		treeDirecciones = tempProcesarDir.treeDirecciones;
		return treeDirecciones;
	}//fin de cargar archivo
	
	/**
	 * metodo guardar direcciones con incidencias
	 * @param archivo
	 */
	public void guardarDireccionesIncidencias(String archivo) {
		try {
			String cadenaDeImpresion = "";
			File file = new File(archivo);
			FileWriter fw = new FileWriter(file);
			BufferedWriter bw = new BufferedWriter(fw);
			PrintWriter pw = new PrintWriter(bw);
			
			Iterator<DireccionMaquinas> iterador = treeDirecciones.iterator();
			pw.print("[[");
			while(iterador.hasNext()){
				cadenaDeImpresion = iterador.next().toString();
				if(iterador.hasNext())
					pw.print(cadenaDeImpresion+", ");	
				else
					pw.print(cadenaDeImpresion);
			}
			pw.print("]]");
			pw.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}//fin guardarDireccionesIncidencias
	
	/**
	 * metodo agregar direccion maquina
	 * @param direccion
	 * @param maquina
	 * @return
	 */
	public boolean addDireccionMaquina(String direccion, String maquina) {
		return this.treeDirecciones.add(new DireccionMaquinas(direccion, maquina));
	}
	
	/**
	 * metodo agregar direccion maquina con busqueda
	 * @param direccion
	 * @param maquina
	 * @return true si logra añadir la maquina
	 */
	public boolean addDireccionMaquinaWithFind(String direccion, String maquina) {
		DireccionMaquinas tempDirMachine = new DireccionMaquinas(direccion, maquina);
		//si la maquina temporal esta contenida en el erbol
		if (treeDirecciones.contains(tempDirMachine)) {
			return false;//devolbemos false
		}
		return treeDirecciones.add(new DireccionMaquinas(direccion, maquina));
	}

	/**
	 * metodo maquinas con contador
	 * @param contador
	 * @return la cuenta de maquinas
	 */
	public int maquinasConContador(int contador) {
		int tempCount = 0;
		Iterator<DireccionMaquinas> tempIteradorDirecion = 
				treeDirecciones.iterator();
		while (tempIteradorDirecion.hasNext()) {
			Iterator<MaquinaContador> tempIteradorMaquin = 
					tempIteradorDirecion.next().getMaquinas().iterator();
			while (tempIteradorMaquin.hasNext()) {
				if (tempIteradorMaquin.next().getContador() == contador) {
					tempCount++;
				}
			}			
		}		
		return tempCount;
	}

	/**
	 * metodo direccion de maquinas con contador
	 * @param i
	 * @return salida
	 */
	public String direccionMaquinasConContador(int contador) {
		String salida = "";
		Iterator<DireccionMaquinas> tempIteradorDirecion =
				treeDirecciones.iterator();
		while (tempIteradorDirecion.hasNext()) {
			DireccionMaquinas tempDirMachine = 
					tempIteradorDirecion.next();
			Iterator<MaquinaContador> tempIteradorMaquina = 
					tempDirMachine.getMaquinas().iterator();
			while (tempIteradorMaquina.hasNext()) {
				MaquinaContador tempMachineCount =
						tempIteradorMaquina.next();
				if (tempMachineCount.getContador() == contador) {
					salida += "("+ tempDirMachine.getDireccion() + ", "
							+ tempMachineCount.getMaquina() + ")\n";
				}
			}
		}
		return salida;
	}

	/**
	 * metodo contador de direccion maquina
	 * @param string
	 * @param string2
	 * @return
	 */
	public int contadorDeDireccionMaquina(String direccion, String maquina) {
		if (treeDirecciones.contains(new DireccionMaquinas(direccion))
				&& treeDirecciones.find(new DireccionMaquinas(direccion))
				.getMaquinas().contains(new MaquinaContador(maquina))) {
			return treeDirecciones.find(new DireccionMaquinas(direccion))
					.getMaquinas().find(new MaquinaContador(maquina))
					.getContador();
		}
		return -1;
	}	
}
