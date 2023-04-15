package Pieces;

import Setup.Board;

public class King extends Piece{
	
	public King(Position p) {
		setPosition(p);
	}
	
	public King(Position p, Boolean b) {
		setPosition(p);
		setWhite(b);
	}
	
	public Boolean isValidMove(Position p, Board b) {
		
		Position pos = getPosition();
		if ((((Math.abs(pos.getX() - p.getX()) <=1) && Math.abs(pos.getY() - p.getY()) <= 1) && (b.getPieceAt(p) == null || b.getPieceAt(p).getWhite() != this.getWhite()) ) && !isThreatened(b, p, pos) && !isProtected(b, p)) {
			return true;
		}
		
		else {return false;}
	};
	
	

}
