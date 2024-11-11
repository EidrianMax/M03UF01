/*
 * SevenHalfGameTest.java 23 Nov 2022
 *
 *
 * \u00A9 Copyright 2022 Joan S�culi  
 * Email: jseculi@escoladeltreball.org
 *
 * This is free software, licensed under the GNU General Public License v3.
 * See http://www.gnu.org/licenses/gpl.html for more information.
 */
package sevenHalfGame;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class SevenHalfGameTest {
	SevenHalfGame sh = new SevenHalfGame();

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
	void valueTest() {
		assertEquals(sh.value((byte)1), 1);
		assertEquals(sh.value((byte)2), 2);
		assertEquals(sh.value((byte)3), 3);
		assertEquals(sh.value((byte)4), 4);
		assertEquals(sh.value((byte)5), 5);
		assertEquals(sh.value((byte)6), 6);
		assertEquals(sh.value((byte)7), 7);
		assertEquals(sh.value((byte)8), 0.5f);
		assertEquals(sh.value((byte)9), 0.5f);
		assertEquals(sh.value((byte)10), 0.5f);
		assertEquals(sh.value((byte)11), 0.5f);
		assertEquals(sh.value((byte)12), 0.5f);

		assertEquals(sh.value((byte)13), 1);
		assertEquals(sh.value((byte)14), 2);
		assertEquals(sh.value((byte)15), 3);
		assertEquals(sh.value((byte)16), 4);
		assertEquals(sh.value((byte)17), 5);
		assertEquals(sh.value((byte)18), 6);
		assertEquals(sh.value((byte)19), 7);
		assertEquals(sh.value((byte)20), 0.5f);
		assertEquals(sh.value((byte)21), 0.5f);
		assertEquals(sh.value((byte)22), 0.5f);
		assertEquals(sh.value((byte)23), 0.5f);
		assertEquals(sh.value((byte)24), 0.5f);
		
		assertEquals(sh.value((byte)25), 1);
		assertEquals(sh.value((byte)26), 2);
		assertEquals(sh.value((byte)27), 3);
		assertEquals(sh.value((byte)28), 4);
		assertEquals(sh.value((byte)29), 5);
		assertEquals(sh.value((byte)30), 6);
		assertEquals(sh.value((byte)31), 7);
		assertEquals(sh.value((byte)32), 0.5f);
		assertEquals(sh.value((byte)33), 0.5f);
		assertEquals(sh.value((byte)34), 0.5f);
		assertEquals(sh.value((byte)35), 0.5f);
		assertEquals(sh.value((byte)36), 0.5f);
		
		assertEquals(sh.value((byte)37), 1);
		assertEquals(sh.value((byte)38), 2);
		assertEquals(sh.value((byte)39), 3);
		assertEquals(sh.value((byte)40), 4);
		assertEquals(sh.value((byte)41), 5);
		assertEquals(sh.value((byte)42), 6);
		assertEquals(sh.value((byte)43), 7);
		assertEquals(sh.value((byte)44), 0.5f);
		assertEquals(sh.value((byte)45), 0.5f);
		assertEquals(sh.value((byte)46), 0.5f);
		assertEquals(sh.value((byte)47), 0.5f);
		assertEquals(sh.value((byte)48), 0.5f);

	}
	@Test
	void winnerBank() {
		
		assertEquals("Bank", sh.winner(8, 7.5f));
		assertEquals("Bank", sh.winner(7.5f, 7.5f));
		assertEquals("Bank", sh.winner(7, 7.5f));
		assertEquals("Bank", sh.winner(6.5f, 7.5f));
		assertEquals("Bank", sh.winner(5.5f, 5.5f));
		assertEquals("Bank", sh.winner(3.5f, 3.5f));
		assertEquals("Bank", sh.winner(5.5f, 6.5f));
		assertEquals("Bank", sh.winner(2.5f, 2.5f));
		assertEquals("Bank", sh.winner(2.5f, 3f));
		assertEquals("Bank", sh.winner(0, 0f));
	}
	
	@Test
	void winnerPlayer() {
		
		assertEquals("Player", sh.winner(7, 6.5f));
		assertEquals("Player", sh.winner(7f, 5.5f));
		assertEquals("Player", sh.winner(6.5f, 5f));
		assertEquals("Player", sh.winner(6.5f, 4.5f));
		assertEquals("Player", sh.winner(6f, 5.5f));
		assertEquals("Player", sh.winner(3.5f, 2.5f));
		assertEquals("Player", sh.winner(5.5f, 4.5f));
		assertEquals("Player", sh.winner(5.5f, 3.5f));
		assertEquals("Player", sh.winner(5.5f, 3f));
		assertEquals("Player", sh.winner(1, 0f));
		
	}
}
