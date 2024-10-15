package org.chess.board;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.List;
import org.chess.board.Moves.Direction;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

class MovesTest {

  private final Moves moves = new Moves();
  private final ChessBoard board = new ChessBoard();

  @ParameterizedTest
  @CsvSource({
      "B5, UP, B6", "H1, UP, H2", "A8, UP, ",
      "A8, DOWN, A7", "E4, DOWN, E3", "E1, DOWN, ",
      "B6, LEFT, A6", "H1, LEFT, G1", "A4, LEFT, ",
      "B6, RIGHT, C6", "A4, RIGHT, B4", "H4, RIGHT, ",
      "B6, UPPER_LEFT, A7", "A4, UPPER_LEFT, ", "H4, UPPER_LEFT, G5",
      "B6, LOWER_LEFT, A5", "A4, LOWER_LEFT, ", "H4, LOWER_LEFT, G3",
      "B6, UPPER_RIGHT, C7", "A4, UPPER_RIGHT, B5", "H4, UPPER_RIGHT, ",
      "B6, LOWER_RIGHT, C5", "A4, LOWER_RIGHT, B3", "H2, LOWER_RIGHT, ",
  })
  void testMoveOneStep(String position, String direction, String expectedPos) {

    String actualPos = moves.moveOneStep(board, position, Direction.valueOf(direction));

    assertEquals(expectedPos, actualPos);
  }

  @Test
  void testMoveHorizontally() {
    List<String> expectedMoves = List.of("A5", "B5", "C5", "D5", "E5", "G5", "H5");

    List<String> actualMoves = moves.moveHorizontally(board, "F5");

    assertEquals(expectedMoves, actualMoves);
  }

  @Test
  void testMoveVertically() {
    List<String> expectedMoves = List.of("F1", "F2", "F3", "F4", "F6", "F7", "F8");

    List<String> actualMoves = moves.moveVertically(board, "F5");

    assertEquals(expectedMoves, actualMoves);
  }

  @Test
  void testMoveDiagonal1() {
    List<String> expectedMoves = List.of("E3", "F2", "G1", "C5", "B6", "A7");
    List<String> actualMoves = moves.moveDiagonal1(board, "D4");
    assertEquals(expectedMoves, actualMoves);

    expectedMoves = List.of("G5", "H4", "E7", "D8");
    actualMoves = moves.moveDiagonal1(board, "F6");
    assertEquals(expectedMoves, actualMoves);
  }

  @Test
  void testMoveDiagonal2() {
    List<String> expectedMoves = List.of("E5", "F6", "G7", "H8", "C3", "B2", "A1");
    List<String> actualMoves = moves.moveDiagonal2(board, "D4");
    assertEquals(expectedMoves, actualMoves);

    expectedMoves = List.of("F4", "G5", "H6", "D2", "C1");
    actualMoves = moves.moveDiagonal2(board, "E3");
    assertEquals(expectedMoves, actualMoves);

    expectedMoves = List.of("D7", "E8", "B5", "A4");
    actualMoves = moves.moveDiagonal2(board, "C6");
    assertEquals(expectedMoves, actualMoves);
  }

  @Test
  void testGetRowColumn() {
    Integer[] position = moves.getRowColumn("E4");

    assertEquals('A' + 4, position[1]);
    assertEquals(4, position[0]);
  }


  @Test
  void testPosition() {
    String position = moves.position(4, 69);
    assertEquals("E4", position);
  }

  @ParameterizedTest
  @ValueSource(strings = {
      "A8", "B8", "C8", "D8", "E8", "F8", "G8", "H8",
      "A7", "B7", "C7", "D7", "E7", "F7", "G7", "H7",
      "A6", "B6", "C6", "D6", "E6", "F6", "G6", "H6",
      "A5", "B5", "C5", "D5", "E5", "F5", "G5", "H5",
      "A4", "B4", "C4", "D4", "E4", "F4", "G4", "H4",
      "A3", "B3", "C3", "D3", "E3", "F3", "G3", "H3",
      "A2", "B2", "C2", "D2", "E2", "F2", "G2", "H2",
      "A1", "B1", "C1", "D1", "E1", "F1", "G1", "H1"
  })
  void testValidMove(String move) {
    Integer row = Integer.valueOf(move.substring(1));
    Integer col = (int) move.charAt(0);
    assertTrue(moves.isValidMove(board, row, col));
  }

  @ParameterizedTest
  @ValueSource(strings = {
      "A9", "A0", "H0", "H9", "I1", "Z3", "a1", "a6"})
  void testInValidMove(String move) {
    Integer row = Integer.valueOf(move.substring(1));
    Integer col = (int) move.charAt(0);
    assertFalse(moves.isValidMove(board, row, col));
  }

}