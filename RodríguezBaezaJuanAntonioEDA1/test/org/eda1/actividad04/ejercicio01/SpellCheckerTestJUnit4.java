package org.eda1.actividad04.ejercicio01;

import static org.junit.Assert.*;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.LinkedList;

import org.eda1.actividad04.ejercicio01.SpellChecker;
import org.junit.Before;
import org.junit.Test;

public class SpellCheckerTestJUnit4 {

	String inputDirectory;

	@Before
	public void setUp() throws Exception {
		inputDirectory = System.getProperty("user.dir");

		inputDirectory = inputDirectory + File.separator + "src"
				+ File.separator + "org" + File.separator + "eda1"
				+ File.separator + "actividad04" + File.separator
				+ "ejercicio01" + File.separator;
	}

	@Test
	public void testSpellChecker() {

		SpellChecker spellChecker = new SpellChecker();
		BufferedReader in = null;
		String line = null;
		// Loading the dictionary file
		try {
			in = new BufferedReader(new FileReader(inputDirectory
					+ "dictionary.txt"));
			while ((line = in.readLine()) != null) {

				spellChecker.addToDictionary(line);
			}

			in.close();
		} catch (IOException e) {
		}

		// loading the document file
		try {
			in = new BufferedReader(new FileReader(inputDirectory
					+ "document.txt"));

			while ((line = in.readLine()) != null) {

				spellChecker.addToDocument(line);
			}

			in.close();
		} catch (IOException e) {
		}

		assertTrue(spellChecker.size() == 58109);

		assertTrue(spellChecker.contains("structure"));

		assertFalse(spellChecker.contains("organization"));

		LinkedList<String> differences = spellChecker.compare();

		assertTrue(differences.size() == 3);

		assertEquals(differences.toString(), "[a, organization, organizing]");

		assertTrue(differences.contains("organization"));

		spellChecker.addToDictionary(differences);

		assertTrue(spellChecker.contains("organization"));

		assertTrue(spellChecker.size() == 58112);

	}

}