package Pieces;

import Setup.Board;

public class Rook extends Piece{
	
	public Rook(Position p) {
		setPosition(p);
	}
	
	public Rook(Position p, Boolean b) {
		setPosition(p);
		setWhite(b);
	}
	
	public Boolean isValidMove(Position p, Board b) {
		
		Position pos = getPosition();
		if ( ((pos.getX() == p.getX() && pos.getY() != p.getY()) || ((pos.getX() != p.getX() && pos.getY() == p.getY()))) && (b.getPieceAt(p) == null || b.getPieceAt(p).getWhite() != this.getWhite()) ) {
			return true;
		}
		
		else {return false;}
	};

}
