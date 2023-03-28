package Pieces;

public class Pawn extends Piece{
	
	public Pawn(Position p, Boolean b) {
		setPosition(p);
		setDead(false);
		setWhite(b);
	}
	
	protected Boolean isValidMove(Position p) {
		
		Position pos = getPosition();
		if ( (pos.getX() == p.getX()) && getWhite() && (p.getY() - pos.getY() == 1)
			|| (pos.getX() == p.getX()) && !getWhite() && (p.getY() - pos.getY() == -1)	
				) {
			return true;
		}
		
		else {return false;}
	};
	
	public void move(int y) {
		if (isValidMove(new Position(getPosition().getX(), y))) {
			setPosition(new Position(getPosition().getX(), y));
			}
	};



}
