/*
* ChessKnight.java Nov 26, 2024
*
*
* ©Copyright 2024 Adrian Alvarado a243469aa@correu.escoladeltreball.org
*
* This is free software, licensed under the GNU General Public License v3.
* See http://www.gnu.org/licenses/gpl.html for more information.
*/
package chess;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Scanner;

public class ChessKnight {
  public static final Scanner scanner = new Scanner(System.in);
  public static final ChessKnight chess = new ChessKnight();
  public static final byte SIZE = 8;

  public static void main(String[] args) {
    String[][] board = new String[SIZE][SIZE];

    for (byte i = 0; i < board.length; i++) {
      for (byte j = 0; j < board[i].length; j++) {
        board[i][j] = "--";
      }
    }

    boolean isGameEnd = false;
    byte[] horse = chess.placePiece(board, "HB");

    while (!isGameEnd) {
      byte option = menu();
      
      switch (option) {
        case 1:
          System.out.println(chess.showBoard(chess.showMovementsHorse(board, horse)));
          break;

        case 2:
          byte[][] possibleMovesHorse = chess.possibleMovesHorse(board, horse);

          for (int i = 0; i < possibleMovesHorse.length; i++) {
            System.out.println(i + ": " + "[" + possibleMovesHorse[i][0] + ", " + possibleMovesHorse[i][1] + "]");
          }

          byte choice = dataEntryByteMinMax("Choose position to move:", (byte) 0, (byte) (possibleMovesHorse.length - 1));
          
          chess.moveHorse(board, horse, possibleMovesHorse[choice]);

          System.out.println(chess.showBoard(board));
          break;
        
        case 0:
          System.out.println("Bye!");
          isGameEnd = true;
          break;

        default:
          System.out.println("Wrong entry");
          break;
      }
    }
  }

  public byte[] placePiece(String[][] board, String piece) {
    byte randomX = (byte) (Math.random() * 8);
    byte randomY = (byte) (Math.random() * 8);

    board[randomX][randomY] = piece;

    return new byte[] { randomX, randomY };
  }

  public String showBoard(String[][] board) {
    String boardStr = "   0   1   2   3   4   5   6   7\n";

    for (int i = 0; i < board.length; i++) {
      boardStr += i + ": ";
      for (int j = 0; j < board[i].length; j++) {
        boardStr += board[i][j] + "  ";
      }

      boardStr += "\n";
    }

    return boardStr;
  }

  public String[][] showMovementsHorse(String[][] board, byte[] pos) {
    String[][] boardClone = board.clone();

    for (int i = 0; i < board.length; i++) {
      boardClone[i] = board[i].clone();
    }

    int count = 0;

    if (pos[0] >= 2 && pos[1] >= 1) {
      boardClone[pos[0] - 2][pos[1] - 1] = count + " ";
      count++;
    }

    if (pos[0] >= 1 && pos[1] >= 2) {
      boardClone[pos[0] - 1][pos[1] - 2] = count + " ";
      count++;
    }

    if (pos[0] <= boardClone.length - 2 && pos[1] >= 2) {
      boardClone[pos[0] + 1][pos[1] - 2] = count + " ";
      count++;
    }

    if (pos[0] <= boardClone.length - 3 && pos[1] >= 1) {
      boardClone[pos[0] + 2][pos[1] - 1] = count + " ";
      count++;
    }

    if (pos[0] <= boardClone.length - 3 && pos[1] <= boardClone.length - 2) {
      boardClone[pos[0] + 2][pos[1] + 1] = count + " ";
      count++;
    }

    if (pos[0] <= boardClone.length - 2 && pos[1] <= boardClone.length - 3) {
      boardClone[pos[0] + 1][pos[1] + 2] = count + " ";
      count++;
    }

    if (pos[0] >= 1 && pos[1] <= boardClone.length - 3) {
      boardClone[pos[0] - 1][pos[1] + 2] = count + " ";
      count++;
    }

    if (pos[0] >= 2 && pos[1] <= boardClone.length - 2) {
      boardClone[pos[0] - 2][pos[1] + 1] = count + " ";
      count++;
    }

    return boardClone;
  }

