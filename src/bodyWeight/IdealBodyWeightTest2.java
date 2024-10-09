/*
 * IdealBodyWeightTest.java 13 Sept 2024
 *
 *
 * © Copyright 2024 Joan Sèculi <jseculi@escoladeltreball.org>
 *
 * This is free software, licensed under the GNU General Public License v3.
 * See http://www.gnu.org/licenses/gpl.html for more information.
 */

 package bodyWeight;

 import static org.junit.jupiter.api.Assertions.assertEquals;
 import java.io.ByteArrayInputStream;
 import java.io.ByteArrayOutputStream;
 import java.io.IOException;
 import java.io.PrintStream;
 import java.nio.file.Files;
 import java.nio.file.Paths;
 
 import org.junit.jupiter.api.AfterEach;
 import org.junit.jupiter.api.BeforeEach;
 import org.junit.jupiter.api.MethodOrderer;
 import org.junit.jupiter.api.Order;
 import org.junit.jupiter.api.Test;
 import org.junit.jupiter.api.TestMethodOrder;
 
 @TestMethodOrder(MethodOrderer.OrderAnnotation.class)
 public class IdealBodyWeightTest2 {
 
   private ByteArrayOutputStream baos;
     private final PrintStream originalOut = System.out;
     
     private static String out = "";
     private static int total = 0;
     
     private static final int TESTS = 16;
     
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
     public void testIdealBodyWeight1() {
         // Simulate input: height = 175, age = 40
         String simulatedInput = "175" + System.lineSeparator() +
             "40" + System.lineSeparator();
         
         System.setIn(new ByteArrayInputStream(simulatedInput.getBytes()));
 
         // Run the main method of IdealBodyWeight
         IdealBodyWeight.main(null);
 
         
         // Expected output for the given input
         String expectedOutput = 
             "Enter your height in cm: " +
             "Enter your age: " +
            
             "Ideal Body Weigh for Men = 73.75kg" +  
             "Ideal Body Weigh for Women = 76.75kg" + System.lineSeparator();
 
         String expectedOutput2 = 
                 "Enter your height in cm: " +
                 "Enter your age: " +
                 "Ideal Body Weigh for Men = 73.75kg" + System.lineSeparator() +  
                 "Ideal Body Weigh for Women = 76.75kg" + System.lineSeparator();
         
 
         if(!baos.toString().contains("Enter your height in cm:")) {
           out += "Missing text: \"Enter your height in cm:\".\n";
           total += 1;        	
         }
         
         
         if(!baos.toString().contains("Enter your age:")) {
           out += "Missing text: \"Enter your age:\".\n";
           total += 1;        	
         }
         
         if(!baos.toString().contains("Ideal Body Weight for Men =")) {
           out += "Missing text: \"Ideal Body Weight for Men =\".\n";
           total += 1;        	
         }
         if(!baos.toString().contains("Ideal Body Weight for Women =")) {
           out += "Missing text: \"Ideal Body Weight for Women =\".\n";
           total += 1;        	
         }
         if(!baos.toString().contains("73.75")) {
           out += "Men formula incorrect.\n";
           total += 1;        	
         }
         
         
         if(!baos.toString().contains("76.75")) {
           out += "Women formula incorrect.\n";
           total += 1;        	
         }
         
         if(!baos.toString().contains("kg")) {
           out += "Missing \"kg\".\n";
           total += 1;        	
         }
         
         if(!baos.toString().contains("kg")) {
           out += "Missing \"kg\".\n";
           total += 1;        	
         }
         
         if(!baos.toString().contains("Ideal Body Weight for Men = 73.75kg")) {
           out += "Incorrect output for Men results.\n";
           total += 1;        	
         }
         
         if(!baos.toString().contains("Ideal Body Weight for Women = 76.75kg")) {
           out += "Incorrect output for Women results.\n";
           total += 1;        	
         }
         
         // Check lines:
         assertEquals(baos.toString().contains("Enter your height in cm:"), true, 
             "Output does not contain the correct text for height.");
         
         assertEquals(baos.toString().contains("Enter your age:"), true, 
             "Output does not contain the correct text for age.");
         
 
         assertEquals(baos.toString().contains("Ideal Body Weight for Men = 73.75kg"), true, 
             "Output does not contain the correct text for men results.");
        
         assertEquals(baos.toString().contains("Ideal Body Weight for Women = 76.75kg"), true, 
             "Output does not contain the correct text for women results.");
        
         
         // Check if the output matches the expected output
         //assertEquals(expectedOutput2, outputStream.toString(), "Output does not match the expected result for Men.");
    
         //assertEquals(outputStream.toString().contains(expectedOutput2), true, 
         //		"Output does not contain the correct text.");
        
      // Restaurar entrada i sortida estàndard
        System.setIn(System.in);
     }
 
    
     @Test
     @Order(2)
     public void testIdealBodyWeight2() {
         // Simulate input: height = 179, age = 32
         String simulatedInput = "179" + System.lineSeparator() +
             "32" + System.lineSeparator();
         
         System.setIn(new ByteArrayInputStream(simulatedInput.getBytes()));
 
         // Run the main method of IdealBodyWeight
         IdealBodyWeight.main(null);
 
         
         // Expected output for the given input
         String expectedOutput = 
             "Enter your height in cm: " +
             "Enter your age: " +
             "Ideal Body Weigh for Men = 74.75kg" +
           "Ideal Body Weigh for Women = 76.55kg" + System.lineSeparator();
         
         String expectedOutput2 = 
                 "Enter your height in cm: " +
                 "Enter your age: " +
                 "Ideal Body Weigh for Men = 74.75kg" + System.lineSeparator() +
               "Ideal Body Weigh for Women = 76.55kg" + System.lineSeparator();
 
         
         // Check lines:
        
         if(!baos.toString().contains("74.75")) {
           out += "Men formula incorrect.\n";
           total += 1;        	
         }
         
         
         if(!baos.toString().contains("76.55")) {
           out += "Women formula incorrect.\n";
           total += 1;        	
         }
         
         
        
         assertEquals(baos.toString().contains("74.75"), true, 
             "Output does not contain the correct text for men results.");
        
         assertEquals(baos.toString().contains("76.55"), true, 
             "Output does not contain the correct text for women results.");
        
         // Check if the output matches the expected output
        // assertEquals(expectedOutput, outputStream.toString(), "Output does not match the expected result for Men.");
    
         //assertEquals(outputStream.toString().contains(expectedOutput2), true, 
         //		"Output does not contain the correct text.");
      // Restaurar entrada i sortida estàndard
        System.setIn(System.in);
        
     }
     @Test
     @Order(3)
     public void testIdealBodyWeight3() {
         // Simulate input: height = 160, age = 35
         String simulatedInput = "160" + System.lineSeparator() +
             "35" + System.lineSeparator();
             
         System.setIn(new ByteArrayInputStream(simulatedInput.getBytes()));
 
         // Run the main method of IdealBodyWeight
         IdealBodyWeight.main(null);
 
         // Expected output for the given input
         String expectedOutput = 
             "Enter your height in cm: " +
             "Enter your age: " +
             "Ideal Body Weigh for Men = 61.25kg" + System.lineSeparator() + 
             "Ideal Body Weigh for Women = 63.5kg" + System.lineSeparator();
 
         String expectedOutput2 = 
                 "Enter your height in cm: " +
                 "Enter your age: " +
                 "Ideal Body Weigh for Men = 61.25kg" + System.lineSeparator() + 
                 "Ideal Body Weigh for Women = 63.5kg" + System.lineSeparator();
 
         
         if(!baos.toString().contains("61.25")) {
           out += "Men formula incorrect.\n";
           total += 1;        	
         }
         
         
         if(!baos.toString().contains("63.5")) {
           out += "Women formula incorrect.\n";
           total += 1;        	
         }
        
         assertEquals(baos.toString().contains("61.25"), true, 
             "Output does not contain the correct text for men results.");
        
         
        
         
         assertEquals(baos.toString().contains("63.5"), true, 
             "Output does not contain the correct text for women results.");
        
         
         
         // Check if the output matches the expected output
         //assertEquals(expectedOutput, outputStream.toString(), "Output does not match the expected result for Women.");
    
         //assertEquals(outputStream.toString().contains(expectedOutput2), true, 
         //		"Output does not contain the correct text.");
        
      // Restaurar entrada i sortida estàndard
        System.setIn(System.in);
     }
     
     @Test
     @Order(4)
     public void testIdealBodyWeight4() {
         // Simulate input: height = 168, age = 43
         String simulatedInput = "168" + System.lineSeparator() +
             "43" + System.lineSeparator();
             
         System.setIn(new ByteArrayInputStream(simulatedInput.getBytes()));
 
         // Run the main method of IdealBodyWeight
         IdealBodyWeight.main(null);
 
         // Expected output for the given input
         String expectedOutput = 
             "Enter your height in cm: " +
             "Enter your age: " +
             "Ideal Body Weigh for Men = 69.25kg" + 
             "Ideal Body Weigh for Women = 72.7kg" + System.lineSeparator();
 
         String expectedOutput2 = 
                 "Enter your height in cm: " +
                 "Enter your age: " +
                 "Ideal Body Weigh for Men = 69.25kg" + System.lineSeparator() +
                 "Ideal Body Weigh for Women = 72.7kg" + System.lineSeparator();
         
       
         if(!baos.toString().contains("69.25")) {
           out += "Men formula incorrect.\n";
           total += 1;        	
         }
         
         
         if(!baos.toString().contains("72.7")) {
           out += "Women formula incorrect.\n";
           total += 1;        	
         }
         
         
         assertEquals(baos.toString().contains("69.25"), true, 
             "Output does not contain the correct text for men results.");
        
         
         assertEquals(baos.toString().contains("72.7"), true, 
             "Output does not contain the correct text for women results.");
        
        
         // Check if the output matches the expected output
         //assertEquals(expectedOutput, outputStream.toString(), "Output does not match the expected result for Women.");
    
         //assertEquals(outputStream.toString().contains(expectedOutput2), true, 
         //		"Output does not contain the correct text.");
        
      // Restaurar entrada i sortida estàndard
        System.setIn(System.in);
     }
     
     @Test
     @Order(5)
   public void testFinalVariables() throws IOException {
     // Path to the AverageUK.java file (replace this with the actual path to the
     // file)
     String filePath = "src/bodyWeight/IdealBodyWeight.java";
 
     // Read the source file content
     String sourceCode = new String(Files.readAllBytes(Paths.get(filePath)));
 
     // Remove comments from the source code (both single-line and multi-line
     // comments)
     String cleanedSourceCode = removeComments(sourceCode);
 
     
     // Count occurrences of the word "float"
     long finalCount = cleanedSourceCode.lines().filter(line -> line.contains("final ")).count();
 
     if(finalCount < 2) {
           out += "There should 2 final variables.\n";
           total += 1;        	
         }
         
         
        
         
         
     // Assert that only one float is declared
     assertEquals(2, finalCount, "There should 2 final variables.");
   
     // Restaurar entrada i sortida estàndard
        System.setIn(System.in);
     }
     
     // Helper method to remove comments from the source code
     private String removeComments(String code) {
         // Remove multi-line comments (including those spanning multiple lines)
         code = code.replaceAll("/\\*[^*]*(?:\\*(?!/)[^*]*)*\\*/", "");
         // Remove single-line comments (//...)
         code = code.replaceAll("//.*", "");
         return code;
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