package org.eda1.practica01.ejercicio01;

import java.util.*;

import org.omg.PortableServer.CurrentOperations;

public class Editor {
     public final static char COMMAND_START = '$';
     public final static char DELIMITER = '%';

     public final static String INSERT_COMMAND = "$Insert";

     public final static String DELETE_COMMAND = "$Delete";

     public final static String LINE_COMMAND = "$Line";

     public final static String DONE_COMMAND = "$Done";
     
     public final static String LAST_COMMAND = "$Last";

     public final static String GETLINES_COMMAND = "$GetLines";
     
     public final static String CHANGE_COMMAND = "$Change";
     
     public final static String BAD_LINE_MESSAGE =
        "Error: a command should start with " + COMMAND_START + ".\n";

     public final static String BAD_COMMAND_MESSAGE =
        "Error: not one of the given commands.\n";

     public final static String INTEGER_NEEDED =
        "Error: The command should be followed by a blank space, " +
        "\nfollowed by an integer.\n";

     public final static String TWO_INTEGERS_NEEDED =
        "Error: The command should be followed by a blank space, " +
        "\nfollowed by an integer, followed by a blank space, " +
        "followed by an integer.\n";

     public final static String FIRST_GREATER =
        "Error: the first line number is greater than the second.\n";

     public final static String FIRST_LESS_THAN_ZERO =
        "Error: the first line number given is less than 0.\n";

     public final static String SECOND_TOO_LARGE =
        "Error: the second line number given is greater than the " +
        "\nnumber of the last line in the text.\n";

     public final static String M_LESS_THAN_ZERO =
        "Error: the number is less than 0.\n";

     public final static String M_TOO_LARGE =
        "Error: the number is larger than the number of lines in the text.\n";

     public final static String LINE_TOO_LONG =
        "Error: the line exceeds the maximum number of characters allowed, ";

     public final static String INCORRECT_DELIMITERS_NUMBER =
        "Error: Delimiter must occur three times. Please try again.\n";
     
     public final static String NO_DELIMITERS_BEGIN_END =
        "Error: Bad Expression format, delimiters should be at the beginning " + 
        "\nand at the end. Please try again.\n";

     public final static String TWO_CONSECUTIVE_DELIMITERS_AT_THE_BEGINNING =
        "Error: Bad Expression format, two consecutive delimiters " +
        "\nat the beginning. Please try again.\n";

     public final static int MAX_LINE_LENGTH = 80;


     protected LinkedList<String> text;

     protected ListIterator<String> current;

     protected boolean inserting;
     

     public Editor() {
         text = new LinkedList<String>();
         current = text.listIterator();
         inserting = false;
     }
     
     
     /*
      * implementacion propia
      */
     
     public String interpret(String s){//comienzo del interprete de comandos
    	 
 		String[] comandoConParametros;
 		Scanner comandoLeido = new Scanner(s);
 		boolean consigueLinea = false;
 		String linea = "";
 		comandoConParametros = s.split(" ");
    	 
    	//Si la linea no inicia con $
 		if(s.equals(""))
 			throw new RuntimeException(BAD_LINE_MESSAGE);
 		
 		/*
 		 * comprobamos los comandos sin parametros insert, last y done
 		 */
 		if (s.equals(INSERT_COMMAND)) {
			inserting = true;
			return null;
		} else if (s.equals(LAST_COMMAND)) {
			return last();
		} else if (s.equals(DONE_COMMAND)) {
			return done();
		}
 		
 		/*
 		 * para comprobar el resto de parametros debemos separar el string de entrada
 		 * en el comando y sus parametros
 		 */
		switch(comandoConParametros[0]){//Controlamos todos los comando con un switch

		case DELETE_COMMAND:
			tryToDelete(comandoLeido);
			break;

		case LINE_COMMAND:
			tryToSetCurrentLineNumber(comandoLeido);
			break;

		case GETLINES_COMMAND:
			linea = tryToGetLine(comandoLeido);
			consigueLinea = true;
			break;

		case CHANGE_COMMAND:
			tryToChange(comandoLeido);
			break;

		default:
			if(s.startsWith(Character.toString(COMMAND_START))){//Controlamos los distintos comandos erroneos
				throw new RuntimeException(BAD_COMMAND_MESSAGE);
			}else if(s.contains("Insert") ||
					s.contains("Delete") ||
					s.contains("Line") ||
					s.contains("Done") ||
					s.contains("Last") ||
					s.contains("GetLines") ||
					s.contains("Change")){
				throw new RuntimeException(BAD_LINE_MESSAGE);
			
			}else{
				insert(s);//Insertamos
			}
			break;
		}//cierre del switch

		if(consigueLinea){
			return linea;
		}else{
		return null;
		}
     }//fin del interprete


