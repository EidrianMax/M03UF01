/*
* Array1dTest.java 10 Jan 2024
*
*
* ©Copyright 2024 Joan Sèculi <jseculi@escoladeltreball.org>
*
* This is free software, licensed under the GNU General Public License v3.
* See http://www.gnu.org/licenses/gpl.html for more information.
*/
package array1d;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class Array1dTest {

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
	void testSumArray() {
		assertEquals(150, Array1d.sumArray(new double[] {10, 20, 30, 40, 50}));
		assertEquals(32.662, Array1d.sumArray(new double[] {12.55, -20.35, 30.33, -40.423, 50.555}), 0.001);
		assertEquals(0, Array1d.sumArray(new double[] {}));
		
		assertEquals(198.009, Array1d.sumArray(new double[] {15.55, 12.57, 20.45, 100.125, -24.45, 10.102, 13.3, 15.567, 22.22, 12.575}));
		
		
	}

	@Test
	void testMeanArray() {
		assertEquals(30, Array1d.meanArray(new double[] {10, 20, 30, 40, 50}));
		assertEquals(6.532, Array1d.meanArray(new double[] {12.55, -20.35, 30.33, -40.423, 50.555}), 0.001);
		
		assertEquals(19.8009, Array1d.meanArray(new double[] {15.55, 12.57, 20.45, 100.125, -24.45, 10.102, 13.3, 15.567, 22.22, 12.575}));
		
	}

	@Test
	void testPercentageGreaterThanMean() {
		
		assertEquals(30, Array1d.percentageGreaterThanMean(new double[] {15.55, 12.57, 20.45, 100.125, -24.45, 10.102, 13.3, 15.567, 22.22, 12.575}));
		
		
	}

	@Test
	void testArrayMaxValue() {
		
		assertEquals(100.125, Array1d.arrayMaxValue(new double[] {15.55, 12.57, 20.45, 100.125, -24.45, 10.102, 13.3, 15.567, 22.22, 12.575}));
		
	}

}