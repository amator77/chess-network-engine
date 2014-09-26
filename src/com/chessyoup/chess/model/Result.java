package com.chessyoup.chess.model;

public class Result {

	public enum VALUE {
		NO_RESULT, DRAW, WHITE_WIN, BLACK_WIN;

		public String toString() {
			switch (this) {
			case DRAW:
				return "1/2-1/2";
			case WHITE_WIN:
				return "1-0";
			case BLACK_WIN:
				return "0-1";

			default:
				return "*";
			}
		}
	}

	public enum REASON {
		DRAW_BY_AGREEMENT, DRAW_BY_REPETITION, DRAY_BY_50_RULE, MATE, RESIGN, FLAG, ABORTED;

		public String toString() {
			switch (this) {
			case DRAW_BY_AGREEMENT:
				return "draw_by_agreement";
			case DRAW_BY_REPETITION:
				return "draw_by_repetition";
			case DRAY_BY_50_RULE:
				return "draw_by_50_rule";
			case MATE:
				return "#";
			case RESIGN:
				return "resign";
			case FLAG:
				return "flag";
			default:
				return "aborted";
			}
		}
	}

	private VALUE value;

	private REASON reason;

	public Result(VALUE value, REASON reason) {
		this.value = value;
		this.reason = reason;
	}

	public VALUE getValue() {
		return this.value;
	}

	public REASON getReason() {
		return this.reason;
	}
	
	public String toString(){
		return this.value.toString() +" "+reason.toString();
	}
}