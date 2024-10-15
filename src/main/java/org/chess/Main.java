package org.chess;

import java.util.Arrays;
import org.chess.board.ChessBoard;

public class Main {

  public static void main(String[] args) {

    ChessBoard board = new ChessBoard();

    String[] moves = board.possibleMoves("Queen", "G5");

    System.out.println(Arrays.asList(moves));
  }
}