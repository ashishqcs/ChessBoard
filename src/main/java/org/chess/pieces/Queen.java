package org.chess.pieces;

import java.util.ArrayList;
import java.util.List;
import org.chess.board.ChessBoard;

public class Queen extends Piece {

  @Override
  public String[] possibleMoves(ChessBoard board, String position) {
    List<String> possibleMoves = new ArrayList<>();
    possibleMoves.addAll(moves.moveHorizontally(board, position));
    possibleMoves.addAll(moves.moveVertically(board, position));
    possibleMoves.addAll(moves.moveDiagonal1(board, position));
    possibleMoves.addAll(moves.moveDiagonal2(board, position));

    return possibleMoves.toArray(new String[0]);
  }
}
