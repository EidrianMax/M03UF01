package chess;

import java.util.Scanner;

public class ChessQueen {
  public static final Scanner scanner = new Scanner(System.in);
  public static final ChessQueen chess = new ChessQueen();
  public static final int SIZE = 8;
  public static final String queenStr = "QB";

  public static void main(String[] args) {
    String[][] board = new String[SIZE][SIZE];

    for (int i = 0; i < board.length; i++) {
      for (int j = 0; j < board[i].length; j++) {
        board[i][j] = "--";
      }
    }

    byte[] queen = chess.placePiece(board, queenStr);
    System.out.println(chess.showBoard(board));

    boolean isEndGame = false;
    
    while (!isEndGame) {
      byte option = menu();

      switch (option) {
        case 1:
          System.out.println(chess.showBoard(chess.showMovementsQueen(board, queen)));
          break;
        
        case 2:
          byte[][] possibleMovesKing = chess.possibleMovesQueen(board, queen);

          for (int i = 0; i < possibleMovesKing.length; i++) {
            System.out.println(i + ": " + "[" + possibleMovesKing[i][0] + ", " + possibleMovesKing[i][1] + "]");
          }

          byte choice = dataEntryByteMinMax("Choose position to move: ", (byte) 0, (byte) (possibleMovesKing.length - 1));
          
          chess.moveQueen(board, queen, possibleMovesKing[choice]);

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

  public String[][] showMovementsQueen(String[][] board, byte[] pos) {
    String[][] boardClone = board.clone();

    for (int i = 0; i < board.length; i++) {
      boardClone[i] = board[i].clone();
    }

    int count = 0;

    // 0 - 6
    if (pos[0] >= 1 && pos[1] >= 0) {
      boardClone[pos[0] - 1][pos[1]] = count + " ";
      count++;
    }

    if(pos[0] >= 2 && pos[1] >= 0) {
      boardClone[pos[0] - 2][pos[1]] = count + " ";
      count++;
    }

    if(pos[0] >= 3 && pos[1] >= 0) {
      boardClone[pos[0] - 3][pos[1]] = count + " ";
      count++;
    }

    if(pos[0] >= 4 && pos[1] >= 0) {
      boardClone[pos[0] - 4][pos[1]] = count + " ";
      count++;
    }

    if(pos[0] >= 5 && pos[1] >= 0) {
      boardClone[pos[0] - 5][pos[1]] = count + " ";
      count++;
    }

    if(pos[0] >= 6 && pos[1] >= 0) {
      boardClone[pos[0] - 6][pos[1]] = count + " ";
      count++;
    }

    if(pos[0] >= 7 && pos[1] >= 0) {
      boardClone[pos[0] - 7][pos[1]] = count + " ";
      count++;
    }
    // 0 - 6

    // 7 - 13
    if(pos[0] >= 1 && pos[1] >= 1) {
      boardClone[pos[0] - 1][pos[1] - 1] = count + " ";
      count++;
    }

    if(pos[0] >= 2 && pos[1] >= 2) {
      boardClone[pos[0] - 2][pos[1] - 2] = count + " ";
      count++;
    }

    if(pos[0] >= 3 && pos[1] >= 3) {
      boardClone[pos[0] - 3][pos[1] - 3] = count + " ";
      count++;
    }

    if(pos[0] >= 4 && pos[1] >= 4) {
      boardClone[pos[0] - 4][pos[1] - 4] = count + " ";
      count++;
    }

    if(pos[0] >= 5 && pos[1] >= 5) {
      boardClone[pos[0] - 5][pos[1] - 5] = count + " ";
      count++;
    }

    if(pos[0] >= 5 && pos[1] >= 5) {
      boardClone[pos[0] - 5][pos[1] - 5] = count + " ";
      count++;
    }

    if(pos[0] >= 6 && pos[1] >= 6) {
      boardClone[pos[0] - 6][pos[1] - 6] = count + " ";
      count++;
    }

    if(pos[0] >= 7 && pos[1] >= 7) {
      boardClone[pos[0] - 7][pos[1] - 7] = count + " ";
      count++;
    }
    // 7 -13

    // 13 - 17
    if(pos[0] >= 1 && pos[1] >= 1) {
      boardClone[pos[0]][pos[1] - 1] = count + " ";
      count++;
    }

    if(pos[0] >= 1 && pos[1] >= 2) {
      boardClone[pos[0]][pos[1] - 2] = count + " ";
      count++;
    }

    if(pos[0] >= 1 && pos[1] >= 3) {
      boardClone[pos[0]][pos[1] - 3] = Integer.toString(count);
      count++;
    }

    if(pos[0] >= 1 && pos[1] >= 4) {
      boardClone[pos[0]][pos[1] - 4] = Integer.toString(count);
      count++;
    }

    if(pos[0] >= 1 && pos[1] >= 5) {
      boardClone[pos[0]][pos[1] - 5] = Integer.toString(count);
      count++;
    }

    if(pos[0] >= 1 && pos[1] >= 6) {
      boardClone[pos[0]][pos[1] - 6] = Integer.toString(count);
      count++;
    }

    if(pos[0] >= 1 && pos[1] >= 7) {
      boardClone[pos[0]][pos[1] - 7] = Integer.toString(count);
      count++;
    }
    // 13 - 17

    // 17 - 24
    if(pos[0] <= board.length - 2 && pos[1] >= 1) {
      boardClone[pos[0] + 1][pos[1] - 1] = Integer.toString(count);
      count++;
    }

    if(pos[0] <= board.length - 3 && pos[1] >= 2) {
      boardClone[pos[0] + 2][pos[1] - 2] = Integer.toString(count);
      count++;
    }

    if(pos[0] <= board.length - 4 && pos[1] >= 3) {
      boardClone[pos[0] + 3][pos[1] - 3] = Integer.toString(count);
      count++;
    }

    if(pos[0] <= board.length - 5 && pos[1] >= 4) {
      boardClone[pos[0] + 4][pos[1] - 4] = Integer.toString(count);
      count++;
    }

    if(pos[0] <= board.length - 5 && pos[1] >= 4) {
      boardClone[pos[0] + 4][pos[1] - 4] = Integer.toString(count);
      count++;
    }

    if(pos[0] <= board.length - 6 && pos[1] >= 5) {
      boardClone[pos[0] + 5][pos[1] - 5] = Integer.toString(count);
      count++;
    }

    if(pos[0] <= board.length - 7 && pos[1] >= 6) {
      boardClone[pos[0] + 6][pos[1] - 6] = Integer.toString(count);
      count++;
    }

    if(pos[0] <= board.length - 8 && pos[1] >= 7) {
      boardClone[pos[0] + 7][pos[1] - 7] = Integer.toString(count);
      count++;
    }
    // 17 - 24


    // 24 - 31 diagonal derecha hacia abajo
    if(pos[0] <= board.length - 2 && pos[1] >= 0) {
      boardClone[pos[0] + 1][pos[1]] = Integer.toString(count);
      count++;
    }

    if(pos[0] <= board.length - 3 && pos[1] >= 0) {
      boardClone[pos[0] + 2][pos[1]] = Integer.toString(count);
      count++;
    }

    if(pos[0] <= board.length - 4 && pos[1] >= 0) {
      boardClone[pos[0] + 3][pos[1]] = Integer.toString(count);
      count++;
    }

    if(pos[0] <= board.length - 5 && pos[1] >= 0) {
      boardClone[pos[0] + 4][pos[1]] = Integer.toString(count);
      count++;
    }

    if(pos[0] <= board.length - 6 && pos[1] >= 0) {
      boardClone[pos[0] + 5][pos[1]] = Integer.toString(count);
      count++;
    }

    if(pos[0] <= board.length - 7 && pos[1] >= 0) {
      boardClone[pos[0] + 6][pos[1]] = Integer.toString(count);
      count++;
    }

    if(pos[0] <= board.length - 8 && pos[1] >= 0) {
      boardClone[pos[0] + 7][pos[1]] = Integer.toString(count);
      count++;
    }
    // 24 - 31 diagonal derecha hacia abajo

    // 32 - 38 diagonal izquierda hacia abajo
    if(pos[0] <= board.length - 2 && pos[1] <= board.length - 2) {
      boardClone[pos[0] + 1][pos[1] + 1] = Integer.toString(count);
      count++;
    }

    if(pos[0] <= board.length - 3 && pos[1] <= board.length - 3) {
      boardClone[pos[0] + 2][pos[1] + 2] = Integer.toString(count);
      count++;
    }

    if(pos[0] <= board.length - 4 && pos[1] <= board.length - 4) {
      boardClone[pos[0] + 3][pos[1] + 3] = Integer.toString(count);
      count++;
    }

    if(pos[0] <= board.length - 5 && pos[1] <= board.length - 5) {
      boardClone[pos[0] + 4][pos[1] + 4] = Integer.toString(count);
      count++;
    }

    if(pos[0] <= board.length - 6 && pos[1] <= board.length - 6) {
      boardClone[pos[0] + 5][pos[1] + 5] = Integer.toString(count);
      count++;
    }

    if(pos[0] <= board.length - 7 && pos[1] <= board.length - 7) {
      boardClone[pos[0] + 6][pos[1] + 6] = Integer.toString(count);
      count++;
    }

    if(pos[0] <= board.length - 8 && pos[1] <= board.length - 8) {
      boardClone[pos[0] + 7][pos[1] + 7] = Integer.toString(count);
      count++;
    }
    // 32 - 28 diagonal izquierda hacia abajo

    // 39 - 45 lateral izquierda a derecha
    if(pos[0] >= 0 && pos[1] <= board.length - 2) {
      boardClone[pos[0]][pos[1] + 1] = Integer.toString(count);
      count++;
    }

    if(pos[0] >= 0 && pos[1] <= board.length - 3) {
      boardClone[pos[0]][pos[1] + 2] = Integer.toString(count);
      count++;
    }

    if(pos[0] >= 0 && pos[1] <= board.length - 4) {
      boardClone[pos[0]][pos[1] + 3] = Integer.toString(count);
      count++;
    }

    if(pos[0] >= 0 && pos[1] <= board.length - 5) {
      boardClone[pos[0]][pos[1] + 4] = Integer.toString(count);
      count++;
    }

    if(pos[0] >= 0 && pos[1] <= board.length - 6) {
      boardClone[pos[0]][pos[1] + 5] = Integer.toString(count);
      count++;
    }

    if(pos[0] >= 0 && pos[1] <= board.length - 7) {
      boardClone[pos[0]][pos[1] + 6] = Integer.toString(count);
      count++;
    }

    if(pos[0] >= 0 && pos[1] <= board.length - 8) {
      boardClone[pos[0]][pos[1] + 7] = Integer.toString(count);
      count++;
    }
    // 39 - 45 lateral izquierda a derecha

    // 46 - 53 abajo izquierda hacia arriba derecha en diagonal
    if(pos[0] >= 1 && pos[1] <= board.length - 2) {
      boardClone[pos[0] - 1][pos[1] + 1] = Integer.toString(count);
      count++;
    }

    if(pos[0] >= 2 && pos[1] <= board.length - 3) {
      boardClone[pos[0] - 2][pos[1] + 2] = Integer.toString(count);
      count++;
    }

    if(pos[0] >= 3 && pos[1] <= board.length - 4) {
      boardClone[pos[0] - 3][pos[1] + 3] = Integer.toString(count);
      count++;
    }

    if(pos[0] >= 4 && pos[1] <= board.length - 5) {
      boardClone[pos[0] - 4][pos[1] + 4] = Integer.toString(count);
      count++;
    }

    if(pos[0] >= 5 && pos[1] <= board.length - 6) {
      boardClone[pos[0] - 5][pos[1] + 5] = Integer.toString(count);
      count++;
    }

    if(pos[0] >= 6 && pos[1] <= board.length - 7) {
      boardClone[pos[0] - 6][pos[1] + 6] = Integer.toString(count);
      count++;
    }

    if(pos[0] >= 7 && pos[1] <= board.length - 8) {
      boardClone[pos[0] - 7][pos[1] + 7] = Integer.toString(count);
      count++;
    }

    return boardClone;
  }

  public byte[][] possibleMovesQueen(String[][] board, byte[] pos) {
    int count = 0;

    if (pos[0] >= 1 && pos[1] >= 0) {
      count++;
    }

    if(pos[0] >= 2 && pos[1] >= 0) {
      count++;
    }

    if(pos[0] >= 3 && pos[1] >= 0) {
      count++;
    }

    if(pos[0] >= 4 && pos[1] >= 0) {
      count++;
    }

    if(pos[0] >= 5 && pos[1] >= 0) {
      count++;
    }

    if(pos[0] >= 6 && pos[1] >= 0) {
      count++;
    }

    if(pos[0] >= 7 && pos[1] >= 0) {
      count++;
    }
  
    if(pos[0] >= 1 && pos[1] >= 1) {
      count++;
    }

    if(pos[0] >= 2 && pos[1] >= 2) {
      count++;
    }

    if(pos[0] >= 3 && pos[1] >= 3) {
      count++;
    }

    if(pos[0] >= 4 && pos[1] >= 4) {
      count++;
    }

    if(pos[0] >= 5 && pos[1] >= 5) {
      count++;
    }

    if(pos[0] >= 5 && pos[1] >= 5) {
      count++;
    }

    if(pos[0] >= 6 && pos[1] >= 6) {
      count++;
    }

    if(pos[0] >= 7 && pos[1] >= 7) {
      count++;
    }

    if(pos[0] >= 1 && pos[1] >= 1) {
      count++;
    }

    if(pos[0] >= 1 && pos[1] >= 2) {
      count++;
    }

    if(pos[0] >= 1 && pos[1] >= 3) {
      count++;
    }

    if(pos[0] >= 1 && pos[1] >= 4) {
      count++;
    }

    if(pos[0] >= 1 && pos[1] >= 5) {
      count++;
    }

    if(pos[0] >= 1 && pos[1] >= 6) {
      count++;
    }

    if(pos[0] >= 1 && pos[1] >= 7) {
      count++;
    }

    if(pos[0] <= board.length - 2 && pos[1] >= 1) {
      count++;
    }

    if(pos[0] <= board.length - 3 && pos[1] >= 2) {
      count++;
    }

    if(pos[0] <= board.length - 4 && pos[1] >= 3) {
      count++;
    }

    if(pos[0] <= board.length - 5 && pos[1] >= 4) {
      count++;
    }

    if(pos[0] <= board.length - 6 && pos[1] >= 5) {
      count++;
    }

    if(pos[0] <= board.length - 7 && pos[1] >= 6) {
      count++;
    }

    if(pos[0] <= board.length - 8 && pos[1] >= 7) {
      count++;
    }

    if(pos[0] <= board.length - 2 && pos[1] >= 0) {
      count++;
    }

    if(pos[0] <= board.length - 3 && pos[1] >= 0) {
      count++;
    }

    if(pos[0] <= board.length - 4 && pos[1] >= 0) {
      count++;
    }

    if(pos[0] <= board.length - 5 && pos[1] >= 0) {
      count++;
    }

    if(pos[0] <= board.length - 6 && pos[1] >= 0) {
      count++;
    }

    if(pos[0] <= board.length - 7 && pos[1] >= 0) {
      count++;
    }

    if(pos[0] <= board.length - 8 && pos[1] >= 0) {
      count++;
    }

    if(pos[0] <= board.length - 2 && pos[1] <= board.length - 2) {
      count++;
    }

    if(pos[0] <= board.length - 3 && pos[1] <= board.length - 3) {
      count++;
    }

    if(pos[0] <= board.length - 4 && pos[1] <= board.length - 4) {
      count++;
    }

    if(pos[0] <= board.length - 5 && pos[1] <= board.length - 5) {
      count++;
    }

    if(pos[0] <= board.length - 6 && pos[1] <= board.length - 6) {
      count++;
    }

    if(pos[0] <= board.length - 7 && pos[1] <= board.length - 7) {
      count++;
    }

    if(pos[0] <= board.length - 8 && pos[1] <= board.length - 8) {
      count++;
    }

    if(pos[0] >= 0 && pos[1] <= board.length - 2) {
      count++;
    }

    if(pos[0] >= 0 && pos[1] <= board.length - 3) {
      count++;
    }

    if(pos[0] >= 0 && pos[1] <= board.length - 4) {
      count++;
    }

    if(pos[0] >= 0 && pos[1] <= board.length - 5) {
      count++;
    }

    if(pos[0] >= 0 && pos[1] <= board.length - 6) {
      count++;
    }

    if(pos[0] >= 0 && pos[1] <= board.length - 7) {
      count++;
    }

    if(pos[0] >= 0 && pos[1] <= board.length - 8) {
      count++;
    }

    if(pos[0] >= 2 && pos[1] <= board.length - 3) {
      count++;
    }

    if(pos[0] >= 3 && pos[1] <= board.length - 4) {
      count++;
    }

    if(pos[0] >= 4 && pos[1] <= board.length - 5) {
      count++;
    }

    if(pos[0] >= 5 && pos[1] <= board.length - 6) {
      count++;
    }

    if(pos[0] >= 6 && pos[1] <= board.length - 7) {
      count++;
    }

    if(pos[0] >= 7 && pos[1] <= board.length - 8) {
      count++;
    }

    byte[][] arr = new byte[count][2];

    int index = 0;

    if (pos[0] >= 1 && pos[1] >= 0) {
      arr[index][0] = (byte)  (pos[0] - 1);
      arr[index][1] = (byte) (pos[1]);
      index++;
    }

    if(pos[0] >= 2 && pos[1] >= 0) {
      arr[index][0] = (byte)  (pos[0] - 2);
      arr[index][1] = (byte) (pos[1]);
      index++;
    }

    if(pos[0] >= 3 && pos[1] >= 0) {
      arr[index][0] = (byte)  (pos[0] - 3);
      arr[index][1] = (byte) (pos[1]);
      index++;
    }

    if(pos[0] >= 4 && pos[1] >= 0) {
      arr[index][0] = (byte)  (pos[0] - 4);
      arr[index][1] = (byte) (pos[1]);
      index++;
    }

    if(pos[0] >= 5 && pos[1] >= 0) {
      arr[index][0] = (byte)  (pos[0] - 5);
      arr[index][1] = (byte) (pos[1]);
      index++;
    }

    if(pos[0] >= 6 && pos[1] >= 0) {
      arr[index][0] = (byte)  (pos[0] - 6);
      arr[index][1] = (byte) (pos[1]);
      index++;
    }

    if(pos[0] >= 7 && pos[1] >= 0) {
      arr[index][0] = (byte)  (pos[0] - 7);
      arr[index][1] = (byte) (pos[1]);
      index++;
    }

    if(pos[0] >= 1 && pos[1] >= 1) {
      arr[index][0] = (byte)  (pos[0] - 1);
      arr[index][1] = (byte) (pos[1] - 1);
      index++;
    }

    if(pos[0] >= 2 && pos[1] >= 2) {
      arr[index][0] = (byte)  (pos[0] - 2);
      arr[index][1] = (byte) (pos[1] - 2);
      index++;
    }

    if(pos[0] >= 3 && pos[1] >= 3) {
      arr[index][0] = (byte)  (pos[0] - 3);
      arr[index][1] = (byte) (pos[1] - 3);
      index++;
    }

    if(pos[0] >= 4 && pos[1] >= 4) {
      arr[index][0] = (byte)  (pos[0] - 4);
      arr[index][1] = (byte) (pos[1] - 4);
      index++;
    }

    if(pos[0] >= 5 && pos[1] >= 5) {
      arr[index][0] = (byte)  (pos[0] - 5);
      arr[index][1] = (byte) (pos[1] - 5);
      index++;
    }

    if(pos[0] >= 6 && pos[1] >= 6) {
      arr[index][0] = (byte)  (pos[0] - 6);
      arr[index][1] = (byte) (pos[1] - 6);
      index++;
    }

    if(pos[0] >= 7 && pos[1] >= 7) {
      arr[index][0] = (byte)  (pos[0] - 7);
      arr[index][1] = (byte) (pos[1] - 7);
      index++;
    }

    if(pos[0] >= 1 && pos[1] >= 1) {
      arr[index][0] = (byte)  (pos[0]);
      arr[index][1] = (byte) (pos[1] - 1);
      index++;
    }

    if(pos[0] >= 1 && pos[1] >= 2) {
      arr[index][0] = (byte)  (pos[0]);
      arr[index][1] = (byte) (pos[1] - 2);
      index++;
    }

    if(pos[0] >= 1 && pos[1] >= 3) {
      arr[index][0] = (byte)  (pos[0]);
      arr[index][1] = (byte) (pos[1] - 3);
      index++;
    }

    if(pos[0] >= 1 && pos[1] >= 4) {
      arr[index][0] = (byte)  (pos[0]);
      arr[index][1] = (byte) (pos[1] - 4);
      index++;
    }

    if(pos[0] >= 1 && pos[1] >= 5) {
      arr[index][0] = (byte)  (pos[0]);
      arr[index][1] = (byte) (pos[1] - 5);
      index++;
    }

    if(pos[0] >= 1 && pos[1] >= 6) {
      arr[index][0] = (byte)  (pos[0]);
      arr[index][1] = (byte) (pos[1] - 6);
      index++;
    }

    if(pos[0] >= 1 && pos[1] >= 7) {
      arr[index][0] = (byte)  (pos[0]);
      arr[index][1] = (byte) (pos[1] - 7);
      index++;
    }

    if(pos[0] <= board.length - 2 && pos[1] >= 1) {
      arr[index][0] = (byte)  (pos[0] + 1);
      arr[index][1] = (byte) (pos[1] - 1);
      index++;
    }

    if(pos[0] <= board.length - 3 && pos[1] >= 2) {
      arr[index][0] = (byte)  (pos[0] + 2);
      arr[index][1] = (byte) (pos[1] - 2);
      index++;
    }

    if(pos[0] <= board.length - 4 && pos[1] >= 3) {
      arr[index][0] = (byte)  (pos[0] + 3);
      arr[index][1] = (byte) (pos[1] - 3);
      index++;
    }

    if(pos[0] <= board.length - 5 && pos[1] >= 4) {
      arr[index][0] = (byte)  (pos[0] + 4);
      arr[index][1] = (byte) (pos[1] - 4);
      index++;
    }

    if(pos[0] <= board.length - 5 && pos[1] >= 4) {
      arr[index][0] = (byte)  (pos[0] + 4);
      arr[index][1] = (byte) (pos[1] - 4);
      index++;
    }

    if(pos[0] <= board.length - 6 && pos[1] >= 5) {
      arr[index][0] = (byte)  (pos[0] + 5);
      arr[index][1] = (byte) (pos[1] - 5);
      index++;
    }

    if(pos[0] <= board.length - 7 && pos[1] >= 6) {
      arr[index][0] = (byte)  (pos[0] + 6);
      arr[index][1] = (byte) (pos[1] - 6);
      index++;
    }

    if(pos[0] <= board.length - 8 && pos[1] >= 7) {
      arr[index][0] = (byte)  (pos[0] + 7);
      arr[index][1] = (byte) (pos[1] - 7);
      index++;
    }

    if(pos[0] <= board.length - 2 && pos[1] >= 0) {
      arr[index][0] = (byte)  (pos[0] + 1);
      arr[index][1] = (byte) (pos[1]);
      index++;
    }

    if(pos[0] <= board.length - 3 && pos[1] >= 0) {
      arr[index][0] = (byte)  (pos[0] + 2);
      arr[index][1] = (byte) (pos[1]);
      index++;
    }

    if(pos[0] <= board.length - 4 && pos[1] >= 0) {
      arr[index][0] = (byte)  (pos[0] + 3);
      arr[index][1] = (byte) (pos[1]);
      index++;
    }

    if(pos[0] <= board.length - 5 && pos[1] >= 0) {
      arr[index][0] = (byte)  (pos[0] + 4);
      arr[index][1] = (byte) (pos[1]);
      index++;
    }

    if(pos[0] <= board.length - 6 && pos[1] >= 0) {
      arr[index][0] = (byte)  (pos[0] + 5);
      arr[index][1] = (byte) (pos[1]);
      index++;
    }

    if(pos[0] <= board.length - 7 && pos[1] >= 0) {
      arr[index][0] = (byte)  (pos[0] + 6);
      arr[index][1] = (byte) (pos[1]);
      index++;
    }

    if(pos[0] <= board.length - 8 && pos[1] >= 0) {
      arr[index][0] = (byte)  (pos[0] + 7);
      arr[index][1] = (byte) (pos[1]);
      index++;
    }

    if(pos[0] <= board.length - 2 && pos[1] <= board.length - 2) {
      arr[index][0] = (byte)  (pos[0] + 1);
      arr[index][1] = (byte) (pos[1] + 1);
      index++;
    }

    if(pos[0] <= board.length - 3 && pos[1] <= board.length - 3) {
      arr[index][0] = (byte)  (pos[0] + 2);
      arr[index][1] = (byte) (pos[1] + 2);
      index++;
    }

    if(pos[0] <= board.length - 4 && pos[1] <= board.length - 4) {
      arr[index][0] = (byte)  (pos[0] + 3);
      arr[index][1] = (byte) (pos[1] + 3);
      index++;
    }

    if(pos[0] <= board.length - 5 && pos[1] <= board.length - 5) {
      arr[index][0] = (byte)  (pos[0] + 4);
      arr[index][1] = (byte) (pos[1] + 4);
      index++;
    }

    if(pos[0] <= board.length - 6 && pos[1] <= board.length - 6) {
      arr[index][0] = (byte)  (pos[0] + 5);
      arr[index][1] = (byte) (pos[1] + 5);
      index++;
    }

    if(pos[0] <= board.length - 7 && pos[1] <= board.length - 7) {
      arr[index][0] = (byte)  (pos[0] + 6);
      arr[index][1] = (byte) (pos[1] + 6);
      index++;
    }

    if(pos[0] <= board.length - 8 && pos[1] <= board.length - 8) {
      arr[index][0] = (byte)  (pos[0] + 7);
      arr[index][1] = (byte) (pos[1] + 7);
      index++;
    }

    if(pos[0] >= 0 && pos[1] <= board.length - 2) {
      arr[index][0] = (byte)  (pos[0]);
      arr[index][1] = (byte) (pos[1] + 1);
      index++;
    }

    if(pos[0] >= 0 && pos[1] <= board.length - 3) {
      arr[index][0] = (byte)  (pos[0]);
      arr[index][1] = (byte) (pos[1] + 2);
      index++;
    }

    if(pos[0] >= 0 && pos[1] <= board.length - 4) {
      arr[index][0] = (byte)  (pos[0]);
      arr[index][1] = (byte) (pos[1] + 3);
      index++;
    }

    if(pos[0] >= 0 && pos[1] <= board.length - 5) {
      arr[index][0] = (byte)  (pos[0]);
      arr[index][1] = (byte) (pos[1] + 4);
      index++;
    }

    if(pos[0] >= 0 && pos[1] <= board.length - 6) {
      arr[index][0] = (byte)  (pos[0]);
      arr[index][1] = (byte) (pos[1] + 5);
      index++;
    }

    if(pos[0] >= 0 && pos[1] <= board.length - 7) {
      arr[index][0] = (byte)  (pos[0]);
      arr[index][1] = (byte) (pos[1] + 6);
      index++;
    }

    if(pos[0] >= 0 && pos[1] <= board.length - 8) {
      arr[index][0] = (byte)  (pos[0]);
      arr[index][1] = (byte) (pos[1] + 7);
      index++;
    }

    if(pos[0] >= 1 && pos[1] <= board.length - 2) {
      arr[index][0] = (byte)  (pos[0] - 1);
      arr[index][1] = (byte) (pos[1] + 1);
      index++;
    }

    if(pos[0] >= 2 && pos[1] <= board.length - 3) {
      arr[index][0] = (byte)  (pos[0] - 2);
      arr[index][1] = (byte) (pos[1] + 2);
      index++;
    }

    if(pos[0] >= 4 && pos[1] <= board.length - 5) {
      arr[index][0] = (byte)  (pos[0] - 4);
      arr[index][1] = (byte) (pos[1] + 4);
      index++;
    }

    if(pos[0] >= 5 && pos[1] <= board.length - 6) {
      arr[index][0] = (byte)  (pos[0] - 5);
      arr[index][1] = (byte) (pos[1] + 5);
      index++;
    }

    if(pos[0] >= 6 && pos[1] <= board.length - 7) {
      arr[index][0] = (byte)  (pos[0] - 6);
      arr[index][1] = (byte) (pos[1] + 6);
      index++;
    }

    if(pos[0] >= 7 && pos[1] <= board.length - 8) {
      arr[index][0] = (byte)  (pos[0] - 7);
      arr[index][1] = (byte) (pos[1] + 7);
      index++;
    }

    return arr;
  }

  public void moveQueen(String[][] board, byte[] pos, byte[] choice) {
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