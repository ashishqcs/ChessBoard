package org.chess.board;

import static org.chess.board.ChessBoard.START_COL;

import java.util.ArrayList;
import java.util.List;

public class Moves {

  public enum Direction {
    LEFT,
    RIGHT,
    UP,
    DOWN,
    UPPER_LEFT,
    LOWER_LEFT,
    UPPER_RIGHT,
    LOWER_RIGHT
  }

  /**
   * Moves one step up.
   *
   * @return null -> If it cannot move <br/> String -> one step up position
   */
  public String moveOneStep(ChessBoard board, String position, Direction direction) {
    Integer[] positions = getRowColumn(position);
    int rowMove = positions[0];
    int colMove = positions[1];

    switch (direction) {
      case UP -> rowMove += 1;
      case DOWN -> rowMove -= 1;
      case LEFT -> colMove -= 1;
      case RIGHT -> colMove += 1;
      case UPPER_LEFT -> {
        rowMove += 1;
        colMove -= 1;
      }
      case UPPER_RIGHT -> {
        rowMove += 1;
        colMove += 1;
      }
      case LOWER_LEFT -> {
        rowMove -= 1;
        colMove -= 1;
      }
      case LOWER_RIGHT -> {
        rowMove -= 1;
        colMove += 1;
      }
    }

    if (isValidMove(board, rowMove, colMove)) {
      return position(rowMove, colMove);
    }

    return null;
  }


  public List<String> moveHorizontally(ChessBoard board, String position) {
    List<String> moves = new ArrayList<>();

    Integer[] positions = getRowColumn(position);
    int row = positions[0];

    for (int col = START_COL; col < START_COL + board.columns(); col++) {
      String newPos = position(row, col);
      if (!newPos.equals(position)) {
        moves.add(newPos);
      }
    }

    return moves;
  }

  public List<String> moveVertically(ChessBoard board, String position) {
    List<String> moves = new ArrayList<>();

    Integer[] positions = getRowColumn(position);
    int col = positions[1];

    for (int row = 1; row <= board.rows(); row++) {
      String newPos = position(row, col);
      if (!newPos.equals(position)) {
        moves.add(newPos);
      }
    }

    return moves;
  }

  /**
   * Across diagonal 1 \ \ \
   */
  public List<String> moveDiagonal1(ChessBoard board, String position) {
    List<String> moves = new ArrayList<>();

    Integer[] positions = getRowColumn(position);
    int col = positions[1];
    int row = positions[0];

    while (row < board.columns()) {
      row--;
      col++;
      if (!isValidMove(board, row, col)) {
        break;
      }
      String newPos = position(row, col);
      if (!newPos.equals(position)) {
        moves.add(newPos);
      }
    }

    col = positions[1];
    row = positions[0];

    while (col < START_COL + board.columns()) {
      row++;
      col--;
      if (!isValidMove(board, row, col)) {
        break;
      }
      String newPos = position(row, col);
      if (!newPos.equals(position)) {
        moves.add(newPos);
      }
    }

    return moves;
  }

  /**
   * Across diagonal 2 / / /
   */
  public List<String> moveDiagonal2(ChessBoard board, String position) {
    List<String> moves = new ArrayList<>();

    Integer[] positions = getRowColumn(position);
    int col = positions[1];
    int row = positions[0];

    while (row < board.columns()) {
      row++;
      col++;
      if (!isValidMove(board, row, col)) {
        break;
      }
      String newPos = position(row, col);
      if (!newPos.equals(position)) {
        moves.add(newPos);
      }
    }
    col = positions[1];
    row = positions[0];

    while (col < START_COL + board.columns()) {
      row--;
      col--;
      if (!isValidMove(board, row, col)) {
        break;
      }
      String newPos = position(row, col);
      if (!newPos.equals(position)) {
        moves.add(newPos);
      }
    }

    return moves;
  }

  public Integer[] getRowColumn(String position) {
    int row = Integer.parseInt(position.substring(1));
    int column = Character.toUpperCase(position.charAt(0));

    return new Integer[]{row, column};
  }

  public boolean isValidMove(ChessBoard board, Integer row, Integer col) {
    return row <= board.rows() && row > 0 && col < START_COL + board.columns() && col >= START_COL;
  }

  public String position(int row, int col) {
    return (char) col + String.valueOf(row);
  }

}
