package math;

import static org.junit.jupiter.api.Assertions.assertEquals;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class FormulasTest2 {

	private ByteArrayOutputStream baos;
    private final PrintStream originalOut = System.out;
    
    private static String out = "";
    private static int total = 0;
    
    private static final int TESTS = 8;
    
    @BeforeEach
	public void setup() {
		//Initialize ByteArrayOutputStream before each test
		baos = new ByteArrayOutputStream();
		System.setOut(new PrintStream(baos));
	}

	@AfterEach
	public void tearDown() {
		//Restore standard output after each test
		System.setOut(originalOut);
	}

    @Test
    @Order(1)
    public void testMain() {
        // Run the main method of the Formulas class
        Formulas.main(null);

        // Capture the output and remove any extra newlines with trim()
        String output = baos.toString().trim();

        // Split the output into lines
        String[] lines = output.split("\r?\n");
        
        /*
         
        "\r?\n": 
        This is a regular expression pattern used to match line breaks in different operating systems. It accounts for both Unix-like and Windows-style line breaks.

    	\n: Matches the newline character used by Unix and Unix-like systems (including Linux and macOS).

    	\r: Matches the carriage return character used by older Mac systems and in conjunction with \n for Windows-style line breaks.

    	?: This makes the preceding character optional. In this case, it means that the \r (carriage return) is optional when matching the line break. This allows the regex to match both \n alone (for Unix-like systems) and \r\n together (for Windows).
        */
        
        if(!baos.toString().contains("Formula 1 = ")) {
        	out += "Missing text: \"Formula 1 = \".\n";
        	total += 1;        	
        }
        
        if(!baos.toString().contains("Formula 2 = ")) {
        	out += "Missing text: \"Formula 2 = \".\n";
        	total += 1;        	
        }
        
        if(!baos.toString().contains("Formula 3 = ")) {
        	out += "Missing text: \"Formula 3 = \".\n";
        	total += 1;        	
        }
        
        if(!baos.toString().contains("Formula 4 = ")) {
        	out += "Missing text: \"Formula 4 = \".\n";
        	total += 1;        	
        }
        

        if(!baos.toString().contains("2.8900656268704426")) {
        	out += "Formula 1 is incorrect.\n";
        	total += 1;        	
        }
        if(!baos.toString().contains("14.331082644107886")) {
        	out += "Formula 2 is incorrect.\n";
        	total += 1;        	
        }
        if(!baos.toString().contains("-15255.402862184514")) {
        	out += "Formula 3 is incorrect.\n";
        	total += 1;        	
        }
        if(!baos.toString().contains("2896.909091441326")) {
        	out += "Formula 4 is incorrect.\n";
        	total += 1;        	
        }
        
        
        
        // Check the results of each formula
        assertEquals("Formula 1 = 2.8900656268704426", lines[0].trim(), "Formula 1 result is incorrect");
        assertEquals("Formula 2 = 14.331082644107886", lines[1].trim(), "Formula 2 result is incorrect");
        assertEquals("Formula 3 = -15255.402862184514", lines[2].trim(), "Formula 3 result is incorrect");
        assertEquals("Formula 4 = 2896.909091441326", lines[3].trim(), "Formula 4 result is incorrect");
   
        // Restaurar entrada i sortida estàndard
     	System.setIn(System.in);
    }
    
    @Test
    @Order(100)
    public void testFinal() {
        // Asegurarnos de que la salida estándar se ha restaurado y que se imprima `out`
        System.setOut(originalOut);  // Restaurar la salida estándar
        if (out.equalsIgnoreCase("")) {
        	out += "TEST RESULTS: \n\n";
        	out += "All tests have been successfully run!\n\n";
        	out += "Total number test: " + TESTS + "\n";
        	out += "Total number test failed: " + total + "\n";
        	out += "Coverage successfully: 100%";
        	System.out.println(out);
        } else {
        	System.out.println("TEST RESULTS: \n");
        	System.out.println("The following tests have failed: \n");
        	
        	System.out.println(out);  // Imprimir el valor acumulado de `out`
        	System.out.println("\nTotal number test: " + TESTS );
        	System.out.println("Total number test failed: " + total);
        	
        	double success = round(100.0 - ((double)total / TESTS * 100.0), 2);
        	System.out.println("Coverage successfully: " + success + "%");
        	
        	
        }
        
    }
    
	public double round(double num, int dec) {
		return Math.round(num * Math.pow(10.0, dec)) / Math.pow(10, dec);
	}
}