package com.chessyoup.chess.game;

import com.chessyoup.chess.game.ui.IChessGameUI;
import com.chessyoup.chess.model.Color;
import com.chessyoup.chess.model.IGame;

public interface IChessGame {

	public enum STATE {
		NOT_READY, READY, IN_PROGRESS
	}

	public enum OFFER {
		DRAW, ABORT, REMATCH
	}

	public String getId();

	public IGame getGame();

	public void setPlayer(IPlayer player, Color color);

	public IPlayer getWhitePlayer();

	public IPlayer getBlackPlayer();
	
	public OFFER getLastOffer();
	
	public IClock getClock();

	public IChessGameUI getGameUI();

	public IGameService getGameService();

	public STATE getState();
}
