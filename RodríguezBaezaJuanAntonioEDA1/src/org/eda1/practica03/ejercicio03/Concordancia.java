package org.eda1.practica03.ejercicio03;

import java.util.regex.*;
import java.util.Iterator;
import java.util.Map.Entry;
import java.util.Scanner;
import java.util.TreeSet;
import java.util.TreeMap;

public class Concordancia {

	private Pattern identifierPattern;
	private Matcher matcher;

	public Concordancia(String expresion) {
		this.identifierPattern = Pattern.compile(expresion);
		this.matcher = null;
	}

	public String concordanceV1(String cadena){
		Scanner fin = new Scanner(cadena);
		TreeMap<String, TreeSet<Integer>> concordanceMap = null;
		String inputLine = null;
		String identifier = null;
		int lineNumber = 0;

		concordanceMap = new TreeMap<String, TreeSet<Integer>>();

		while(fin.hasNext()) {
			inputLine = fin.nextLine();
			lineNumber++;

			matcher = identifierPattern.matcher(inputLine);

			while (matcher.find()) {
				identifier = inputLine.substring(matcher.start(), matcher.end());

				//........
				TreeSet<Integer> set = concordanceMap.get(identifier);
				if (set == null) {
					//el identificador no está en el mapa
					set = new TreeSet<Integer>();
					set.add(lineNumber);
					concordanceMap.put(identifier, set);
				}
				else {
					//el identificador está en el mapa, inserto el
					//numero de linea en el set
					set.add(lineNumber);
				}
			}
		}
		fin.close();
		return formatOutputMapSet(concordanceMap);

	}

	private String formatOutputMapSet(TreeMap<String, TreeSet<Integer>> mapa){

		//Similar a un toString() personalizado...
		//Similar a un toString() personalizado...
		String cadena = "";

		for (Entry<String, TreeSet<Integer>> e : mapa.entrySet()) {
			cadena = cadena + e.getKey() + "\t" + e.getValue().size()+":";
			for (Integer n : e.getValue()) {
				cadena = cadena + "\t" + n;
			}
			cadena = cadena + "\n";
		}
		return cadena;

	}


	public String concordanceV2(String cadena){
		Scanner fin = new Scanner(cadena);
		TreeMap<String, TreeMap<Integer, Integer>> concordanceMap;
		String inputLine = null;
		String identifier = null;
		int lineNumber = 0;

		concordanceMap = new TreeMap<String, TreeMap<Integer, Integer>>();

		while(fin.hasNext()) {
			inputLine = fin.nextLine();
			lineNumber++;

			matcher = identifierPattern.matcher(inputLine);

			while (matcher.find()) {
				identifier = inputLine.substring(matcher.start(), matcher.end());

				//........
				TreeMap<Integer, Integer> mapa = concordanceMap.get(identifier);
				if (mapa == null) {
					//el identificador no está en el mapa
					mapa = new TreeMap<Integer, Integer>();
					mapa.put(lineNumber, 1);
					concordanceMap.put(identifier, mapa);
				}
				else {
					//el identificador está en el mapa, buscar la linea
					//en el otro mapa
					Integer n = mapa.get(lineNumber);
					if (n != null)
						mapa.put(lineNumber, n+1);
					else
						mapa.put(lineNumber, 1);
				}
			}
		}
		fin.close();
		return formatOutputMapMap(concordanceMap);
	}

	private String formatOutputMapMap(TreeMap<String, TreeMap<Integer, Integer>> mapa){
		String cadena = "";

		for (Entry<String, TreeMap<Integer, Integer>> e1 : mapa.entrySet()) {
			cadena = cadena + e1.getKey()+"\t";
			int suma = 0;
			for (Entry<Integer, Integer> e2 : e1.getValue().entrySet()) {
				suma = suma + e2.getValue();
			}
			cadena = cadena + suma + ":";
			for (Entry<Integer, Integer> e2 : e1.getValue().entrySet()) {
				cadena = cadena +"\t"+e2.getKey()+"("+e2.getValue()+")";
			}
		}
		return cadena;
	}
}
