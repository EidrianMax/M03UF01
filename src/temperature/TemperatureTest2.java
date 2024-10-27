/*
 * TemperatureTest.java 10 Sept 2023
 *
 *
 * \u00A9 Copyright 2023 Joan S�culi
 * Email: jseculi@escoladeltreball.org
 *
 * This is free software, licensed under the GNU General Public License v3.
 * See http://www.gnu.org/licenses/gpl.html for more information.
 */
package temperature;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;


@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
class TemperatureTest2 {

	private static String out = "";
	private static int total = 0;

	private static final int TESTS = 6;

	
	
	
	static Temperature t;
	@BeforeAll
	static void setUpBeforeClass() throws Exception {
		
	}

	@AfterAll
	static void tearDownAfterClass() throws Exception {
	}

	@BeforeEach
	void setUp() throws Exception {
		t = new Temperature();
	}

	@AfterEach
	void tearDown() throws Exception {
	}

	@Test
	@Order(1) 
	void testF2C() {
		
		if (round(t.f2c(86), (byte)2) != 30) {
			out += "Test f2c method => For fahrenheit = 30, Temp in Celsius should be 30.00, but it is actually " + String.format("%.2f", t.f2c(86), (byte)2) + "\n";
			total += 1;
		}
		if (round(t.f2c(91.4f), (byte)2) != 33) {
			out += "Test f2c method => For fahrenheit = 91.4, Temp in Celsius should be 33.00, but it is actually " + String.format("%.2f", t.f2c(91.4f), (byte)2) + "\n";
			total += 1;
		}
		if (round(t.f2c(120), (byte)2) != 48.89) {
			out += "Test f2c method => For fahrenheit = 120, Temp in Celsius should be 48.89, but it is actually " + String.format("%.2f", t.f2c(120), (byte)2) + "\n";
			total += 1;
		}
		
		assertEquals(t.f2c(86), 30, 0.01);
		assertEquals(t.f2c(91.4f), 33, 0.01);
		assertEquals(t.f2c(120), 48.89, 0.01);
	}
	
	@Test
	@Order(2) 
	void testC2F() {
		
		if (round(t.c2f(30), (byte)2) != 86) {
			out += "Test c2f method => For Celsius = 30, Temp in Fahrenheit should be 86.00, but it is actually " + String.format("%.2f", t.c2f(30), (byte)2) + "\n";
			total += 1;
		}
		if (round(t.c2f(33), (byte)2) != 91.4) {
			out += "Test c2f method => For Celsius = 33, Temp in Fahrenheit should be 91.40, but it is actually " + String.format("%.2f", t.c2f(33), (byte)2) + "\n";
			total += 1;
		}
		if (round(t.c2f(48.89f), (byte)2) != 120) {
			out += "Test c2f method => For Celsius = 48.89, Temp in Fahrenheit should be 120.00, but it is actually " + String.format("%.2f", t.c2f(48.89f), (byte)2) + "\n";
			total += 1;
		}
		
		
		assertEquals(t.c2f(30), 86, 0.01);
		assertEquals(t.c2f(33), 91.4, 0.01);
		assertEquals(t.c2f(48.89f), 120, 0.01);	
	}
	
	@Test
	@Order(100)
	public void testFinal() {

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

			System.out.println(out);
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