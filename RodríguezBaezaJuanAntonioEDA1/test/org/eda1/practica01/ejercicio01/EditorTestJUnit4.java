package org.eda1.practica01.ejercicio01;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class EditorTestJUnit4 {

    protected Editor editor;
    
	@Before
	public void setUp() throws Exception {
		editor = new Editor();
	}

	@Test
	public void testInterpret() {
        assertEquals(null, editor.interpret("$Insert"));
	}

    @Test (expected = RuntimeException.class)    
    public void testInterpretEmpty() {
        try {                    
            editor.interpret("");            
        }
        catch (RuntimeException e) {
            assertEquals("java.lang.RuntimeException: " + Editor.BAD_LINE_MESSAGE, e.toString());
            throw new RuntimeException();
        } 
    }

    @Test (expected = RuntimeException.class)    
    public void testInterpretBadCommand() {        
        try {                    
            editor.interpret("$last");            
        }
        catch (RuntimeException e) {
            assertEquals("java.lang.RuntimeException: " + Editor.BAD_COMMAND_MESSAGE, e.toString());
            throw new RuntimeException();
        }
    }

    @Test (expected = RuntimeException.class)
    public void testInterpretBadLine() {
        try {                    
            editor.interpret("$Delete 7 x");            
        }
        catch (RuntimeException e) {
            assertEquals("java.lang.RuntimeException: " + Editor.TWO_INTEGERS_NEEDED, e.toString());
            throw new RuntimeException();
        }
    }

    @Test (expected = RuntimeException.class)    
    public void testInterpretBadDelete() {
        try {                    
            editor.interpret("$Delete 7 x");            
        }
        catch (RuntimeException e){
            assertEquals("java.lang.RuntimeException: " + Editor.TWO_INTEGERS_NEEDED, e.toString());
            throw new RuntimeException();
        }
    }

    @Test (expected = RuntimeException.class)    
    public void testInterpretBadGetLines() {
        try {                    
            editor.interpret("$GetLines 3 1");            
        }
        catch (RuntimeException e){
            assertEquals("java.lang.RuntimeException: " + Editor.FIRST_GREATER, e.toString());
            throw new RuntimeException();
        }
    }

    @Test (expected = RuntimeException.class)    
    public void testInterpretBadChange01() {
        try {                    
            editor.interpret("$Change %a%b");            
        }
        catch (RuntimeException e){
            assertEquals("java.lang.RuntimeException: " + Editor.INCORRECT_DELIMITERS_NUMBER, e.toString());
            throw new RuntimeException();
        }
    }

    @Test (expected = RuntimeException.class)    
    public void testInterpretBadChange02() {
        try {                    
            editor.interpret("$Change %a%b%c");            
        }
        catch (RuntimeException e){
            assertEquals("java.lang.RuntimeException: " + Editor.NO_DELIMITERS_BEGIN_END, e.toString());
            throw new RuntimeException();
        }
    }

    @Test (expected = RuntimeException.class)    
    public void testInterpretBadChange03() {
        try {                    
            editor.interpret("$Change %%a%");
        }
        catch (RuntimeException e){
            assertEquals("java.lang.RuntimeException: " + Editor.TWO_CONSECUTIVE_DELIMITERS_AT_THE_BEGINNING, e.toString());
            throw new RuntimeException();
        }
    }

    @Test
    public void testInterpretNotInserting() {
        assertEquals(null, editor.interpret("$Line 0"));                   
    }

    @Test    
    public void testInsert() {                      
        editor.interpret("$Insert");
        editor.insert("a");
        editor.insert("b");
        String actual = editor.interpret("$Done"), expected = "   a\n   b\n>  \n";       
        assertEquals(expected, actual);
    }

    @Test (expected = RuntimeException.class)
    public void testInsertTooLong() {                      
        editor.interpret("$Insert");
        editor.insert("aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa" +
                      "aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa");
    }

    @Test   
    public void testSetLineNumber() {
        editor.interpret("$Insert");
        editor.insert("c");
        editor.insert("d");
        editor.setCurrentLineNumber(1);
        editor.insert("x");
        String actual = editor.interpret("$Done"),
               expected = "   c\n   x\n>  d\n";
        assertEquals(expected, actual);   
    }

    @Test (expected = RuntimeException.class)    
    public void testSetLineNumberHigh() {
        try {
            editor.interpret("$Insert");
            editor.insert("c");
            editor.insert("d");
            editor.setCurrentLineNumber(3);
        }
        catch (RuntimeException e) {
            assertEquals("java.lang.RuntimeException: " + Editor.M_TOO_LARGE, e.toString());
            throw new RuntimeException();
        }
    }

    @Test
    public void testDelete() {                      
       editor.interpret("$Insert");
       editor.insert("a");
       editor.insert("b");
       editor.insert("c");
       editor.insert("d");
       editor.insert("e");
       editor.insert("f");
       editor.delete(1, 3);
       String actual = editor.interpret("$Done");
       String expected = "   a\n>  e\n   f\n";
       assertEquals(expected, actual);    
    }

    @Test (expected = RuntimeException.class)    
    public void testDeleteFirstGreater() {
       try {
           editor.interpret("$Insert");
           editor.insert("c");
           editor.insert("d");
           editor.interpret("$Delete 1 0");
       }
       catch (RuntimeException e) {
           assertEquals("java.lang.RuntimeException: " + Editor.FIRST_GREATER, e.toString());
           throw new RuntimeException();
       }
     }

    @Test (expected = RuntimeException.class)    
    public void testDeleteFirstLess0() {
        try {
           editor.interpret("$Insert");
           editor.insert("c");
           editor.insert("d");
           editor.interpret("$Delete -1 0");
        }
        catch (RuntimeException e) {
            assertEquals("java.lang.RuntimeException: " + Editor.FIRST_LESS_THAN_ZERO, e.toString());
            throw new RuntimeException();
        }
    }

    @Test (expected = RuntimeException.class)    
    public void testDeleteSecondHigh() {
        try {
            editor.interpret("$Insert");
            editor.insert("c");
            editor.insert("d");
            editor.interpret("$Delete 1 2");
        }
        catch (RuntimeException e) {
            assertEquals("java.lang.RuntimeException: " + Editor.SECOND_TOO_LARGE, e.toString());
            throw new RuntimeException();
        }
     }

    @Test      
    public void testDoneEndCurrentLine() {
        editor.interpret("$Insert");
        editor.insert("c");
        editor.insert("d");
        String actual = editor.interpret ("$Done");
        String expected = "   c\n   d\n>  \n";
        assertEquals(expected, actual);
    }
    
    @Test
    public void testDoneStartCurrentLine() {
        editor.interpret("$Insert");
        editor.insert("c");
        editor.insert("d");
        editor.setCurrentLineNumber(0);
        String actual = editor.interpret("$Done");
        String expected = ">  c\n   d\n";
        assertEquals(expected, actual);
    }

    @Test
    public void testLast() {
        editor.interpret("$Insert");
        editor.insert("a");
        editor.insert("b");
        editor.insert("c");
        editor.insert("d");
        String actual = editor.interpret ("$Last");
        String expected = "3";
        assertEquals(expected, actual);
    }

    @Test
    public void testGetLines() {                      
       editor.interpret("$Insert");
       editor.insert("a");
       editor.insert("b");
       editor.insert("c");
       editor.insert("d");
       editor.insert("e");
       editor.insert("f");
       String actual = editor.getLines(1, 3);
       String expected = "1\tb\n2\tc\n3\td";
       assertEquals(expected, actual);    
    }

    
    @Test
    public void testChange() {                      
       editor.interpret("$Insert");
       editor.insert("a b");
       editor.insert("b c");
       editor.insert("c d");
       editor.insert("d e");
       editor.setCurrentLineNumber(2);
       editor.change("%c %x%");
       String actual = editor.interpret("$Done");
       String expected = "   a b\n   b c\n>  xd\n   d e\n";
       assertEquals(expected, actual);    
    }

    @Test (expected = RuntimeException.class)    
    public void testChangeIncorrectNumberOfDelimiters() {
       try {
           editor.interpret("$Insert");
           editor.insert("c");
           editor.insert("d");
           editor.interpret("$Line 1");
           editor.interpret("$Change %d%a%%");
       }
       catch (RuntimeException e) {
           assertEquals("java.lang.RuntimeException: " + Editor.INCORRECT_DELIMITERS_NUMBER, e.toString());
           throw new RuntimeException();
       }
     }

    @Test (expected = RuntimeException.class)    
    public void testChangeNoDelimitersBeginEnd() {
        try {
           editor.interpret("$Insert");
           editor.insert("c");
           editor.insert("d");
           editor.interpret("$Line 1");
           editor.interpret("$Change %d%a%a");
        }
        catch (RuntimeException e) {
            assertEquals("java.lang.RuntimeException: " + Editor.NO_DELIMITERS_BEGIN_END, e.toString());
            throw new RuntimeException();
        }
    }

    @Test (expected = RuntimeException.class)    
    public void testChangeTwoConsecutiveDelimitersAtTheBeginning() {
        try {
            editor.interpret("$Insert");
            editor.insert("c");
            editor.insert("d");
            editor.interpret("$Line 1");
            editor.interpret("$Change %%a%");
        }
        catch (RuntimeException e) {
            assertEquals("java.lang.RuntimeException: " + Editor.TWO_CONSECUTIVE_DELIMITERS_AT_THE_BEGINNING, e.toString());
            throw new RuntimeException();
        }
     }

    @Test
    public void testChangeRemoveString() {
    	editor.interpret("$Insert");
    	editor.insert("a b");
    	editor.insert("b c");
    	editor.insert("c d");
    	editor.insert("d e");
    	editor.interpret("$Line 1");
    	editor.interpret("$Change %b %%");
    	String actual = editor.interpret("$Done");
    	String expected = "   a b\n>  c\n   c d\n   d e\n";
    	assertEquals(expected, actual);    
     }
     
}
