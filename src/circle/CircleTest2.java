package circle;

import org.junit.jupiter.api.*;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import static org.junit.jupiter.api.Assertions.assertEquals;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class CircleTest2 {
	
	

    @Test
    @Order(1)
    public void testMainOption1() {
    	
    	String exemple = "Choose your option: 1=perimeter, 2=area?\n"
    			+ "1\n"
    			+ "Enter perimeter: \n"
    			+ "10\n"
    			+ "Perimeter = 62.8319";
		
		// Configurar l'entrada estàndar
        String userInput = "1" + System.lineSeparator() + "10" + System.lineSeparator();
        ByteArrayInputStream bais = new ByteArrayInputStream(userInput.getBytes());
        System.setIn(bais);

        // Configurar la sortida estàndar per capturar la sortida del mètode main
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        PrintStream printStream = new PrintStream(baos);
        System.setOut(printStream);

        String expected = "Choose your option: 1=perimeter, 2=area?" + System.lineSeparator();
        expected += "Enter perimeter: " + System.lineSeparator();
        expected += "Perimeter = " + 62.8319 + System.lineSeparator();
        
        
        Circle.main(new String[] {}); // call the main method
        
        String actual = baos.toString();

        // checkout output
        //String[] lines = actual.split(System.lineSeparator());
        //assertEquals(expected, actual);

        //Checkout message
        
       
        assertEquals(actual.contains("Choose your option: 1=perimeter, 2=area?"), true);
        assertEquals(actual.contains("Enter radius:"), true);
        assertEquals(actual.contains("Perimeter = 62.8319"), true);
        assertEquals(actual.contains("Perimeter = 62.83185"), false);

        
        // Restaurar entrada i sortida estàndard
        System.setIn(System.in);
        System.setOut(System.out);

      }


    @Test
    @Order(2)
    public void testMainOption2() {
    	
    	String exemple = "Choose your option: 1=perimetre, 2=area?\n"
    			+ "2\n"
    			+ "Enter radius: \n"
    			+ "3\n"
    			+ "Perimeter = 28.2743";
		
		// Configurar l'entrada estàndar
        String userInput = "2" + System.lineSeparator() + "3" + System.lineSeparator();
        ByteArrayInputStream bais = new ByteArrayInputStream(userInput.getBytes());
        System.setIn(bais);

        // Configurar la sortida estàndar per capturar la sortida del mètode main
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        PrintStream printStream = new PrintStream(baos);
        System.setOut(printStream);

        String expected = "Choose your option: 1=perimetre, 2=area?" + System.lineSeparator();
        expected += "Enter radius: " + System.lineSeparator();
        expected += "Area = " + 28.2743 + System.lineSeparator();
        
        
        Circle.main(new String[] {}); // call the main method
        
        String actual = baos.toString();

        // checkout output
        //String[] lines = actual.split(System.lineSeparator());
        //assertEquals(expected, actual);

        //Checkout message

        assertEquals(actual.contains("Choose your option: 1=perimeter, 2=area?"), true);
        assertEquals(actual.contains("Enter radius:"), true);
        assertEquals(actual.contains("Area = 28.2743"), true);
        assertEquals(actual.contains("Area = 28.27433"), false);

 
        
        
        //28.27433
        // Restaurar entrada i sortida estàndard
        System.setIn(System.in);
        System.setOut(System.out);
        
       
    }


    @Test
    @Order(3)
    public void testMainInvalidOption() {
    	
    	String exemple = "Choose your option: 1=perimetre, 2=area?\n"
    			+ "3\n"
    			+ "Option no valid!";
		
		// Configurar l'entrada estàndar
        String userInput = "3" + System.lineSeparator();
        ByteArrayInputStream bais = new ByteArrayInputStream(userInput.getBytes());
        System.setIn(bais);

        // Configurar la sortida estàndar per capturar la sortida del mètode main
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        PrintStream printStream = new PrintStream(baos);
        System.setOut(printStream);

        String expected = "Choose your option: 1=perimetre, 2=area?" + System.lineSeparator();
        expected += "Option no valid!" + System.lineSeparator();
        
        
        Circle.main(new String[] {}); // call the main method
        
        String actual = baos.toString();

        // checkout output
        //String[] lines = actual.split(System.lineSeparator());
        //assertEquals(expected, actual);

        //Checkout message
       
        assertEquals(actual.contains("Choose your option: 1=perimeter, 2=area?"), true);
        assertEquals(actual.contains("Option no valid!"), true);

        
        
        // Restaurar entrada i sortida estàndard
        System.setIn(System.in);
        System.setOut(System.out);
        
      
    }

   
    @Test
    @Order(4)
    public void testMainValidInputOption1() {
    	
    	String exemple = "Choose your option: 1=perimetre, 2=area?\n"
    			+ "1\n"
    			+ "Enter radius: \n"
    			+ "3.0\n"
    			+ "Perimeter = 18.8496";
		
		// Configurar l'entrada estàndar
        String userInput = "1" + System.lineSeparator() + "3" + System.lineSeparator();
        ByteArrayInputStream bais = new ByteArrayInputStream(userInput.getBytes());
        System.setIn(bais);

        // Configurar la sortida estàndar per capturar la sortida del mètode main
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        PrintStream printStream = new PrintStream(baos);
        System.setOut(printStream);

        String expected = "Choose your option: 1=perimetre, 2=area?" + System.lineSeparator();
        expected += "Enter radius: " + System.lineSeparator();
        expected += "Perimeter = " + 18.8496 + System.lineSeparator();
        
        
        Circle.main(new String[] {}); // call the main method
        
        String actual = baos.toString();

        // checkout output
        //String[] lines = actual.split(System.lineSeparator());
        //assertEquals(expected, actual);

        //Checkout message
        assertEquals(actual.contains("Choose your option: 1=perimeter, 2=area?"), true);
        assertEquals(actual.contains("Enter radius:"), true);
        assertEquals(actual.contains("Perimeter = 18.8496"), true);
        assertEquals(actual.contains("Perimeter = 18.84955592"), false);

        // Restaurar entrada i sortida estàndard
        System.setIn(System.in);
        System.setOut(System.out);
        
        
       
    }

   
    @Test
    @Order(5)
    public void testMainValidInputOption2() {
    	String exemple = "Choose your option: 1=perimetre, 2=area?\n"
    			+ "2\n"
    			+ "Enter radius: \n"
    			+ "2.55\n"
    			+ "Area = 20.4282";
		
		// Configurar l'entrada estàndar
        String userInput = "2" + System.lineSeparator() + "2.55" + System.lineSeparator();
        ByteArrayInputStream bais = new ByteArrayInputStream(userInput.getBytes());
        System.setIn(bais);

        // Configurar la sortida estàndar per capturar la sortida del mètode main
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        PrintStream printStream = new PrintStream(baos);
        System.setOut(printStream);

        String expected = "Choose your option: 1=perimetre, 2=area?" + System.lineSeparator();
        expected += "Enter radius: " + System.lineSeparator();
        expected += "Area = " + 20.4282 + System.lineSeparator();
        
        
        Circle.main(new String[] {}); // call the main method
        
        String actual = baos.toString();

        // checkout output
        //String[] lines = actual.split(System.lineSeparator());
        //assertEquals(expected, actual);

        //Checkout message
        assertEquals(actual.contains("Choose your option: 1=perimeter, 2=area?"), true);
        assertEquals(actual.contains("Enter radius:"), true);
        assertEquals(actual.contains("Area = 20.4282"), true);
        assertEquals(actual.contains("Area = 20.428205"), false);

        
        // Restaurar entrada i sortida estàndard
        System.setIn(System.in);
        System.setOut(System.out);


    }

    
    @Test
    @Order(6)
    public void testMainInvalidInput1() {
    	String exemple = "Choose your option: 1=perimetre, 2=area?\n"
    			+ "a\n"
    			+ "This is not a number";
		
		// Configurar l'entrada estàndar
        String userInput = "a" + System.lineSeparator();
        ByteArrayInputStream bais = new ByteArrayInputStream(userInput.getBytes());
        System.setIn(bais);

        // Configurar la sortida estàndar per capturar la sortida del mètode main
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        PrintStream printStream = new PrintStream(baos);
        System.setOut(printStream);

        String expected = "Choose your option: 1=perimetre, 2=area?" + System.lineSeparator();
        expected += "This is not a number" + System.lineSeparator();
        
        
        Circle.main(new String[] {}); // call the main method
        
        String actual = baos.toString();

        // checkout output
        //String[] lines = actual.split(System.lineSeparator());
        //assertEquals(expected, actual);

        //Checkout message
        assertEquals(actual.contains("Choose your option: 1=perimeter, 2=area?"), true);
        assertEquals(actual.contains("This is not a number"), true);

        // Restaurar entrada i sortida estàndard
        System.setIn(System.in);
        System.setOut(System.out);


    }
   
    
    @Test
    @Order(7)
    public void testMainInvalidInput2() {
    	String exemple = "Choose your option: 1=perimetre, 2=area?\n"
    			+ "2\n"
    			+ "Enter radius: \n"
    			+ "a\n"
    			+ "This is not a number";
		
		// Configurar l'entrada estàndar
        String userInput = "2" + System.lineSeparator() + "a" + System.lineSeparator();
        ByteArrayInputStream bais = new ByteArrayInputStream(userInput.getBytes());
        System.setIn(bais);

        // Configurar la sortida estàndar per capturar la sortida del mètode main
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        PrintStream printStream = new PrintStream(baos);
        System.setOut(printStream);

        String expected = "Choose your option: 1=perimetre, 2=area?" + System.lineSeparator();
        expected += "Enter radius: " + System.lineSeparator();
        expected += "This is not a number" + System.lineSeparator();
        
        
        Circle.main(new String[] {}); // call the main method
        
        String actual = baos.toString();

        // checkout output
        //String[] lines = actual.split(System.lineSeparator());
        //assertEquals(expected, actual);

        //Checkout message
        assertEquals(actual.contains("Choose your option: 1=perimeter, 2=area?"), true);
        assertEquals(actual.contains("Enter radius:"), true);
        assertEquals(actual.contains("This is not a number"), true);

        
        // Restaurar entrada i sortida estàndard
        System.setIn(System.in);
        System.setOut(System.out);

    }
    
    /*
    @Test
    @Order(100)
    public void testFinal() {
    	
    	 // Restaurar entrada i sortida estàndard
        System.setIn(System.in);
        System.setOut(System.out);
    	
    	System.out.println(out);
    }
 */
    
}