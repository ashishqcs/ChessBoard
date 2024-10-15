package org.chess.pieces;

import static org.chess.board.Moves.Direction.DOWN;
import static org.chess.board.Moves.Direction.LEFT;
import static org.chess.board.Moves.Direction.LOWER_LEFT;
import static org.chess.board.Moves.Direction.LOWER_RIGHT;
import static org.chess.board.Moves.Direction.RIGHT;
import static org.chess.board.Moves.Direction.UP;
import static org.chess.board.Moves.Direction.UPPER_LEFT;
import static org.chess.board.Moves.Direction.UPPER_RIGHT;

import org.chess.board.ChessBoard;

public class King extends Piece {

  @Override
  public String[] possibleMoves(ChessBoard board, String position) {
    return new String[]{
        moves.moveOneStep(board, position, UP),
        moves.moveOneStep(board, position, DOWN),
        moves.moveOneStep(board, position, LEFT),
        moves.moveOneStep(board, position, RIGHT),
        moves.moveOneStep(board, position, UPPER_LEFT),
        moves.moveOneStep(board, position, UPPER_RIGHT),
        moves.moveOneStep(board, position, LOWER_LEFT),
        moves.moveOneStep(board, position, LOWER_RIGHT)
    };
  }
}