  public byte[][] possibleMovesHorse(String[][] board, byte[] pos) {
    int count = 0;

    if (pos[0] >= 2 && pos[1] >= 1) {
      count++;
    }

    if (pos[0] >= 1 && pos[1] >= 2) {
      count++;
    }

    if (pos[0] <= board.length - 2 && pos[1] >= 2) {
      count++;
    }

    if (pos[0] <= board.length - 3 && pos[1] >= 1) {
      count++;
    }

    if (pos[0] <= board.length - 3 && pos[1] <= board.length - 2) {
      count++;
    }

    if (pos[0] <= board.length - 2 && pos[1] <= board.length - 3) {
      count++;
    }

    if (pos[0] >= 1 && pos[1] <= board.length - 3) {
      count++;
    }

    if (pos[0] >= 2 && pos[1] <= board.length - 2) {
      count++;
    }

    byte[][] arr = new byte[count][2];

    int index = 0;

    if (pos[0] >= 2 && pos[1] >= 1) {
      arr[index][0] = (byte) (pos[0] - 2);
      arr[index][1] = (byte) (pos[1] - 1);
      index++;
    }

    if (pos[0] >= 1 && pos[1] >= 2) {
      arr[index][0] = (byte) (pos[0] - 1);
      arr[index][1] = (byte) (pos[1] - 2);
      index++;
    }

    if (pos[0] <= board.length - 2 && pos[1] >= 2) {
      arr[index][0] = (byte) (pos[0] + 1);
      arr[index][1] = (byte) (pos[1] - 2);
      index++;
    }

    if (pos[0] <= board.length - 3 && pos[1] >= 1) {
      arr[index][0] = (byte) (pos[0] + 2);
      arr[index][1] = (byte) (pos[1] - 1);
      index++;
    }

    if (pos[0] <= board.length - 3 && pos[1] <= board.length - 2) {
      arr[index][0] = (byte) (pos[0] + 2);
      arr[index][1] = (byte) (pos[1] + 1);
      index++;
    }

    if (pos[0] <= board.length - 2 && pos[1] <= board.length - 3) {
      arr[index][0] = (byte) (pos[0] + 1);
      arr[index][1] = (byte) (pos[1] + 2);
      index++;
    }

    if (pos[0] >= 1 && pos[1] <= board.length - 3) {
      arr[index][0] = (byte) (pos[0] - 1);
      arr[index][1] = (byte) (pos[1] + 2);
      index++;
    }

    if (pos[0] >= 2 && pos[1] <= board.length - 2) {
      arr[index][0] = (byte) (pos[0] - 2);
      arr[index][1] = (byte) (pos[1] + 1);
      index++;
    }

    return arr;
  }

  public void moveHorse(String[][] board, byte[] pos, byte[] choice){
    board[choice[0]][choice[1]] = "HB";
    board[pos[0]][pos[1]] = "--";
    pos[0] = choice[0];
    pos[1] = choice[1];
  }

  public static byte menu() {
    return dataEntryByteMinMax(
        "MENU\n" + "1. SHOW KNIGHT MOVES\n" + "2. MOVE KNIGHT\n" + "0. Quit\n" + "Choose menu option: ",
        (byte) 0, (byte) 2);
  }

  public static byte dataEntryByteMinMax(String text, byte min, byte max) {
    byte number = 0;
    System.out.print(text);
    boolean isValid = false;
    while (!isValid) {
      if (scanner.hasNextInt()) {
        number = scanner.nextByte();
        if (number <= max && number >= min) {
          isValid = true;
        } else {
          System.err.println("Error! Insert a number between " + min + " and " + max);
          System.out.print(text);
        }
      } else {
        scanner.next(); // Consume scanner
        System.err.println("Error! Insert a number");
        System.out.print(text);
      }
    }
    return number;
  }
}
