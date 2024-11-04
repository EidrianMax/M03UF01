/*
 * DatesTest.java 10 Oct 2023
 *
 *
 * \u00A9 Copyright 2023 Joan S�culi
 * Email: jseculi@escoladeltreball.org
 *
 * This is free software, licensed under the GNU General Public License v3.
 * See http://www.gnu.org/licenses/gpl.html for more information.
 */
package dates;

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
class DatesTest {

	static Dates d;
	@BeforeAll
	static void setUpBeforeClass() throws Exception {
		d = new Dates();
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
	void testIsLeapYear() {
		assertTrue(d.isLeapYear((short)2000));
		assertTrue(d.isLeapYear((short)2004));
		assertTrue(d.isLeapYear((short)2008));
		assertTrue(d.isLeapYear((short)2012));
		assertTrue(d.isLeapYear((short)2016));
		assertTrue(d.isLeapYear((short)2020));
		assertTrue(d.isLeapYear((short)2024));
		assertTrue(d.isLeapYear((short)2028));
		assertTrue(d.isLeapYear((short)2032));
		assertTrue(d.isLeapYear((short)2036));
		assertTrue(d.isLeapYear((short)2040));
		assertTrue(d.isLeapYear((short)2044));
		assertTrue(d.isLeapYear((short)2048));
		assertTrue(d.isLeapYear((short)2052));
		assertTrue(d.isLeapYear((short)2056));
		assertTrue(d.isLeapYear((short)2060));
		assertTrue(d.isLeapYear((short)2064));
		assertTrue(d.isLeapYear((short)2068));
		assertTrue(d.isLeapYear((short)2072));
		assertTrue(d.isLeapYear((short)2076));
		assertTrue(d.isLeapYear((short)2080));
		assertTrue(d.isLeapYear((short)2084));
		assertTrue(d.isLeapYear((short)2088));
		assertTrue(d.isLeapYear((short)2092));
		assertTrue(d.isLeapYear((short)2096));
		assertTrue(d.isLeapYear((short)2104));
		assertTrue(d.isLeapYear((short)2108));
		assertTrue(d.isLeapYear((short)2112));
		
		assertTrue(d.isLeapYear((short)2400));
		assertTrue(d.isLeapYear((short)2800));
		
		assertFalse(d.isLeapYear((short)1900));
		assertFalse(d.isLeapYear((short)2100));
		assertFalse(d.isLeapYear((short)2300));
		assertFalse(d.isLeapYear((short)2500));
		assertFalse(d.isLeapYear((short)2600));
		assertFalse(d.isLeapYear((short)2700));
		assertFalse(d.isLeapYear((short)2900));
		assertFalse(d.isLeapYear((short)3000));
	}
	
	@Test
	@Order(2)
	void testDaysOfMonth() {
		assertEquals(31, d.daysOfMonth((byte)1, (short)2000));
		assertEquals(29, d.daysOfMonth((byte)2, (short)2000));
		assertEquals(28, d.daysOfMonth((byte)2, (short)2001));
		assertEquals(31, d.daysOfMonth((byte)3, (short)2000));
		assertEquals(30, d.daysOfMonth((byte)4, (short)2000));
		assertEquals(31, d.daysOfMonth((byte)5, (short)2000));
		assertEquals(30, d.daysOfMonth((byte)6, (short)2000));
		assertEquals(31, d.daysOfMonth((byte)7, (short)2000));
		assertEquals(31, d.daysOfMonth((byte)8, (short)2000));
		assertEquals(30, d.daysOfMonth((byte)9, (short)2000));
		assertEquals(31, d.daysOfMonth((byte)10, (short)2000));
		assertEquals(30, d.daysOfMonth((byte)11, (short)2000));
		assertEquals(31, d.daysOfMonth((byte)12, (short)2000));
	}
	
	@Test
	@Order(3)
	void testisValidDate() {
		assertTrue(d.isValidDate((byte)31, (byte)1, (short)2000));
		assertTrue(d.isValidDate((byte)29, (byte)2, (short)2000));
		assertTrue(d.isValidDate((byte)15, (byte)10, (short)1980));
		assertTrue(d.isValidDate((byte)31, (byte)7, (short)2023));
		assertTrue(d.isValidDate((byte)29, (byte)12, (short)2100));
		assertTrue(d.isValidDate((byte)29, (byte)5, (short)2036));
		assertTrue(d.isValidDate((byte)30, (byte)11, (short)2055));
		assertTrue(d.isValidDate((byte)5, (byte)2, (short)2000));
		assertTrue(d.isValidDate((byte)15, (byte)12, (short)1000));
		assertTrue(d.isValidDate((byte)25, (byte)7, (short)9999));
		assertFalse(d.isValidDate((byte)35, (byte)4, (short)2000));	
		assertFalse(d.isValidDate((byte)12, (byte)44, (short)2000));	
		assertFalse(d.isValidDate((byte)55, (byte)44, (short)2000));	
		
	
		assertFalse(d.isValidDate((byte)29, (byte)2, (short)2001));
		assertFalse(d.isValidDate((byte)29, (byte)32, (short)2001));
		assertFalse(d.isValidDate((byte)55, (byte)10, (short)2036));
		assertFalse(d.isValidDate((byte)29, (byte)22, (short)2015));
		assertFalse(d.isValidDate((byte)29, (byte)22, (short)900));
		assertFalse(d.isValidDate((byte)29, (byte)22, (short)15000));	
		
	}

}