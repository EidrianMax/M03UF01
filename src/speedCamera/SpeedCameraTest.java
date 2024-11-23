/*
 * RadarTest.java 18 Nov 2023
 *
 *
 * © Copyright 2023 Joan Sèculi
 * Email: jseculi@escoladeltreball.org
 *
 * This is free software, licensed under the GNU General Public License v3.
 * See http://www.gnu.org/licenses/gpl.html for more information.
 */
package speedCamera;

import static org.junit.jupiter.api.Assertions.*;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
class SpeedCameraTest {

	static SpeedCamera sc;
	@BeforeAll
	static void setUpBeforeClass() throws Exception {
		sc = new SpeedCamera();
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

	/*
	 * 9165 110 300
9165 110 299
12000 100 433
12000 100 431
12000 100 359
-1000 -50 -100
0 0 0

OK
MULTA
OK
MULTA
PUNTOS
ERROR
*/

	
	 
	@Test
	@Order(1)
	void test1() {
		assertEquals(sc.speed(12000, 433), 99);
		assertFalse(sc.isFine(12000, 433, (byte) 100));
		assertEquals(sc.fine(12000, 433, (byte) 100), 0);
		assertEquals(sc.points(12000, 433, (byte) 100), 0);
	}
	 
	@Test
	@Order(2)
	void test2() {
		assertEquals(sc.speed(12000, 431), 100);
		assertFalse(sc.isFine(12000, 431, (byte) 100));
		assertEquals(sc.fine(12000, 431, (byte) 100), 0);
		assertEquals(sc.points(12000, 431, (byte) 100), 0);
	}
	
	@Test
	@Order(3)
	void test3() {
		assertEquals(sc.speed(12000, 380), 113);
		assertTrue(sc.isFine(12000, 380, (byte) 100));
		assertEquals(sc.fine(12000, 380, (byte) 100), 100);
		assertEquals(sc.points(12000, 380, (byte) 100), 0);
	}
	 	
	@Test
	@Order(4)
	void test4() {
		assertEquals(sc.speed(12000, 330), 130);
		assertTrue(sc.isFine(12000, 330, (byte) 100));
		assertEquals(sc.fine(12000, 330, (byte) 100), 100);
		assertEquals(sc.points(12000, 330, (byte) 100), 0);
	}
	
	@Test
	@Order(5)
	void test5() {
		assertEquals(sc.speed(12000, 285), 151);
		assertTrue(sc.isFine(12000, 285, (byte) 100));
		assertEquals(sc.fine(12000, 285, (byte) 100), 400);
		assertEquals(sc.points(12000, 285, (byte) 100), 4);
	}
	
	@Test
	@Order(6)
	void test6() {
		assertEquals(sc.speed(12000, 265), 163);
		assertTrue(sc.isFine(12000, 265, (byte) 100));
		assertEquals(sc.fine(12000, 265, (byte) 100), 500);
		assertEquals(sc.points(12000, 265, (byte) 100), 6);
	}
	
	@Test
	@Order(7)
	void test7() {
		assertEquals(sc.speed(12000, 225), 192);
		assertTrue(sc.isFine(12000, 225, (byte) 100));
		assertEquals(sc.fine(12000, 225, (byte) 100), 600);
		assertEquals(sc.points(12000, 225, (byte) 100), 6);
	}
	
	
	@Test
	@Order(8) 
	void test8() {
		assertEquals(sc.speed(9165, 300), 109);
		assertFalse(sc.isFine(9165, 300, (byte)110));
		assertEquals(sc.fine(9165, 300, (byte)110), 0);
		assertEquals(sc.points(9165, 300, (byte)110), 0);
	}
	
	@Test
	@Order(9) 
	void test9() {
		assertEquals(sc.speed(9165, 299), 110);
		assertFalse(sc.isFine(9165, 299, (byte)110));
		assertEquals(sc.fine(9165, 299, (byte)110), 0);
		assertEquals(sc.points(9165, 299, (byte)110), 0);
		
	}

	
	@Test
	@Order(10) 
	void test10() {
		assertEquals(sc.speed(9165, 255), 129);
		assertTrue(sc.isFine(9165, 255, (byte)110));
		assertEquals(sc.fine(9165, 255, (byte)110), 100);
		assertEquals(sc.points(9165, 255, (byte)110), 0);
		
	}
	
	@Test
	@Order(11) 
	void test11() {
		assertEquals(sc.speed(9165, 235), 140);
		assertTrue(sc.isFine(9165, 235, (byte)110));
		assertEquals(sc.fine(9165, 235, (byte)110), 100);
		assertEquals(sc.points(9165, 235, (byte)110), 0);
		
	}
	
	@Test
	@Order(12) 
	void test12() {
		assertEquals(sc.speed(9165, 200), 164);
		assertTrue(sc.isFine(9165, 200, (byte)110));
		assertEquals(sc.fine(9165, 200, (byte)110), 400);
		assertEquals(sc.points(9165, 200, (byte)110), 4);
		
	}
	
	@Test
	@Order(13) 
	void test13() {
		assertEquals(sc.speed(9165, 190), 173);
		assertTrue(sc.isFine(9165, 190, (byte)110));
		assertEquals(sc.fine(9165, 190, (byte)110), 500);
		assertEquals(sc.points(9165, 190, (byte)110), 6);
		
	}
	
	@Test
	@Order(14) 
	void test14() {
		assertEquals(sc.speed(9165, 180), 183);
		assertTrue(sc.isFine(9165, 180, (byte)110));
		assertEquals(sc.fine(9165, 180, (byte)110), 600);
		assertEquals(sc.points(9165, 180, (byte)110), 6);
		
	}
	
	@Test
	@Order(15)
	void test15() {
		assertEquals(sc.speed(2000, 65), 110);
		assertFalse(sc.isFine(2000, 65, (byte) 120));
		assertEquals(sc.fine(2000, 65, (byte) 120), 0);
		assertEquals(sc.points(2000, 65, (byte) 120), 0);
	}
	
	@Test
	@Order(16)
	void test16() {
		assertEquals(sc.speed(2000, 55), 130);
		assertTrue(sc.isFine(2000, 55, (byte) 120));
		assertEquals(sc.fine(2000, 55, (byte) 120), 100);
		assertEquals(sc.points(2000, 55, (byte) 120), 0);
	}
	
	@Test
	@Order(17)
	void test17() {
		assertEquals(sc.speed(2000, 45), 160);
		assertTrue(sc.isFine(2000, 45, (byte) 120));
		assertEquals(sc.fine(2000, 45, (byte) 120), 300);
		assertEquals(sc.points(2000, 45, (byte) 120), 2);
	}
	
	@Test
	@Order(18)
	void test18() {
		assertEquals(sc.speed(2000, 42), 171);
		assertTrue(sc.isFine(2000, 42, (byte) 120));
		assertEquals(sc.fine(2000, 42, (byte) 120), 400);
		assertEquals(sc.points(2000, 42, (byte) 120), 4);
	}
	
	@Test
	@Order(19)
	void test19() {
		assertEquals(sc.speed(2000, 38), 189);
		assertTrue(sc.isFine(2000, 38, (byte) 120));
		assertEquals(sc.fine(2000, 38, (byte) 120), 500);
		assertEquals(sc.points(2000, 38, (byte) 120), 6);
	}
	
	@Test
	@Order(20)
	void test20() {
		assertEquals(sc.speed(2000, 35), 205);
		assertTrue(sc.isFine(2000, 35, (byte) 120));
		assertEquals(sc.fine(2000, 35, (byte) 120), 600);
		assertEquals(sc.points(2000, 35, (byte) 120), 6);
	}
	

	@Test
	@Order(21)
	void test21() {
		assertEquals(sc.speed(1500, 44), 122);
		assertTrue(sc.isFine(1500, 44, (byte) 120));
		assertEquals(sc.fine(1500, 44, (byte) 120), 100);
		assertEquals(sc.points(1500, 44, (byte) 120), 0);
	}
	
	@Test
	@Order(22)
	void test22() {
		assertEquals(sc.speed(1500, 30), 180);
		assertTrue(sc.isFine(1500, 30, (byte) 110));
		assertEquals(sc.fine(1500, 30, (byte) 110), 500);
		assertEquals(sc.points(1500, 30, (byte) 110), 6);
	}

	@Test
	@Order(23)
	void test23() {
		assertEquals(sc.speed(1500, 55), 98);
		assertTrue(sc.isFine(1500, 55, (byte) 90));
		assertEquals(sc.fine(1500, 55, (byte) 90), 100);
		assertEquals(sc.points(1500, 55, (byte) 90), 0);
	}
	
	@Test
	@Order(24)
	void test24() {
		assertEquals(sc.speed(1500, 45), 120);
		assertTrue(sc.isFine(1500, 45, (byte) 90));
		assertEquals(sc.fine(1500, 45, (byte) 90), 100);
		assertEquals(sc.points(1500, 45, (byte) 90), 0);
	}
	
	@Test
	@Order(25)
	void test25() {
		assertEquals(sc.speed(1500, 44), 122);
		assertTrue(sc.isFine(1500, 44, (byte) 90));
		assertEquals(sc.fine(1500, 44, (byte) 90), 300);
		assertEquals(sc.points(1500, 44, (byte) 90), 2);
	}
	
	@Test
	@Order(26)
	void test26() {
		assertEquals(sc.speed(1500, 36), 150);
		assertTrue(sc.isFine(1500, 36, (byte) 90));
		assertEquals(sc.fine(1500, 36, (byte) 90), 400);
		assertEquals(sc.points(1500, 36, (byte) 90), 4);
	}
	
	@Test
	@Order(27)
	void test27() {
		assertEquals(sc.speed(1500, 35), 154);
		assertTrue(sc.isFine(1500, 35, (byte) 90));
		assertEquals(sc.fine(1500, 35, (byte) 90), 500);
		assertEquals(sc.points(1500, 35, (byte) 90), 6);
	}
	
	@Test
	@Order(28)
	void test28() {
		assertEquals(sc.speed(1500, 30), 180);
		assertTrue(sc.isFine(1500, 30, (byte) 90));
		assertEquals(sc.fine(1500, 30, (byte) 90), 600);
		assertEquals(sc.points(1500, 30, (byte) 90), 6);
	}
	
	
	
	@Test
	@Order(29)
	void test29() {
		assertEquals(sc.speed(1500, 50), 108);
		assertTrue(sc.isFine(1500, 50, (byte) 80));
		assertEquals(sc.fine(1500, 50, (byte) 80), 100);
		assertEquals(sc.points(1500, 50, (byte) 80), 0);
	}
	
	@Test
	@Order(30)
	void test30() {
		assertEquals(sc.speed(1500, 45), 120);
		assertTrue(sc.isFine(1500, 45, (byte) 80));
		assertEquals(sc.fine(1500, 45, (byte) 80), 300);
		assertEquals(sc.points(1500, 45, (byte) 80), 2);
	}
	
	@Test
	@Order(31)
	void test31() {
		assertEquals(sc.speed(1500, 40), 135);
		assertTrue(sc.isFine(1500, 40, (byte) 80));
		assertEquals(sc.fine(1500, 40, (byte) 80), 400);
		assertEquals(sc.points(1500, 40, (byte) 80), 4);
	}
	

	@Test
	@Order(32)
	void test32() {
		assertEquals(sc.speed(1500, 38), 142);
		assertTrue(sc.isFine(1500, 38, (byte) 80));
		assertEquals(sc.fine(1500, 38, (byte) 80), 500);
		assertEquals(sc.points(1500, 38, (byte) 80), 6);
	}
	
	@Test
	@Order(33)
	void test33() {
		assertEquals(sc.speed(1500, 35), 154);
		assertTrue(sc.isFine(1500, 35, (byte) 80));
		assertEquals(sc.fine(1500, 35, (byte) 80), 600);
		assertEquals(sc.points(1500, 35, (byte) 80), 6);
	}
	
	@Test
	@Order(34)
	void test34() {
		assertEquals(sc.speed(1500, 80), 67);
		assertFalse(sc.isFine(1500, 80, (byte) 70));
		assertEquals(sc.fine(1500, 80, (byte) 70), 0);
		assertEquals(sc.points(1500, 80, (byte) 70), 0);
	}
	
	
	@Test
	@Order(35)
	void test35() {
		assertEquals(sc.speed(1500, 60), 90);
		assertTrue(sc.isFine(1500, 60, (byte) 70));
		assertEquals(sc.fine(1500, 60, (byte) 70), 100);
		assertEquals(sc.points(1500, 60, (byte) 70), 0);
	}
	
	@Test
	@Order(36)
	void test36() {
		assertEquals(sc.speed(1500, 50), 108);
		assertTrue(sc.isFine(1500, 50, (byte) 70));
		assertEquals(sc.fine(1500, 50, (byte) 70), 300);
		assertEquals(sc.points(1500, 50, (byte) 70), 2);
	}
	
	@Test
	@Order(37)
	void test37() {
		assertEquals(sc.speed(1500, 44), 122);
		assertTrue(sc.isFine(1500, 44, (byte) 70));
		assertEquals(sc.fine(1500, 44, (byte) 70), 400);
		assertEquals(sc.points(1500, 44, (byte) 70), 4);
	}
	
	@Test
	@Order(38)
	void test38() {
		assertEquals(sc.speed(1500, 40), 135);
		assertTrue(sc.isFine(1500, 40, (byte) 70));
		assertEquals(sc.fine(1500, 40, (byte) 70), 500);
		assertEquals(sc.points(1500, 40, (byte) 70), 6);
	}
	
	
	@Test
	@Order(39)
	void test39() {
		assertEquals(sc.speed(1500, 90), 60);
		assertFalse(sc.isFine(1500, 90, (byte) 60));
		assertEquals(sc.fine(1500, 90, (byte) 60), 0);
		assertEquals(sc.points(1500, 90, (byte) 60), 0);
	}
	
	@Test
	@Order(40)
	void test40() {
		assertEquals(sc.speed(1500, 80), 67);
		assertTrue(sc.isFine(1500, 80, (byte) 60));
		assertEquals(sc.fine(1500, 80, (byte) 60), 100);
		assertEquals(sc.points(1500, 80, (byte) 60), 0);
	}
	
	@Test
	@Order(41)
	void test41() {
		assertEquals(sc.speed(1500, 70), 77);
		assertTrue(sc.isFine(1500, 70, (byte) 60));
		assertEquals(sc.fine(1500, 70, (byte) 60), 100);
		assertEquals(sc.points(1500, 70, (byte) 60), 0);
	}
	
	@Test
	@Order(42)
	void test42() {
		assertEquals(sc.speed(1500, 60), 90);
		assertTrue(sc.isFine(1500, 60, (byte) 60));
		assertEquals(sc.fine(1500, 60, (byte) 60), 100);
		assertEquals(sc.points(1500, 60, (byte) 60), 0);
	}
	
	@Test
	@Order(43)
	void test43() {
		assertEquals(sc.speed(1500, 50), 108);
		assertTrue(sc.isFine(1500, 50, (byte) 60));
		assertEquals(sc.fine(1500, 50, (byte) 60), 300);
		assertEquals(sc.points(1500, 50, (byte) 60), 2);
	}
	
	@Test
	@Order(44)
	void test44() {
		assertEquals(sc.speed(1500, 45), 120);
		assertTrue(sc.isFine(1500, 45, (byte) 60));
		assertEquals(sc.fine(1500, 45, (byte) 60), 400);
		assertEquals(sc.points(1500, 45, (byte) 60), 4);
	}
	
	@Test
	@Order(46)
	void test46() {
		assertEquals(sc.speed(1500, 40), 135);
		assertTrue(sc.isFine(1500, 40, (byte) 60));
		assertEquals(sc.fine(1500, 40, (byte) 60), 600);
		assertEquals(sc.points(1500, 40, (byte) 60), 6);
	}
	
	@Test
    @Order(50)
	public void testTernaryOperator() throws IOException {
		// Path to the AverageUK.java file (replace this with the actual path to the
		// file)
		String filePath = "src/speedCamera/SpeedCamera.java";

		// Read the source file content
		String sourceCode = new String(Files.readAllBytes(Paths.get(filePath)));

		// Remove comments from the source code (both single-line and multi-line
		// comments)
		String cleanedSourceCode = removeComments(sourceCode);

		
		// Count occurrences of ?
		long finalTernary1 = cleanedSourceCode.lines().filter(line -> line.contains("?")).count();


        
		// Assert that only one float is declared
		assertTrue(finalTernary1 >= 1, "There should an operator ternary.");
	
		// Restaurar entrada i sortida estàndard
     	System.setIn(System.in);
    }
	
	 // Helper method to remove comments from the source code
    private String removeComments(String code) {
        // Remove multi-line comments (including those spanning multiple lines)
        code = code.replaceAll("/\\*[^*]*(?:\\*(?!/)[^*]*)*\\*/", "");
        // Remove single-line comments (//...)
        code = code.replaceAll("//.*", "");
        return code;
    }
	
}