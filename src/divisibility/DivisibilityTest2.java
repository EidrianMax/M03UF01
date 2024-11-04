package divisibility;

import org.junit.jupiter.api.*;
import java.io.*;
import static org.junit.jupiter.api.Assertions.*;


@TestClassOrder(ClassOrderer.OrderAnnotation.class)
public class DivisibilityTest2 {

    @Test
    @Order(1)
    void testAreDivisibleTrue() {
    	
    	String exemple = "Enter number 1: \n"
    			+ "2\n"
    			+ "Enter number 2: \n"
    			+ "22\n"
    			+ "They are divisible";
		
		// Configurar l'entrada estàndar
        String userInput = "2" + System.lineSeparator() + "22" + System.lineSeparator();
        ByteArrayInputStream bais = new ByteArrayInputStream(userInput.getBytes());
        System.setIn(bais);

        // Configurar la sortida estàndar per capturar la sortida del mètode main
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        PrintStream printStream = new PrintStream(baos);
        System.setOut(printStream);

        String expected = "Enter number 1: " + System.lineSeparator();
        expected += "Enter number 2: " + System.lineSeparator();
        expected += "They are divisible" + System.lineSeparator();
        
        
        Divisibility.main(new String[] {}); // call the main method
        
        String actual = baos.toString();

        // checkout output
        String[] lines = actual.split(System.lineSeparator());
        assertEquals(expected, actual);

        //Checkout message
        assertEquals("Enter number 1: ", lines[0]);
        assertEquals("Enter number 2: ", lines[1]);
        assertEquals("They are divisible", lines[2]);

        // Restaurar entrada i sortida estàndard
        System.setIn(System.in);
        System.setOut(System.out);
        
       
    }

    
    @Test
    @Order(2)
    void testAreDivisibleFalse() {
    	
    	String exemple = "Enter number 1: \n"
    			+ "7\n"
    			+ "Enter number 2: \n"
    			+ "4\n"
    			+ "They are not divisible";
		
		// Configurar l'entrada estàndar
        String userInput = "7" + System.lineSeparator() + "4" + System.lineSeparator();
        ByteArrayInputStream bais = new ByteArrayInputStream(userInput.getBytes());
        System.setIn(bais);

        // Configurar la sortida estàndar per capturar la sortida del mètode main
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        PrintStream printStream = new PrintStream(baos);
        System.setOut(printStream);

        String expected = "Enter number 1: " + System.lineSeparator();
        expected += "Enter number 2: " + System.lineSeparator();
        expected += "They are not divisible" + System.lineSeparator();
        
        
        Divisibility.main(new String[] {}); // call the main method
        
        String actual = baos.toString();

        // checkout output
        String[] lines = actual.split(System.lineSeparator());
        assertEquals(expected, actual);

        //Checkout message
        assertEquals("Enter number 1: ", lines[0]);
        assertEquals("Enter number 2: ", lines[1]);
        assertEquals("They are not divisible", lines[2]);

        // Restaurar entrada i sortida estàndard
        System.setIn(System.in);
        System.setOut(System.out);
        
      
    }

