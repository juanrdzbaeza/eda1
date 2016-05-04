package org.eda1.prueba01;

import java.util.Comparator;

public class FrecuenciaComparatorLess implements Comparator<Palabra> {

	@Override
    public int compare(Palabra p1, Palabra p2) 
    { 
		
		int freq1 = p1.getFrecuencia();
		int freq2 = p2.getFrecuencia();
		
		if(freq1 < freq2)return -1;
		if(freq1 > freq2)return 1;		
		return p1.compareTo(p2);
    } 
}
