package Pieces;

public abstract class Piece {
	
	private Position pos = new Position();
	private Boolean dead;
	
	public Boolean getDead() {
		return dead;
	}
	
	public void setDead(Boolean b) {
		this.dead = b;
	}
	
	public Position getPosition() {
		return new Position(this.pos.getX(), this.pos.getY());
	}
	
	public void setPosition(Position p) {
		this.pos.setX(p.getX());
		this.pos.setY(p.getY());
	}
	
	protected abstract Boolean isValidMove(Position p);
	public abstract void move(Position p);

}
