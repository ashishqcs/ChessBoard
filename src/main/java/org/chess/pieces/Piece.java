package org.chess.pieces;

import org.chess.board.ChessBoard;
import org.chess.board.Moves;

public abstract class Piece {

  protected Moves moves;

  protected Piece() {
    this.moves = new Moves();
  }

  public abstract String[] possibleMoves(ChessBoard board, String position);
}
