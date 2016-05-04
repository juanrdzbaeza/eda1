package org.eda1.prueba01;

import java.util.Comparator;

public class LongitudComparatorGreater implements Comparator<Palabra> {

	@Override
    public int compare(Palabra p1, Palabra p2) 
    { 
		int lon1 = p1.getLongitud();
		int lon2 = p2.getLongitud();
		
		if (lon1 < lon2) return 1;
		if (lon1 > lon2) return -1;
		return p1.compareTo(p2);
    } 
}
