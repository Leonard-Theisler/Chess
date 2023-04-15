package StepDefinitions;

import Pieces.Bishop;
import Pieces.Knight;
import Pieces.Position;
import Pieces.Queen;
import Pieces.Rook;
import Pieces.Pawn;
import Setup.Board;
import Setup.Game;


public class Context {
	
	Game game;
	Board board;
	Position oldPos;
	Position newPos;

	
	Bishop bishop;
	Pawn pawn;
	Rook rook;
	Queen queen;
	Knight knight;

}
