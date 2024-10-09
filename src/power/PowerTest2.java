/*
 * PowerTest.java 13 Sept 2024
 *
 *
 * © Copyright 2024 Joan Sèculi <jseculi@escoladeltreball.org>
 *
 * This is free software, licensed under the GNU General Public License v3.
 * See http://www.gnu.org/licenses/gpl.html for more information.
 */
package power;

import static org.junit.Assert.assertTrue;
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
public class PowerTest2 {

	private ByteArrayOutputStream baos;
    private final PrintStream originalOut = System.out;
    
    private static String out = "";
    private static int total = 0;
    
    private static final int TESTS = 7;
    
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
        // Set line separator 
        String lineSeparator = System.lineSeparator(); 

        // Run the main method of the Power class
        Power.main(null);
        
     // Expected output
        String expectedOutput = 
            "P (no decimals) = 385" + lineSeparator +
            "P (with decimals) = 385.4166666666667" + lineSeparator +
            "P (with 2 decimals) = 385.42" ; //+ lineSeparator;

        if(!baos.toString().contains("P (no decimals)")) {
        	out += "Missing text: \"P (no decimals)\"\n";
        	total += 1;
        }
        
        if(!baos.toString().contains("P (with decimals)")) {
        	out += "Missing text: \"P (with decimals)\"\n";
        	total += 1;
        }
        
        if(!baos.toString().contains("P (with 2 decimals)")) {
        	out += "Missing text: \"P (with 2 decimals)\"\n";
        	total += 1;
        }
        //redundant
        if(!baos.toString().contains("385")) {
        	out += "Missing results with no decimals.\n";
        	total += 1;
        }
        
        if(!baos.toString().contains("385.4166666666667")) {
        	out += "Missing results with all decimals.\n";
        	total += 1;
        }
        
        if(!baos.toString().contains("385.42")) {
        	out += "Missing results with 2 decimals.\n";
        	total += 1;
        }
        
        if(!baos.toString().contains(expectedOutput)) {
        	out += "Complete output is incorrect.\n";
        	total += 1;
        }
        
        
        // Check lines
        assertTrue(baos.toString().contains("P (no decimals) = 385"));
        assertEquals(baos.toString().contains("P (no decimals) = 385" + lineSeparator), true,
        		() -> "You are not showing the result with no decimals.");
        
         assertEquals(baos.toString().contains("P (with decimals) = 385.4166666666667"), true,
        		() -> "You should use a double type instead of float.");
        
         assertTrue(baos.toString().contains("P (with 2 decimals) = 385.42"));
         assertEquals(baos.toString().contains("P (with 2 decimals) = 385.42" /*+ lineSeparator*/), true,
        		 () -> "You are not showing the result with 2 decimals.");

        
        // Compare the output from the program with the expected output
        assertTrue(baos.toString().contains(expectedOutput));
    
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