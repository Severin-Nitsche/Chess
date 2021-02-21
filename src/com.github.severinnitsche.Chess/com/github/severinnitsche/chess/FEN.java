package com.github.severinnitsche.chess;

import com.github.severinnitsche.algebraic_data_types.List;

public record FEN(Board placement, boolean white, boolean K, boolean Q, boolean k, boolean q, int en_passant, int halfmove, int fullmove) {

  public static FEN FEN(String fen) {
    var components = fen.split(" ");
    return new FEN(new Board(components[0]), components[1].equals("w"), components[2].contains("K"), components[2].contains("Q"), components[2].contains("k"), components[2].contains("q"), components[3].equals("-") ? -1 : components[3].charAt(0)-'a'+(components[3].charAt(1)-'1')*8, Integer.parseInt(components[4]), Integer.parseInt(components[5]));
  }

  public List<Turn> generateMoves() {
    //generate moves
    var moves = placement.indices().mapToObj(i -> i).reduce((List<Turn>)List.<Turn>Nil(), (list, index) -> index == -1 ? list : generateMoves(list,index), (smøl,big) -> smøl.concat(big));
    //verify moves

    return moves;
  }

  public List<Turn> generateMoves(List<Turn> base, int index) {
    /*final var piece = board.gp(i);
    if(piece instanceof Piece.Pawn pawn)

    else if(piece instanceof Piece.Rook rook)
    else if(piece instanceof Piece.Knight knight)
    else if(piece instanceof Piece.Bishop bishop)
    else if(piece instanceof Piece.Queen queen)
    else if(piece instanceof Piece.King king)
    else*/
      return base;
  }

  @Override
  public String toString() {
    var builder = new StringBuilder();
    return builder.append(placement).append(" ").append(white ? 'w' : 'b').append(" ").append(K ? "K" : "").append(Q ? "Q" : "").append(k ? "k" : "k").append(q ? "q" : "").append(!K&!Q&!k&!q ? "-" : "").append(" ").append(en_passant == -1 ? '-' : (char)(en_passant % 8 + 'a')).append(en_passant == -1 ? "" : Integer.toString(en_passant / 8 + 1)).append(" ").append(halfmove).append(" ").append(fullmove).toString();
  }

}
