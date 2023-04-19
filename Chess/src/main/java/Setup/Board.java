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
	
	public Cell getCellAt(Position p) {
		return matrix[p.getX()][p.getY()];
	}
	
	public Boolean hasPieceAt(Position p) {
		return getCellAt(p).piece != null;
		
	}
	
	public void setPieceAt(Piece p, Position pos)
	{
		getCellAt(pos).piece = p;
		p.setPosition(pos);
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
		else if (p instanceof King) {
			King king = (King) p;
			return isCastleLegal(king, oldPos, newPos);
			
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
	
	public Boolean isCastleLegal(King king, Position oldPos, Position newPos) {
		if (king.isThreatened(this, oldPos, oldPos)) {
			return false;
		}
		else if (king.isAtInitialPosition() && oldPos.getX()-newPos.getX() < 0 ) {
			Piece piece = getPieceAt(new Position(oldPos.getX()+3, oldPos.getY()));
			if (piece instanceof Rook) {
				Rook rook = (Rook) piece;
				if (king.canCastle(this, newPos, rook)) {
					Position pos = rook.getPosition();
					setPieceAt(rook, new Position(rook.getPosition().getX()-2, rook.getPosition().getY()));
					removePieceAt(pos);
					return true;
				}
			}
		}
		else if (king.isAtInitialPosition() && oldPos.getX()-newPos.getX() > 0 ) {
			Piece piece = getPieceAt(new Position(oldPos.getX()-4, oldPos.getY()));
			if (piece instanceof Rook) {
				Rook rook = (Rook) piece;
				if (king.canCastle(this, newPos, rook)) {
					Position pos = rook.getPosition();
					setPieceAt(rook, new Position(rook.getPosition().getX()+3, rook.getPosition().getY()));
					removePieceAt(pos);
					return true;
				}
			}
		}
		return false;
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
