package Pieces;

import Setup.Board;

public class Rook extends Piece{
	
	private Boolean initialPosition = true;
	
	public Rook(Position p) {
		setPosition(p);
		initialPosition = true;
	}
	
	public Rook(Position p, Boolean b) {
		setPosition(p);
		setWhite(b);
	}
	
	public Boolean isAtInitialPosition(){
		return initialPosition;
	}
	public Boolean isValidMove(Position p, Board b) {
		
		Position pos = getPosition();
		if ( ((pos.getX() == p.getX() && pos.getY() != p.getY()) || ((pos.getX() != p.getX() && pos.getY() == p.getY()))) && (b.getPieceAt(p) == null || b.getPieceAt(p).getWhite() != this.getWhite()) ) {
			initialPosition = false;
			return true;
		}
		
		else {return false;}
	};

}
