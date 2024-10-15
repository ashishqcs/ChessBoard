package org.chess.pieces;

import org.chess.board.ChessBoard;
import org.chess.board.Moves.Direction;

public class Pawn extends Piece {

  @Override
  public String[] possibleMoves(ChessBoard board, String position) {
    return new String[]{
        moves.moveOneStep(board, position, Direction.UP)
    };
  }
}
