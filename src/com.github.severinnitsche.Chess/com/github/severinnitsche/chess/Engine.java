package com.github.severinnitsche.chess;

public class Engine {

  public static void main(String[] args) {
    var board = new Board("rnbqkbnr/pppppppp/8/8/8/8/PPPPPPPP/RNBQKBNR");
    var fen = FEN.FEN("rnbqkbnr/pppppppp/8/8/8/8/PPPPPPPP/RNBQKBNR w KQkq - 0 1");
    System.out.println(board);
    System.out.println(fen);
    System.out.println(board.get('d').apply(1));
  }

}
