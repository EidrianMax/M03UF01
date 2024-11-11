/*
* SlotMachineTest.java
*
* This is free software; you can redistribute it and/or
* modify it under the terms of the GNU Lesser General Public
* License as published by the Free Software Foundation v3.
*
* @see <a href="http://www.gnu.org/licenses/gpl.html">GNU License</a> for more information.
*
* Copyright (c) Joan Sèculi <a href="mailto:jseculi@escoladeltreball.org">Joan Sèculi</a>
*/
package slotMachine;

import static org.junit.jupiter.api.Assertions.*;

import java.math.BigDecimal;
import java.math.RoundingMode;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

/**
* Enter a description
*
* @author  <a href="mailto:jseculi@escoladeltreball.org">Joan Sèculi</a>
* @version 1.0
* @since   28/11/2021  
* 
*
* This is free software; you can redistribute it and/or
* modify it under the terms of the GNU Lesser General Public
* License as published by the Free Software Foundation v3.
*
* @see <a href="http://www.gnu.org/licenses/gpl.html">GNU License</a>
*
*
*/
class SlotMachineTest {

	static byte B1 = 1;
	static byte B2 = 2;
	static byte B3 = 3;
	static byte B4 = 4;
	static byte B5 = 5;
	static byte B6 = 6;
	
	/**
	 * @throws java.lang.Exception
	 */
	@BeforeAll
	static void setUpBeforeClass() throws Exception {
		
	}

	/**
	 * @throws java.lang.Exception
	 */
	@AfterAll
	static void tearDownAfterClass() throws Exception {
	}

	/**
	 * @throws java.lang.Exception
	 */
	@BeforeEach
	void setUp() throws Exception {
	}

	/**
	 * @throws java.lang.Exception
	 */
	@AfterEach
	void tearDown() throws Exception {
	}

//	@Test
//	void oneStartTest() {
//		
//		assertTrue(SlotMachine3.isOneStar(6, 2, 1));
//		assertTrue(SlotMachine3.isOneStar(1, 6, 1));
//		assertTrue(SlotMachine3.isOneStar(1, 1, 6));
//		assertTrue(SlotMachine3.isOneStar(6, 1, 3));
//		assertTrue(SlotMachine3.isOneStar(3, 6, 2));
//		assertTrue(SlotMachine3.isOneStar(3, 4, 6));
//		
//		assertFalse(SlotMachine3.isOneStar(6, 6, 2));
//		assertFalse(SlotMachine3.isOneStar(3, 6, 6));
//		assertFalse(SlotMachine3.isOneStar(6, 4, 6));
//		assertFalse(SlotMachine3.isOneStar(6, 6, 6));
//		assertFalse(SlotMachine3.isOneStar(1, 3, 2));
//		
//	}
	
