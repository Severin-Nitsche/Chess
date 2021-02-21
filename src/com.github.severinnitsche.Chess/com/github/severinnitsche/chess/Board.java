package com.github.severinnitsche.chess;

import java.util.function.IntFunction;
import java.util.function.Consumer;

public class Board {

  private final Piece[] board = new Piece[64];

  public IntFunction<Piece> get(char file) {
    return rank -> board[(rank-1)*8+file-'a'];
  }

  public IntFunction<Piece> get(int rank) {
    return file -> get((char)file).apply(rank);
  }

  public Board(String SAN) {
    SAN.chars().mapToObj(
      i -> switch(i) {
        case 'r' -> new Piece.Rook(false);
        case 'R' -> new Piece.Rook(true);
	case 'n' -> new Piece.Knight(false);
	case 'N' -> new Piece.Knight(true);
	case 'b' -> new Piece.Bishop(false);
	case 'B' -> new Piece.Bishop(true);
	case 'q' -> new Piece.Queen(false);
	case 'Q' -> new Piece.Queen(true);
	case 'k' -> new Piece.King(false);
	case 'K' -> new Piece.King(true);
	case 'p' -> new Piece.Pawn(false);
	case 'P' -> new Piece.Pawn(true);
	case '1','2','3','4','5','6','7','8' -> new Integer(i-'1'+1);
	default -> new Integer(0);
      }
    ).forEach(
      new Consumer<Object>() {
        int i = 0;
	public void accept(Object obj) {
          if(obj instanceof Piece piece)
            board[i++] = piece;
	  else
            i += (int)obj;
	}
      }
    );
  }

  @Override
  public String toString() {
    var builder = new StringBuilder();
    for(int rank = 1; rank <= 8; rank++) {
      var empty = 0;
      for(char file = 'a'; file <= 'h'; file++) {
        if(get(rank).apply(file) instanceof Piece piece) {
	  if(empty != 0) {
	    builder.append(empty);
	    empty = 0;
	  } 
          builder.append(piece);
	} else
	  empty++; 
      }
      if(empty != 0)
        builder.append(empty);
      builder.append('/');
    }
    return builder.toString();
  }

}
