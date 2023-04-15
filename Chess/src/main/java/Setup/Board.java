package Setup;

import Pieces.Piece;

import java.util.ArrayList;

import Pieces.Bishop;
import Pieces.King;
import Pieces.Knight;
import Pieces.Pawn;
import Pieces.Position;
import Pieces.Queen;
import Pieces.Rook;

public class Board {

	private class Cell {
		public Piece piece;
	}
	
	private Cell[][] matrix;
	ArrayList<Piece> backRow;
	ArrayList<Piece> pawnRow;


	public Board()
	{
		matrix = new Cell[8][8];
		for (int i = 0; i < 8; i++) {
			for (int j = 0; j < 8; j++) {
				matrix[i][j] = new Cell();
			}
		}
	}
	
	private Cell getCellAt(Position p) {
		return matrix[p.getX()][p.getY()];
	}
	
	public Boolean hasPieceAt(Position p) {
		return getCellAt(p).piece != null;
		
	}
	
	public void setPieceAt(Piece p, Position pos)
	{
		getCellAt(pos).piece = p;
	}
	
	public Piece getPieceAt(Position p) {
		return getCellAt(p).piece;
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
		getCellAt(p).piece = null;
	}
	
	private ArrayList<Piece> backRowGen(Boolean color) {
		int rowNum;
		backRow = new ArrayList<Piece>();

		if(color) {rowNum = 0;}
		else {rowNum = 7;}
		
		backRow.add(new Rook(new Position(rowNum, 0), color));
		backRow.add(new Knight(new Position(rowNum, 1), color));
		backRow.add(new Bishop(new Position(rowNum, 2), color));
		backRow.add(new Queen(new Position(rowNum, 3), color));
		backRow.add(new King(new Position(rowNum, 4), color));
		backRow.add(new Bishop(new Position(rowNum, 5), color));
		backRow.add(new Knight(new Position(rowNum, 6), color));
		backRow.add(new Rook(new Position(rowNum, 7), color));

		return backRow;
	}
	
	private ArrayList<Piece> pawnRowGen(Boolean color) {
		int rowNum;
		pawnRow = new ArrayList<Piece>();

		if(color) {rowNum = 1;}
		else {rowNum = 6;}
		
		for (int i = 0; i<8; i++) {
			pawnRow.add(new Pawn(new Position(rowNum, i), color));
		}

		return pawnRow;
	}
	
	
	public void boardSetup() {
		for (int i = 0; i<8; i++) {
			matrix[0][i].piece = backRowGen(true).get(i);
			matrix[1][i].piece = pawnRowGen(true).get(i);
			matrix[6][i].piece = pawnRowGen(false).get(i);
			matrix[7][i].piece = backRowGen(false).get(i);

		}
	}
	
	
}
