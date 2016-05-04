package org.eda1.prueba01;

import java.util.Comparator;

public class MediaComparatorLess implements Comparator<Palabra> {

	@Override
    public int compare(Palabra p1, Palabra p2) 
    { 
		double media1 = (p1.getLongitud()+p1.getFrecuencia())/2.0;
		double media2 = (p2.getLongitud()+p2.getFrecuencia())/2.0;
		
		if (media1 < media2) return -1;
		if (media1 > media2) return 1;
		return p1.compareTo(p2);
    } 
}
