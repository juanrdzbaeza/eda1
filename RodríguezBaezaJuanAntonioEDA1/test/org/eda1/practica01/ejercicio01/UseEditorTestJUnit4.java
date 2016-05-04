package org.eda1.practica01.ejercicio01;

import static org.junit.Assert.*;

import java.io.File;
import java.io.FileNotFoundException;

import java.util.Scanner;

import org.junit.Before;
import org.junit.Test;

public class UseEditorTestJUnit4 {
	
    public final static String FINAL_MESSAGE = "***********************\nHere is the final text:\n";
	String inputFolder;
	String inputFile;

	@Before
	public void setUp() throws Exception {
	}

	@Test
	public void test() {
		inputFolder = System.getProperty("user.dir");
		inputFolder = inputFolder + File.separator +
      		"src" + File.separator +
      		"org" + File.separator +
      		"eda1" + File.separator + 
  			"practica01" + File.separator + 
  			"ejercicio01" + File.separator;
        String inputFile = inputFolder + "text.txt";
        
        Scanner fileScanner = null;
        
        try {
			fileScanner = new Scanner(new File(inputFile));
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}

        String output = editText(fileScanner);

        fileScanner.close();
        
        String expected = "";
        expected += "$Insert" + "\n"; 
        expected += "You can fool" + "\n";
        expected += "some of the people" + "\n";
        expected += "some of the times," + "\n";
        expected += "but you cannot foul" + "\n";
        expected += "all of the people" + "\n";
        expected += "all of the time." + "\n";
        expected += "$Line 2" + "\n";
        expected += "$GetLines 2 1" + "\n";
        expected += "java.lang.RuntimeException: Error: the first line number is greater than the second." + "\n\n";
        
        expected += "$ GetLines 2 2" + "\n";
        expected += "java.lang.RuntimeException: Error: not one of the given commands." + "\n\n";

        expected += "$Change %s%%" + "\n";
        expected += "$GetLines 2 2" + "\n";
        expected += "2\tome of the time," + "\n";
        expected += "$Change %o%so" + "\n";
        expected += "java.lang.RuntimeException: Error: Delimiter must occur three times. Please try again." + "\n\n";

        expected += "$Change %o%so%" + "\n";
        expected += "$GetLines 2 2" + "\n";
        expected += "2\tsome sof the time," + "\n";
        expected += "Change" + "\n";
        expected += "java.lang.RuntimeException: Error: a command should start with $." + "\n\n";

        expected += "$Change %sof%of%" + "\n";
        expected += "$GetLines 2 2" + "\n";
        expected += "2\tsome of the time," + "\n";
        expected += "$Line 0" + "\n";
        expected += "$Insert" + "\n";
        expected += "Lincoln once said that" + "\n";
        expected += "you can fool" + "\n";
        expected += "some of the people" + "\n";
        expected += "all the time and" + "\n";
        expected += "all of the time and" + "\n";
        expected += "$Last" + "\n";
        expected += "10" + "\n";
        expected += "$GetLines 0 10" + "\n";
        expected += "0\tLincoln once said that" + "\n";
        expected += "1\tyou can fool" + "\n";
        expected += "2\tsome of the people" + "\n";
        expected += "3\tall the time and" + "\n";
        expected += "4\tall of the time and" + "\n";
        expected += "5\tYou can fool" + "\n";
        expected += "6\tsome of the people" + "\n";
        expected += "7\tsome of the time," + "\n";
        expected += "8\tbut you cannot foul" + "\n";
        expected += "9\tall of the people" + "\n";
        expected += "10\tall of the time." + "\n";
        expected += "$Line 5" + "\n";
        expected += "$Change %Y%y%" + "\n";
        expected += "$GetLines 5 5" + "\n";
        expected += "5\tyou can fool" + "\n";
        expected += "$Line 6" + "\n";
        expected += "$Change %some%all%" + "\n";
        expected += "$GetLines 6 6" + "\n";
        expected += "6\tall of the people" + "\n";
        expected += "$Line 8" + "\n";
        expected += "$Change %ul%ol%" + "\n";
        expected += "$GetLines 8 8" + "\n";
        expected += "8\tbut you cannot fool" + "\n";
        expected += "$Line 9" + "\n";
        expected += "$Change %ee%eo%" + "\n";
        expected += "$GetLines 9 9" + "\n";
        expected += "9\tall of the people" + "\n";
        expected += "$Delete 3 3" + "\n";
        expected += "$GetLines 0 10" + "\n";
        expected += "java.lang.RuntimeException: Error: the second line number given is greater than the " + "\n";
        expected += "number of the last line in the text." + "\n\n";

        expected += "$Last" + "\n";
        expected += "9" + "\n";
        expected += "$GetLines 0 9" + "\n";
        expected += "0\tLincoln once said that" + "\n";
        expected += "1\tyou can fool" + "\n";
        expected += "2\tsome of the people" + "\n";
        expected += "3\tall of the time and" + "\n";
        expected += "4\tyou can fool" + "\n";
        expected += "5\tall of the people" + "\n";
        expected += "6\tsome of the time," + "\n";
        expected += "7\tbut you cannot fool" + "\n";
        expected += "8\tall of the people" + "\n";
        expected += "9\tall of the time." + "\n";
        expected += "$Change %%eo%" + "\n";
        expected += "java.lang.RuntimeException: Error: Bad Expression format, two consecutive delimiters " + "\n";
        expected += "at the beginning. Please try again." + "\n\n";

        expected += "$Done" + "\n";
        expected += "***********************" + "\n";
        expected += "Here is the final text:" + "\n";
        expected += "   Lincoln once said that" + "\n";
        expected += "   you can fool" + "\n";
        expected += "   some of the people" + "\n";
        expected += ">  all of the time and" + "\n";
        expected += "   you can fool" + "\n";
        expected += "   all of the people" + "\n";
        expected += "   some of the time," + "\n";
        expected += "   but you cannot fool" + "\n";
        expected += "   all of the people" + "\n";
        expected += "   all of the time." + "\n\n";

  
        assertEquals(output, expected);

	}

    private String editText(Scanner fileScanner) {                
        Editor editor = new Editor();
        
        String line = new String();
        String result = new String();
        String output = new String();

        output = "";
        while (true) {
            try {      
                line = fileScanner.nextLine();
                output += line + "\n";
                result = editor.interpret(line);
                if ((result != null) && (!line.equals(Editor.DONE_COMMAND)))
                	output += result + "\n";
             }
             catch (RuntimeException e) {
            	 output += e + "\n";
             }

             if (line.equals(Editor.DONE_COMMAND)) {
            	 output += FINAL_MESSAGE + result + "\n";
                 break;
             }             
          }
        
        return output;
    }

}
