package Pieces;

import Setup.Board;

public class Knight extends Piece{
	
	public Knight(Position p) {
		setPosition(p);
	}
	
	public Knight(Position p, Boolean b) {
		setPosition(p);
		setWhite(b);
	}
	
	public Boolean isValidMove(Position p, Board b) {
		
		Position pos = getPosition();	
		if (((Math.abs(pos.getX() - p.getX()) == 2 && Math.abs(pos.getY() - p.getY()) == 1) || (Math.abs(pos.getX() - p.getX()) == 1 && Math.abs(pos.getY() - p.getY()) == 2)) && ((b.getPieceAt(p) == null || b.getPieceAt(p).getWhite() != this.getWhite()))){
			return true;
		}
		
		else {return false;}
	};

}
