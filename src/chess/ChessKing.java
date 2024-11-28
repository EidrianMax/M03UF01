package chess;

public class ChessKing {
  public static final ChessKing chess = new ChessKing();
  public static final int SIZE = 8;
  public static void main(String[] args) {
    String[][] board = new String[SIZE][SIZE];

    for (int i = 0; i < board.length; i++) {
      for (int j = 0; j < board[i].length; j++) {
        board[i][j] = "--";
      }
    }

    byte[] king = chess.placePiece(board, "KB");
    System.out.println(chess.showBoard(board));
    board[king[0] - 1][king[1]] = "0 ";
    board[king[0] - 1][king[1] - 1] = "1 ";
    board[king[0]][king[1] - 1] = "2 ";
    board[king[0] + 1][king[1] - 1] = "3 ";
    System.out.println(chess.showBoard(board));
  }

  public byte[] placePiece(String[][] board, String piece){
    byte randomX = (byte) (Math.random() * 8);
    byte randomY = (byte) (Math.random() * 8);

    board[randomX][randomY] = piece;

    return new byte[] { randomX, randomY };
  }

  public String showBoard(String[][] board){
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

  public String[][] showMovementsKing(String[][] board, byte[] pos){
    String[][] boardClone = board.clone();

    for (int i = 0; i < board.length; i++) {
      boardClone[i] = board[i].clone();
    }

    int count = 0;

    board[pos[0]][pos[1] - 1] = "0 ";

    String[][] str = {};

    return str;
  }
}
