/*
* SplitTest.java 10 Jan 2024
*
*
* ©Copyright 2024 Joan Sèculi <jseculi@escoladeltreball.org>
*
* This is free software, licensed under the GNU General Public License v3.
* See http://www.gnu.org/licenses/gpl.html for more information.
*/
package splitEvenOdd;

import static org.junit.jupiter.api.Assertions.*;

import java.util.Arrays;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class SplitTest {

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
	void testSplitArray() {
		int[] array = { 1, 47, 11, 32, -60, 91, -34, 56, 77, 120 };
		
		int[] arrayEven = { 32, -60, -34, 56, 120 };

		int[] arrayOdd = { 1, 47, 11, 91, 77 };
		
		assertTrue(Arrays.equals(arrayEven, Split.splitArray(array, true)));
		
		assertFalse(Arrays.equals(arrayEven, Split.splitArray(array, false)));
		
		assertTrue(Arrays.equals(arrayOdd, Split.splitArray(array, false)));
	
		assertFalse(Arrays.equals(arrayOdd, Split.splitArray(array, true)));
		
	}

	@Test
	void testSplitArrayForEach() {
		
int[] array = { 1, 47, 11, 32, -60, 91, -34, 56, 77, 120 };
		
		int[] arrayEven = { 32, -60, -34, 56, 120 };

		int[] arrayOdd = { 1, 47, 11, 91, 77 };
		
		assertTrue(Arrays.equals(arrayEven, Split.splitArrayForEach(array, true)));
		
		assertFalse(Arrays.equals(arrayEven, Split.splitArrayForEach(array, false)));
		
		assertTrue(Arrays.equals(arrayOdd, Split.splitArrayForEach(array, false)));
	
		assertFalse(Arrays.equals(arrayOdd, Split.splitArrayForEach(array, true)));
	}

}