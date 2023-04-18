package Pieces;

import Setup.Board;

public class King extends Piece{
	
	private Boolean initialPosition = true;
	
	public King(Position p) {
		setPosition(p);
		initialPosition = true;
	}
	
	public King(Position p, Boolean b) {
		setPosition(p);
		setWhite(b);
	}
	
	public Boolean isAtInitialPosition(){
		return initialPosition;
	}
	
	public Boolean isValidMove(Position p, Board b) {
		
		Position pos = getPosition();
		if ((((Math.abs(pos.getX() - p.getX()) <=1) && Math.abs(pos.getY() - p.getY()) <= 1) && (b.getPieceAt(p) == null || b.getPieceAt(p).getWhite() != this.getWhite()) ) && !isThreatened(b, p, pos) && !isProtected(b, p)) {
			boolean initialPositon = false;
			return true;
		}
		
		else {return false;}
	};
	
	public Boolean canCastle(Board b, Position pos, Rook r) {
		if((initialPosition && r.isAtInitialPosition()) && getWhite()==r.getWhite()) {
			if (Math.abs(getPosition().getX() - r.getPosition().getX()) == 3) {
				for (int i=1; i<3; i++) {
					if (b.getPieceAt(new Position(getPosition().getX()+i, getPosition().getY())) != null) {
						return false;
					}
				}
			}
			if (Math.abs(getPosition().getX() - r.getPosition().getX()) == 4) {
				for (int i=1; i<4; i++) {
					if (b.getPieceAt(new Position(getPosition().getX()-i, getPosition().getY())) != null) {
						return false;
					}
				}
			}
			if (Math.abs(pos.getX()-getPosition().getX()) == 2) {
				return true;
			}
		}
		return false;
	}
	
	

}
