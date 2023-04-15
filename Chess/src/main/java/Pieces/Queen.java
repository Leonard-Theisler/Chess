package Pieces;

import Setup.Board;

public class Queen extends Piece{
	public Queen(Position p) {
		setPosition(p);
	}
	
	public Queen(Position p, Boolean b) {
		setPosition(p);
		setWhite(b);
	}
	
	public Boolean isValidMove(Position p, Board b) {
		
		Bishop bish = new Bishop(getPosition(), getWhite());
		Rook r = new Rook(getPosition(), getWhite());

		if (r.isValidMove(p, b) || bish.isValidMove(p, b)) {
			return true;
		}
		
		else {return false;}
	};

}
