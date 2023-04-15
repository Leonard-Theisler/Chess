package StepDefinitions;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import Pieces.Pawn;
import Pieces.Position;
import Setup.Board;
import Setup.Game;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class SDBoard {
	private Context context;
	
	public SDBoard(Context context) {
		this.context = context;
	}
	
	
	@Given("a game with an empty board")
	public void a_game_with_an_empty_board() {
	    Game game = new Game();
	    Board board = new Board();
	    context.game = game;
	    context.board = board;
	    context.game.setBoard(board);
	}
	@When("the board is setup")
	public void the_board_is_setup() {
	    context.board.boardSetup();
	}
	@Then("row {int} has white pieces")
	public void row_has_white_pieces(Integer int1) {
		Position p = new Position(int1, 1);
	    assertEquals(context.board.getPieceAt(p).getWhite(), true);
	}
	@Then("row {int} has white pawns")
	public void row_has_white_pawns(Integer int1) {
		Position p = new Position(int1, 1);
	    assertEquals(context.board.getPieceAt(p).getWhite(), true);
	    assertTrue(context.board.getPieceAt(p) instanceof Pawn);
	    
	}
	@Then("row {int} has black pawns")
	public void row_has_black_pawns(Integer int1) {
		Position p = new Position(int1, 1);
	    assertEquals(context.board.getPieceAt(p).getWhite(), false);
	    assertTrue(context.board.getPieceAt(p) instanceof Pawn);
	}
	@Then("row {int} has black pieces")
	public void row_has_black_pieces(Integer int1) {
		Position p = new Position(int1, 1);
	    assertEquals(context.board.getPieceAt(p).getWhite(), false);
	}

}
