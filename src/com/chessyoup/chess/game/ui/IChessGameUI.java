package com.chessyoup.chess.game.ui;

import com.chessyoup.chess.game.IChessGame;
import com.chessyoup.chess.game.IPlayer;

public interface IChessGameUI {
	
	public interface ChessGameUIListener{
		
	}
	
	public IPlayer getPlayerById(String playerId);
	
	public IChessGame getChessGame();
	
	public void addChessGameUIListener(ChessGameUIListener listener);
	
	public void removeChessGameUIListener(ChessGameUIListener listener);	
}
