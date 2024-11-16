/*
* SumFirstElementsTest.java 10 Jan 2024
*
*
* ©Copyright 2024 Joan Sèculi <jseculi@escoladeltreball.org>
*
* This is free software, licensed under the GNU General Public License v3.
* See http://www.gnu.org/licenses/gpl.html for more information.
*/
package sumFirstElements;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class SumFirstElementsTest {
	
	SumFirstElements sfe = new SumFirstElements();

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
	void testSumFirstElements() {
		double[] array = {
				100.5, -50.5, 25.25, -15.25, 33, 100.56, -25.57, 20, 10.5, -2.2 
		};
		assertEquals(93.0, sfe.sumFirstElements(array, 5), 0.001);
		
		assertEquals(75.25, sfe.sumFirstElements(array, 3), 0.001);
		
		assertEquals(196.29, sfe.sumFirstElements(array, 10), 0.001);
		
		assertEquals(196.29, sfe.sumFirstElements(array, 30), 0.001);
		
		
		
		
	}

}