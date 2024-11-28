/*
 * ChessKingTest.java 24 Jan 2024
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
class ChessKingTest {

	static ChessKing ck;
	static final byte SIZE = 8;
	static final String KING_B = "KB";
	
	static final String EMPTY = "--";
	
	static String[][] board;
	
	@BeforeAll
	static void setUpBeforeClass() throws Exception {
		ck = new ChessKing();
		
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
	void testShowMovementsKing() {
		
	}

	@Test
	@Order(1) 
	void testPlacePiece() {
		for (int i = 0; i < 10000; i++) {
			byte[] piece = ck.placePiece(board, "KING_B");
			
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
				+ "5: --  --  --  KB  --  --  --  --  \n"
				+ "6: --  --  --  --  --  --  --  --  \n"
				+ "7: --  --  --  --  --  --  --  --  \n";
		
		board[5][3]= KING_B;
		//assertEquals(ck.showBoard(board), text);
		assertTrue(ck.showBoard(board).equals(text));
	}


	@Test
	@Order(3) 
	void testPossibleMovesKing() {
		byte[] pos = {4, 4};
		byte[][] actual = ck.possibleMovesKing(board, pos);
		
		byte[][] expected = {
				{3, 4},
				{3, 3},
				{4, 3},
				{5, 3},
				{5, 4},
				{5, 5},
				{4, 5},
				{3, 5}
		};
		
		for (int i = 0; i < actual.length; i++) {
			
			assertTrue(Arrays.equals (actual[i], expected[i]));
		}
	}
	
	@Test
	@Order(4) 
	void testPossibleMovesKing2() {

		
		byte[] pos = {5, 7};
		byte[][] actual = ck.possibleMovesKing(board, pos);
		
		byte[][] expected = {
				{4, 7},
				{4, 6},
				{5, 6},
				{6, 6},
				{6, 7}
		};
		
		for (int i = 0; i < actual.length; i++) {
			
			assertTrue(Arrays.equals (actual[i], expected[i]));
		}
	}

	@Test
	@Order(4) 
	void testPossibleMovesKing3() {

		
		byte[] pos = {6, 0};
		byte[][] actual = ck.possibleMovesKing(board, pos);
		
		byte[][] expected = {
				{5, 0},
				{7, 0},
				{7, 1},
				{6, 1},
				{5, 1},
				{5, 0}
		};
		
		for (int i = 0; i < actual.length; i++) {
			
			assertTrue(Arrays.equals (actual[i], expected[i]));
		}
	}
	
	@Test
	@Order(5) 
	void testMoveKing() {
		for (byte i = 0; i < board.length; i++) {
			for (byte j = 0; j < board[i].length; j++) {
				board[i][j] = "--";				
			}		
		}
		board[4][3] = KING_B;
		
		byte[] pos = {4, 4};
		byte[] choice = {5, 5};
		String empty ="--";
		
		ck.moveKing(board, pos, choice);
		
		//New position of knight
		assertTrue(Arrays.equals(choice, pos));
		
		//Old position of King
		assertTrue(board[4][4].equals(empty));
	}

}