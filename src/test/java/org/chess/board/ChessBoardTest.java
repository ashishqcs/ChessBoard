package org.chess.board;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.Test;

class ChessBoardTest {

  private ChessBoard chessBoard = new ChessBoard();

  @Test
  void testPossibleMoves() {
    String[] expectedMoves = new String[]{"G6", "G4", "F5", "H5", "F6", "H6", "F4", "H4"};

    String[] actualMoves = chessBoard.possibleMoves("King", "G5");

    assertThat(expectedMoves).isEqualTo(actualMoves);
  }

  @Test
  void testInvalidPieceInPossibleMoves() {
    assertThatThrownBy(() -> chessBoard.possibleMoves("Kingo", "G5"))
        .isInstanceOf(RuntimeException.class)
        .hasMessage("Invalid piece: Kingo");
  }
}