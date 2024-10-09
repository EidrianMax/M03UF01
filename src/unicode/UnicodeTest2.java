/*
* NameTest.java 13 Sept 2024
*
*
* ©Copyright 2024 Joan Sèculi <jseculi@escoladeltreball.org>
*
* This is free software, licensed under the GNU General Public License v3.
* See http://www.gnu.org/licenses/gpl.html for more information.
*/
package unicode;

import static org.junit.jupiter.api.Assertions.assertEquals;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.junit.jupiter.api.condition.EnabledOnOs;
import org.junit.jupiter.api.condition.OS;

import junit.extensions.TestSetup;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class UnicodeTest2 {

	// Store the output of the program
	private ByteArrayOutputStream baos;
    private final PrintStream originalOut = System.out;
    
    private static String out = "";
    private static int total = 0;
    
    private static final int TESTS = 11;

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

    // Test case for Windows
    @Test
    @Order(1)
    public void testMainWindows() {
        // Set line separator for Windows
        String lineSeparator = System.lineSeparator();

        // Run the main method of the Name class
        Unicode.main(null);

		
		
        // Expected output
        String expectedOutput = '\u00A9' + " " + '\u00C5' + "sa " + '\u00D6' + "str" + '\u00F6' + "m " + '\u00AE' + lineSeparator +
                                '\u00AB' + '\u00BD' + " of the World is suffering from malnutrition" + '\u00BB' + lineSeparator +
                                '\u00AB' + "The average temperature of the planet is 13" + '\u00B0' + "C" + '\u00BB' + lineSeparator;

        //Check characters
        if (!baos.toString().contains('\u00A9' + "")) {
        	out += "Your program does not contain char \\u00A9\n";
        	total += 1;
        }
        
   

        if (!baos.toString().contains('\u00C5' + "")) {
        	out += "Your program does not contain char \\u00C5\\n";
        	total += 1;
        }
        
	
        if (!baos.toString().contains('\u00D6' + "")) {
        	out += "Your program does not contain char \\u00D6\n";
        	total += 1;
        }
        if (!baos.toString().contains('\u00F6' + "")) {
        	out += "Your program does not contain char \\u00F6\n";
        	total += 1;
        }
        if (!baos.toString().contains('\u00AE' + "")) {
        	out += "Your program does not contain char \\u00AE\n";
        	total += 1;
        }
        if (!baos.toString().contains('\u00AB' + "")) {
        	out += "Your program does not contain char \\u00AB\n";
        	total += 1;
        }
        if (!baos.toString().contains('\u00BD' + "")) {
        	out += "Your program does not contain char \\u00BD\n";
        	total += 1;
        }
        if (!baos.toString().contains('\u00BB' + "")) {
        	out += "Your program does not contain char \\u00BB\n";
        	total += 1;
        }
        if (!baos.toString().contains('\u00B0' + "")) {
        	out += "Your program does not contain char \\u00B0\n";
        	total += 1;
        }
        

      //Check lines
        if (!baos.toString().contains('\u00A9' + " " + '\u00C5' + "sa " + '\u00D6' + "str" + '\u00F6' + "m " + '\u00AE')) {
        	out += "There is an error in the first line.\n";
        	total += 1;
        }
        
        if (!baos.toString().contains("" + '\u00AB' + '\u00BD' + " of the World is suffering from malnutrition" + '\u00BB')) {
        	out += "There is an error in the second line.\n";
        	total += 1;
        }
        
        if (!baos.toString().contains('\u00AB' + "The average temperature of the planet is 13" + '\u00B0' + "C" + '\u00BB')) {
        	out += "There is an error in the third line.\n";
        	total += 1;
        }
        
       
        
        
        
        assertEquals(baos.toString().contains('\u00A9' + ""), true, 
        		()-> "Your program does not contain char \\u00A9");
        
        assertEquals(baos.toString().contains('\u00C5' + ""), true, 
        		()-> "Your program does not contain char \\u00C5");
        
        assertEquals(baos.toString().contains('\u00D6' + ""), true, 
        		()-> "Your program does not contain char \\u00D6");
        
        assertEquals(baos.toString().contains('\u00F6' + ""), true, 
        		()-> "Your program does not contain char \\u00F6");
        
        assertEquals(baos.toString().contains('\u00AE' + ""), true, 
        		()-> "Your program does not contain char \\u00AE");
        
        assertEquals(baos.toString().contains('\u00AB' + ""), true, 
        		()-> "Your program does not contain char \\u00AB");
        
        assertEquals(baos.toString().contains('\u00BD' + ""), true, 
        		()-> "Your program does not contain char \\u00BD");
        
        assertEquals(baos.toString().contains('\u00BB' + ""), true, 
        		()-> "Your program does not contain char \\u00BB");
        
        assertEquals(baos.toString().contains('\u00B0' + ""), true, 
        		()-> "Your program does not contain char \\u00B0");
        
        
        //Check lines
        assertEquals(baos.toString().contains('\u00A9' + " " + '\u00C5' + "sa " + '\u00D6' + "str" + '\u00F6' + "m " + '\u00AE'), true, 
        		()-> "There is an error in the first line.");
        
        assertEquals(baos.toString().contains("" + '\u00AB' + '\u00BD' + " of the World is suffering from malnutrition" + '\u00BB'), true, 
        		()-> "There is an error in the second line.");
        
        assertEquals(baos.toString().contains('\u00AB' + "The average temperature of the planet is 13" + '\u00B0' + "C" + '\u00BB'), true, 
        		()-> "There is an error in the third line.");
        
     
        
        
        // Compare the output from the program with the expected output
        assertEquals(expectedOutput, baos.toString());
        
     // Restaurar entrada i sortida estàndard
     	System.setIn(System.in);
     		
     		
    }
    
    @Test
    @Order(100)
    public void testFinal() {
        // Asegurarnos de que la salida estándar se ha restaurado y que se imprima `out`
        System.setOut(originalOut);  // Restaurar la salida estándar
        if (out.equalsIgnoreCase("")) {
        	out += "TEST RESULTS: \n";
        	out += "All tests have been successfully run!\n";
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