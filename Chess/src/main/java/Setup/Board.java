package Setup;

import Pieces.Piece;

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

}
