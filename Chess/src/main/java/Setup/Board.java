package Setup;

import Pieces.Piece;
import Pieces.Bishop;
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
	
	private void movePiece(Piece p, Position pos) {
		
	};
	
	
}
