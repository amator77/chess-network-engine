package com.chessyoup.chess.game.network;

import com.chessyoup.chess.game.IChessGame;
import com.chessyoup.chess.game.IPlayer;
import com.chessyoup.chess.model.IMove;

public interface INetworkGame {
	
	public interface NetworkGameListener {
		
		public void onRemotePlayerConnected();
		
		public void onRemotePlayerDisconect();
		
		public void onReadyRecevied();

		public void onMoveRecevied(IMove move);

		public void onOfferReceived();

		public void onChatReceived(String chatMessage);

		public void onResignRecevied();

		public void onFlagRecevied();

		public void onExitRecevied();
	}
	
	public IPlayer getLocalPlayer();
	
	public IPlayer getRemotePlayer();
	
	public boolean isRemotePlayerConnected();
	
	public IChessGame getChessGame();
	
	public ITransport getTransport();
	
	public void addNetworkGameListener(NetworkGameListener listener);
	
	public void removeNetworkGameListener(NetworkGameListener listener);
}
