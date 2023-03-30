package Pieces;
import java.lang.Math;

public class Bishop extends Piece {
	
	public Bishop(Position p) {
		setPosition(p);
	}
	
	public Bishop(Position p, Boolean b) {
		setPosition(p);
		setWhite(b);
	}
	
	public Boolean isValidMove(Position p) {
		
		Position pos = getPosition();
		if (Math.abs(pos.getX() - p.getX()) == Math.abs(pos.getY() - p.getY()) ) {
			return true;
		}
		
		else {return false;}
	};
	



}
