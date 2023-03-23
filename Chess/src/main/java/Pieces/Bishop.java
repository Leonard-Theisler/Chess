package Pieces;
import java.lang.Math;

public class Bishop extends Piece {
	
	public Bishop(Position p) {
		setPosition(p);
		setDead(false);
	}
	
	protected Boolean isValidMove(Position p) {
		
		Position pos = getPosition();
		if (Math.abs(pos.getX() - p.getX()) == Math.abs(pos.getY() - p.getY()) ) {
			return true;
		}
		
		else {return false;}
	};
	
	protected void move(Position p) {
		if (isValidMove(p)) {setPosition(p);}
	};


}
