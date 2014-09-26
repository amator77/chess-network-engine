package com.chessyoup.chess.game.network;

import com.chessyoup.chess.game.network.impl.InMemoryTransport;

public class TransportFactory {
	
	private static ITransport defaultTransport = new InMemoryTransport();
	
	public static ITransport  getDefautlTransport(){
		return defaultTransport;
	}
}
