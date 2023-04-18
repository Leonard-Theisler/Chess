package StepDefinitions;

import static org.junit.Assert.assertEquals;

import Pieces.Bishop;
import Pieces.Position;
import Pieces.Rook;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class SDRook {
	private Context context;
	
	public SDRook(Context context) {
		this.context = context;
	}
	
	@Given("a rook on the board at \\({int}, {int})")
	public void a_rook_on_the_board_at(Integer int1, Integer int2) {
		Position p = new Position(int1, int2);
	    Rook r = new Rook(p);
	    context.oldPos = p;
	    context.rook = r;
	    context.board.setPieceAt(context.rook, context.oldPos);
	}
	@Given("a white rook on the board at \\({int}, {int})")
	public void a_white_rook_on_the_board_at(Integer int1, Integer int2) {
		Position p = new Position(int1, int2);
	    Rook r = new Rook(p, true);
	    context.oldPos = p;
	    context.rook = r;
	    context.board.setPieceAt(context.rook, context.oldPos);
	}
	
	@Given("a black rook on the board at \\({int}, {int})")
	public void a_black_rook_on_the_board_at(Integer int1, Integer int2) {
		Position p = new Position(int1, int2);
	    Rook r = new Rook(p, false);
	    context.rook = r;
	    context.board.setPieceAt(context.rook, p);
	}
	
	@Given("a white rook on the board at position \\({int}, {int})")
	public void a_white_rook_on_the_board_at_position(Integer int1, Integer int2) {
		Position p = new Position(int1, int2);
	    Rook r = new Rook(p, true);
	    context.rook = r;
	    context.board.setPieceAt(context.rook, p);
	}
	@Given("a black rook on the board at position \\({int}, {int})")
	public void a_black_rook_on_the_board_at_position(Integer int1, Integer int2) {
		Position p = new Position(int1, int2);
	    Rook r = new Rook(p, false);
	    context.rook = r;
	    context.board.setPieceAt(context.rook, p);
	}
	@When("the rook moves to \\({int}, {int})")
	public void the_rook_moves_to(Integer int1, Integer int2) {
		Position p = new Position(int1, int2);
		context.newPos = p;
	    context.board.movePiece(context.rook, context.newPos, context.oldPos);
	}
	@When("the rook tries to move to \\({int}, {int})")
	public void the_rook_tries_to_move_to(Integer int1, Integer int2) {
		Position p = new Position(int1, int2);
		context.newPos = p;
	    context.board.movePiece(context.rook, context.newPos, context.oldPos);
	}
	@Then("the rook is at \\({int}, {int})")
	public void the_rook_is_at(Integer int1, Integer int2) {
		Position pos = new Position(int1, int2);
   	    assertEquals(context.rook, context.board.getPieceAt(pos));
	}
	
	@Then("the rook is still at the old position")
	public void the_rook_is_still_at_the_old_position() {
   	    assertEquals(context.rook, context.board.getPieceAt(context.oldPos));

	}

}
