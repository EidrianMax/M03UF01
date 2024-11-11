/*
* FactorialTest.java 10 Jan 2024
*
*
* ©Copyright 2024 Joan Sèculi <jseculi@escoladeltreball.org>
*
* This is free software, licensed under the GNU General Public License v3.
* See http://www.gnu.org/licenses/gpl.html for more information.
*/
package factorial;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class FactorialTest {
	
	static Factorial f;

	@BeforeAll
	static void setUpBeforeClass() throws Exception {
		f = new Factorial();
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
	void fatorialTest() {
		assertEquals(1, f.factorial(0));
		assertEquals(1, f.factorial(1));
		assertEquals(2, f.factorial(2));
		assertEquals(6, f.factorial(3));
		assertEquals(24, f.factorial(4));
		assertEquals(120, f.factorial(5));
		assertEquals(720, f.factorial(6));
		assertEquals(5040, f.factorial(7));
		assertEquals(40320, f.factorial(8));
		assertEquals(362880, f.factorial(9));
		assertEquals(3628800, f.factorial(10));
		
		assertEquals(2.6525285981219103E32, f.factorial(30));
		
		assertEquals(7.257415615307994E306, f.factorial(170));
		assertEquals(1.2146304367025325E205, f.factorial(123));
		
		
		assertEquals(-1, f.factorial(-1));
		assertEquals(-1, f.factorial(-2));
		assertEquals(-1, f.factorial(-3));
		assertEquals(-1, f.factorial(-4));
		assertEquals(-1, f.factorial(-5));
		
	}

}