     //@#$@#$@#$@#$@#$@#$@#$@#$@#$@#$@#$@#$@#$@#$@#\\
    //@#$@#$@#$       BLOQUE BORRAR       @#$@#$@#$@\\
   //@#$@#$@#$@#$@#$@#$@#$@#$@#$@#$@#$@#$@#$@#$@#$@#$\\
     
     protected void tryToDelete(Scanner comandoLeido){ 

    	 String comando = comandoLeido.nextLine();
    	 String[] array = comando.split(" ");

    	 int parametro1, parametro2;

    	 //Asignamos las filas en las que se realizara la accion
    	 try{
    		 parametro1 = Integer.parseInt(array[1]);
    		 parametro2 = Integer.parseInt(array[2]);
    	 }catch(Exception e){
    		 throw new RuntimeException(TWO_INTEGERS_NEEDED);
    	 }

    	 //Comprobamos todas las restricciones
    	 if(parametro1 > parametro2)
    		 throw new RuntimeException(FIRST_GREATER);

    	 if(parametro1 < 0)
    		 throw new RuntimeException(FIRST_LESS_THAN_ZERO);

    	 if(parametro2 > text.size()-1)
    		 throw new RuntimeException(SECOND_TOO_LARGE);

    	 //Procedemos al borrado
    	 delete(parametro1, parametro2);
     }//Cierre tryToDelete


     protected void delete(int parametro1, int parametro2) {
    	 //Sacamos el numero de lineas a borrar
    	 int lineasABorrar = parametro2 - parametro1 + 1;

    	 for(int i = 0; i < lineasABorrar; i++){
    		 text.remove(parametro1);
    	 }
    	 //Ahora dejamos el current en la posicion necesaria
    	 current = text.listIterator();
    	 if(!text.isEmpty()){
    		 while(current.nextIndex() != parametro1){
    			 current.next();
    		 }
    	 }	
     }//Cierre delete



     //@#$@#$@#$@#$@#$@#$@#$@#$@#$@#$@#$@#$@#$@#$@#\\
    //@#$@#$@#   BLOQUE ESTABLECER LINEA   #$@#$@#$@\\
   //@#$@#$@#$@#$@#$@#$@#$@#$@#$@#$@#$@#$@#$@#$@#$@#$\\
     
     protected void tryToSetCurrentLineNumber(Scanner comandoLeido){

    	 String comando = comandoLeido.nextLine();
    	 String[] array = comando.split(" ");

    	 int linea;

    	 //Asignamos la fila en la que se realizara la accion
    	 try{
    		 linea = Integer.parseInt(array[1]);
    	 }catch(Exception e){
    		 throw new RuntimeException(INTEGER_NEEDED);
    	 }


    	 //Comprobamos todas las restricciones

    	 if(linea % 1 != 0){
    		 throw new RuntimeException(INTEGER_NEEDED);

    	 }else if(linea > text.size()-1 && linea != 0){
    		 throw new RuntimeException(FIRST_GREATER);

    	 }else if(linea < 0){
    		 throw new RuntimeException(FIRST_LESS_THAN_ZERO);
    	 }
    	 //Procedemos a asignar la fila actual
    	 setCurrentLineNumber(linea);

     }//Cierre tryToSetCurrentLineNumber

     protected void setCurrentLineNumber(int linea){
    	 if(linea > text.size()-1 && linea != 0){
    		 throw new RuntimeException(M_TOO_LARGE);
    	 }

    	 current = text.listIterator(linea);

    	 while(current.nextIndex() != linea){
    		 current.next();
    	 }
     }//Cierre setCurrentLineNumber   
     
     
     
     
     //@#$@#$@#$@#$@#$@#$@#$@#$@#$@#$@#$@#$@#$@#$@#\\
    //@#$@#$@#    BLOQUE CONSIGUE LINEA    #$@#$@#$@\\
   //@#$@#$@#$@#$@#$@#$@#$@#$@#$@#$@#$@#$@#$@#$@#$@#$\\ 
     
