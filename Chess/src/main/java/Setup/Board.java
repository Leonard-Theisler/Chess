package Setup;

import Pieces.Piece;
import Pieces.Bishop;
import Pieces.Pawn;
import Pieces.Position;

public class Board {

	private class Cell {
		public Piece piece;
	}
	
	private Cell[][] matrix;

	public Board()
	{
		this.matrix = new Cell[8][8];
		for (int i = 0; i < 8; i++) {
			for (int j = 0; j < 8; j++) {
				matrix[i][j] = new Cell();
			}
		}
	}
	
	private Cell getCell(Position p) {
		return matrix[p.getX()][p.getY()];
	}
	
	public Boolean hasPieceAt(Position p) {
		return getCell(p).piece != null;
		
	}
	
	public void setPieceAt(Piece p, Position pos)
	{
		getCell(pos).piece = p;
	}
	
	public Piece getPieceAt(Position p) {
		return getCell(p).piece;
	}
	
	public Boolean canMove(Piece p, Position oldPos, Position newPos) {
		if (p.isValidMove(newPos, this))
			{return true;}
		else if (p instanceof Pawn) {
			Pawn pawn = (Pawn) p;
			if (pawn.canTake(oldPos, newPos, this)) {
				return true;
			}
		}

		return false;
	}
	
	public void movePiece(Piece p, Position newPos, Position oldPos) {
		if (canMove(p, oldPos, newPos)) {
			removePieceAt(oldPos);
			setPieceAt(p, newPos);
			}
	}
	
	private void removePieceAt(Position p) {
		getCell(p).piece = null;
	}
	
	
}
