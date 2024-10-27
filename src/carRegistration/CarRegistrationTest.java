/*
* CarRegistrationTest.java 8 Oct 2024
*
*
* © Copyright 2024 Joan Sèculi <jseculi@escoladeltreball.org>
*
* This is free software, licensed under the GNU General Public License v3.
* See http://www.gnu.org/licenses/gpl.html for more information.
*/
package carRegistration;

import static org.junit.jupiter.api.Assertions.*;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
class CarRegistrationTest {
	
	CarRegistration cr = new CarRegistration();

	private ByteArrayOutputStream baos;
	private final PrintStream originalOut = System.out;

	private static String out = "";
	private static int total = 0;

	private static final int TESTS = 5;

	
	@BeforeAll
	static void setUpBeforeClass() throws Exception {
	}

	@AfterAll
	static void tearDownAfterClass() throws Exception {
	}

	@BeforeEach
	void setUp() throws Exception {
	}

	@AfterEach
	void tearDown() throws Exception {
	}

	
	@Test
	@Order(1)
	void testGetNumber() {
		if(cr.getNumber("1234LCX") != 1234) {
        	out += "Error: method getNumber() is not correct.\n";
        	total += 1;        	
        }
		assertEquals(1234, cr.getNumber("1234LCX"));
	}
	
	
	@Test
	@Order(2)
	void testGetLetters() {
		
		if(!cr.getLetters("1234LCX").equals("LCX") ){
        	out += "Error: method getLetters() is not correct.\n";
        	total += 1;        	
        }
		
		if(!cr.getLetters("1234lcx").equals("LCX") ){
        	out += "Error: method getLetters() should convert letters to uppercase.\n";
        	total += 1;        	
        }
		assertEquals("LCX", cr.getLetters("1234LCX"));
		
		assertEquals("LCX", cr.getLetters("1234lcx"));
	}
	
	@Test
	@Order(3)
	void testCompare() {
		
		if(!cr.compare("1234LCX", "1234LCX") ){
        	out += "Error: method compare() is not correct.\n";
        	total += 1;        	
        }
		
		if(!cr.compare("1234lcx", "1234LCX") ){
        	out += "Error: method compare() should convert letters to uppercase.\n";
        	total += 1;        	
        }
		assertTrue(cr.compare("1234LCX", "1234LCX"));
		assertTrue(cr.compare("1234lcx", "1234LCX"));
		
	}
	
	@Test
	@Order(100)
	public void testFinal() {
		// Asegurarnos de que la salida estándar se ha restaurado y que se imprima `out`
		System.setOut(originalOut); // Restaurar la salida estándar
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

			System.out.println(out); // Imprimir el valor acumulado de `out`
			System.out.println("\nTotal number test: " + TESTS);
			System.out.println("Total number test failed: " + total);

			double success = round(100.0 - ((double) total / TESTS * 100.0), 2);
			System.out.println("Coverage successfully: " + success + "%");

		}

	}

	public double round(double num, int dec) {
		return Math.round(num * Math.pow(10.0, dec)) / Math.pow(10, dec);
	}

}