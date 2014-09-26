package com.chessyoup.chess.model;

public interface IPiece {
		
	public enum PieceType {
		KING, QUEEN, ROOK, KNIGHT, BISHOP, PAWN
	}

	public Color getColor();

	public PieceType getType();
}
