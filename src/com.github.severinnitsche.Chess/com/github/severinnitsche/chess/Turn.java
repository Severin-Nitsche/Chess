package com.github.severinnitsche.chess;

public sealed interface Turn permits Turn.Move, Turn.Castle, Turn.Promote {

  FEN context();

  record Move(FEN context, int start, int stop) implements Turn {}
  record Castle(FEN context, boolean kingside) implements Turn {}
  record Promote(FEN context, Move move, Piece piece) implements Turn {}

}
