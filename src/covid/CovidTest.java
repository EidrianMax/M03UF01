/*
 * CovidTest.java 11 Jan 2024
 *
 *
 * \u00A9 Copyright 2024 Joan S�culi
 * Email: jseculi@escoladeltreball.org
 *
 * This is free software, licensed under the GNU General Public License v3.
 * See http://www.gnu.org/licenses/gpl.html for more information.
 */
package covid;

import static org.junit.jupiter.api.Assertions.*;

import java.util.Arrays;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class CovidTest {

	int[][] covidCases = {       { 54,  57,     71,  191,  225,  323,  433 }, 
		    { 764,  982,  1146, 1472, 1720, 2126, 1729 },
			{ 2488, 3698, 4040, 5184, 4877, 7646, 8544 },
			{ 8945, 9195, 8263, 6140, 5642, 8146, 6041 },
			{ 5802, 7654, 6765, 5654, 3467, 5277, 7647 }, 
			{ 5675, 4345, 3234, 4532, 3567, 3756, 3243 },
			{ 2578, 3089, 2987, 2867, 2433, 3222, 3433 },
			{ 2133, 2111, 1567, 1322, 1211, 1089,  899 },
			{  677,  566,  454,  454,  478,  686,  544 } };

	
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
	void testNumberOfCases () {
		assertEquals(54, Covid.numberfCases(covidCases, 0, 0));
		assertEquals(57, Covid.numberfCases(covidCases, 1, 0));
		assertEquals(71, Covid.numberfCases(covidCases, 2, 0));
		assertEquals(191, Covid.numberfCases(covidCases, 3, 0));
		assertEquals(225, Covid.numberfCases(covidCases, 4, 0));
		assertEquals(323, Covid.numberfCases(covidCases, 5, 0));
		assertEquals(433, Covid.numberfCases(covidCases, 6, 0));
		
		
		assertEquals(764, Covid.numberfCases(covidCases, 0, 1));
		assertEquals(982, Covid.numberfCases(covidCases, 1, 1));
		assertEquals(1146, Covid.numberfCases(covidCases, 2, 1));
		assertEquals(1472, Covid.numberfCases(covidCases, 3, 1));
		assertEquals(1720, Covid.numberfCases(covidCases, 4, 1));
		assertEquals(2126, Covid.numberfCases(covidCases, 5, 1));
		assertEquals(1729, Covid.numberfCases(covidCases, 6, 1));
		
		
	}
	@Test
	void testCasesPerWeek() {
		assertEquals(9939, Covid.casesPerWeek(covidCases, 1));
		assertEquals(36477, Covid.casesPerWeek(covidCases, 2));
		assertEquals(52372, Covid.casesPerWeek(covidCases, 3));
		assertEquals(42266, Covid.casesPerWeek(covidCases, 4));
		assertEquals(28352, Covid.casesPerWeek(covidCases, 5));
		assertEquals(20609, Covid.casesPerWeek(covidCases, 6));
		assertEquals(10332, Covid.casesPerWeek(covidCases, 7));
		
		
	}

	@Test
	void testTotalCases() {
		assertEquals(205560, Covid.totalCases(covidCases));
		
	}

	@Test
	void testTotalAverage() {
		assertEquals(3262.0, Covid.totalAverage(covidCases));
		
	}

	@Test
	void testArrayTotalPerWeek() {
		
		int[] result = { 1354, 9939, 36477, 52372, 42266, 28352, 20609, 10332, 3859 };
		
		assertTrue(Arrays.equals(Covid.arrayTotalPerWeek(covidCases), result));
		
	}

	@Test
	void testArrayAveragePerWeek() {
		
		int[] result = { 193, 1419, 5211, 7481, 6038, 4050, 2944, 1476, 551 };
		
		assertTrue(Arrays.equals(Covid.arrayAveragePerWeek (covidCases), result));
		
		
	}

	@Test
	void testArrayMaxValueaxValuePerWeek() {
		
		int[] result = { 433, 2126, 8544, 9195, 7654, 5675, 3433, 2133, 686 };
		
		assertTrue(Arrays.equals(Covid.arrayMaxValueaxValuePerWeek (covidCases), result));
		
		
		
	}

}