	@Test
	void twoFruitsTest() {
		//x x y
		//y x x
		//x y x
		
		assertTrue(SlotMachine.isTwoFruits(B1, B1, B2)); //x x y
		assertTrue(SlotMachine.isTwoFruits(B2, B2, B1)); //x y x
		assertTrue(SlotMachine.isTwoFruits(B3, B3, B4));
		assertTrue(SlotMachine.isTwoFruits(B4, B4, B1));
		assertTrue(SlotMachine.isTwoFruits(B5, B5, B1));
		assertTrue(SlotMachine.isTwoFruits(B3, B4, B4)); //y x x
		assertTrue(SlotMachine.isTwoFruits(B3, B4, B3));
		
		assertFalse(SlotMachine.isTwoFruits(B1, B6, B6)); //x * *
		assertFalse(SlotMachine.isTwoFruits(B6, B6, B2)); //* * x
		assertFalse(SlotMachine.isTwoFruits(B6, B4, B6)); //* x *
		
		assertFalse(SlotMachine.isTwoFruits(B6, B6, B6)); //* * *
		assertFalse(SlotMachine.isTwoFruits(B1, B3, B2)); //x y z
		
		assertFalse(SlotMachine.isTwoFruits(B1, B1, B6)); //x x *
		assertFalse(SlotMachine.isTwoFruits(B1, B6, B1)); //x * x
		assertFalse(SlotMachine.isTwoFruits(B6, B1, B1)); //* x x
		
		
	}
	@Test
	void threeFruitsTest() {
		//x x x
		assertTrue(SlotMachine.isThreeFruits(B1, B1, B1)); //x x x
		assertTrue(SlotMachine.isThreeFruits(B2, B2, B2)); //x x x
		assertTrue(SlotMachine.isThreeFruits(B3, B3, B3)); //x x x
		assertTrue(SlotMachine.isThreeFruits(B4, B4, B4)); //x x x
		assertTrue(SlotMachine.isThreeFruits(B5, B5, B5)); //x x x
		
		assertFalse(SlotMachine.isThreeFruits(B1, B6, B6)); //* * *
		assertFalse(SlotMachine.isThreeFruits(B6, B6, B6)); //* * *
		assertFalse(SlotMachine.isThreeFruits(B3, B6, B6)); //x * *
		assertFalse(SlotMachine.isThreeFruits(B6, B4, B6)); //* x *
		assertFalse(SlotMachine.isThreeFruits(B6, B6, B2)); //* * x
		
		assertFalse(SlotMachine.isThreeFruits(B1, B3, B2)); //x y z
		
		assertFalse(SlotMachine.isThreeFruits(B1, B1, B2)); //x x y
		assertFalse(SlotMachine.isThreeFruits(B1, B3, B1)); //x y x
		assertFalse(SlotMachine.isThreeFruits(B1, B3, B3)); //y x x
		
		
	}
	@Test
	void twoStarsTest() {
		
		assertTrue(SlotMachine.isTwoStars(B6, B6, B1));
		assertTrue(SlotMachine.isTwoStars(B2, B6, B6));
		assertTrue(SlotMachine.isTwoStars(B6, B6, B3));
		assertTrue(SlotMachine.isTwoStars(B6, B4, B6));
		assertTrue(SlotMachine.isTwoStars(B5, B6, B6));
		
		assertFalse(SlotMachine.isTwoStars(B6, B1, B2));
		assertFalse(SlotMachine.isTwoStars(B3, B6, B5));
		assertFalse(SlotMachine.isTwoStars(B1, B4, B6));
		assertFalse(SlotMachine.isTwoStars(B6, B6, B6));
		assertFalse(SlotMachine.isTwoStars(B1, B3, B2));
		
		
		
	}
	@Test
	void threeStarsTest() {
		//* * * 
		assertTrue(SlotMachine.isThreeStars(B6, B6, B6)); //* * *

		assertFalse(SlotMachine.isThreeStars(B1, B1, B1)); //x x x
		assertFalse(SlotMachine.isThreeStars(B3, B3, B3)); //x x x
		
		assertFalse(SlotMachine.isThreeStars(B6, B4, B4)); //* x x
		assertFalse(SlotMachine.isThreeStars(B4, B6, B4)); //x * x
		assertFalse(SlotMachine.isThreeStars(B4, B4, B6)); //x x *
		
		assertFalse(SlotMachine.isThreeStars(B6, B2, B6)); //* x *
		assertFalse(SlotMachine.isThreeStars(B6, B6, B2)); //* * x
		assertFalse(SlotMachine.isThreeStars(B2, B6, B6)); //x * *
		
	}
	
