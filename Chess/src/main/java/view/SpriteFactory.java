package view;

import java.awt.Image;

import Pieces.Bishop;
import Pieces.King;
import Pieces.Knight;
import Pieces.Pawn;
import Pieces.Piece;
import Pieces.Queen;
import Pieces.Rook;
import utils.ImageUtils;

public class SpriteFactory {

	public static Sprite getFromPiece(Piece piece, int cellSize, BoardPanel canvas) {
		if (piece instanceof Pawn) {
			Pawn pawn = (Pawn) piece;
			if (pawn.getWhite()) {
				Image image = ImageUtils.scaledImage("/whitePawn", cellSize, cellSize);
				return new Sprite(image, pawn.getPosition().getX(), pawn.getPosition().getY(), canvas);
			}
			else if (!pawn.getWhite()) {
				Image image = ImageUtils.scaledImage("/blackPawn", cellSize, cellSize);
				return new Sprite(image, pawn.getPosition().getX(), pawn.getPosition().getY(), canvas);
			}
			
		}
		else if (piece instanceof Rook) {
			Rook rook = (Rook) piece;
			if (rook.getWhite()) {
				Image image = ImageUtils.scaledImage("/whiteRook", cellSize, cellSize);
				return new Sprite(image, rook.getPosition().getX(), rook.getPosition().getY(), canvas);
			}
			else if (!rook.getWhite()) {
				Image image = ImageUtils.scaledImage("/blackRook", cellSize, cellSize);
				return new Sprite(image, rook.getPosition().getX(), rook.getPosition().getY(), canvas);
			}
			
		}
		else if (piece instanceof Knight) {
			Knight knight = (Knight) piece;
			if (knight.getWhite()) {
				Image image = ImageUtils.scaledImage("/whiteKnight", cellSize, cellSize);
				return new Sprite(image, knight.getPosition().getX(), knight.getPosition().getY(), canvas);
			}
			else if (!knight.getWhite()) {
				Image image = ImageUtils.scaledImage("/blackKnight", cellSize, cellSize);
				return new Sprite(image, knight.getPosition().getX(), knight.getPosition().getY(), canvas);
			}
			
		}
		else if (piece instanceof Bishop) {
			Bishop bishop = (Bishop) piece;
			if (bishop.getWhite()) {
				Image image = ImageUtils.scaledImage("/whiteBishop", cellSize, cellSize);
				return new Sprite(image, bishop.getPosition().getX(), bishop.getPosition().getY(), canvas);
			}
			else if (!bishop.getWhite()) {
				Image image = ImageUtils.scaledImage("/blackBihop", cellSize, cellSize);
				return new Sprite(image, bishop.getPosition().getX(), bishop.getPosition().getY(), canvas);
			}
			
		}
		else if (piece instanceof King) {
			King king = (King) piece;
			if (king.getWhite()) {
				Image image = ImageUtils.scaledImage("/whiteKing", cellSize, cellSize);
				return new Sprite(image, king.getPosition().getX(), king.getPosition().getY(), canvas);
			}
			else if (!king.getWhite()) {
				Image image = ImageUtils.scaledImage("/blackKing", cellSize, cellSize);
				return new Sprite(image, king.getPosition().getX(), king.getPosition().getY(), canvas);
			}
			
		}
		else if (piece instanceof Queen) {
			Queen queen = (Queen) piece;
			if (queen.getWhite()) {
				Image image = ImageUtils.scaledImage("/whiteQueen", cellSize, cellSize);
				return new Sprite(image, queen.getPosition().getX(), queen.getPosition().getY(), canvas);
			}
			else if (!queen.getWhite()) {
				Image image = ImageUtils.scaledImage("/blackQueen", cellSize, cellSize);
				return new Sprite(image, queen.getPosition().getX(), queen.getPosition().getY(), canvas);
			}
			
		}
		return null;
	}

}
