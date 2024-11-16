/*
* RepeatedEntriesTest.java 10 Jan 2024
*
*
* ©Copyright 2024 Joan Sèculi <jseculi@escoladeltreball.org>
*
* This is free software, licensed under the GNU General Public License v3.
* See http://www.gnu.org/licenses/gpl.html for more information.
*/
package repeatedEntries;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class RepeatedEntriesTest {

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
	void testAreRepeatedEntries() {
		assertEquals(true, RepeatedEntries.areRepeatedEntries(new double[] {10.5, 12.25, -50.75, 10.5, 25.22, 100.155, 10.5, 0.25, 25.22, 11.15}));
		
		assertEquals(false, RepeatedEntries.areRepeatedEntries(new double[] {10.4, 12.25, -50.75, 10.6, 25.23, 100.155, 10.5, 0.25, 25.22, 11.15}));
		
	}

	@Test
	void testNumberOfTimes() {
		assertEquals(3, RepeatedEntries.numberOfTimes(new double[] {10.5, 12.25, -50.75, 10.5, 25.22, 100.155, 10.5, 0.25, 25.22, 11.15}, 10.5));
		
		assertEquals(1, RepeatedEntries.numberOfTimes(new double[] {10.4, 12.25, -50.75, 10.6, 25.23, 100.155, 10.5, 0.25, 25.22, 11.15}, 10.5));
		
		assertEquals(0, RepeatedEntries.numberOfTimes(new double[] {10.4, 12.25, -50.75, 10.6, 25.23, 100.155, 10.5, 0.25, 25.22, 11.15}, 1));
		
	}

}