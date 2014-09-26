package com.chessyoup.chess.game.network.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.logging.Logger;

import com.chessyoup.chess.game.IChessGame;
import com.chessyoup.chess.game.IPlayer;
import com.chessyoup.chess.game.impl.ChessGameImpl;
import com.chessyoup.chess.game.network.INetworkGame;
import com.chessyoup.chess.game.network.ITransport;
import com.chessyoup.chess.game.network.ITransport.TransportListener;
import com.chessyoup.chess.game.network.messages.IMessage;
import com.chessyoup.chess.model.IGame;

public class NetworkGameImpl extends ChessGameImpl implements INetworkGame,
		TransportListener {

	private static final Logger LOG = Logger.getLogger(NetworkGameImpl.class
			.getName());

	private IPlayer localPlayer;

	private IPlayer remotePlayer;

	private ITransport transport;

	public List<NetworkGameListener> listeners;

	public NetworkGameImpl(String gameId, IGame game, IPlayer localPlayer,
			ITransport transport) {
		super(gameId, game);
		this.localPlayer = localPlayer;
		this.transport = transport;
		this.transport.addTransportListener(this);
		this.listeners = new ArrayList<INetworkGame.NetworkGameListener>();
	}

	@Override
	public IPlayer getLocalPlayer() {
		return this.localPlayer;
	}

	@Override
	public IPlayer getRemotePlayer() {
		return this.remotePlayer;
	}

	@Override
	public IChessGame getChessGame() {
		return this;
	}

	@Override
	public ITransport getTransport() {
		return this.transport;
	}

	@Override
	public void addNetworkGameListener(NetworkGameListener listener) {

		if (!this.listeners.contains(listener)) {
			this.listeners.add(listener);
		}
	}

	@Override
	public void removeNetworkGameListener(NetworkGameListener listener) {
		if (this.listeners.contains(listener)) {
			this.listeners.remove(listener);
		}
	}
	
	@Override
	public boolean isRemotePlayerConnected() {
		return this.remotePlayer != null;
	}
	
	@Override
	public void onMessageReceived(IMessage message) {
		LOG.info("onMessageReceived :: " + message.toString());

		switch (message.getCommand()) {
		case CONNECT :
			this.handleConnectMessage(message);
			break;
//		case MOVE:
//			this.handleMoveMessage(message);
//			break;
//		case CHAT:
//			this.handleChatMessage(message);
//			break;
//		case DISCONNECT :
//			this.handleDisconnectMessage(message);			
//			break;
		default:
			break;
		}
	}
	
	private void handleConnectMessage(IMessage message) {
		this.remotePlayer = getPlayer(message.getPayload());
		
		for(NetworkGameListener listener : listeners){
			listener.onRemotePlayerConnected();
		}
	}
	
	private IPlayer getPlayer(Map<String, String> data) {
		// TODO Auto-generated method stub
		return null;
	}

	private void handleChatMessage(IMessage message) {
		
		for(NetworkGameListener listener : listeners){
			listener.onChatReceived(message.toString());
		}
	}

//	private void handleMoveMessage(MoveMessage message) {
//		
//		for(NetworkGameListener listener : listeners){
//			listener.onMoveRecevied(message.getMove());
//		}
//	}
//	
//	private void handleDisconnectMessage(DisconnectMessage message) {
//		
//		this.remotePlayer = null;
//		
//		for(NetworkGameListener listener : listeners){
//			listener.onRemotePlayerDisconect();
//		}		
//	}		
}
