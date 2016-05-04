package org.eda1.practica03.ejercicio03;

import static org.junit.Assert.*;

import java.io.IOException;
import java.util.ArrayList;

import org.junit.Before;
import org.junit.Test;

public class ConcordanciaTestJUnit4 {

	String directorioEntrada;
	Concordancia concordancia;

	@Before
	public void setUp() throws Exception {
		String expresion = "[a-zA-Z][a-zA-Z0-9]*";
		concordancia = new Concordancia(expresion);
	}

	
	@Test
	public void testProcesarConcordanciaArchivo() throws IOException {
		
		String cadena = "int m = 12, n = 14;\n"
				      + "double a = 3, b = 2, hypotenuse;\n\n"
				      + "if (n <= 5)\n"
				      + "n = 2*m;\n"
				      + "else\n"
				      + "n = m * m;\n"
				      + "hypotenuse = sqrt(a*a + b*b);\n";
		
		String cadenaConcordanciaV1 = concordancia.concordanceV1(cadena);
		
		ArrayList<String> salidaEsperada = new ArrayList<String>();
		salidaEsperada.add("a\t2:\t2\t8");
		salidaEsperada.add("b\t2:\t2\t8");
		salidaEsperada.add("double\t1:\t2");
		salidaEsperada.add("else\t1:\t6");
		salidaEsperada.add("hypotenuse\t2:\t2\t8");
		salidaEsperada.add("if\t1:\t4");
		salidaEsperada.add("int\t1:\t1");
		salidaEsperada.add("m\t3:\t1\t5\t7");
		salidaEsperada.add("n\t4:\t1\t4\t5\t7");
		salidaEsperada.add("sqrt\t1:\t8");
		
		
		for (String string : salidaEsperada) {
			assertTrue(cadenaConcordanciaV1.contains(string));
		}
		
		String cadenaConcordanciaV2 = concordancia.concordanceV2(cadena);
		salidaEsperada.clear();
		salidaEsperada.add("a\t3:\t2(1)\t8(2)");
		salidaEsperada.add("b\t3:\t2(1)\t8(2)");
		salidaEsperada.add("double\t1:\t2(1)");
		salidaEsperada.add("else\t1:\t6(1)");
		salidaEsperada.add("hypotenuse\t2:\t2(1)\t8(1)");
		salidaEsperada.add("if\t1:\t4(1)");
		salidaEsperada.add("int\t1:\t1(1)");
		salidaEsperada.add("m\t4:\t1(1)\t5(1)\t7(2)");
		salidaEsperada.add("n\t4:\t1(1)\t4(1)\t5(1)\t7(1)");
		salidaEsperada.add("sqrt\t1:\t8(1)");

		for (String string : salidaEsperada) {
			assertTrue(cadenaConcordanciaV2.contains(string));
		}

	}

}
