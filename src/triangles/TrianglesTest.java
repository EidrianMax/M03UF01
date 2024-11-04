/*
 * Triangle0Test.java 31 Oct 2022
 *
 *
 * \u00A9 Copyright 2022 Joan S�culi  
 * Email: jseculi@escoladeltreball.org
 *
 * This is free software, licensed under the GNU General Public License v3.
 * See http://www.gnu.org/licenses/gpl.html for more information.
 */
package triangles;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class TrianglesTest {
	Triangles t = new Triangles();

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
	void isTriangle() {

		assertTrue(t.isTriangle(6, 7, 8));
		assertTrue(t.isTriangle(10.5, 10.5, 7.3));
		assertTrue(t.isTriangle(7.32, 7.32, 7.32));
		assertFalse(t.isTriangle(15, 5, 9));
		
		assertEquals("ESCALEN", t.typeOfTriangle(14.6, 10.2, 6.5));
		assertEquals("ESCALEN", t.typeOfTriangle(5, 4, 3));		
	}
	
	
	@Test
	void typeOfTriangleTest() {

		assertEquals("ESCALEN", t.typeOfTriangle(6, 7, 8));
		assertEquals("ISOSCELES", t.typeOfTriangle(10.5, 10.5, 7.3));
		assertEquals("EQUILATER", t.typeOfTriangle(7.32, 7.32, 7.32));
		assertEquals("ERROR", t.typeOfTriangle(15, 5, 9));
		
		assertEquals("ESCALEN", t.typeOfTriangle(14.6, 10.2, 6.5));
		assertEquals("ESCALEN", t.typeOfTriangle(5, 4, 3));		
	}
	
	@Test
	void perimeterTest() {
		assertEquals(21.0, t.perimeter(6, 7, 8), 0.0001);
		assertEquals(28.3, t.perimeter(10.5, 10.5, 7.3), 0.0001);
		assertEquals(21.96, t.perimeter(7.32, 7.32, 7.32), 0.0001);

		assertEquals(31.3, t.perimeter(14.6, 10.2, 6.5), 0.0001);
		assertEquals(12, t.perimeter(5, 4, 3), 0.0001);
		
		
	}
	
	@Test
	void semiperimeterTest() {
		assertEquals(10.5, t.semiperimeter(6, 7, 8), 0.0001);
		assertEquals(14.15, t.semiperimeter(10.5, 10.5, 7.3), 0.0001);
		assertEquals(10.98, t.semiperimeter(7.32, 7.32, 7.32), 0.0001);
//		assertEquals(0, t.semiperimeter(15, 5, 9), 0.0001);
		assertEquals(15.65, t.semiperimeter(14.6, 10.2, 6.5), 0.0001);
		assertEquals(6, t.semiperimeter(5, 4, 3), 0.0001);
		
		
	}
	
	@Test
	void areaTest() {
		assertEquals(20.3332, t.area(6, 7, 8), 0.0001);
		assertEquals(35.9349, t.area(10.5, 10.5, 7.3), 0.0001);
		assertEquals(23.2019, t.area(7.32, 7.32, 7.32), 0.0001);
//		assertEquals(0, t.area(15, 5, 9), 0.0001);
		assertEquals(28.626, t.area(14.6, 10.2, 6.5), 0.0001);
		assertEquals(6, t.area(5, 4, 3), 0.0001);
		
		
	}
	@Test
	void angleATest() {
		assertEquals(46.5675, t.angleA(6, 7, 8), 0.0001);
		assertEquals(69.6582, t.angleA(10.5, 10.5, 7.3), 0.0001);
		assertEquals(60, t.angleA(7.32, 7.32, 7.32), 0.0001);
//		assertEquals(0, t.angleA(15, 5, 9), 0.0001);
		assertEquals(120.2848, t.angleA(14.6, 10.2, 6.5), 0.0001);
		assertEquals(90, t.angleA(5, 4, 3), 0.0001);
		
		
	}
	@Test
	void angleBTest() {
		assertEquals(57.91, t.angleB(6, 7, 8), 0.0001);
		assertEquals(69.6582, t.angleB(10.5, 10.5, 7.3), 0.0001);
		assertEquals(60, t.angleB(7.32, 7.32, 7.32), 0.0001);
//		assertEquals(0, t.angleB(15, 5, 9), 0.0001);
		assertEquals(37.1057, t.angleB(14.6, 10.2, 6.5), 0.0001);
		assertEquals(53.1301, t.angleB(5, 4, 3), 0.0001);
		
		
	}
	@Test
	void angleCTest() {
		assertEquals(75.5225, t.angleC(6, 7, 8), 0.0001);
		assertEquals(40.6835, t.angleC(10.5, 10.5, 7.3), 0.0001);
		assertEquals(60, t.angleC(7.32, 7.32, 7.32), 0.0001);
//		assertEquals(0, t.angleA(15, 5, 9), 0.0001);
		assertEquals(22.6095, t.angleC(14.6, 10.2, 6.5), 0.0001);
		assertEquals(36.8699, t.angleC(5, 4, 3), 0.0001);
		
		
	}
	
	@Test
	void inradiusTest() {
		assertEquals(1.9365, t.inradius(6, 7, 8), 0.0001);
		assertEquals(2.5396, t.inradius(10.5, 10.5, 7.3), 0.0001);
		assertEquals(2.1131, t.inradius(7.32, 7.32, 7.32), 0.0001);
//		assertEquals(0, t.inradius(15, 5, 9), 0.0001);
		assertEquals(1.8291, t.inradius(14.6, 10.2, 6.5), 0.0001);
		assertEquals(1, t.inradius(5, 4, 3), 0.0001);
		
		
	}
	
	@Test
	void circumradiusTest() {
		assertEquals(4.1312, t.circumradius(6, 7, 8), 0.0001);
		assertEquals(5.5992, t.circumradius(10.5, 10.5, 7.3), 0.0001);
		assertEquals(4.2262, t.circumradius(7.32, 7.32, 7.32), 0.0001);
//		assertEquals(0, t.circumradius(15, 5, 9), 0.0001);
		assertEquals(8.4537, t.circumradius(14.6, 10.2, 6.5), 0.0001);
		assertEquals(2.5, t.circumradius(5, 4, 3), 0.0001);
		
		
	}
	
	//Extra
	@Test
	void heightATest() {
		assertEquals(6.7777, t.heightA(6, 7, 8), 0.0001);
		assertEquals(6.8447, t.heightA(10.5, 10.5, 7.3), 0.0001);
		assertEquals(6.3393, t.heightA(7.32, 7.32, 7.32), 0.0001);
//		assertEquals(0, t.heightA(15, 5, 9), 0.0001);
		assertEquals(3.9214, t.heightA(14.6, 10.2, 6.5), 0.0001);
		assertEquals(2.4, t.heightA(5, 4, 3), 0.0001);
		
		
	}
	@Test
	void heightBTest() {
		assertEquals(5.8095, t.heightB(6, 7, 8), 0.0001);
		assertEquals(6.8447, t.heightB(10.5, 10.5, 7.3), 0.0001);
		assertEquals(6.3393, t.heightB(7.32, 7.32, 7.32), 0.0001);
//		assertEquals(0, t.heightB(15, 5, 9), 0.0001);
		assertEquals(5.6129, t.heightB(14.6, 10.2, 6.5), 0.0001);
		assertEquals(3, t.heightB(5, 4, 3), 0.0001);
	}
	
	@Test
	void heightCTest() {
		assertEquals(5.0833, t.heightC(6, 7, 8), 0.0001);
		assertEquals(9.8452, t.heightC(10.5, 10.5, 7.3), 0.0001);
		assertEquals(6.3393, t.heightC(7.32, 7.32, 7.32), 0.0001);
//		assertEquals(0, t.heightC(15, 5, 9), 0.0001);
		assertEquals(8.808, t.heightC(14.6, 10.2, 6.5), 0.0001);
		assertEquals(4, t.heightC(5, 4, 3), 0.0001);
	}
	@Test
	void typeAngleTest() {
		assertEquals("ACUTE", t.typeOfTriangleByAngles(6, 7, 8));
		assertEquals("ACUTE", t.typeOfTriangleByAngles(10.5, 10.5, 7.3));
		assertEquals("ACUTE", t.typeOfTriangleByAngles(7.32, 7.32, 7.32));
//		assertEquals(0, t.typeOfTriangleByAngles(15, 5, 9));
		assertEquals("OBTUSE", t.typeOfTriangleByAngles(14.6, 10.2, 6.5));
		assertEquals("RIGHT", t.typeOfTriangleByAngles(5, 4, 3));
	}
	@Test
	void medianATest() {
		assertEquals(6.892, t.medianA(6, 7, 8), 0.0001);
		assertEquals(7.3626, t.medianA(10.5, 10.5, 7.3), 0.0001);
		assertEquals(6.3393, t.medianA(7.32, 7.32, 7.32), 0.0001);
//		assertEquals(0, t.medianA(15, 5, 9), 0.0001);
		assertEquals(4.4559, t.medianA(14.6, 10.2, 6.5), 0.0001);
		assertEquals(2.5, t.medianA(5, 4, 3), 0.0001);
	}
	
	@Test
	void medianBTest() {
		assertEquals(6.1441, t.medianB(6, 7, 8), 0.0001);
		assertEquals(7.3626, t.medianB(10.5, 10.5, 7.3), 0.0001);
		assertEquals(6.3393, t.medianB(7.32, 7.32, 7.32), 0.0001);
//		assertEquals(0, t.medianB(15, 5, 9), 0.0001);
		assertEquals(10.0844, t.medianB(14.6, 10.2, 6.5), 0.0001);
		assertEquals(3.6056, t.medianB(5, 4, 3), 0.0001);
	}	@Test
	void medianCTest() {
		assertEquals(5.1478, t.medianC(6, 7, 8), 0.0001);
		assertEquals(9.8452, t.medianC(10.5, 10.5, 7.3), 0.0001);
		assertEquals(6.3393, t.medianC(7.32, 7.32, 7.32), 0.0001);
//		assertEquals(0, t.medianC(15, 5, 9), 0.0001);
		assertEquals(12.1671, t.medianC(14.6, 10.2, 6.5), 0.0001);
		assertEquals(4.272, t.medianC(5, 4, 3), 0.0001);
	}
}