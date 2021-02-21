package com.github.severinnitsche.chess;

public class Engine {

  public static void main(String[] args) {
    System.out.println(new Board("rnbqkbnr/pppppppp/8/8/8/8/PPPPPPPP/RNBQKBNR"));
    System.out.println(FEN.FEN("rnbqkbnr/pppppppp/8/8/8/8/PPPPPPPP/RNBQKBNR w KQkq - 0 1"));
  }

}
