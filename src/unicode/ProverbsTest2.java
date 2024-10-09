/*
* ProverbsTest.java 13 Sept 2024
*
*
* © Copyright 2024 Joan Sèculi <jseculi@escoladeltreball.org>
*
* This is free software, licensed under the GNU General Public License v3.
* See http://www.gnu.org/licenses/gpl.html for more information.
*/
package unicode;

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
import org.junit.jupiter.api.condition.EnabledOnOs;
import org.junit.jupiter.api.condition.OS;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class ProverbsTest2 {
	// Store the output of the program
		private ByteArrayOutputStream baos;
	    private final PrintStream originalOut = System.out;
	    
	    private static String out = "";
	    private static int total = 0;
	    
	    private static final int TESTS = 22;
	    
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
        // Set line separator for Windows
        String lineSeparator = System.lineSeparator(); //"\r\n";

        // Run the main method of the Proverbs class
        Proverbs.main(null);
        
        if(!baos.toString().contains("Proverb in Catalan:")) {
        	out += "Missing text: \"Proverb in Catalan:\"\n";
        	total += 1;
        }

        if(!baos.toString().contains("Proverb in Chinese (Good medicine tastes bitter):")) {
        	out += "Missing text: \"Proverb in Chinese (Good medicine tastes bitter):\"\n";
        	total += 1;
        }
        

        if(!baos.toString().contains("Proverb in Swedish (Better short of pence than short of sense):")) {
        	out += "Missing text: \"Proverb in Swedish (Better short of pence than short of sense):\"\n";
        	total += 1;
        }
        
        //"Proverb in Greek (Better late than never):"
        if(!baos.toString().contains("Proverb in Greek (Better late than never):")) {
        	out += "Missing text: \"Proverb in Greek (Better late than never):\"\n";
        	total += 1;
        }
        
        
        if(!baos.toString().contains("" + '\u00EF')) {
        	out += "Catalan proverb does not contain char \\u00EF\n";
        	total += 1;
        }
        
        if(!baos.toString().contains("" + '\u00F3')) {
        	out += "Catalan proverb does not contain char \\u00F3\n";
        	total += 1;
        }
        
        if(!baos.toString().contains("" + '\u00E9')) {
        	out += "Catalan proverb does not contain char \\u00E9\n";
        	total += 1;
        }
        
     
        //Chinese
        if(!baos.toString().contains("" + '\u826F')) {
        	out += "Chinese proverb does not contain char \\u826F\n";
        	total += 1;
        }
        if(!baos.toString().contains("" + '\u836F')) {
        	out += "Chinese proverb does not contain char \\u836F\n";
        	total += 1;
        }
        if(!baos.toString().contains("" + '\u82E6')) {
        	out += "Chinese proverb does not contain char \\u82E6\n";
        	total += 1;
        }
        if(!baos.toString().contains("" + '\u53E3')) {
        	out += "Chinese proverb does not contain char \\u53E3\n";
        	total += 1;
        }
        
        //Swedish
        if(!baos.toString().contains("" + '\u00E4')) {
        	out += "Swedish proverb does not contain char \\u53E3\n";
        	total += 1;
        }
        if(!baos.toString().contains("" + '\u00F6')) {
        	out += "Swedish proverb does not contain char \\u00F6\n";
        	total += 1;
        }
        if(!baos.toString().contains("" + '\u00E5')) {
        	out += "Swedish proverb does not contain char \\u00E5\n";
        	total += 1;
        }
        
        //Greek
        
        //"\u039A" + '\u03AC' + "\u03BB" + '\u03BB' + "\u03B9" + '\u03BF' + " " + '\u03B1' + "\u03C1" + "\u03B3" + '\u03AC' + " " + '\u03C0' + "\u03C1" + "\u03B3" + '\u03AC' + " " + '\u03C0' + '\u03BF' + '\u03C4' + '\u03AD'
        if(!baos.toString().contains("" + "\u039A\u03AC\u03BB\u03BB\u03B9\u03BF")) {
        	out += "The first word of the greek proverb is incorrect.\n";
        	total += 1;
        }
       
        if(!baos.toString().contains("" + "\u03B1\u03C1\u03B3\u03AC")) {
        	out += "The second word of the greek proverb is incorrect.\n";
        	total += 1;
        }
        

        if(!baos.toString().contains("" + "\u03C0\u03C1\u03B3\u03AC")) {
        	out += "The third word of the greek proverb is incorrect.\n";
        	total += 1;
        }
        
       
        
        if(!baos.toString().contains("" + "\u03C0\u03BF\u03C4\u03AD")) {
        	out += "The fourth word of the greek proverb is incorrect.\n";
        	total += 1;
        }
        
        //"De desagra" + '\u00EF' + "ts el m" + '\u00F3' + "n n'" + '\u00E9' + "s ple."
        if(!baos.toString().contains("De desagra\u00EFts el m\u00F3n n'\u00E9s ple.")) {
        	out += "Catalan proverb is incorrect.\n";
        	total += 1;
        }
        
        if(!baos.toString().contains("\u826F\u836F\u82E6\u53E3")) {
        	out += "Chinese proverb is incorrect.\n";
        	total += 1;
        }
        
        if(!baos.toString().contains("B\u00E4ttre br\u00F6dl\u00F6s \u00E4n r\u00E5dl\u00F6s.")) {
        	out += "Swedish proverb is incorrect.\n";
        	total += 1;
        }
        
        if(!baos.toString().contains("\u039A\u03AC\u03BB\u03BB\u03B9\u03BF \u03B1\u03C1\u03B3\u03AC \u03C0\u03C1\u03B3\u03AC \u03C0\u03BF\u03C4\u03AD.")) {
        	out += "Greek proverb is incorrect.\n";
        	total += 1;
        }
        
        
      
        
        
        
        //Check chars
        //Català
      	//De desagraïts el món n'és ple.
        assertTrue(baos.toString().contains("" + '\u00EF'));
        assertTrue(baos.toString().contains("" + '\u00F3'));
        assertTrue(baos.toString().contains("" + '\u00E9'));
        
        //Chinese
      	//良药苦口 //Good medicine tastes bitter
        assertTrue(baos.toString().contains("" + '\u826F'));
        assertTrue(baos.toString().contains("" + '\u836F'));
        assertTrue(baos.toString().contains("" + '\u82E6'));
        assertTrue(baos.toString().contains("" + '\u53E3'));
       
        //Bättre brödlös än rådlös. //Better short of pence than short of sense.
        assertTrue(baos.toString().contains("" + '\u00E4'));
        assertTrue(baos.toString().contains("" + '\u00F6'));
        //assertTrue(baos.toString().contains("" + '\u00E4'));
        assertTrue(baos.toString().contains("" + '\u00E5'));
        //assertTrue(baos.toString().contains("" + '\u00F6'));
        
       
        //Κάλλιο αργά παρά ποτέ. //Better late than never.
        assertTrue(baos.toString().contains("" + "\u039A\u03AC\u03BB\u03BB\u03B9\u03BF"));
        assertTrue(baos.toString().contains("" + "\u03C0\u03C1\u03B3\u03AC"));
        assertTrue(baos.toString().contains("" + "\u03B1\u03C1\u03B3\u03AC"));
        assertTrue(baos.toString().contains("" + "\u03C0\u03C1\u03B3\u03AC"));
        assertTrue(baos.toString().contains("" + "\u03C0\u03BF\u03C4\u03AD"));
        
        
        // Check complete lines
        assertTrue(baos.toString().contains("De desagra\u00EFts el m\u00F3n n'\u00E9s ple."));
        assertTrue(baos.toString().contains("\u826F\u836F\u82E6\u53E3"));
        assertTrue(baos.toString().contains("B\u00E4ttre br\u00F6dl\u00F6s \u00E4n r\u00E5dl\u00F6s."));
        assertTrue(baos.toString().contains("\u039A\u03AC\u03BB\u03BB\u03B9\u03BF \u03B1\u03C1\u03B3\u03AC \u03C0\u03C1\u03B3\u03AC \u03C0\u03BF\u03C4\u03AD."));
        
        
        
        
        // Expected output
        String expectedOutput = 
            "Proverb in Catalan:" + lineSeparator +
            "De desagra\u00EFts el m\u00F3n n'\u00E9s ple." + lineSeparator +
            lineSeparator +
            "Proverb in Chinese (Good medicine tastes bitter):" + lineSeparator +
            "\u826F\u836F\u82E6\u53E3." + lineSeparator +
            lineSeparator +
            "Proverb in Swedish (Better short of pence than short of sense):" + lineSeparator +
            "B\u00E4ttre br\u00F6dl\u00F6s \u00E4n r\u00E5dl\u00F6s." + lineSeparator +
            lineSeparator +
            "Proverb in Greek (Better late than never):" + lineSeparator +
            "\u039A\u03AC\u03BB\u03BB\u03B9\u03BF \u03B1\u03C1\u03B3\u03AC \u03C0\u03C1\u03B3\u03AC \u03C0\u03BF\u03C4\u03AD." + lineSeparator;

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