package chess;

import java.util.Scanner;

public class ChessKing {
  public static final Scanner scanner = new Scanner(System.in);
  public static final ChessKing chess = new ChessKing();
  public static final int SIZE = 8;
  public static final String kingStr = "KB";

  public static void main(String[] args) {
    String[][] board = new String[SIZE][SIZE];

    for (int i = 0; i < board.length; i++) {
      for (int j = 0; j < board[i].length; j++) {
        board[i][j] = "--";
      }
    }

    byte[] king = chess.placePiece(board, kingStr);
    System.out.println(chess.showBoard(board));

    boolean isEndGame = false;
    
    while (!isEndGame) {
      byte option = menu();

      switch (option) {
        case 1:
          System.out.println(chess.showBoard(chess.showMovementsKing(board, king)));
          break;
        
        case 2:
          byte[][] possibleMovesKing = chess.possibleMovesKing(board, king);

          for (int i = 0; i < possibleMovesKing.length; i++) {
            System.out.println(i + ": " + "[" + possibleMovesKing[i][0] + ", " + possibleMovesKing[i][1] + "]");
          }

          byte choice = dataEntryByteMinMax("Choose position to move: ", (byte) 0, (byte) (possibleMovesKing.length - 1));
          
          chess.moveKing(board, king, possibleMovesKing[choice]);

          System.out.println(chess.showBoard(board));
          break;

        case 0:
          System.out.println("Bye!");
          isEndGame = true;
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

  public String[][] showMovementsKing(String[][] board, byte[] pos) {
    String[][] boardClone = board.clone();

    for (int i = 0; i < board.length; i++) {
      boardClone[i] = board[i].clone();
    }

    int count = 0;

    if (pos[0] >= 1 && pos[1] >= 0) {
      boardClone[pos[0] - 1][pos[1]] = count + " ";
      count++;
    }

    if (pos[0] >= 1 && pos[1] >= 1) {
      boardClone[pos[0] - 1][pos[1] - 1] = count + " ";
      count++;
    }

    if (pos[0] >= 0 && pos[1] >= 1) {
      boardClone[pos[0]][pos[1] - 1] = count + " ";
      count++;
    }

    if (pos[0] <= boardClone.length - 2 && pos[1] >= 1) {
      boardClone[pos[0] + 1][pos[1] - 1] = count + " ";
      count++;
    }

    if (pos[0] <= boardClone.length - 2 && pos[1] >= 0) {
      boardClone[pos[0] + 1][pos[1]] = count + " ";
      count++;
    }

    if (pos[0] <= boardClone.length - 1 && pos[1] <= boardClone.length - 2) {
      boardClone[pos[0] + 1][pos[1] + 1] = count + " ";
      count++;
    }

    if (pos[1] <= boardClone.length - 2) {
      boardClone[pos[0]][pos[1] + 1] = count + " ";
      count++;
    }

    if (pos[0] >= 1 && pos[1] <= boardClone.length - 2) {
      boardClone[pos[0] - 1][pos[1] + 1] = count + " ";
      count++;
    }

    return boardClone;
  }

  public byte[][] possibleMovesKing(String[][] board, byte[] pos) {
    int count = 0;

    if (pos[0] >= 1 && pos[1] >= 0) {
      count++;
    }

    if (pos[0] >= 1 && pos[1] >= 1) {
      count++;
    }

    if (pos[0] >= 0 && pos[1] >= 1) {
      count++;
    }

    if (pos[0] <= board.length - 2 && pos[1] >= 1) {
      count++;
    }

    if (pos[0] <= board.length - 2 && pos[1] >= 0) {
      count++;
    }

    if (pos[0] <= board.length - 1 && pos[1] <= board.length - 2) {
      count++;
    }

    if (pos[1] <= board.length - 2) {
      count++;
    }

    if (pos[0] >= 1 && pos[1] <= board.length - 2) {
      count++;
    }

    byte[][] arr = new byte[count][2];

    int index = 0;

    if (pos[0] >= 1 && pos[1] >= 0) {
      arr[index][0] = (byte) (pos[0] - 1);
      arr[index][1] = (byte) pos[1];
      index++;
    }

    if (pos[0] >= 1 && pos[1] >= 1) {
      arr[index][0] = (byte) (pos[0] - 1);
      arr[index][1] = (byte) (pos[1] - 1);
      index++;
    }

    if (pos[0] >= 0 && pos[1] >= 1) {
      arr[index][0] = (byte) (pos[0]);
      arr[index][1] = (byte) (pos[1] - 1);
      index++;
    }

    if (pos[0] <= board.length - 2 && pos[1] >= 1) {
      arr[index][0] = (byte) (pos[0] + 1);
      arr[index][1] = (byte) (pos[1] - 1);
      index++;
    }

    if (pos[0] <= board.length - 2 && pos[1] >= 0) {
      arr[index][0] = (byte) (pos[0] + 1);
      arr[index][1] = (byte) (pos[1]);
      index++;
    }

    if (pos[0] <= board.length - 1 && pos[1] <= board.length - 2) {
      arr[index][0] = (byte) (pos[0] + 1);
      arr[index][1] = (byte) (pos[1] + 1);
      index++;
    }

    if (pos[1] <= board.length - 2) {
      arr[index][0] = (byte) (pos[0]);
      arr[index][1] = (byte) (pos[1] + 1);
      index++;
    }

    if (pos[0] >= 1 && pos[1] <= board.length - 2) {
      arr[index][0] = (byte) (pos[0] - 1);
      arr[index][1] = (byte) (pos[1] + 1);
      index++;
    }

    return arr;
  }

  public void moveKing(String[][] board, byte[] pos, byte[] choice) {
    board[choice[0]][choice[1]] = "KB";
    board[pos[0]][pos[1]] = "--";
    pos[0] = choice[0];
    pos[1] = choice[1];
  }

  public static byte menu() {
    return dataEntryByteMinMax("1. SHOW MOVES FOR KING\r\n" + //
        "2. MOVE KING\r\n" + //
        "0. Quit\r\n" + //
        "Choose menu option: ", (byte) 0, (byte) 2);
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