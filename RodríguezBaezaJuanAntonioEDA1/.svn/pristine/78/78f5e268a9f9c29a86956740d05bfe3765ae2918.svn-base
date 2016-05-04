package org.eda1.actividad05;

import java.util.ArrayList;
import java.util.Map;
import java.util.TreeMap;

public class ManageFloyd <Vertex> {
	final double INFINITY = Double.MAX_VALUE;
	private double [][] matrixD;
	private int[][]matrixA;
	private TreeMap<Vertex,Integer> vertexToIndex;
	
	public ManageFloyd(double[][]matrixD, int[][]matrixA, TreeMap<Vertex, Integer> v2i){
		this.matrixD = matrixD;
		this.matrixA = matrixA;
		this.vertexToIndex = v2i;
	}
	
 	public Vertex getVertexFromIndex(int index){
  		Vertex v = null;
  		for (Map.Entry<Vertex,Integer> e : vertexToIndex.entrySet()){
  			if (e.getValue() != index) continue;
  			v = e.getKey();
  			break;
  		}
  		return v;
  	}
	
	public String toString(){
  		Vertex vertex;
		String result = "";
		for (int i=0; i<vertexToIndex.size(); i++){
			for (int j=0; j<vertexToIndex.size(); j++){
				result += (matrixD[i][j] == INFINITY ? "inf" : matrixD[i][j]) + "\t";
			}
			result += "\t\t\t";
			for (int j=0; j<vertexToIndex.size(); j++){
				vertex = getVertexFromIndex(matrixA[i][j]);
				result += (matrixA[i][j]<0 ? matrixA[i][j] : vertex) + "\t";
			}
			result += "\n";
		}
		return result;
	}
	
	public String findPath(Vertex vertexI, Vertex vertexJ){
		int vI, vJ;
		if (!vertexToIndex.containsKey(vertexI) || !vertexToIndex.containsKey(vertexJ)) return null;
		if (vertexI.equals(vertexJ)) return "Just the same vertex...";
		vI = vertexToIndex.get(vertexI);
		vJ = vertexToIndex.get(vertexJ);
		if (matrixD[vI][vJ] == INFINITY) return null;
		return findPath(vI, vJ) + " (" + matrixD[vI][vJ] + ")";
	}
	
	public ArrayList<String> getPaths(){
		ArrayList<String> resultado = new ArrayList<String>();
		int numPaths = 1;
		for (int i=0; i<this.vertexToIndex.size(); i++){
			for (int j=0; j<this.vertexToIndex.size(); j++){
				if (i==j) continue;
				if (matrixD[i][j] == INFINITY) continue;
				resultado.add("Camino #" + (numPaths++) + ": " + findPath(i,j)  + " (" + matrixD[i][j] + ")");
			}
		}
		
		return resultado;
	}
	

	private String findPath(int vertexI, int vertexJ){
		ArrayList<Vertex> camino = new ArrayList<Vertex>();
		String resultado = "";
		findPathAux(vertexI, vertexJ, camino);
		if (camino.isEmpty()) return "";
		resultado = camino.get(0).toString();
		for (int i=1; i<camino.size(); i++){
			if (camino.get(i) != camino.get(i-1)){
				resultado += " --> " + camino.get(i).toString();
			}
		}
		return resultado;
	}
	
	private void findPathAux(int vertexI, int vertexJ, ArrayList<Vertex> camino){
		int vertexK = matrixA[vertexI][vertexJ];
		if (vertexK == -1){ 
			camino.add(this.getVertexFromIndex(vertexI));
			camino.add(this.getVertexFromIndex(vertexJ));
		}else{
			findPathAux(vertexI, vertexK, camino);
			findPathAux(vertexK, vertexJ, camino);
		}
		//here (recursive algorithm???)
	}
	
	public ArrayList<String> filterPathsByDistance(double distanceMin, double distanceMax){
		ArrayList<String> resultado = new ArrayList<String>();
		int numPaths = 1;
		for (int i=0; i<this.vertexToIndex.size(); i++){
			for (int j=0; j<this.vertexToIndex.size(); j++){
				if (i==j) continue;
				if (matrixD[i][j] < distanceMin || matrixD[i][j] > distanceMax) continue;
				resultado.add("Camino #" + (numPaths++) + ": " + findPath(i,j)  + " (" + matrixD[i][j] + ")");
			}
		}
		
		return resultado;
	}
	
	
	public String findTheLargestPath(){
		int vImax = 0;
		int vJmax = 0;
		double weightMax = Double.MIN_VALUE;
		
		for (int i=0; i<this.vertexToIndex.size(); i++){
			for (int j=0; j<this.vertexToIndex.size(); j++){
				if (i == j) continue;
				if (matrixD[i][j] == INFINITY) continue;
				if (matrixD[i][j] > weightMax){
					vImax = i;
					vJmax = j;
					weightMax = matrixD[i][j];
				}
			}
		}
		return findPath(vImax,vJmax) + " (" + weightMax + ")";
	}

	public String findTheShortestPath(){
		int vImin = 0;
		int vJmin = 0;
		double weightMin = Double.MAX_VALUE;
		
		for (int i=0; i<this.vertexToIndex.size(); i++){
			for (int j=0; j<this.vertexToIndex.size(); j++){
				if (i == j) continue;
				if (matrixD[i][j] == INFINITY) continue;
				if (matrixD[i][j] < weightMin){
					vImin = i;
					vJmin = j;
					weightMin = matrixD[i][j];
				}
			}
		}
		return findPath(vImin,vJmin) + " (" + weightMin + ")";
	}
}

