package Pieces;

public abstract class Piece {
	
	private Position pos;
	
	private Position getPosition() {
		return this.pos;
	}
	
	protected abstract Boolean isValidMove();
	
}
