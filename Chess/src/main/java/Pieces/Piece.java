package Pieces;

public abstract class Piece {
	
	private Position pos;
	private Boolean dead;
	
	public Boolean getDead() {
		return dead;
	}
	
	public void setDead(Boolean b) {
		this.dead = b;
	}
	
	protected Position getPosition() {
		return this.pos;
	}
	
	protected void setPosition(Position p) {
		this.pos.setX(p.getX());
		this.pos.setY(p.getY());
	}
	
	protected abstract Boolean isValidMove(Position p);
	protected abstract void move(Position p);

}
