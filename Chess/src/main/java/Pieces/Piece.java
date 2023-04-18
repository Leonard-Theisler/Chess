package Pieces;

import Setup.Board;

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
	
	public Boolean isThreatened(Board b, Position p, Position kingPos) {
		
		for (int i = 0; i<8; i++) {
			for (int j = 0; j<8; j++) {
				Position pos = new Position (i, j);
				if (b.hasPieceAt(pos) && pos.getX() != kingPos.getX()){
					if (b.getPieceAt(pos).isValidMove(p, b)) {
						return true;
					}
				}
				pos = null;
			}
		}
		return false;
		
	}
	
	protected Boolean isProtected(Board b, Position p) {
		
		for (int i = 0; i<8; i++) {
			for (int j = 0; j<8; j++) {
				Position pos = new Position (i, j);
				if (b.hasPieceAt(p) && b.hasPieceAt(pos) && pos.getX() != p.getX()){
					b.getPieceAt(p).setWhite(!b.getPieceAt(p).getWhite());
					if (b.getPieceAt(pos).isValidMove(p, b)) {
						b.getPieceAt(p).setWhite(!b.getPieceAt(p).getWhite());
						return true;
					}
					b.getPieceAt(p).setWhite(!b.getPieceAt(p).getWhite());
				}
				pos = null;
			}
		}
		return false;
		
	}
	
	public abstract Boolean isValidMove(Position p, Board b);

}
