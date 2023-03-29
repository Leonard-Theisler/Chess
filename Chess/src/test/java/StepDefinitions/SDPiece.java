package StepDefinitions;

import io.cucumber.java.en.Then;
import static org.junit.Assert.assertEquals;
import Pieces.Position;
import Setup.Board;
import Setup.Game;


public class SDPiece {
	private Context context;
	
	public SDPiece(Context context) {
		this.context = context;
	}
	
	@Then("there is no piece at \\({int}, {int})")
	public void there_is_no_piece_at(Integer int1, Integer int2) {
	    assertEquals(context.board.getPieceAt(new Position(int1, int2)), null);
	}
	
	@Then("there is no piece on the new square")
	public void a_game_with_an_empty_board() {
	    assertEquals(null, context.board.getPieceAt(context.newPos));
	}

}
