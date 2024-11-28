/*
 * ChessKnightTest.java 11 Jan 2024
 *
 *
 * \u00A9 Copyright 2024 Joan Sèculi
 * Email: jseculi@escoladeltreball.org
 *
 * This is free software, licensed under the GNU General Public License v3.
 * See http://www.gnu.org/licenses/gpl.html for more information.
 */
package chess;

import static org.junit.jupiter.api.Assertions.*;

import java.util.Arrays;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
class ChessKnightTest {

	static ChessKnight ck;
	static final byte SIZE = 8;
	static final String HORSE_B = "HB";
	
	static final String EMPTY = "--";
	
	static String[][] board;
	
	@BeforeAll
	static void setUpBeforeClass() throws Exception {
		ck = new ChessKnight();
		
		board = new String[SIZE][SIZE];
		
		for (byte i = 0; i < board.length; i++) {
			for (byte j = 0; j < board[i].length; j++) {
				board[i][j] = "--";
				
			}
			
		}
	}

	@AfterAll
	static void tearDownAfterClass() throws Exception {
	}

	@BeforeEach
	void setUp() throws Exception {
		for (byte i = 0; i < board.length; i++) {
			for (byte j = 0; j < board[i].length; j++) {
				board[i][j] = "--";
				
			}
			
		}
	}

	@AfterEach
	void tearDown() throws Exception {
	}

	@Test
	void testShowMovementsHorse() {
		
	}

	@Test
	@Order(1) 
	void testPlacePiece() {
		
		for (int i = 0; i < 10000; i++) {
			byte[] piece = ck.placePiece(board, "HORSE_B");
			
			if (piece[0] < 0 || piece[0] > SIZE - 1 
					 || piece[1] < 0 || piece[1] > SIZE - 1) {
				System.out.println(Arrays.toString(piece));
			}
			assertTrue(	piece[0] >= 0 && piece[0] <= SIZE  - 1
					 && piece[1] >= 0 && piece[1] <= SIZE - 1);
		}
	}

	@Test
	@Order(2) 
	void testShowBoard() {
		String text = "   0   1   2   3   4   5   6   7\n"
				+ "0: --  --  --  --  --  --  --  --  \n"
				+ "1: --  --  --  --  --  --  --  --  \n"
				+ "2: --  --  --  --  --  --  --  --  \n"
				+ "3: --  --  --  --  --  --  --  --  \n"
				+ "4: --  --  --  --  --  --  --  --  \n"
				+ "5: --  --  --  HB  --  --  --  --  \n"
				+ "6: --  --  --  --  --  --  --  --  \n"
				+ "7: --  --  --  --  --  --  --  --  \n";
		
		board[5][3]= HORSE_B;
		//assertEquals(ck.showBoard(board), text);
		assertTrue(ck.showBoard(board).equals(text));

	}




	@Test
	@Order(3) 
	void testPossibleMovesHorse() {

		byte[] pos = {4, 3};
		byte[][] actual = ck.possibleMovesHorse(board, pos);
		
		byte[][] expected = {
				{2, 2},
				{3, 1},
				{5, 1},
				{6, 2},
				{6, 4},
				{5, 5},
				{3, 5},
				{2, 4}
		};
		
		for (int i = 0; i < actual.length; i++) {
			
			assertTrue(Arrays.equals (actual[i], expected[i]));
		}
	}
	
	@Test
	@Order(4) 
	void testPossibleMovesHorse2() {

		
		byte[] pos = {5, 6};
		byte[][] actual = ck.possibleMovesHorse(board, pos);
		
		byte[][] expected = {
				{3, 5},
				{4, 4},
				{6, 4},
				{7, 5},
				{7, 7},
				{3, 7}
		};
		
		for (int i = 0; i < actual.length; i++) {
			
			assertTrue(Arrays.equals (actual[i], expected[i]));
		}
	}
	
	@Test
	@Order(5) 
	void testPossibleMovesHorse3() {

		
		byte[] pos = {1, 3};
		byte[][] actual = ck.possibleMovesHorse(board, pos);
		
		byte[][] expected = {
				{0, 1},
				{2, 1},
				{3, 2},
				{3, 4},
				{2, 5},
				{0, 5}
		};
		
		for (int i = 0; i < actual.length; i++) {
			
			assertTrue(Arrays.equals (actual[i], expected[i]));
		}
	}
	@Order(6) 
	void testPossibleMovesHorse4() {

		
		byte[] pos = {0, 0};
		byte[][] actual = ck.possibleMovesHorse(board, pos);
		
		byte[][] expected = {
				{2, 1},
				{1, 2}
		};
		
		for (int i = 0; i < actual.length; i++) {
			
			assertTrue(Arrays.equals (actual[i], expected[i]));
		}
	}

	@Test
	@Order(7) 
	void testMoveHorse() {
		for (byte i = 0; i < board.length; i++) {
			for (byte j = 0; j < board[i].length; j++) {
				board[i][j] = "--";				
			}		
		}
		board[4][3] = HORSE_B;
		
		byte[] pos = {4, 3 };
		byte[] choice = {2, 2};
		String empty ="--";
		
		ck.moveHorse(board, pos, choice);
		
		//New position of knight
		assertTrue(Arrays.equals(choice, pos));
		
		//Old position of knight
		assertTrue(board[4][3].equals(empty));
	}

}