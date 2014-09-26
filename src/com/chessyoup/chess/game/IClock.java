package com.chessyoup.chess.game;

import com.chessyoup.chess.model.Color;
import com.chessyoup.chess.model.ITimeControll;


public interface IClock {
	
	public interface ClockListener {
		
		public void onStop(IClock source);
		
		public void onTimeUpdate(IClock source);
		
		public void onClockPress(IClock source);
		
		public void onFlag(IClock source,Color color);
	}
	
	public enum STATE { NOT_RUNNING , RUNNING }
	
	public ITimeControll getTimeControll();
	
	public STATE getState();
	
	public void press();
	
	public void start();
	
	public void stop();
	
	public Color getRunningColor(); 
	
	public void reset(ITimeControll timeControll);
	
	public long getWhiteTime();
	
	public long getBlackTime();
	
	public void addClockListener();
	
	public void removeClockListener();
}
