package com.github.severinnitsche.chess;

public sealed interface Piece permits Piece.Pawn, Piece.Knight, Piece.Bishop, Piece.Rook, Piece.Queen, Piece.King {

  boolean white();

  record Pawn(boolean white) implements Piece {
    @Override
    public String toString() {
      return white ? "P" : "p";
    }
  }
  record Knight(boolean white) implements Piece {
    @Override
    public String toString() {
      return white ? "N" : "n";
    }
  }
  record Bishop(boolean white) implements Piece {
    @Override
    public String toString() {
      return white ? "B" : "b";
    }
  }
  record Rook(boolean white) implements Piece {
    @Override
    public String toString() {
      return white ? "R" : "r";
    }
  }
  record Queen(boolean white) implements Piece {
    @Override
    public String toString() {
      return white ? "Q" : "q";
    }
  }
  record King(boolean white) implements Piece {
    @Override
    public String toString() {
      return white ? "K" : "k";
    }
  }

}
