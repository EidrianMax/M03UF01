/*
* GuessNumberTest.java 19 Oct 2024
*
*
* © Copyright 2024 Joan Sèculi <jseculi@escoladeltreball.org>
*
* This is free software, licensed under the GNU General Public License v3.
* See http://www.gnu.org/licenses/gpl.html for more information.
*/
package guessNumber;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class GuessNumberTest {

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
	void test() {
		assertEquals(0, GuessNumber.guessNumber((byte)10, (byte)10));
		assertEquals(0, GuessNumber.guessNumber((byte)100, (byte)100));
		assertEquals(1, GuessNumber.guessNumber((byte)10, (byte)1));
		assertEquals(1, GuessNumber.guessNumber((byte)118, (byte)100));
		assertEquals(-1, GuessNumber.guessNumber((byte)10, (byte)100));
		assertEquals(-1, GuessNumber.guessNumber((byte)3, (byte)120));

	}

}