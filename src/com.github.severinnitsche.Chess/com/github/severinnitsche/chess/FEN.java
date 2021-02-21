package com.github.severinnitsche.chess;

public record FEN(Board placement, boolean white, boolean K, boolean Q, boolean k, boolean q, int en_passant, int halfmove, int fullmove) {

  public static FEN FEN(String fen) {
    var components = fen.split(" ");
    return new FEN(new Board(components[0]), components[1].equals("w"), components[2].contains("K"), components[2].contains("Q"), components[2].contains("k"), components[2].contains("q"), components[3].equals("-") ? -1 : components[3].charAt(0)-'a'+(components[3].charAt(1)-'1')*8, Integer.parseInt(components[4]), Integer.parseInt(components[5]));
  }

  @Override
  public String toString() {
    var builder = new StringBuilder();
    return builder.append(placement).append(" ").append(white ? 'w' : 'b').append(" ").append(K ? "K" : "").append(Q ? "Q" : "").append(k ? "k" : "k").append(q ? "q" : "").append(!K&!Q&!k&!q ? "-" : "").append(" ").append(en_passant == -1 ? '-' : (char)(en_passant % 8 + 'a')).append(en_passant == -1 ? "" : Integer.toString(en_passant / 8 + 1)).append(" ").append(halfmove).append(" ").append(fullmove).toString();
  }

}
