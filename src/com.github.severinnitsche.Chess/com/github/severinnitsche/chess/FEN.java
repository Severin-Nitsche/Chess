package com.github.severinnitsche.chess;

public record FEN(Board placement, boolean white, int castling, int en_passant, int halfmove, int fullmove) {
  
}
