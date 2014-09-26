package com.chessyoup.chess.game;

import com.chessyoup.chess.game.IChessGame.OFFER;
import com.chessyoup.chess.model.IGame;
import com.chessyoup.chess.model.IMove;

public interface IPlayer {
	
	public interface PlayerListener {
		
		public void onMove(IGame game, IMove move);
		
		public void onOffer(IGame game,OFFER offer);
		
		public void onResign(IGame game);
	}
	
	public String getPlayerId();
	
	public IRating getRating(IRating.TYPE type);
	
	public void updateRating(IRating.TYPE type, double newRating);
	
	public void addPlayerListener(PlayerListener listener);
	
	public void removePlayerListener(PlayerListener listener);
}
