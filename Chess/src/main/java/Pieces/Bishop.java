package Pieces;
import java.lang.Math;

import Setup.Board;

public class Bishop extends Piece {
	
	public Bishop(Position p) {
		setPosition(p);
	}
	
	public Bishop(Position p, Boolean b) {
		setPosition(p);
		setWhite(b);
	}
	
	public Boolean isValidMove(Position p, Board b) {
		
		Position pos = getPosition();
		if (Math.abs(pos.getX() - p.getX()) == Math.abs(pos.getY() - p.getY()) && (b.getPieceAt(p) == null || b.getPieceAt(p).getWhite() != this.getWhite()) ) {
			return true;
		}
		
		else {return false;}
	};
	
}
