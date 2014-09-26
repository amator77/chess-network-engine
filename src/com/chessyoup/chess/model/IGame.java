package com.chessyoup.chess.model;

import java.util.List;

public interface IGame {
	
	public interface GameListener {
		
		public void onMove(IGame source , IMove move);
		
		public void onResult(IGame source);					
	}
		
	public List<IMove> getMoves();

	public IPosition getCurrentPosition();
			
	public Result getResult();
	
	public void setResult(Result result);
	
	public void doMove(IMove move);

	public void addGameListener(GameListener listener);
	
	public void removeGameListener(GameListener listener);
	
	public void reset();
	
	public void goToStart();
	
	public void goToEnd();
	
	public void goForward();
	
	public void goBack();
	
	public void jumpTo(int moveIndex);
}
