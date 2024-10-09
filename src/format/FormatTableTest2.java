/*
 * FormatTableTest.java 13 Sept 2024
 *
 *
 * © Copyright 2024 Joan Sèculi <jseculi@escoladeltreball.org>
 *
 * This is free software, licensed under the GNU General Public License v3.
 * See http://www.gnu.org/licenses/gpl.html for more information.
 */
package format;

import static org.junit.jupiter.api.Assertions.assertEquals;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.PrintStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.condition.EnabledOnOs;
import org.junit.jupiter.api.condition.OS;

public class FormatTableTest2 {

    private final ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
    private final PrintStream originalOut = System.out;

    @BeforeEach
    public void setUp() {
        // Redirect System.out to outputStream
        System.setOut(new PrintStream(outputStream));
    }

    @AfterEach
    public void tearDown() {
        // Restore the original System.out
        System.setOut(originalOut);
    }

    @Test
    public void testMainWindows() {
        // Set line separator for Windows
        //String lineSeparator = "\r\n";
    	String lineSeparator = "\n"; //System.lineSeparator();
    	
        // Run the main method of the FormatTable class
        FormatTable.main(null);

        // Expected output
        String expectedOutput = 
            "-------------------------------------------------------" + lineSeparator +
            "|ARTICLE             |PRICE     |QUANTITY  |TOTAL     |" + lineSeparator +
            "-------------------------------------------------------" + lineSeparator +
            "|T-SHIRT RED         |   33.55 €|         2|   67.09 €|" + lineSeparator +
            "|CAP GREEN           |   22.22 €|         5|  111.12 €|" + lineSeparator +
            "|LEATHER WALLET      |   15.36 €|         3|   46.07 €|" + lineSeparator +
            "|BLUE JACKET         |   67.16 €|         4|  268.63 €|" + lineSeparator +
            "|LEATHER JACKET      |  129.32 €|         7|  905.25 €|" + lineSeparator +
            "-------------------------------------------------------" + lineSeparator;

        String expectedOutput2 = 
                "-------------------------------------------------------" + lineSeparator +
                "|ARTICLE             |PRICE     |QUANTITY  |TOTAL     |" + lineSeparator +
                "-------------------------------------------------------" + lineSeparator +
                "|T-SHIRT RED         |   33.55 €|         2|   67.09 €|" + lineSeparator +
                "|CAP GREEN           |   22.22 €|         5|  111.12 €|" + lineSeparator +
                "|LEATHER WALLET      |   15.36 €|         3|   46.07 €|" + lineSeparator +
                "|BLUE JACKET         |   67.16 €|         4|  268.63 €|" + lineSeparator +
                "|LEATHER JACKET      |  129.32 €|         7|  905.25 €|" + lineSeparator +
                "-------------------------------------------------------";

       
        // Check lines
        
        assertEquals(outputStream.toString().contains("-------------------------------------------------------"), true,
        		() -> "Check the number of \"-\".");
        
        assertEquals(outputStream.toString().contains("|ARTICLE             |PRICE     |QUANTITY  |TOTAL     |"), true,
        		() -> "The header line contains an error");
        
        assertEquals(outputStream.toString().contains("|T-SHIRT RED         |   33.55 €|         2|   67.09 €|"), true,
        		() -> "The T-SHIRT RED line contains an error");
        
        assertEquals(outputStream.toString().contains("|CAP GREEN           |   22.22 €|         5|  111.12 €|"), true,
        		() -> "The CAP GREEN line contains an error");
        
        assertEquals(outputStream.toString().contains("|LEATHER WALLET      |   15.36 €|         3|   46.07 €|"), true,
        		() -> "The LETHER WALLET line contains an error");
        
       
        assertEquals(outputStream.toString().contains("|BLUE JACKET         |   67.16 €|         4|  268.63 €|"), true,
        		() -> "The BLUE JACKET line contains an error");
        
        assertEquals(outputStream.toString().contains("|LEATHER JACKET      |  129.32 €|         7|  905.25 €|"), true,
        		() -> "The LEATHER JACKET line contains an error");
      
        // Compare the output from the program with the expected output
        //assertEquals(expectedOutput, outputStream.toString());
        //assertEquals(outputStream.toString().contains(expectedOutput2), true,
        //		() -> "Output does not contains the correct text");
        
    }

    
    
    @Test
    public void testMainContainsStringFormat() throws IOException {
        // Path to the FormatTable.java file
        Path path = Paths.get("src/format/FormatTable.java");
        
        // Read the file content as a String
        String content = Files.readString(path);
        
        // Check if the content contains "String.format"
        assertEquals(content.contains("String.format"), true,
            () -> "The source code does not contain the String.format method.");

        // Check if the content contains the specific format pattern
        assertEquals(content.contains("|%-20S|%8.2f €|%10d|%8.2f €|"), true, 
        		() -> "The source code does not contain the expected format string: |%-20S|%8.2f €|%10d|%8.2f €|%n");
    }
    
    
}