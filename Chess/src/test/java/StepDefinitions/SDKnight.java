package StepDefinitions;

import static org.junit.Assert.assertEquals;

import Pieces.Position;
import Pieces.Knight;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class SDKnight {
	private Context context;
	
	public SDKnight(Context context) {
		this.context = context;
	}
	
	@Given("a knight on the board at \\({int}, {int})")
	public void a_knight_on_the_board_at(Integer int1, Integer int2) {
		Position p = new Position(int1, int2);
	    Knight r = new Knight(p);
	    context.oldPos = p;
	    context.knight = r;
	    context.board.setPieceAt(context.knight, context.oldPos);
	}
	@Given("a white knight on the board at \\({int}, {int})")
	public void a_white_knight_on_the_board_at(Integer int1, Integer int2) {
		Position p = new Position(int1, int2);
	    Knight r = new Knight(p, true);
	    context.oldPos = p;
	    context.knight = r;
	    context.board.setPieceAt(context.knight, context.oldPos);
	}
	@Given("a white knight on the board at position\\({int}, {int})")
	public void a_white_knight_on_the_board_at_position(Integer int1, Integer int2) {
		Position p = new Position(int1, int2);
	    Knight r = new Knight(p, true);
	    context.knight = r;
	    context.board.setPieceAt(context.knight, p);
	}
	@Given("a black knight on the board at position\\({int}, {int})")
	public void a_black_knight_on_the_board_at_position(Integer int1, Integer int2) {
		Position p = new Position(int1, int2);
	    Knight r = new Knight(p, false);
	    context.knight = r;
	    context.board.setPieceAt(context.knight, p);
	}
	@When("the knight moves to \\({int}, {int})")
	public void the_knight_moves_to(Integer int1, Integer int2) {
		Position p = new Position(int1, int2);
		context.newPos = p;
	    context.board.movePiece(context.knight, context.newPos, context.oldPos);
	}
	@When("the knight tries to move to \\({int}, {int})")
	public void the_knight_tries_to_move_to(Integer int1, Integer int2) {
		Position p = new Position(int1, int2);
		context.newPos = p;
	    context.board.movePiece(context.knight, context.newPos, context.oldPos);
	}
	@Then("the knight is at \\({int}, {int})")
	public void the_knight_is_at(Integer int1, Integer int2) {
		Position pos = new Position(int1, int2);
   	    assertEquals(context.knight, context.board.getPieceAt(pos));
	}
	
	@Then("the knight is still at the old position")
	public void the_knight_is_still_at_the_old_position() {
   	    assertEquals(context.knight, context.board.getPieceAt(context.oldPos));

	}

}