    @Test
    @Order(3)
    void testAreDivisibleWithZero() {
    	
    	String exemple = "Enter number 1: \n"
    			+ "0\n"
    			+ "Enter number 2: \n"
    			+ "5\n"
    			+ "They are not divisible";
		
		// Configurar l'entrada estàndar
        String userInput = "0" + System.lineSeparator() + "5" + System.lineSeparator();
        ByteArrayInputStream bais = new ByteArrayInputStream(userInput.getBytes());
        System.setIn(bais);

        // Configurar la sortida estàndar per capturar la sortida del mètode main
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        PrintStream printStream = new PrintStream(baos);
        System.setOut(printStream);

        String expected = "Enter number 1: " + System.lineSeparator();
        expected += "Enter number 2: " + System.lineSeparator();
        expected += "They are divisible" + System.lineSeparator();
        
        Divisibility.main(new String[] {}); // call the main method
        
        String actual = baos.toString();

        // checkout output
        String[] lines = actual.split(System.lineSeparator());
        assertEquals(expected, actual);

        //Checkout message
        assertEquals("Enter number 1: ", lines[0]);
        assertEquals("Enter number 2: ", lines[1]);
        assertEquals("They are divisible", lines[2]);

        // Restaurar entrada i sortida estàndard
        System.setIn(System.in);
        System.setOut(System.out);

    }
    
  
    @Test
    @Order(4)
    void testAreDivisibleWithNegativeNumbers() {
    	
    	String example = "Enter number 1: \n"
    			+ "-8\n"
    			+ "Enter number 2: \n"
    			+ "4\n"
    			+ "They are divisible";
    	
    	
    	// Configurar l'entrada estàndar
        String userInput = "-8" + System.lineSeparator() + "4" + System.lineSeparator();
        ByteArrayInputStream bais = new ByteArrayInputStream(userInput.getBytes());
        System.setIn(bais);

        // Configurar la sortida estàndar per capturar la sortida del mètode main
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        PrintStream printStream = new PrintStream(baos);
        System.setOut(printStream);

        String expected = "Enter number 1: " + System.lineSeparator();
        expected += "Enter number 2: " + System.lineSeparator();
        expected += "They are divisible" + System.lineSeparator();
        
        Divisibility.main(new String[] {}); // call the main method
        
        String actual = baos.toString();

        // checkout output
        String[] lines = actual.split(System.lineSeparator());
        assertEquals(expected, actual);

        //Checkout message
        assertEquals("Enter number 1: ", lines[0]);
        assertEquals("Enter number 2: ", lines[1]);
        assertEquals("They are divisible", lines[2]);

        // Restaurar entrada i sortida estàndard
        System.setIn(System.in);
        System.setOut(System.out);
        
    }

    
    @Test
    @Order(5)
    void testAreDivisibleWithEqualNumbers() {
    	
       	String example = "Enter number 1: \n"
    			+ "4\n"
    			+ "Enter number 2: \n"
    			+ "4\n"
    			+ "They are divisible";
    	
    	
    	// Configurar l'entrada estàndar
        String userInput = "4" + System.lineSeparator() + "4" + System.lineSeparator();
        ByteArrayInputStream bais = new ByteArrayInputStream(userInput.getBytes());
        System.setIn(bais);

        // Configurar la sortida estàndar per capturar la sortida del mètode main
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        PrintStream printStream = new PrintStream(baos);
        System.setOut(printStream);

        String expected = "Enter number 1: " + System.lineSeparator();
        expected += "Enter number 2: " + System.lineSeparator();
        expected += "They are divisible" + System.lineSeparator();
        
        Divisibility.main(new String[] {}); // call the main method
        
        String actual = baos.toString();

        // checkout output
        String[] lines = actual.split(System.lineSeparator());
        assertEquals(expected, actual);

        //Checkout message
        assertEquals("Enter number 1: ", lines[0]);
        assertEquals("Enter number 2: ", lines[1]);
        assertEquals("They are divisible", lines[2]);

        // Restaurar entrada i sortida estàndard
        System.setIn(System.in);
        System.setOut(System.out);

    }

   
    @Test
    @Order(6)
    void testAreDivisibleInvalidInput1() {
    	
       	String example = "Enter number 1: \n"
       			+ "a\n"
       			+ "This is not a integer";
    	
    	
    	// Configurar l'entrada estàndar
        String userInput = "a" + System.lineSeparator();
        ByteArrayInputStream bais = new ByteArrayInputStream(userInput.getBytes());
        System.setIn(bais);

        // Configurar la sortida estàndar per capturar la sortida del mètode main
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        PrintStream printStream = new PrintStream(baos);
        System.setOut(printStream);

        String expected = "Enter number 1: " + System.lineSeparator();
        expected += "This is not an integer" + System.lineSeparator();
        
        Divisibility.main(new String[] {}); // call the main method
        
        String actual = baos.toString();

        // checkout output
        String[] lines = actual.split(System.lineSeparator());
        assertEquals(expected, actual);

        //Checkout message
        assertEquals("Enter number 1: ", lines[0]);
        assertEquals("This is not an integer", lines[1]);

        // Restaurar entrada i sortida estàndard
        System.setIn(System.in);
        System.setOut(System.out);

    }
    
    @Test
    @Order(7)
    void testAreDivisibleInvalidInput2() {
    	
       	String example = "Enter number 1: \n"
    			+ "4\n"
    			+ "Enter number 2: \n"
    			+ "a\n"
    			+ "This is not a integer";
    	
    	
    	// Configurar l'entrada estàndar
        String userInput = "4" + System.lineSeparator() + "a" + System.lineSeparator();
        ByteArrayInputStream bais = new ByteArrayInputStream(userInput.getBytes());
        System.setIn(bais);

        // Configurar la sortida estàndar per capturar la sortida del mètode main
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        PrintStream printStream = new PrintStream(baos);
        System.setOut(printStream);

        String expected = "Enter number 1: " + System.lineSeparator();
        expected += "Enter number 2: " + System.lineSeparator();
        expected += "This is not an integer" + System.lineSeparator();
        
        Divisibility.main(new String[] {}); // call the main method
        
        String actual = baos.toString();

        // checkout output
        String[] lines = actual.split(System.lineSeparator());
        assertEquals(expected, actual);

        //Checkout message
        assertEquals("Enter number 1: ", lines[0]);
        assertEquals("Enter number 2: ", lines[1]);
        assertEquals("This is not an integer", lines[2]);

        // Restaurar entrada i sortida estàndard
        System.setIn(System.in);
        System.setOut(System.out);

    }
}