	protected String tryToGetLine(Scanner comandoLeido) {
		
		String comando = comandoLeido.nextLine();
		String[] array = comando.split(" ");
		
		int desde, hasta;
		
		//Asignamos las filas en las que se realizara la accion
		try{
			desde = Integer.parseInt(array[1]);
			hasta = Integer.parseInt(array[2]);
		}catch(Exception e){
			throw new RuntimeException(TWO_INTEGERS_NEEDED);
		}

		//Comprobamos todas las restricciones
		if(desde > hasta)
			throw new RuntimeException(FIRST_GREATER);

		if(desde < 0)
			throw new RuntimeException(FIRST_LESS_THAN_ZERO);

		if(hasta > text.size()-1)
			throw new RuntimeException(SECOND_TOO_LARGE);

		//Procedemos a realizar la accion
		return getLines(desde, hasta);
		
	}//Cierre tryToGetLine
	

	protected String getLines(int desde, int hasta) {
		String salida = "";

		for(int i = desde; i < hasta+1; i++){//Damos el formato correcto al texto
			if(salida.equals("")){
				salida = i + "\t" + text.get(i);
			}else{
				salida +="\n" + i + "\t" + text.get(i);
			}
		}
		
		return salida;
	}//Cierre getLines
     
     
     
     
     
    //@#$@#$@#$@#$@#$@#$@#$@#$@#$@#$@#$@#$@#$@#$@#\\
   //@#$@#$@#        BLOQUE CAMBIO        #$@#$@#$@\\
  //@#$@#$@#$@#$@#$@#$@#$@#$@#$@#$@#$@#$@#$@#$@#$@#$\\
	
	protected void tryToChange(Scanner comandoLeido){
		
		String comando = comandoLeido.nextLine();
		String[] array = comando.split(" ");
		String aux = "";

		Character a, b, c;
		int contador = 0;
		String comprobar = "";

		for(int i = 0; i < comando.length(); i++){
			c = comando.charAt(i);
			if(c.equals(DELIMITER))
				contador++;
		}

		if(contador != 3)//Comprobamos que tenga 3 delimitadores
			throw new RuntimeException(INCORRECT_DELIMITERS_NUMBER);

		aux = array[1].toString();
		
		a = aux.charAt(0);
		b = aux.charAt(1);
		comprobar += a;
		comprobar += b;

		if(comprobar.equals("%%"))//Comprobamos que no exitan 2 delimitadores juntos al comienzo
			throw new RuntimeException(TWO_CONSECUTIVE_DELIMITERS_AT_THE_BEGINNING);

		Character d;
		int ultimoCaracter = comando.length()-1;
		d = comando.charAt(ultimoCaracter);
		if(!d.equals('%'))//Comprobamos que exista un delimitador al final
			throw new RuntimeException(NO_DELIMITERS_BEGIN_END);
		change(comando);
	}

	protected void change(String entrada) {

		String[] aux = entrada.split(Character.toString(DELIMITER));//Separamos el comando por delimitadores
		String aux1 = "";
		String aux2 = "";
		String linea = "";

		try{//Asignamos a String los caracteres a sustituir
			aux1 = aux[1];
			aux2 = aux[2];
		}catch(Exception e){//Controlamos la excepcion del caracter vacio
			aux2 = "";
		}
		
		linea = current.next();
		linea = linea.replaceAll(aux1, aux2);
			
		current.set(linea);//Inserta elemento en el ultimo current.next utilizazo
		current.previous();//Dejamos el current en la posicion que estaba
	}    
     
     
     
     
    //@#$@#$@#$@#$@#$@#$@#$@#$@#$@#$@#$@#$@#$@#$@#\\
   //@#$@#$@#    LAST - DONE - INSERT     #$@#$@#$@\\
  //@#$@#$@#$@#$@#$@#$@#$@#$@#$@#$@#$@#$@#$@#$@#$@#$\\    
	
	protected String last() {

		return (text.size() - 1 + "");
	}
	
	protected String done() {

		if (text.size() == 0) {
			return null;
		}
		String aux = "";
		ListIterator<String> iterador = text.listIterator();


		int i=0;
		while(iterador.hasNext()){
			if(i == current.nextIndex()){
				aux += ">  " + iterador.next() + "\n";	
			}else{
				aux += "   " + iterador.next() + "\n";
			}
			i++;
		}	
		// comprueba si el current es la ultima linea ficicia
		if(current.nextIndex() == text.size()){
			aux += ">  \n";
		}

		inserting = false;
		return aux;
	}
     
	protected void insert(String s){
		if(inserting){
			if(s.length() > MAX_LINE_LENGTH)
				throw new RuntimeException(LINE_TOO_LONG);
			else
				current.add(s);
		}
	}   
         
}//fin de la clase Editor
