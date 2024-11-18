/*
* JoinTest.java 10 Jan 2024
*
*
* ©Copyright 2024 Joan Sèculi <jseculi@escoladeltreball.org>
*
* This is free software, licensed under the GNU General Public License v3.
* See http://www.gnu.org/licenses/gpl.html for more information.
*/
package join;

import static org.junit.jupiter.api.Assertions.*;

import java.util.Arrays;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class JoinTest {

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
	void testJoin() {
		double[] array1 = {10.5, 7.4, 20.10, 35.32, 60.67, 9.21, 3.4, 53.6, 17.3, 87.8};
		double[] array2 = {12.6, 4.7, 1.31, 32.54, 60.4, 9.31, 134.0, 55.2, 12.2, 43.6, 3.6};
	
		double[] result = {10.5, 7.4, 20.10, 35.32, 60.67, 9.21, 3.4, 53.6, 17.3, 87.8, 12.6, 4.7, 1.31, 32.54, 60.4, 9.31, 134.0, 55.2, 12.2, 43.6, 3.6};
		
		assertTrue(Arrays.equals(result, Join.join(array1, array2)));
	}

}