package org.eda1.actividad04.ejercicio01;

import java.util.*;

public class SpellChecker
{
	protected TreeSet<String> dictionary;
	protected TreeSet<String> document;


	/**
 	 *  Initializes this SpellChecker object.
 	 *
 	 */
	public SpellChecker()
	{
		dictionary = new TreeSet<String> ();
		document = new TreeSet<String> ();
 	} // default constructor


	/**
 	 *  Inserts a specified word into the dictionary set of words.
 	 *  The worstTime(n) is O(log n), where n is the number of words in the
 	 *  dictionary set of words.
 	 *
 	 *  @param word - the word to be inserted into the dictionary set of words.
 	 *
 	 */
	public void addToDictionary(String word)
	{
		dictionary.add(word);
	} // method addToDictionarySet

	public void addToDictionary(LinkedList<String> additionalWords)
	{
		for (String word : additionalWords) {
			addToDictionary (word);
		}
	}


	/**
 	 *  Inserts all of the words in a specified line into the document set of words.
 	 *  The worstTime(m) is O(log m), where m is the number of (unique) words
 	 *  in the document set of words.
 	 *
 	 *  @param line - the line whose words are added to the document set of
 	 *                 words.
 	 *
 	 */
	public void addToDocument(String line)
	{
		String []words = line.split("[ ,.:;]");
		System.out.println(Arrays.toString(words));
		for (String word : words) {
			if (!word.isEmpty())
				document.add(word.toLowerCase());
		}
	}

	/**
 	 *  Determines all words that are in the document set but not in the
 	 *  dictionary set.
 	 *  The worstTime(m, n) is O(m log n), where m is the number of words
 	 *  in the document set, and n is the number of words in the dictionary set.
 	 *
 	 *  @return a LinkedList consisting of all the words in the document set that
 	 *                are not in the dictionary set.
 	 *
 	 */
	public LinkedList<String> compare()
	{
		LinkedList<String> lista = new LinkedList<String>();
		for (String word : document) {
			if ( ! dictionary.contains(word))
				lista.add(word);
		}
		return lista;
	}

	public LinkedList<String> dictioanryToList()
	{
		LinkedList<String> lista = new LinkedList<String> (dictionary);
		return lista;
	}

	public LinkedList<String> documentToList()
	{
		LinkedList<String> lista = new LinkedList<String> (document);
		return lista;
	}

	public boolean contains(String word){
		return dictionary.contains(word);
	}

	public int size(){
		return dictionary.size();
	}

}
