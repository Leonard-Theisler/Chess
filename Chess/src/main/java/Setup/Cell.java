package Setup;
import Pieces.Piece;
import Pieces.Position;

public class Cell {
		public Piece piece;
		
		public Boolean isThreatened(Board b, Position p, Boolean white) {
			
			for (int i = 0; i<8; i++) {
				for (int j = 0; j<8; j++) {
					Position pos = new Position (i, j);
					if (white) {
						if (b.hasPieceAt(pos) && b.getPieceAt(pos).getWhite()){
							if (b.getPieceAt(pos).isValidMove(p, b)) {
								return true;
							}
						}
					}
					if (!white) {
						if (b.hasPieceAt(pos) && !b.getPieceAt(pos).getWhite()){
							if (b.getPieceAt(pos).isValidMove(p, b)) {
								return true;
							}
						}
					}

					pos = null;
				}
			}
			return false;			
		}
}
