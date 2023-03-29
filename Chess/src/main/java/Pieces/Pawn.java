package Pieces;

public class Pawn extends Piece{
	
	public Pawn(Position p, Boolean b) {
		setPosition(p);
		setDead(false);
		setWhite(b);
	}
	

	public Boolean isValidMove(Position newPos) {
		
		Position oldPos = getPosition();
		
		if ( (oldPos.getX() == newPos.getX()) && getWhite() && (newPos.getY() - oldPos.getY() == 1)
			|| (oldPos.getX() == newPos.getX()) && !getWhite() && (newPos.getY() - oldPos.getY() == -1)
			|| (oldPos.getX() == newPos.getX()) && getWhite() && (newPos.getY() - oldPos.getY() == 2) && oldPos.isWhitePawnInitialPosition()
			|| (oldPos.getX() == newPos.getX()) && !getWhite() && (newPos.getY() - oldPos.getY() == -2) && oldPos.isBlackPawnInitialPosition()
				) {
			return true;
		}
		
		else {return false;}
	};
	
}