	@Test
	void twoFruitsOneStarsTest() {
		//x x *
		//* x x
		//x * x
		assertTrue(SlotMachine.isTwoFruitsOneStar(B1, B1, B6)); //x x *

		assertTrue(SlotMachine.isTwoFruitsOneStar(B2, B6, B2)); //x * x
		assertTrue(SlotMachine.isTwoFruitsOneStar(B6, B3, B3)); //* x x
		assertTrue(SlotMachine.isTwoFruitsOneStar(B3, B3, B6)); 
		assertTrue(SlotMachine.isTwoFruitsOneStar(B5, B6, B5)); 
		
		assertFalse(SlotMachine.isTwoFruitsOneStar(B6, B6, B2)); //* * x
		assertFalse(SlotMachine.isTwoFruitsOneStar(B3, B6, B6)); //x * *
		assertFalse(SlotMachine.isTwoFruitsOneStar(B6, B2, B6)); //* x *

		assertFalse(SlotMachine.isTwoFruitsOneStar(B6, B6, B6)); //* * *
		assertFalse(SlotMachine.isTwoFruitsOneStar(B1, B2, B3)); //x y z
		
		assertFalse(SlotMachine.isTwoFruitsOneStar(B5, B6, B2)); //x * y
		assertFalse(SlotMachine.isTwoFruitsOneStar(B6, B1, B2)); //* x y
		assertFalse(SlotMachine.isTwoFruitsOneStar(B5, B4, B6)); //x y *
		
	}
	
	@Test
	void figureTest() {
		assertEquals("STRAWBERRY", SlotMachine.figure((byte)1));
		assertEquals("BANANA", SlotMachine.figure((byte)2));
		assertEquals("APPLE", SlotMachine.figure((byte)3));
		assertEquals("LEMON", SlotMachine.figure((byte)4));
		assertEquals("WATERMELON", SlotMachine.figure((byte)5));
		assertEquals("STAR", SlotMachine.figure((byte)6));
		assertEquals("ERROR", SlotMachine.figure((byte)7));
		assertEquals("ERROR", SlotMachine.figure((byte)0));
		
	}
	
	@Test
	void randomFruitTest() {
		int count1 = 0;
		int count2 = 0;
		int count3 = 0;
		int count4 = 0;
		int count5 = 0;
		int count6 = 0;
		
		int max = 10000000;
		for (int i = 0; i< max; i++) {
			if(SlotMachine.randomFruit()==1) count1++;
			if(SlotMachine.randomFruit()==2) count2++;
			if(SlotMachine.randomFruit()==3) count3++;
			if(SlotMachine.randomFruit()==4) count4++;
			if(SlotMachine.randomFruit()==5) count5++;
			if(SlotMachine.randomFruit()==6) count6++;
		}
		double total1 = (double)count1 / max;
		double total2 = (double)count2 / max;
		double total3 = (double)count3 / max;
		double total4 = (double)count4 / max;
		double total5 = (double)count5 / max;
		double total6 = (double)count6 / max;
		
//		System.out.println("1: " + total1);
//		System.out.println("2: " + total2);
//		System.out.println("3: " + total3);
//		System.out.println("4: " + total4);
//		System.out.println("5: " + total5);
//		System.out.println("6: " + total6);
		
		assertEquals(total1, 0.1817, 0.001);
		assertEquals(total2, 0.1817, 0.001);
		assertEquals(total3, 0.1817, 0.001);
		assertEquals(total4, 0.1817, 0.001);
		assertEquals(total5, 0.1817, 0.001);
		assertEquals(total6, 0.0909, 0.001);
		
	}
	
	@Test
	void priceTest() {
		assertEquals(10, SlotMachine.prize(10, "TWO FRUITS"));
		assertEquals(30, SlotMachine.prize(10, "TWO FRUITS ONE STAR"));
		assertEquals(40, SlotMachine.prize(10, "TWO STARS"));
		assertEquals(50, SlotMachine.prize(10, "THREE FRUITS"));
		assertEquals(110, SlotMachine.prize(10, "THREE STARS"));
		assertEquals(0, SlotMachine.prize(10, "OTHER"));
		
	}
	
	@Test
	void resultTest() {
		//Not necessary
	}
}