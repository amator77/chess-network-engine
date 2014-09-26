package com.chessyoup.chess.game.impl;

import com.chessyoup.chess.game.IChessGame;
import com.chessyoup.chess.game.IClock;
import com.chessyoup.chess.game.IGameService;
import com.chessyoup.chess.game.IPlayer;
import com.chessyoup.chess.game.ui.IChessGameUI;
import com.chessyoup.chess.model.Color;
import com.chessyoup.chess.model.IGame;

public class ChessGameImpl implements IChessGame {

	public String gameId;

	public IGame game;

	public IPlayer whitePlayer;

	public IPlayer blackPlayer;

	public IClock clock;

	public OFFER lastOffer;

	public STATE state;

	public ChessGameImpl(String gameId, IGame game) {
		this.gameId = gameId;
		this.game = game;
		this.whitePlayer = null;
		this.blackPlayer = null;
		this.lastOffer = null;
		this.state = STATE.NOT_READY;
	}

	@Override
	public String getId() {
		return this.gameId;
	}

	@Override
	public IGame getGame() {
		return this.game;
	}

	@Override
	public void setPlayer(IPlayer player, Color color) {
		switch (color) {
		case WHITE:
			this.whitePlayer = player;
			break;
		case BLACK:
			this.blackPlayer = player;
			break;
		default:
			break;
		}
	}

	@Override
	public IPlayer getWhitePlayer() {
		return this.whitePlayer;
	}

	@Override
	public IPlayer getBlackPlayer() {
		return this.blackPlayer;
	}

	@Override
	public OFFER getLastOffer() {
		return null;
	}

	@Override
	public IClock getClock() {
		return this.clock;
	}

	@Override
	public IGameService getGameService() {
		return null;
	}

	@Override
	public STATE getState() {
		return this.state;
	}

	@Override
	public IChessGameUI getGameUI() {
		// TODO Auto-generated method stub
		return null;
	}
}
