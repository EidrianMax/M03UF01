/*
 * ChessQueenTest.java 24 Jan 2024
 *
 *
 * \u00A9 Copyright 2024 Joan S�culi
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
class ChessQueenTest {

	static ChessQueen cq;
	static final byte SIZE = 8;
	static final String QUEEN_B = "QB";
	
	static final String EMPTY = "--";
	
	static String[][] board;
	
	@BeforeAll
	static void setUpBeforeClass() throws Exception {
		cq = new ChessQueen();
		
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
	void testShowMovementsQueen() {

	}

	@Test
	@Order(1) 
	void testPlacePiece() {
		for (int i = 0; i < 10000; i++) {
			byte[] piece = cq.placePiece(board, QUEEN_B);
			
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
				+ "5: --  --  --  QB  --  --  --  --  \n"
				+ "6: --  --  --  --  --  --  --  --  \n"
				+ "7: --  --  --  --  --  --  --  --  \n";
		
		board[5][3]= QUEEN_B;
		//assertEquals(ck.showBoard(board), text);
		assertTrue(cq.showBoard(board).equals(text));
	}

	@Test
	@Order(3)
	void testPossibleMovesQueen1() {
		byte[] pos = {4, 4};
		byte[][] actual = cq.possibleMovesQueen(board, pos);
		
		byte[][] expected = {
				{3, 4},
				{2, 4},
				{1, 4},
				{0, 4},
				
				{3, 3},
				{2, 2},
				{1, 1},
				{0, 0},
				
				{4, 3},
				{4, 2},
				{4, 1},
				{4, 0},
				
				{5, 3},
				{6, 2},
				{7, 1},
				
				{5, 4},
				{6, 4},
				{7, 4},
				
				{5, 5},
				{6, 6},
				{7, 7},
				
				{4, 5},
				{4, 6},
				{4, 7},
				
				{3, 5},
				{2, 6},
				{1, 7}

		};
		
		for (int i = 0; i < actual.length; i++) {
			
			assertTrue(Arrays.equals (actual[i], expected[i]));
		}
	}
	
	@Test
	@Order(4)
	void testPossibleMovesQueen2() {
		byte[] pos = {7, 5};
		byte[][] actual = cq.possibleMovesQueen(board, pos);
		
		byte[][] expected = {
				{6, 5},
				{5, 5},
				{4, 5},
				{3, 5},
				{2, 5},
				{1, 5},
				{0, 5},
				
				{6, 4},
				{5, 3},
				{4, 2},
				{3, 1},
				{2, 0},

				{7, 4},
				{7, 3},
				{7, 2},
				{7, 1},
				{7, 0},
				
				{7, 6},
				{7, 7},
				
				{6, 6},
				{5, 7}

				
		};
		
		for (int i = 0; i < actual.length; i++) {
			
			assertTrue(Arrays.equals (actual[i], expected[i]));
		}
	}
	
	@Test
	@Order(5)
	void testPossibleMovesQueen3() {

	}

	@Test
	@Order(6)
	void testMoveQueen() {
		for (byte i = 0; i < board.length; i++) {
			for (byte j = 0; j < board[i].length; j++) {
				board[i][j] = "--";				
			}		
		}
		board[7][5] = QUEEN_B;
		
		byte[] pos = {7, 5};
		byte[] choice = {2, 0};
		String empty ="--";
		
		cq.moveQueen(board, pos, choice);
		
		//New position of knight
		assertTrue(Arrays.equals(choice, pos));
		
		//Old position of King
		assertTrue(board[4][4].equals(empty));
	}
	

}