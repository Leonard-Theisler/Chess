package Pieces;

public class Position {
	private int x;
	private int y;
	
	public Position(int x, int y) {
		setX(x);
		setY(y);
	}
	
	public Position(){}
	
	public int getX() {
		return this.x;
	}
	
	public int getY() {
		return this.y;
	}
	
	public void setX(int x) {
		this.x = x;
	}
	
	public void setY(int y) {
		this.y = y;
	}
	
	public Boolean isWhitePawnInitialPosition() {
		if (y == 1 && (x<=7 && x>=0 )) {
			return true;
		}
		return false;
	}
	
	public Boolean isBlackPawnInitialPosition() {
		if (y == 6 && (x<=7 && x>=0 )) {
			return true;
		}
		return false;
	}
	

}
