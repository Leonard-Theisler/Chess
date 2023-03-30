package Pieces;

public abstract class Piece {
	
	private Position pos = new Position();
	private Boolean white;
	

	public Boolean getWhite() {
		return white;
	}
	
	public void setWhite(Boolean b) {
		white = b;
	}
		
	public Position getPosition() {
		return new Position(this.pos.getX(), this.pos.getY());
	}
	
	public void setPosition(Position p) {
		this.pos.setX(p.getX());
		this.pos.setY(p.getY());
	}
	
	public abstract Boolean isValidMove(Position p);

}
