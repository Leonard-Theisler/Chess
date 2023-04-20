package view;

import java.awt.BasicStroke;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.util.ArrayList;

import javax.swing.JPanel;

import Setup.Board;
import Pieces.Piece;
import Pieces.Position;
import utils.ImageUtils;


public class BoardPanel extends JPanel{
	private int rows;
	private int cols;
	private int width;
	private int height;
	private static final int maxDimension = 500;
	int cellWidth; 
	ArrayList<Sprite> pieceImages;
	
	private Image whiteTile;
	private Image blackTile;

	public BoardPanel(Board board) {
		
		rows = 8;
		cols = 8;
		cellWidth = maxDimension/rows;
		
		width = rows*cellWidth;
		height = rows*cellWidth;
		
		whiteTile = ImageUtils.scaledImage("/whiteTile.png", cellWidth, cellWidth);
		blackTile = ImageUtils.scaledImage("/blackTile.png", cellWidth, cellWidth);

		board.boardSetup();
	}
	
	private void addPieceSprites(Board board) {
		for (int i = 0; i<rows; i++) {
			for (int j=0; j<cols; j++) {
				Position pos = new Position(i, j);
				if(board.hasPieceAt(pos)){
					addSprite(board.getPieceAt(pos), pos);
				}
			}
		}
	}

	private void addSprite(Piece piece, Position pos) {
		Sprite pieceSprite = SpriteFactory.getFromPiece(piece, cellWidth, this);
		pieceImages.add(pieceSprite);
		
	}
	
	public void paintComponent(Graphics g) {
		int colorChanger = 0;
		super.paintComponent(g);
		Graphics2D g2 = (Graphics2D) g;
		
		// draw the background tiles
		for (int col = 0; col < cols; col++) {
			for (int row = 0; row < rows; row++) {
				if (colorChanger % 2 == 0) {
					g2.drawImage(whiteTile, col*cellWidth, row*cellWidth, null);
				}
				else if (colorChanger % 2 != 0) {
					g2.drawImage(blackTile, col*cellWidth, row*cellWidth, null);
				}
			}
		}
		
		for (Sprite sprite: pieceImages) {
			sprite.drawUsing(g2);
		}
	}
}
