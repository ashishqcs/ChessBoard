package org.chess.pieces;

import static org.assertj.core.api.Assertions.assertThat;

import org.chess.board.ChessBoard;
import org.junit.jupiter.api.Test;

class KingTest {

  King king = new King();

  @Test
  void testPossibleMove() {
    String[] expectedMoves = new String[]{"G6", "G4", "F5", "H5", "F6", "H6", "F4", "H4"};

    String[] actualMoves = king.possibleMoves(new ChessBoard(), "G5");

    assertThat(expectedMoves).isEqualTo(actualMoves);

  }
}