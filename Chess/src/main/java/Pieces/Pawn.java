package Pieces;

import Setup.Board;

public class Pawn extends Piece{
	
	public Pawn(Position p, Boolean b) {
		setPosition(p);
		setWhite(b);
	}
	

	public Boolean isValidMove(Position newPos, Board b) {
		
		Position oldPos = getPosition();
		
		if ( ((oldPos.getX() == newPos.getX()) && getWhite() && (newPos.getY() - oldPos.getY() == 1)
			|| (oldPos.getX() == newPos.getX()) && !getWhite() && (newPos.getY() - oldPos.getY() == -1)
			|| (oldPos.getX() == newPos.getX()) && getWhite() && (newPos.getY() - oldPos.getY() == 2) && oldPos.isWhitePawnInitialPosition()
			|| (oldPos.getX() == newPos.getX()) && !getWhite() && (newPos.getY() - oldPos.getY() == -2) && oldPos.isBlackPawnInitialPosition())
			&& b.getPieceAt(newPos) == null)
		{return true;}

		else {return false;}
	};
	
	public Boolean canTake(Position oldPos, Position newPos, Board b) {
		if ( ((Math.abs(newPos.getX() - oldPos.getX()) == Math.abs(newPos.getY() - oldPos.getY()) && newPos.getY() - oldPos.getY() == 1) && getWhite() && b.hasPieceAt(newPos) && !b.getPieceAt(newPos).getWhite())
		  || ((Math.abs(newPos.getX() - oldPos.getX()) == Math.abs(newPos.getY() - oldPos.getY()) && newPos.getY() - oldPos.getY() == -1) && !getWhite() && b.hasPieceAt(newPos) && b.getPieceAt(newPos).getWhite()))
			{return true;}
		
		else {return false;}
	}
	
	
	
}
