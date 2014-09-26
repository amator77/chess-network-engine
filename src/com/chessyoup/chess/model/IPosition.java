package com.chessyoup.chess.model;

public interface IPosition {

	public IPiece getPieceAt(ISquare square);

	public Color getActiveColor();
	
	public ISquare getEnpassantSquare();	
	
	public boolean isWhiteKingSideCastleAvailable();
	
	public boolean isWhiteQueenSideCastleCastleAvailable();
	
	public boolean isBlackKingSideCastleAvailable();
	
	public boolean isBlackQueenSideCastleAvailable();
		
	public int getHalfMoveClock();
	
	public int getFullMoveNumber();
}