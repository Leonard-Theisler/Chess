package StepDefinitions;

import static org.junit.Assert.assertEquals;

import Pieces.Position;
import Pieces.Queen;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class SDQueen {
private Context context;
	
	public SDQueen(Context context) {
		this.context = context;
	}
	
	@Given("a queen on the board at \\({int}, {int})")
	public void a_queen_on_the_board_at(Integer int1, Integer int2) {
		Position p = new Position(int1, int2);
	    Queen r = new Queen(p);
	    context.oldPos = p;
	    context.queen = r;
	    context.board.setPieceAt(context.queen, context.oldPos);
	}
	@Given("a white queen on the board at \\({int}, {int})")
	public void a_white_queen_on_the_board_at(Integer int1, Integer int2) {
		Position p = new Position(int1, int2);
	    Queen r = new Queen(p, true);
	    context.oldPos = p;
	    context.queen = r;
	    context.board.setPieceAt(context.queen, context.oldPos);
	}
	@When("the queen moves to \\({int}, {int})")
	public void the_queen_moves_to(Integer int1, Integer int2) {
		Position p = new Position(int1, int2);
		context.newPos = p;
	    context.board.movePiece(context.queen, context.newPos, context.oldPos);
	}
	@When("the queen tries to move to \\({int}, {int})")
	public void the_queen_tries_to_move_to(Integer int1, Integer int2) {
		Position p = new Position(int1, int2);
		context.newPos = p;
	    context.board.movePiece(context.queen, context.newPos, context.oldPos);
	}
	@Then("the queen is at \\({int}, {int})")
	public void the_queen_is_at(Integer int1, Integer int2) {
		Position pos = new Position(int1, int2);
   	    assertEquals(context.queen, context.board.getPieceAt(pos));
	}
	
	@Then("the queen is still at the old position")
	public void the_queen_is_still_at_the_old_position() {
   	    assertEquals(context.queen, context.board.getPieceAt(context.oldPos));

	}

}
