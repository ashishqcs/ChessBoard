package org.chess.board;

import java.util.Map;
import org.chess.pieces.King;
import org.chess.pieces.Pawn;
import org.chess.pieces.Piece;
import org.chess.pieces.Queen;

/**
 * CHESS BOARD
 * <p>
 *    A   B   C   D   E   F   G   H    <br/>
 * 8  A8  B8  C8  D8  E8  F8  G8  H8   <br/>
 * 7  A7  B7  C7  D7  E7  F7  G7  H7   <br/>
 * 6  A6  B6  C6  D6  E6  F6  G6  H6  <br/>
 * 5  A5  B5  C5  D5  E5  F5  G5  H5   <br/>
 * 4  A4  B4  C4  D4  E4  F4  G4  H4   <br/>
 * 3  A3  B3  C3  D3  E3  F3  G3  H3   <br/>
 * 2  A2  B2  C2  D2  E2  F2  G2  H2   <br/>
 * 1  A1  B1  C1  D1  E1  F1  G1  H1   <br/>
 */
public class ChessBoard {

  public static final int START_COL = 'A';
  private final Piece[][] board = new Piece[8][8];
  private final Map<String, Piece> pieceMap = Map.of(
      "king", new King(),
      "queen", new Queen(),
      "pawn", new Pawn()
  );

  public String[] possibleMoves(String piece, String position) {
    if (!pieceMap.containsKey(piece.toLowerCase())) {
      throw new RuntimeException("Invalid piece: %s".formatted(piece));
    }
    return pieceMap.get(piece.toLowerCase()).possibleMoves(this, position);
  }

  public int rows() {
    return board[0].length;
  }

  public int columns() {
    return board.length;
  }
}
