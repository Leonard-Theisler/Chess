package StepDefinitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;

import Pieces.Bishop;
import Pieces.Position;
import Setup.Board;
import Setup.Game;


public class SDPiece {
	private Context context;
	
	public SDPiece(Context context) {
		this.context = context;
	}
	
	@Given("a black piece on the board at \\({int}, {int})")
	public void a_black_piece_on_the_board_at(Integer int1, Integer int2) {
		Position pos = new Position(int1, int2);
	    Bishop b = new Bishop(pos, false);
	    context.newPos = pos;
	    context.bishop = b;
	    context.board.setPieceAt(context.bishop, context.newPos);
	}
	
	@Given("a white piece on the board at \\({int}, {int})")
	public void a_white_piece_on_the_board_at(Integer int1, Integer int2) {
		Position pos = new Position(int1, int2);
	    Bishop b = new Bishop(pos, true);
	    context.newPos = pos;
	    context.bishop = b;
	    context.board.setPieceAt(context.bishop, context.newPos);
	}
	
	@Then("there is no piece at \\({int}, {int})")
	public void there_is_no_piece_at(Integer int1, Integer int2) {
	    assertEquals(context.board.getPieceAt(new Position(int1, int2)), null);
	}
	
	@Then("there is no piece on the new square")
	public void a_game_with_an_empty_board() {
	    assertEquals(null, context.board.getPieceAt(context.newPos));
	}
	
	@Then("the black piece is not longer at \\({int}, {int})")
	public void the_black_piece_is_not_longer_at(Integer int1, Integer int2) {
	    assertFalse(context.board.getPieceAt(context.newPos) == context.bishop);
	}
	
	@Then("the white piece is not longer at \\({int}, {int})")
	public void the_white_piece_is_not_longer_at(Integer int1, Integer int2) {
	    assertFalse(context.board.getPieceAt(context.newPos) == context.bishop);
	}
	
	@Then("the black piece is still at \\({int}, {int})")
	public void the_black_piece_is_still_at(Integer int1, Integer int2) {
		Position pos = new Position(int1, int2);
		assertEquals(context.bishop, context.board.getPieceAt(pos));
	}
	
	@Then("the white piece is still at \\({int}, {int})")
	public void the_white_piece_is_still_at(Integer int1, Integer int2) {
		Position pos = new Position(int1, int2);
		assertEquals(context.bishop, context.board.getPieceAt(pos));
	}

}
